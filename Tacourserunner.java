package com.company.Mainusers;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
//inheritance and interface used here, execpt ta duties all the relevant functions presnet in studentcourserunner
public class Tacourserunner extends Studentcourserunner implements Courserunner {
    private static HashMap<String, String> emailCourseMap = new HashMap<>();

// Static block to initialize the hashmap
static {
    emailCourseMap.put("a6@iiitd.ac.in", "ENT3");
    emailCourseMap.put("a7@iiitd.ac.in", "A2");
}

public void taduties(String email) {
    Scanner scanner = new Scanner(System.in);

    // Step 1: Check if email is in the hashmap
    if (!emailCourseMap.containsKey(email)) {
        System.out.println("Email not recognized. Access denied.");
        return;
    }

    // Step 2: Provide options to the user
    while (true) {
        System.out.println("Select an option:");
        System.out.println("1 - View course details");
        System.out.println("2 - View current students enrolled in the class");
        System.out.println("3 - Update student grades");
        

        System.out.print("Enter your choice: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                // View course details
                String courseCode = emailCourseMap.get(email);
                Course course = Course.getCourseByCode(courseCode);
                if (course != null) {
                    System.out.println("Course Details:");
                    System.out.println("Course Code: " + course.getCoursecode());
                    System.out.println("Title: " + course.getCoursetitle());
                    System.out.println("Credits: " + course.getCourseCredits());
                    System.out.println("Schedule: " + course.getSchedule());
                    System.out.println("Location: " + course.getLocation());
                    System.out.println("Office Hours: " + course.getOfficehrs());
                    System.out.println("Day: " + course.getDay());
                    System.out.println("Prerequisites: " + getPrerequisitesDisplay(courseCode));
                    System.out.println("Student limit: " + course.getStudent_limit());
                    System.out.println("Drop date: " + course.getDropDate());
                } else {
                    System.out.println("Course not found.");
                }
                return;

            case 2:
                // View current students enrolled in the class
                String currentCourseCode = emailCourseMap.get(email);
                displayCurrentStudents(currentCourseCode);
                return;

            case 3:
                // Update student grades
                String currentCourseCodeForGrades = emailCourseMap.get(email);
                Course currentCourse = Course.getCourseByCode(currentCourseCodeForGrades);
                ArrayList<Stdacad> students = Stdacad.course_stdacad_mapping.get(currentCourse);
                if (students != null && !students.isEmpty()) {
                    System.out.println("Select a student to update grades:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + " - " + students.get(i).getStudentEmailId());
                    }
                    System.out.print("Enter the number of the student: ");
                    int studentChoice = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline

                    if (studentChoice >= 0 && studentChoice < students.size()) {
                        Stdacad selectedStudent = students.get(studentChoice);
                        System.out.println("Current Grade: " + selectedStudent.getGrade(currentCourseCodeForGrades));

                        System.out.print("Do you want to update the grade? (Y/N): ");
                        String updateChoice = scanner.nextLine().trim().toUpperCase();

                        if (updateChoice.equals("Y")) {
                            System.out.print("Enter new grade: ");
                            int newGrade = scanner.nextInt();
                            selectedStudent.add_or_update_grade_sem1(currentCourse, newGrade); // Pass the Course object
                            System.out.println("Grade updated successfully.");
                        } else {
                            System.out.println("Grade update cancelled.");
                        }
                    } else {
                        System.out.println("Invalid student choice.");
                    }
                } else {
                    System.out.println("No students enrolled in this course.");
                }
                return;
                

            

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

// Method to display current students enrolled in the class
private void displayCurrentStudents(String courseCode) {
    Course course = Course.getCourseByCode(courseCode);
    ArrayList<Stdacad> students = Stdacad.course_stdacad_mapping.get(course);
    if (students != null && !students.isEmpty()) {
        System.out.println("Current students enrolled in the class:");
        for (Stdacad student : students) {
            System.out.println(student.getStudentEmailId());
        }
    } else {
        System.out.println("No students enrolled in this course.");
    }
}


}
