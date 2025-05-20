package com.company.Mainusers;

import java.util.Scanner;

public class ComplaintFunctions implements Interfacesforadmin, Interfacesforstudent {

    // For Students
    public static String handleComplaints(Student student) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforstudent.display_complaints();
            input = scanner.next();
            scanner.nextLine(); 
    
            if ("1".equals(input)) {
                return input; // Go back to the previous directory
            } else if ("2".equals(input)) {
                System.out.println("Provide title for complaint:");
                String title = scanner.nextLine();
                System.out.println("Provide description for complaint:");
                String description = scanner.nextLine();
                new Student_complain(student.getEmail(), title, description);
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            } else if ("3".equals(input)) {
                Student_complain.viewAllComplaints(student.getEmail());
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            } else if ("4".equals(input)) {
                Student_complain.viewComplaintsSortedByDate(student.getEmail());
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            } else if ("0".equals(input) || "-1".equals(input)) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
        return input;
    }

    // For Admins
    public static String handleComplaints(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforadmin.display_complaints();
            input = scanner.next();
            if ("1".equals(input)) {
                return input; // Go back to the previous directory
            } else if ("2".equals(input)) {
                System.out.println("Enter complaint ID to update:");
                String complaintId = scanner.next();
                Admin_complaint.updateComplaintById(complaintId);
                Interfacesforadmin.display_after_task();
                input = scanner.next();
            } else if ("3".equals(input)) {
                System.out.println("Enter status to filter:");
                String status = scanner.next();
                Admin_complaint.viewComplaintsByStatus(status);
                Interfacesforadmin.display_after_task();
                input = scanner.next();
            } else if ("4".equals(input)) {
                Admin_complaint.viewAllComplaintsSortedByDate();
                Interfacesforadmin.display_after_task();
                input = scanner.next();
            } else if ("5".equals(input)) {
                System.out.println("Enter student email to view complaints:");
                String email = scanner.next();
                Admin_complaint.viewComplaintsByStudentEmail(email);
                Interfacesforadmin.display_after_task();
                input = scanner.next();
            } else if ("0".equals(input) || "-1".equals(input)) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
        return input;
    }
}