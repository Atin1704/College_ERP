
package com.company.Mainusers;

import java.util.Scanner;
//inheritance used here mainly ,here the info for adin functions being called are implemented
public class Personal_info_methods extends Studentpersonal_info implements Interfacesforadmin {

    public Personal_info_methods(String emailid, String name, String mother_name, String branch, char year) {
        super(emailid, name, mother_name, branch, year);
    }

    static void display_alldata(String email) {
        Studentpersonal_info student = Studentpersonal_info.getPersonalInfoByEmail(email);
        if (student != null) {
            System.out.println("Email ID: " + student.getEmailid());
            System.out.println("Name: " + student.getName());
            System.out.println("Mother's Name: " + student.getMother_name());
            System.out.println("Branch: " + student.getBranch());
            System.out.println("Year: " + student.getYear());
        } else {
            System.out.println("No data found for the provided email.");
        }
    }

    public static void view_change_password(String email) {
        Scanner scanner = new Scanner(System.in);
        
        // Check if the student exists
        if (!TopLevelData.Student_checker(email)) {
            System.out.println("Email ID not found in the system.");
            return;
        }
        
        // Display the current password, handle null cases
        String currentPassword = TopLevelData.Student_getter(email); // Assuming you have a getter method for current password
        if (currentPassword == null) {
            System.out.println("Current password is not set.");
        } else {
            System.out.println("Current password: " + currentPassword);
        }
    
        // Ask if the user wants to change the password
        System.out.println("Do you want to change the password? (y/n)");
        String response = scanner.next();
    
        if ("y".equalsIgnoreCase(response)) {
            System.out.println("Enter new password:");
            String newPassword = scanner.next();
    
            // Check if the new password is empty
            if (newPassword.trim().isEmpty()) {
                System.out.println("Password cannot be empty. Change aborted.");
            } else {
                TopLevelData.Student_setter(email, newPassword);
                System.out.println("Password updated successfully.");
            }
        } else {
            System.out.println("Password change cancelled.");
        }
    }
    
    public static String change_personal_data(String email) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
    
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforadmin.display_personal_data_menu();
            input = scanner.next();
    
            if ("1".equals(input)) {
                return input; // Go back to the previous directory
            } else if ("2".equals(input)) {
                Studentpersonal_info student = Studentpersonal_info.getPersonalInfoByEmail(email);
                if (student != null) {
                    // Display current data
                    System.out.println("Current name: " + student.getName());
                    System.out.println("Enter new name:");
                    String newName = scanner.next();
                    student.setName(newName);
                    System.out.println("Name updated successfully.");
                } else {
                    System.out.println("Student not found.");
                }
                Interfacesforadmin.display_after_task();
                input = scanner.next(); // Take input after displaying the task
            } else if ("3".equals(input)) {
                Studentpersonal_info student = Studentpersonal_info.getPersonalInfoByEmail(email);
                if (student != null) {
                    // Display current data
                    System.out.println("Current branch: " + student.getBranch());
                    System.out.println("Enter new branch:");
                    String newBranch = scanner.next();
                    student.setBranch(newBranch);
                    System.out.println("Branch updated successfully.");
                } else {
                    System.out.println("Student not found.");
                }
                Interfacesforadmin.display_after_task();
                input = scanner.next(); // Take input after displaying the task
            } else if ("4".equals(input)) {
                Studentpersonal_info student = Studentpersonal_info.getPersonalInfoByEmail(email);
                if (student != null) {
                    // Display current data
                    System.out.println("Current year: " + student.getYear());
                    System.out.println("Enter new year (e.g., '2' for second year):");
                    char newYear = scanner.next().charAt(0);
                    student.setYear(newYear);
                    System.out.println("Year updated successfully.");
                } else {
                    System.out.println("Student not found.");
                }
                Interfacesforadmin.display_after_task();
                input = scanner.next(); // Take input after displaying the task
            } else if ("5".equals(input)) {
                Studentpersonal_info student = Studentpersonal_info.getPersonalInfoByEmail(email);
                if (student != null) {
                    // Display current data
                    System.out.println("Current mother's name: " + student.getMother_name());
                    System.out.println("Enter new mother's name:");
                    String newMotherName = scanner.next();
                    student.setMother_name(newMotherName);
                    System.out.println("Mother's name updated successfully.");
                } else {
                    System.out.println("Student not found.");
                }
                Interfacesforadmin.display_after_task();
                input = scanner.next(); // Take input after displaying the task
            } else if ("0".equals(input) || "-1".equals(input)) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
                input = scanner.next(); // Ensure the loop continues
            }
        }
    
        return input;
    }
}

    






