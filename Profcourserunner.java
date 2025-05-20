package com.company.Mainusers;

import java.util.Scanner;
import java.util.ArrayList;
//similar definition applies for studnet course runner etc, run thru na interface displaying polymorphism
//provide methods and to display academic info,seperate classes made for prof studnet and to make code more specific and easier to change
public class Profcourserunner implements Courserunner {

    @Override
    public void displaycourses(String emailid) {
        // Display all courses taught by the professor with email id
        ArrayList<Course> courses = Course.getCoursesByProfessorEmail(emailid);
        if (courses != null) {
            for (Course course : courses) {
                System.out.println("Course Code: " + course.getCoursecode());
                System.out.println("Title: " + course.getCoursetitle());
                System.out.println("Credits: " + course.getCourseCredits());
                System.out.println("Schedule: " + course.getSchedule());
                System.out.println("Location: " + course.getLocation());
                System.out.println("Office Hours: " + course.getOfficehrs());
                System.out.println("Day: " + course.getDay());
                System.out.println("Prerequisites: " + getPrerequisitesDisplay(course.getCoursecode()));
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("No courses found for professor with email " + emailid);
        }
    }

    @Override
    public void displaystudentdata(String coursecode) {
        // Show all students enrolled in the course with the given code
        Course course = Course.getCourseByCode(coursecode);
        if (course != null) {
            ArrayList<Stdacad> students = Stdacad.course_stdacad_mapping.get(course);
            if (students != null) {
                for (Stdacad student : students) {
                    System.out.println("Student Email: " + student.getStudentEmailId());
                    System.out.println("GPA: " + student.calculateGPA());
                }
            } else {
                System.out.println("No students are enrolled in this course.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }
    @Override
public String update_data(String coursecode) {
    Scanner scanner = new Scanner(System.in);
    String input = null;

    while (!"-1".equals(input) && !"0".equals(input)) {

        display_menu();
        input = scanner.next();
        scanner.nextLine(); // Consume the leftover newline character

        if ("1".equals(input)) {
            return input; // Go back to the previous directory
        } else if ("2".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Update course code (current code: " + course.getCoursecode() + ")");
                System.out.println("Are you sure you want to update? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Remove old course from all mappings
                    Course.coursecodeMapping.remove(coursecode);
                    Course.professorCoursesMapping.get(course.getProfEmailId()).remove(course);
                    Course.semCourseMapping.get(course.getSem()).remove(course);

                    // Update course code
                    System.out.println("Enter new course code:");
                    String newCode = scanner.nextLine();
                    course.setCoursecode(newCode);

                    // Add course to new mappings
                    Course.coursecodeMapping.put(newCode, course);
                    Course.professorCoursesMapping.computeIfAbsent(course.getProfEmailId(), k -> new ArrayList<>()).add(course);
                    Course.semCourseMapping.computeIfAbsent(course.getSem(), k -> new ArrayList<>()).add(course);

                    System.out.println("Course code updated to " + newCode);
                    System.out.println("exiting menu to save info" );
                    return "1";

                }
                
            }
        } else if ("3".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Update office hours (current hours: " + course.getOfficehrs() + ")");
                System.out.println("Are you sure you want to update? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Code to update office hours
                    System.out.println("Enter new office hours:");
                    String newHours = scanner.nextLine();
                    course.setOfficehrs(newHours);
                    System.out.println("Office hours updated to " + newHours);
                }
                Interfacesforstudent.display_after_task();
            }
        } else if ("4".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Update days (current days: " + course.getDay() + ")");
                System.out.println("Are you sure you want to update? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Code to update days
                    System.out.println("Enter new days:");
                    String newDays = scanner.nextLine();
                    course.setDay(newDays);
                    System.out.println("Days updated to " + newDays);
                }
                Interfacesforstudent.display_after_task();
            }
        } else if ("5".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Update schedule (current schedule: " + course.getSchedule() + ")");
                System.out.println("Are you sure you want to update? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Code to update schedule
                    System.out.println("Enter new schedule:");
                    String newSchedule = scanner.nextLine();
                    course.setSchedule(newSchedule);
                    System.out.println("Schedule updated to " + newSchedule);
                }
                Interfacesforstudent.display_after_task();
            }
        } else if ("6".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Current pre-requisites: " + getPrerequisitesDisplay(coursecode));
                System.out.println("Add pre-requisite");
                System.out.println("Are you sure you want to add a pre-requisite? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Code to add pre-requisite
                    System.out.println("Enter pre-requisite course code:");
                    String prereqCode = scanner.nextLine();
                    Course prereqCourse = Course.getCourseByCode(prereqCode);
                    if (prereqCourse != null) {
                        Course.addPrerequisite(coursecode, prereqCourse);
                        System.out.println("Pre-requisite added: " + prereqCode);
                    } else {
                        System.out.println("Prerequisite course not found.");
                    }
                }
                Interfacesforstudent.display_after_task();
            }
        } else if ("7".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Current pre-requisites: " + getPrerequisitesDisplay(coursecode));
                System.out.println("Drop pre-requisite");
                System.out.println("Are you sure you want to drop a pre-requisite? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Code to drop pre-requisite
                    System.out.println("Enter pre-requisite course code to drop:");
                    String prereqCode = scanner.nextLine();
                    Course prereqCourse = Course.getCourseByCode(prereqCode);
                    if (prereqCourse != null) {
                        Course.removePrerequisite(coursecode, prereqCourse);
                        System.out.println("Pre-requisite dropped: " + prereqCode);
                    } else {
                        System.out.println("Prerequisite course not found.");
                    }
                }
                Interfacesforstudent.display_after_task();
            }
        } else if ("8".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Change course credits (current credits: " + course.getCourseCredits() + ")");
                System.out.println("Are you sure you want to change the credits? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Code to change course credits
                    System.out.println("Enter new course credits:");
                    
                    int newCredits = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if(newCredits!=2||newCredits!=4){
                        System.out.println("wrong credits");
                        return "1";

                    }
                    course.setCourseCredits(newCredits);
                    System.out.println("Course credits updated to " + newCredits);
                }
                Interfacesforstudent.display_after_task();
            }
        } else if ("9".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Change course title (current title: " + course.getCoursetitle() + ")");
                System.out.println("Are you sure you want to change the title? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Code to change course title
                    System.out.println("Enter new course title:");
                    String newTitle = scanner.nextLine();
                    course.setCoursetitle(newTitle);
                    System.out.println("Course title updated to " + newTitle);
                }
                Interfacesforstudent.display_after_task();
            }
        } else if ("10".equals(input)) {
            Course course = Course.getCourseByCode(coursecode);
            if (course != null) {
                System.out.println("Change course location (current location: " + course.getLocation() + ")");
                System.out.println("Are you sure you want to change the location? (y/n)");
                String confirmation = scanner.nextLine();
                if ("y".equalsIgnoreCase(confirmation)) {
                    // Code to change course location
                    System.out.println("Enter new course location:");
                    String newLocation = scanner.nextLine();
                    course.setLocation(newLocation);
                    System.out.println("Course location updated to " + newLocation);
                }
                Interfacesforstudent.display_after_task();
            }
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }
    return input;
}
    
    private void display_menu() {
        System.out.println("Select an option:");
        System.out.println("1. Go back");
        System.out.println("2. Update course code");
        System.out.println("3. Update office hours");
        System.out.println("4. Update days");
        System.out.println("5. Update schedule");
        System.out.println("6. Add pre-requisite");
        System.out.println("7. Drop pre-requisite");
        System.out.println("8. Change course credits");
        System.out.println("9. Change course title");
        System.out.println("10. Change course location");
        System.out.println("-1. Exit");
    }

    private ArrayList<String> getPrerequisitesDisplay(String courseCode) {
        // Fetch prerequisites using the static method from Course class
        ArrayList<Course> prerequisites = Course.getPrerequisites(courseCode);
        
        ArrayList<String> prereqTitles = new ArrayList<>();
        
        // Iterate through prerequisites and collect course codes
        for (Course prereq : prerequisites) {
            prereqTitles.add(prereq.getCoursecode());
        }
        
        return prereqTitles;
    }
}