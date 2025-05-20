package com.company.Mainusers;

import java.util.Scanner;
//similar defn applicable for studnet and professor,inherits an abstract class and implements  amethod to print menu, abstract class refernce i used to run it showing polymorphism
public class Admin extends User {

    @Override
    public String Startprocedure() {
        Boolean checkemail = false;
        Scanner scanner = new Scanner(System.in);
        while (!checkemail) {
            System.out.println("Welcome admin\nPlease provide your email address");
            String emailid = scanner.next();
            checkemail = Admin_checker(emailid); // Check if email exists in admin records
            if (checkemail) {
                this.email = emailid; // Assign email if correct
                break;
            } else {
                System.out.println("Wrong email id, try again");
            }
        }

        Boolean checkpassword = false;
        int attempts = 0;
        while (!checkpassword && attempts < 3) {
            String passwd = Admin_getter(this.email); // Get the admin password
            System.out.println("Enter password:");
            String passwdEntered = scanner.next();
            if (passwd.equals(passwdEntered)) {
                checkpassword = true; // Password entered correctly
            } else {
                System.out.println("Incorrect password, try again");
                attempts++;
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
                nextstep = showfunctionalities(); // Show Admin-specific functionalities
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
            Interfacesforadmin.display_main();
            input = scanner.next();
            if ("1".equals(input)) {
                return input;
            } else if ("2".equals(input)) {
                input = ComplaintFunctions.handleComplaints(this);
            } else if ("3".equals(input)) {
                input = Info_for_admin.handlePersonalinfo(this);
            } 
            else if ("4".equals(input)) {
                input = CourseFunctions.handleCourses(this);
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