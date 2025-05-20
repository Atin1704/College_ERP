package com.company.Mainusers;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Admincourserunner implements Courserunner {
    private static HashMap<String, String> prof_expertise = new HashMap<>();
    private static HashMap<String, String> prof_name = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    static {
        prof_expertise.put("p1@iiitd.ac.in", "Cs");
        prof_expertise.put("p2@iiitd.ac.in", "Maths");
        prof_expertise.put("p3@iiitd.ac.in", "ECE");
        prof_expertise.put("p4@iiitd.ac.in", "Cs");
        prof_expertise.put("p5@iiitd.ac.in", "Bio");

        prof_name.put("p1", "p1@iiitd.ac.in");
        prof_name.put("p2", "p2@iiitd.ac.in");
        prof_name.put("p3", "p3@iiitd.ac.in");
        prof_name.put("p4", "p4@iiitd.ac.in");
        prof_name.put("p5", "p5@iiitd.ac.in");
    }

    @Override
public void displaycourses() {
    Scanner scanner = new Scanner(System.in);
    int option;

    while (true) {
        System.out.println("Select an option:");
        System.out.println("1 - View all courses in a semester");
        System.out.println("2 - View details of a course by course code");
        System.out.println("3 - Add a new course");
        System.out.println("4 - Drop a course (not implemented)");
        System.out.println("0 - Go back to the previous menu");
        
        System.out.print("Enter your choice: ");
        option = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (option) {
            case 1:
                // View all courses in a semester
                System.out.print("Enter semester (1, 2, 3, ...): ");
                char semester = scanner.nextLine().charAt(0);
                ArrayList<Course> coursesInSemester = Course.getCoursesForSemester(semester);
                
                if (coursesInSemester.isEmpty()) {
                    System.out.println("No courses found for semester " + semester + ".");
                } else {
                    System.out.println("Courses in semester " + semester + ":");
                    for (Course course : coursesInSemester) {
                        System.out.println(course.getCoursetitle() + " (" + course.getCoursecode() + ")");
                    }
                }
                break;

            case 2:
                // View details of a course by course code
                System.out.print("Enter course code: ");
                String courseCode = scanner.nextLine().trim();
                Course course = Course.getCourseByCode(courseCode);
                
                if (course != null) {
                    System.out.println("Course Details:");
                    System.out.println("Title: " + course.getCoursetitle());
                    System.out.println("Credits: " + course.getCourseCredits());
                    System.out.println("Professor: " + course.getProfEmailId());
                    System.out.println("Semester: " + course.getSem());
                    System.out.println("Location: " + course.getLocation());
                    System.out.println("Schedule: " + course.getSchedule());
                    System.out.println("Day: " + course.getDay());
                    System.out.println("Office Hours: " + course.getOfficehrs());
                } else {
                    System.out.println("Course with code '" + courseCode + "' not found.");
                }
                break;

            case 3:
                // Add a new course
                System.out.print("Enter course code: ");
                String newCourseCode = scanner.nextLine().trim();
                
                System.out.print("Enter course credits: ");
                int courseCredits = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                
                System.out.print("Enter professor email ID: ");
                String profEmailId = scanner.nextLine().trim();
                
                System.out.print("Enter semester (1, 2, 3, ...): ");
                char newSemester = scanner.nextLine().charAt(0);
                
                System.out.print("Enter location: ");
                String location = scanner.nextLine().trim();
                
                System.out.print("Enter schedule: ");
                String schedule = scanner.nextLine().trim();
                
                System.out.print("Enter course title: ");
                String courseTitle = scanner.nextLine().trim();
                
                System.out.print("Enter day: ");
                String day = scanner.nextLine().trim();
                
                System.out.print("Enter office hours: ");
                String officeHours = scanner.nextLine().trim();
                
                // Create the new course
                new Course(newCourseCode, courseCredits, profEmailId, newSemester, location, schedule, courseTitle, day, officeHours);
                System.out.println("Course added successfully.");
                break;

            case 4:
                //ask sem
                //show courses in that sem
                //ask course code
                //check if course code exist in that sem
                //ask y or n
                //delete course
                //delete it from course sem mapping
                //delete it from prof_course mapping
                //pre req mapping(just delet it as key, it can remian a preq for other courses)
                //delete it from course code course mapping
                //go to course studnet mapping, get all the stdunets that have this course
                //deleet this course and set that grdae to 0, then delete it from course student mapping
                // Drop a course
                
                // Drop a course
                
    // Drop a course
    System.out.print("Enter semester (1, 2, 3, ...): ");
    char dropSemester = scanner.nextLine().charAt(0);

    // Step 2: Get courses for the semester
    ArrayList<Course> coursesInDropSemester = Course.getCoursesForSemester(dropSemester);
    if (coursesInDropSemester.isEmpty()) {
        System.out.println("No courses found for semester " + dropSemester + ".");
        return; // Exit the method if no courses found
    }

    // Step 3: Display available courses
    System.out.println("Courses in semester " + dropSemester + ":");
    for (Course course1 : coursesInDropSemester) {
        System.out.println(course1.getCoursetitle() + " (" + course1.getCoursecode() + ")");
    }

    // Step 4: Ask for the course code to drop
    System.out.print("Enter course code to drop: ");
    String dropCourseCode = scanner.nextLine().trim();
    Course courseToDrop = Course.getCourseByCode(dropCourseCode);

    if (courseToDrop != null && coursesInDropSemester.contains(courseToDrop)) {
        // Confirm dropping the course
        System.out.print("Are you sure you want to drop the course " + courseToDrop.getCoursetitle() + " (Y/N)? ");
        String confirmation = scanner.nextLine().trim().toUpperCase();

        if (confirmation.equals("Y")) {
            // Step 5: Remove course from semester course mapping
            ArrayList<Course> semesterCourses = Course.semCourseMapping.get(dropSemester);
            if (semesterCourses != null) {
                semesterCourses.remove(courseToDrop);
                if (semesterCourses.isEmpty()) {
                    Course.semCourseMapping.remove(dropSemester); // Clean up if no courses are left
                }
            }

            // Step 6: Remove course from professor's course mapping
            ArrayList<Course> professorCourses = Course.professorCoursesMapping.get(courseToDrop.getProfEmailId());
            if (professorCourses != null) {
                professorCourses.remove(courseToDrop);
                if (professorCourses.isEmpty()) {
                    Course.professorCoursesMapping.remove(courseToDrop.getProfEmailId()); // Clean up if no courses are left
                }
            }

            // Step 7: Remove course from prerequisite mapping
            Course.prereqMapping.remove(courseToDrop);

            // Step 8: Remove course from global course code mapping
            Course.coursecodeMapping.remove(courseToDrop.getCoursecode());

            // Step 9: Remove course from course-student mapping and update student records
            ArrayList<Stdacad> studentsInCourse = Stdacad.course_stdacad_mapping.get(courseToDrop);
            if (studentsInCourse != null) {
                // Collect students to safely remove the course from their records
                ArrayList<Stdacad> studentsToRemove = new ArrayList<>(studentsInCourse);
                
                for (Stdacad student : studentsToRemove) {
                    switch (student.getSem()) {
                        case '1':
                            student.drop_course_sem1(courseToDrop);
                            break;
                        case '2':
                            student.drop_course_sem2(courseToDrop);
                            break;
                        case '3':
                            student.drop_course_sem3(courseToDrop);
                            break;
                        case '4':
                            student.drop_course_sem4(courseToDrop);
                            break;
                    }
                }
                
                // Finally, remove the course from the course-student mapping
                        Stdacad.course_stdacad_mapping.remove(courseToDrop); // Clean up if no students are left
                    }

                    System.out.println("Course " + courseToDrop.getCoursetitle() + " has been dropped successfully.");
                } else {
                    System.out.println("Course drop cancelled.");
                }
            } else {
                System.out.println("Course with code '" + dropCourseCode + "' not found or not in the specified semester.");
            }
    break;
                
                

            case 0:
                return; // Go back to the previous menu

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}
    
    @Override
public void displaystudentdata() {
    Stdacad student = null;
    String emailId = ""; // Initialize emailId

    // Step 1: Ask for the student email until a valid one is provided
    while (student == null) {
        System.out.print("Enter student email: ");
        emailId = scanner.nextLine().trim();
        
        student = Stdacad.get_instance(emailId);
        if (student == null) {
            System.out.println("Student with email '" + emailId + "' not found. Please try again.");
            System.out.print("Press -1 to close the program, or any other key to continue: ");
            String option = scanner.nextLine();
            if (option.equals("-1")) {
                System.exit(0);
            }
        }
    }

    // Step 2: Ask for option to view courses or SGPA/GPA
    int option = -1;
    while (option < 1 || option > 4) {
        System.out.println("Select an option:");
        System.out.println("1 - View courses");
        System.out.println("2 - See SGPA");
        System.out.println("3 - See GPA");
        System.out.println("4 - Change grade");
        
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();
        
        try {
            option = Integer.parseInt(input);
            if (option < 1 || option > 4) {
                System.out.println("Invalid option. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
        }
    }

    switch (option) {
        case 1:
            // View courses student is currently enrolled in
            Studentcourserunner newstd = new Studentcourserunner();
            newstd.display_course_titles(emailId);
            break;

        case 2:
            // Display SGPA
            System.out.print("Enter the semester for SGPA: ");
            char sgpaSemester = scanner.nextLine().charAt(0); // Use nextLine to consume the newline
            double sgpa = student.calculateSGPAWithGrades(sgpaSemester);
            System.out.println("SGPA for semester " + sgpaSemester + ": " + sgpa);
            break;

        case 3:
            // Display GPA
            double gpa = student.calculateGPA();
            if (gpa != 0.0) {
                System.out.println("GPA: " + gpa);
            } else {
                System.out.println("GPA not available.");
            }
            break;

        case 4:
            // Change grade
            System.out.print("Enter the semester to change grade: ");
            char gradeSemester = scanner.nextLine().charAt(0); // Use nextLine to consume the newline
            
            // Ask for course code
            System.out.print("Enter the course code: ");
            String courseCode = scanner.nextLine().trim();
            Course courseToUpdate = null;

            // Find the course in the specified semester
            ArrayList<Course> coursesForSemester = student.getCoursesForSemester(gradeSemester);
            for (Course course : coursesForSemester) {
                if (course.getCoursecode().equalsIgnoreCase(courseCode)) {
                    courseToUpdate = course;
                    break;
                }
            }

            if (courseToUpdate == null) {
                System.out.println("Course not found for the given semester.");
                return;
            }

            // Show current grade
            int currentGrade = 0;
            switch (gradeSemester) {
                case '1':
                    currentGrade = student.sem1_grade.get(student.sem1.indexOf(courseToUpdate));
                    break;
                case '2':
                    currentGrade = student.sem2_grade.get(student.sem2.indexOf(courseToUpdate));
                    break;
                case '3':
                    currentGrade = student.sem3_grade.get(student.sem3.indexOf(courseToUpdate));
                    break;
                case '4':
                    currentGrade = student.sem4_grade.get(student.sem4.indexOf(courseToUpdate));
                    break;
                default:
                    System.out.println("Invalid semester.");
                    return;
            }

            System.out.println("Current grade for " + courseCode + ": " + currentGrade);
            System.out.print("Enter new grade: ");
            String newGradeInput = scanner.nextLine();
            int newGrade = Integer.parseInt(newGradeInput); // Simple error checking should be implemented here if needed

            // Update the grade
            switch (gradeSemester) {
                case '1':
                    student.add_or_update_grade_sem1(courseToUpdate, newGrade);
                    break;
                case '2':
                    student.add_or_update_grade_sem2(courseToUpdate, newGrade);
                    break;
                case '3':
                    student.add_or_update_grade_sem3(courseToUpdate, newGrade);
                    break;
                case '4':
                    student.add_or_update_grade_sem4(courseToUpdate, newGrade);
                    break;
            }

            System.out.println("Grade updated successfully.");
            break;
    }
}
   
   

    @Override
public void update_data() {
    // Step 1: Ask for the semester input without mentioning specific semesters
    System.out.print("Enter the semester: ");
    char semester = scanner.next().charAt(0);
    scanner.nextLine(); // Consume the newline character

    // Step 2: Get and display courses for the selected semester
    ArrayList<Course> semesterCourses = Course.getCoursesForSemester(semester);
    if (semesterCourses == null || semesterCourses.isEmpty()) {
        System.out.println("No courses available for the entered semester.");
        return;
    }

    System.out.println("Courses available in semester " + semester + ":");
    for (Course course : semesterCourses) {
        System.out.println("Course Title: " + course.getCoursetitle() + " | Course Code: " + course.getCoursecode());
    }

    // Step 3: Ask for the course code to update
    System.out.print("Enter the course code you want to update: ");
    String courseCode = scanner.nextLine().trim(); // Trim spaces

    Course selectedCourse = null;
    for (Course course : semesterCourses) {
        // Normalize comparison by trimming and using case insensitive check
        if (course.getCoursecode().trim().equalsIgnoreCase(courseCode)) {
            selectedCourse = course;
            break;
        }
    }

    if (selectedCourse == null) {
        System.out.println("Course not found.");
        return;
    }

    // Step 4: Display current course details
    System.out.println("Current details of the selected course:");
    System.out.println("Course Title: " + selectedCourse.getCoursetitle());
    System.out.println("Course Code: " + selectedCourse.getCoursecode());
    System.out.println("Credits: " + selectedCourse.getCourseCredits());
    System.out.println("Professor Email: " + selectedCourse.getProfEmailId());
    System.out.println("Location: " + selectedCourse.getLocation());
    System.out.println("Schedule: " + selectedCourse.getSchedule());
    System.out.println("Day: " + selectedCourse.getDay());
    System.out.println("Office Hours: " + selectedCourse.getOfficehrs());

    // Step 5: Display professors and their expertise along with the total number of courses they are teaching
    System.out.println("\nList of Professors, their Expertise, and Total Courses they are Teaching:");
    for (String email : Course.professorCoursesMapping.keySet()) {
        String expertise = prof_expertise.get(email);
        ArrayList<Course> coursesTaught = Course.professorCoursesMapping.get(email);
        int courseCount = (coursesTaught != null) ? coursesTaught.size() : 0;
        System.out.println("Professor Email: " + email + " | Expertise: " + expertise + " | Courses Taught: " + courseCount);
    }

    // Step 6: Ask for the professor's name to assign to the course
    System.out.print("Enter the professor's name to assign to this course: ");
    String professorName = scanner.nextLine();

    // Check if the professor exists in prof_name map
    String profEmailId = prof_name.get(professorName.toLowerCase());
    if (profEmailId == null) {
        System.out.println("Professor not found.");
        return;
    }

    // Step 7: Update the course's professor email
    String oldProfEmailId = selectedCourse.getProfEmailId(); // Store the old professor email for update
    selectedCourse.setProfEmailId(profEmailId);

    // Remove the course from the old professor's course list
    ArrayList<Course> oldProfessorCourses = Course.professorCoursesMapping.get(oldProfEmailId);
    if (oldProfessorCourses != null) {
        oldProfessorCourses.remove(selectedCourse);
    }

    // Add the course to the new professor's course list
    ArrayList<Course> newProfessorCourses = Course.professorCoursesMapping.get(profEmailId);
    if (newProfessorCourses == null) {
        newProfessorCourses = new ArrayList<>();
        Course.professorCoursesMapping.put(profEmailId, newProfessorCourses);
    }
    if (!newProfessorCourses.contains(selectedCourse)) {
        newProfessorCourses.add(selectedCourse);
    }

    System.out.println("Course updated successfully. New Professor Email: " + profEmailId);
}







    @Override
    public void displaycourses(String emailid) {
        return;
    }

    @Override
    public void displaystudentdata(String emailid) {
        return;
    }

    @Override
    public String update_data(String emailid) {
       return "-1";
        }
}

    

    
















    
     

