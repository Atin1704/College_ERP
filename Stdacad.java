package com.company.Mainusers;
//contains studnet acacdemic details,specificlaly created for studnet acacdemics to follow one class one functionality
//encapsulation used here-alos basically in every top level classw here contrcutor is present and some data is being initialized
//for detailed overview read readme and reference uml   

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Stdacad {

    private char sem;
    private String studentEmailId;
    private int sem1_course_count = 0;
    private int sem2_course_count = 0;
    private int sem3_course_count = 0;
    private int sem4_course_count = 0;

    protected static ArrayList<Course> std_course_mapping = new ArrayList<>();
    protected static HashMap<String, Stdacad> email_stdacad_mapping = new HashMap<>();
    protected static HashMap<Course, ArrayList<Stdacad>> course_stdacad_mapping = new HashMap<>();

    Stdacad(char sem, String studentEmailId) {
        this.sem = sem;
        this.studentEmailId = studentEmailId;
        email_stdacad_mapping.put(studentEmailId, this);
    }

    public static Stdacad get_instance(String studentEmailId) {
        Stdacad student = email_stdacad_mapping.get(studentEmailId);
        if (student == null) {
            System.out.println("Student with email " + studentEmailId + " not found.");
        }
        return student;
    }

    protected ArrayList<Course> sem1 = new ArrayList<>();
    protected ArrayList<Integer> sem1_grade = new ArrayList<>(Collections.nCopies(10, 0));
    protected ArrayList<Course> sem2 = new ArrayList<>();
    protected ArrayList<Integer> sem2_grade = new ArrayList<>(Collections.nCopies(10, 0));
    protected ArrayList<Course> sem3 = new ArrayList<>();
    protected ArrayList<Integer> sem3_grade = new ArrayList<>(Collections.nCopies(10, 0));
    protected ArrayList<Course> sem4 = new ArrayList<>();
    protected ArrayList<Integer> sem4_grade = new ArrayList<>(Collections.nCopies(10, 0));

    private void add_course_to_mapping(Course course) {
        if (course.getSem() == this.sem) {
            ArrayList<Stdacad> students = course_stdacad_mapping.get(course);
            if (students == null) {
                students = new ArrayList<>();
                course_stdacad_mapping.put(course, students);
            }
            if (!students.contains(this)) {
                students.add(this);
            }
        }
    }

    private void add_course(ArrayList<Course> semesterCourses, ArrayList<Integer> semesterGrades, Course course, int grade) {
        // Add course to the list
        semesterCourses.add(course);
        std_course_mapping.add(course); // Add to the global course mapping

        // Ensure the grade list grows dynamically
        if (semesterGrades.size() > semesterCourses.size()) {
            semesterGrades.set(semesterCourses.size() - 1, grade); // Replace grade if already initialized
        } else {
            semesterGrades.add(grade); // Add new grade
        }

        // Update course mapping
        add_course_to_mapping(course);
    }

    void add_course_sem1(Course course, int grade) {
        add_course(sem1, sem1_grade, course, grade);
        sem1_course_count++;  // Increment the course count after adding
    }

    void add_course_sem2(Course course, int grade) {
        add_course(sem2, sem2_grade, course, grade);
        sem2_course_count++;  // Increment the course count after adding
    }

    void add_course_sem3(Course course, int grade) {
        add_course(sem3, sem3_grade, course, grade);
        sem3_course_count++;  // Increment the course count after adding
    }

    void add_course_sem4(Course course, int grade) {
        add_course(sem4, sem4_grade, course, grade);
        sem4_course_count++;  // Increment the course count after adding
    }

    void add_or_update_grade_sem1(Course course, int grade) {
        int index = sem1.indexOf(course);
        if (index != -1) {
            sem1_grade.set(index, grade); // Update existing grade
        } else {
            add_course_sem1(course, grade); // Add new course and grade
        }
    }

    void add_or_update_grade_sem2(Course course, int grade) {
        int index = sem2.indexOf(course);
        if (index != -1) {
            sem2_grade.set(index, grade); // Update existing grade
        } else {
            add_course_sem2(course, grade); // Add new course and grade
        }
    }

    void add_or_update_grade_sem3(Course course, int grade) {
        int index = sem3.indexOf(course);
        if (index != -1) {
            sem3_grade.set(index, grade); // Update existing grade
        } else {
            add_course_sem3(course, grade); // Add new course and grade
        }
    }

    void add_or_update_grade_sem4(Course course, int grade) {
        int index = sem4.indexOf(course);
        if (index != -1) {
            sem4_grade.set(index, grade); // Update existing grade
        } else {
            add_course_sem4(course, grade); // Add new course and grade
        }
    }

    public char getSem() {
        return sem;
    }

    public void setSem(char sem) {
        this.sem = sem;
    }

    public String getStudentEmailId() {
        return studentEmailId;
    }

    public void setStudentEmailId(String studentEmailId) {
        this.studentEmailId = studentEmailId;
    }

    static {
        initialize();
    }

    public static void initialize() {
        Stdacad a1 = new Stdacad('1', "a1@iiitd.ac.in");
        Stdacad a2 = new Stdacad('2', "a2@iiitd.ac.in");
        Stdacad a3 = new Stdacad('2', "a3@iiitd.ac.in");
        Stdacad a4 = new Stdacad('3', "a4@iiitd.ac.in");
        Stdacad a5 = new Stdacad('3', "a5@iiitd.ac.in");

        // Semester 1 Courses
        Course cs1 = Course.getCourseByCode("CS1");
        Course m1 = Course.getCourseByCode("M1");
        Course ece1 = Course.getCourseByCode("ECE1");
        Course a11 = Course.getCourseByCode("A1");
        Course ent1 = Course.getCourseByCode("ENT1");

        // Enroll a1 in Semester 1 Courses
        a1.add_course_sem1(cs1, 0);
        a1.add_course_sem1(m1, 0);
        a1.add_course_sem1(ece1, 0);
        a1.add_course_sem1(a11, 0);
        a1.add_course_sem1(ent1, 0);

        // Semester 2 Courses
        Course cs2 = Course.getCourseByCode("CS2");
        Course m2 = Course.getCourseByCode("M2");
        Course ece2 = Course.getCourseByCode("ECE2");
        Course a22 = Course.getCourseByCode("A2");
        Course ent2 = Course.getCourseByCode("ENT2");

        // Enroll a2 in Semester 1 and 2 Courses
        a2.add_course_sem1(cs1, 7);
        a2.add_course_sem1(m1, 8);
        a2.add_course_sem1(ece1, 9);
        a2.add_course_sem1(a11, 8);
        a2.add_course_sem1(ent1, 8);

        a2.add_course_sem2(cs2, 8);
        a2.add_course_sem2(m2, 9);
        a2.add_course_sem2(ece2, 8);
        a2.add_course_sem2(a22, 8);
        a2.add_course_sem2(ent2, 8);

        a3.add_course_sem1(cs1, 7);
        a3.add_course_sem1(m1, 8);
        a3.add_course_sem1(ece1, 9);
        a3.add_course_sem1(a11, 8);
        a3.add_course_sem1(ent1, 8);

        a3.add_course_sem2(cs2, 0);
        a3.add_course_sem2(m2, 0);
        a3.add_course_sem2(a22, 8);

        // Semester 3 Courses
        Course cs4 = Course.getCourseByCode("CS4");
        Course m4 = Course.getCourseByCode("M4");
        Course ece3 = Course.getCourseByCode("ECE3");
        Course a33 = Course.getCourseByCode("A3");
        Course ent3 = Course.getCourseByCode("ENT3");

        // Enroll a4 in Semester 1, 2, and 3 Courses
        a4.add_course_sem1(cs1, 8);
        a4.add_course_sem1(m1, 8);
        a4.add_course_sem1(ece1, 8);
        a4.add_course_sem1(a11, 9);
        a4.add_course_sem1(ent1, 8);

        a4.add_course_sem2(cs2, 9);
        a4.add_course_sem2(m2, 8);
        a4.add_course_sem2(ece2, 8);
        a4.add_course_sem2(a22, 9);
        a4.add_course_sem2(ent2, 8);

        
        a4.add_course_sem3(m4, 8);
        a4.add_course_sem3(ece3, 9);
        a4.add_course_sem3(a33, 8);
        a4.add_course_sem3(ent3, 8);

        // Enroll a5 in Semester 1, 2, and 3 Courses
        a5.add_course_sem1(cs1, 7);
        a5.add_course_sem1(m1, 8);
        a5.add_course_sem1(ece1, 8);
        a5.add_course_sem1(a11, 8);
        a5.add_course_sem1(ent1, 7);

        a5.add_course_sem2(cs2, 8);
        a5.add_course_sem2(m2, 8);
        a5.add_course_sem2(a22, 7);
        a5.add_course_sem2(ent2, 8);

        a5.add_course_sem3(cs4, 9);
        a5.add_course_sem3(m4, 0);
        a5.add_course_sem3(ent3, 9);
    }

    public double calculateSGPA(char semester) {
        ArrayList<Course> semesterCourses;
        ArrayList<Integer> semesterGrades;
        int courseCount;

        switch (semester) {
            case '1':
                semesterCourses = sem1;
                semesterGrades = sem1_grade;
                courseCount = sem1_course_count;
                break;
            case '2':
                semesterCourses = sem2;
                semesterGrades = sem2_grade;
                courseCount = sem2_course_count;
                break;
            case '3':
                semesterCourses = sem3;
                semesterGrades = sem3_grade;
                courseCount = sem3_course_count;
                break;
            case '4':
                semesterCourses = sem4;
                semesterGrades = sem4_grade;
                courseCount = sem4_course_count;
                break;
            default:
                System.out.println("Invalid semester.");
                return 0.0;
        }

        if (semester > sem) {
            System.out.println("SGPA doesn't exist for semester " + semester);
            return 0.0;
        }

        double totalGrades = 0;
        int validCourses = 0;

        for (int i = 0; i < courseCount; i++) {
            int grade = semesterGrades.get(i);
            if (grade > 0) {
                totalGrades += grade;
                validCourses++;
            }
        }

        if (validCourses == courseCount) {
            return totalGrades / courseCount;
        } else {
            System.out.println("SGPA doesn't exist for semester " + semester);
            return 0.0;
        }
    }

    public double calculateGPA() {
        double totalSGPA = 0;
        int validSemesters = 0;

        for (char sem = '1'; sem <= this.sem; sem++) {
            double sgpa = calculateSGPA(sem);
            if (sgpa != -1.0) {
                totalSGPA += sgpa;
                validSemesters++;
            }
        }

        if (validSemesters > 0) {
            return totalSGPA / validSemesters;
        } else {
            System.out.println("GPA doesn't exist.");
            return 0.0;
        }
    }

    public double calculateSGPAWithGrades(char semester) {
        ArrayList<Course> semesterCourses;
        ArrayList<Integer> semesterGrades;
        int courseCount;

        switch (semester) {
            case '1':
                semesterCourses = sem1;
                semesterGrades = sem1_grade;
                courseCount = sem1_course_count;
                break;
            case '2':
                semesterCourses = sem2;
                semesterGrades = sem2_grade;
                courseCount = sem2_course_count;
                break;
            case '3':
                semesterCourses = sem3;
                semesterGrades = sem3_grade;
                courseCount = sem3_course_count;
                break;
            case '4':
                semesterCourses = sem4;
                semesterGrades = sem4_grade;
                courseCount = sem4_course_count;
                break;
            default:
                System.out.println("Invalid semester.");
                return -1.0;
        }

        if (semester > sem) {
            System.out.println("SGPA doesn't exist for semester " + semester);
            return -1.0;
        }

        double totalGrades = 0;
        int validCourses = 0;
        boolean allGradesAssigned = true;

        System.out.println("Grades for semester " + semester + ":");
        for (int i = 0; i < courseCount; i++) {
            int grade = semesterGrades.get(i);
            Course course = semesterCourses.get(i);
            System.out.println(course.getCoursecode() + ": " + grade);

            if (grade > 0) {
                totalGrades += grade;
                validCourses++;
            } else {
                allGradesAssigned = false;
            }
        }

        if (allGradesAssigned) {
            double sgpa = totalGrades / courseCount;
            System.out.println("SGPA for semester " + semester + ": " + sgpa);
            return sgpa;
        } else {
            System.out.println("SGPA doesn't exist for semester " + semester);
            return -1.0;
        }
    }

    public static void display_hello() {
        System.out.println();
    }

    public static Stdacad getStudentByEmail(String emailId) {
        // Retrieve the student object from the email-to-student mapping
        Stdacad student = email_stdacad_mapping.get(emailId);
        
        if (student == null) {
            System.out.println("Student with email " + emailId + " not found.");
        }
        return student;
    }

    public ArrayList<Course> getCoursesForSemester(char currentSem) {
        switch (currentSem) {
            case '1':
                return sem1;
            case '2':
                return sem2;
            case '3':
                return sem3;
            case '4':
                return sem4;
            default:
                System.out.println("Invalid semester.");
                return new ArrayList<>();  // Return empty list if semester is invalid
        }
    }

    void drop_course_sem1(Course course) {
        int index = sem1.indexOf(course);
        if (index != -1) {
            sem1.remove(index); // Remove course from semester list
            sem1_grade.remove(index); // Remove the corresponding grade
            sem1_course_count--; // Decrement the course count
    
            // Remove the student from the course mapping
            ArrayList<Stdacad> students = course_stdacad_mapping.get(course);
            if (students != null) {
                students.remove(this);
                if (students.isEmpty()) {
                    course_stdacad_mapping.remove(course); // Clean up if no students are left
                }
            }
        } else {
            System.out.println("Course not found in semester 1.");
        }
    }


    void drop_course_sem2(Course course) {
        int index = sem2.indexOf(course);
        if (index != -1) {
            sem2.remove(index); // Remove course from semester list
            sem2_grade.remove(index); // Remove the corresponding grade
            sem2_course_count--; // Decrement the course count
    
            // Remove the student from the course mapping
            ArrayList<Stdacad> students = course_stdacad_mapping.get(course);
            if (students != null) {
                students.remove(this);
                if (students.isEmpty()) {
                    course_stdacad_mapping.remove(course); // Clean up if no students are left
                }
            }
        } else {
            System.out.println("Course not found in semester 2.");
        }
    }

    void drop_course_sem3(Course course) {
        int index = sem3.indexOf(course);
        if (index != -1) {
            sem3.remove(index); // Remove course from semester list
            sem3_grade.remove(index); // Remove the corresponding grade
            sem3_course_count--; // Decrement the course count
    
            // Remove the student from the course mapping
            ArrayList<Stdacad> students = course_stdacad_mapping.get(course);
            if (students != null) {
                students.remove(this);
                if (students.isEmpty()) {
                    course_stdacad_mapping.remove(course); // Clean up if no students are left
                }
            }
        } else {
            System.out.println("Course not found in semester 3.");
        }
    }

    void drop_course_sem4(Course course) {
        int index = sem4.indexOf(course);
        if (index != -1) {
            sem4.remove(index); // Remove course from semester list
            sem4_grade.remove(index); // Remove the corresponding grade
            sem4_course_count--; // Decrement the course count
    
            // Remove the student from the course mapping
            ArrayList<Stdacad> students = course_stdacad_mapping.get(course);
            if (students != null) {
                students.remove(this);
                if (students.isEmpty()) {
                    course_stdacad_mapping.remove(course); // Clean up if no students are left
                }
            }
        } else {
            System.out.println("Course not found in semester 4.");
        }
    }

    
    

    
}


