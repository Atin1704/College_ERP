package com.company.Mainusers;

import java.util.Scanner;

public class Student extends User implements Interfacesforstudent {

    @Override
    public String Startprocedure() {
        Boolean checkemail = false;
        Scanner scanner = new Scanner(System.in);
        while (!checkemail) {
            System.out.println("Welcome student\nPlease provide your email address");
            String emailid = scanner.next();
            checkemail = Student_checker(emailid); // Check if email exists in student records
            if (checkemail) {
                this.email = emailid; // Assign the email if it exists
                break;
            } else {
                System.out.println("Wrong email id, try again");
            }
        }

        Boolean checkpassword = false;
        int attempts = 0;
        while (!checkpassword && attempts < 3) {
            String passwdexistence = Student_getter(this.email); // Get password for student email
            if (passwdexistence == null) {
                System.out.println("Create password");
                String passwd1 = scanner.next();
                System.out.println("Re-enter password");
                String passwd2 = scanner.next();
                if (passwd1.equals(passwd2)) {
                    checkpassword = true;
                    Student_setter(email, passwd1); // Set the new password for student
                } else {
                    System.out.println("Passwords do not match, try again");
                    attempts++;
                }
            } else {
                System.out.println("Enter password:");
                String passwdEntered = scanner.next();
                if (passwdexistence.equals(passwdEntered)) {
                    checkpassword = true; // Password entered correctly
                } else {
                    System.out.println("Incorrect password, try again");
                    attempts++;
                }
            }
        }

        if (attempts >= 3) {
            System.out.println("Too many attempts, returning to login page");
            return "0"; // Return to login after too many attempts
        }

        String nextstep = null;
        System.out.println("Main directory");
        while (!"0".equals(nextstep) && !"-1".equals(nextstep)) {
            User.Entry(); // Call the common entry method
            nextstep = scanner.next();
            if ("2".equals(nextstep)) {
                nextstep = showfunctionalities(); // Show Student-specific functionalities
                if ("1".equals(nextstep)) {
                    System.out.println("Main directory");
                    continue;
                }
            } else if ("0".equals(nextstep) || "-1".equals(nextstep)) {
                break;
            } else {
                System.out.println("Invalid input, try again");
            }
        }
        return nextstep;
    }

    @Override
    public String showfunctionalities() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforstudent.display_main();
            input = scanner.next();
            if ("1".equals(input)) {
                return input;
            } else if ("2".equals(input)) {
                input = ComplaintFunctions.handleComplaints(this);
            } 
            else if("3".equals(input)){
                input=CourseFunctions.handleCourses(this);
            }
            else if ("0".equals(input) || "-1".equals(input)) {
                break;
            } else {
                System.out.println("Invalid input, try again");
            }
        }
        return input;
    }
}