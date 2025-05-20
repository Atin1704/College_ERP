package com.company.Mainusers;

import java.util.Scanner;

public class Professor extends User {

    @Override
    public String Startprocedure() {
        Boolean checkemail = false;
        Scanner scanner = new Scanner(System.in);
        while (!checkemail) {
            System.out.println("Welcome professor\nPlease provide your email address");
            String emailid = scanner.next();
            checkemail = Professor_checker(emailid);
            if (checkemail) {
                this.email = emailid;
                break;
            } else {
                System.out.println("Wrong email id, try again");
            }
        }

        Boolean checkpassword = false;
        int attempts = 0;
        while (!checkpassword && attempts < 3) {
            String passwdexistence = Professor_getter(this.email);
            if (passwdexistence == null) {  // Use `== null` for null checks
                System.out.println("Create password");
                String passwd1 = scanner.next();
                System.out.println("Re-enter password");
                String passwd2 = scanner.next();
                if (passwd1.equals(passwd2)) {
                    checkpassword = true;
                    Professor_setter(email, passwd1);
                } else {
                    System.out.println("Passwords do not match, try again");
                    attempts++;
                }
            } else {
                System.out.println("Enter password:");
                String passwdEntered = scanner.next();
                if (passwdexistence.equals(passwdEntered)) {
                    checkpassword = true;
                } else {
                    System.out.println("Incorrect password, try again");
                    attempts++;
                }
            }
        }

        if (attempts >= 3) {
            System.out.println("Too many attempts, returning to login page");
            return "0";
        }

        String nextstep = null;
        System.out.println("Main directory");
        while (!"0".equals(nextstep) && !"-1".equals(nextstep)) {
            User.Entry();
            nextstep = scanner.next();
            if ("2".equals(nextstep)) {
                nextstep = showfunctionalities();
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

    public String showfunctionalities() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforprofessors.display_main();
            input = scanner.next();
            if ("1".equals(input)) {
                return input;
            } else if ("2".equals(input)) {
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