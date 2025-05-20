package com.company.Mainusers;

import java.util.ArrayList;
import java.util.Scanner;

public class Studentcourserunner implements Courserunner {
    @Override
    public void displaycourses(String emailid) {
        // Retrieve the student instance using the provided email ID
        Stdacad student = Stdacad.get_instance(emailid);
        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        // Get the student's current semester
        char currentSem = student.getSem();

        // Retrieve courses for the current semester
        ArrayList<Course> courses = Course.getCoursesForSemester(currentSem);
        
        // Display course information
        System.out.println("Courses for Semester " + currentSem + ":");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCoursecode());
            System.out.println("Title: " + course.getCoursetitle());
            System.out.println("Credits: " + course.getCourseCredits());
            System.out.println("Location: " + course.getLocation());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Day: " + course.getDay());
            System.out.println("Office Hours: " + course.getOfficehrs());
            System.out.println("Professor Email: " + course.getProfEmailId());
            System.out.println("-------------------------------");
        }
    }
        
    

    @Override
    public void displaystudentdata(String emailid) {
        Scanner scanner = new Scanner(System.in);
        Stdacad student = Stdacad.getStudentByEmail(emailid);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter 1 for GPA");
        System.out.println("Enter 2 for SGPA");
        String input = scanner.next();

        switch (input) {
            case "1":
                System.out.println("Your GPA is: " + student.calculateGPA());
                break;
            case "2":
                System.out.println("Enter semester to calculate SGPA:");
                char semInput = scanner.next().charAt(0);

                // Validate semester input
                if (semInput > student.getSem()) {
                    System.out.println("Invalid semester. It cannot be greater than your current semester.");
                } else {
                    double sgpa = student.calculateSGPAWithGrades(semInput);
                    // if (sgpa != -1.0) {
                    //     System.out.println("SGPA for semester " + semInput + " is: " + sgpa);
                    // } else {
                    //     System.out.println("SGPA does not exist for semester " + semInput + ".");
                    // }
                }
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    }


public String update_data(String emailid) {
    // Retrieve the student instance using the provided email ID
    Stdacad student = Stdacad.get_instance(emailid);
    Scanner scanner = new Scanner(System.in);

    // Check if student exists
    if (student == null) {
        System.out.println("Error: Student not found.");
        return "1"; // Return error code
    }

    // Get the student's current semester and calculate total credits
    char currentSem = student.getSem();
    int totalCredits = 0;

    ArrayList<Course> currentCourses = student.getCoursesForSemester(currentSem);
    if (currentCourses != null) {
        for (Course course : currentCourses) {
            totalCredits += course.getCourseCredits(); // Sum up the credits for all courses in the semester
        }
    }

    // Provide options for adding or dropping courses
    System.out.println("Choose an option:");
    System.out.println("1. Add Course");
    System.out.println("2. Drop Course");

    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character after the integer input

    if (choice == 1) {
        // Add course option
        System.out.println("Enter the course code to add: ");
        String courseCode = scanner.nextLine();
        Course courseToAdd = Course.coursecodeMapping.get(courseCode);

        // Check if the course exists
        if (courseToAdd == null) {
            System.out.println("Error: Invalid course code.");
            return "1";
        }

        // Check if the course already exists in the current semester
        if (currentCourses != null && currentCourses.contains(courseToAdd)) {
            System.out.println("Error: Course " + courseCode + " is already in your current semester.");
            return "1"; // Return error code indicating duplicate course
        }

        // Ensure the course is in the current semester
        if (courseToAdd.getSem() != currentSem) {
            System.out.println("Error: You can only add courses for the current semester.");
            return "1";
        }

        // Check if adding this course would exceed the 20-credit limit
        if (totalCredits + courseToAdd.getCourseCredits() > 20) {
            System.out.println("Error: Adding this course would exceed the 20-credit limit.");
            return "1";
        }

        // Check if prerequisites are satisfied
        ArrayList<Course> prerequisites = Course.prereqMapping.get(courseToAdd);
        boolean prerequisitesSatisfied = true;

        if (prerequisites != null) {
            for (Course prerequisite : prerequisites) {
                if (!currentCourses.contains(prerequisite)) {
                    prerequisitesSatisfied = false;
                    System.out.println("Error: Unmet prerequisite: " + prerequisite.getCoursecode());
                }
            }
        }

        // If prerequisites are not satisfied, return error
        if (!prerequisitesSatisfied) {
            return "1";
        }

        // Add the course to the student's current semester
        switch (currentSem) {
            case '1':
                student.add_course_sem1(courseToAdd, 0);
                break;
            case '2':
                student.add_course_sem2(courseToAdd, 0);
                break;
            case '3':
                student.add_course_sem3(courseToAdd, 0);
                break;
            case '4':
                student.add_course_sem4(courseToAdd, 0);
                break;
            default:
                System.out.println("Error: Invalid semester.");
                return "1";
        }

        System.out.println("Course " + courseToAdd.getCoursecode() + " added successfully.");
        return "1"; // Success code

    } else if (choice == 2) {
        // Drop course option
        System.out.println("Enter the course code to drop: ");
        String courseCodeDrop = scanner.nextLine();
        Course courseToDrop = Course.coursecodeMapping.get(courseCodeDrop);

        // Check if the course exists in the current semester
        if (courseToDrop == null || !currentCourses.contains(courseToDrop)) {
            System.out.println("Error: Course not found in your current semester.");
            return "1";
        }

        // Drop the course from the student's current semester
        switch (currentSem) {
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
            default:
                System.out.println("Error: Invalid semester.");
                return "1";
        }

        System.out.println("Course " + courseCodeDrop + " dropped successfully.");
        return "1"; // Success code

    } else {
        System.out.println("Error: Invalid option. Please choose 1 or 2.");
        return "1"; // Return error for invalid option
    }
}





        
    


    


    @Override
    public void display_schedule(String emailid) {
        Stdacad student = Stdacad.getStudentByEmail(emailid);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        char currentSem = student.getSem();
        ArrayList<Course> currentCourses = student.getCoursesForSemester(currentSem);

        if (currentCourses == null || currentCourses.isEmpty()) {
            System.out.println("No courses available for the current semester.");
            return;
        }

        for (Course course : currentCourses) {
            System.out.println("Course: " + course.getCoursecode());
            System.out.println("Location: " + course.getLocation());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Day: " + course.getDay());
            System.out.println("--------------------------------------");
        }
    }

    @Override
    public void display_course_titles(String emailid) {
        Stdacad student = Stdacad.getStudentByEmail(emailid);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        char currentSem = student.getSem();
        ArrayList<Course> currentCourses = student.getCoursesForSemester(currentSem);

        if (currentCourses == null || currentCourses.isEmpty()) {
            System.out.println("No courses available for the current semester.");
            return;
        }

        for (Course course : currentCourses) {
            System.out.println("Course: " + course.getCoursecode());
        }
    }

    // Helper method to get prerequisites (already provided by you)
    private ArrayList<String> getPrerequisitesDisplay(String courseCode) {
        ArrayList<Course> prerequisites = Course.getPrerequisites(courseCode);
        ArrayList<String> prereqTitles = new ArrayList<>();
        for (Course prereq : prerequisites) {
            prereqTitles.add(prereq.getCoursecode());
        }
        return prereqTitles;
    }
}