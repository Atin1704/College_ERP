package com.company.Mainusers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//inheritance used here,similar definition for studnet complains,inherits methods and uses them to sort admin side of complaints
//difference classes made for studnet and admin because differnet functionalities,easier to debug and change....
class Admin_complaint extends Complaints {

    // Constructor
    Admin_complaint(String emailId, String title, String description) {
        super(emailId, title, description);
    }

    // View all complaints sorted by date
    public static void viewAllComplaintsSortedByDate() {
        ArrayList<Complaints> allComplaints = new ArrayList<>();
        
        // Collect all complaints from all students
        for (ArrayList<Complaints> complaintsList : holder.values()) {
            allComplaints.addAll(complaintsList);
        }
        
        // Sort the complaints by date (newest first)
        Collections.sort(allComplaints, new Comparator<Complaints>() {
            @Override
            public int compare(Complaints c1, Complaints c2) {
                return c2.getDate().compareTo(c1.getDate()); // Sort by date (descending)
            }
        });

        // Display the sorted complaints
        System.out.println("Complaints sorted by date:");
        for (Complaints complaint : allComplaints) {
            System.out.println("Complaint ID: " + complaint.getComplaintId());
            System.out.println("Student Email: " + complaint.getStudentEmailId());
            System.out.println("Title: " + complaint.getTitle());
            System.out.println("Description: " + complaint.getDescription());
            System.out.println("Status: " + complaint.getStatus());
            System.out.println("Resolution Details: " + complaint.getResolutionDetails());
            System.out.println("Date: " + complaint.getDate());
            System.out.println("-----------------------------");
        }
    }

    // View all complaints with a similar status (e.g., "pending", "resolved")
    public static void viewComplaintsByStatus(String status) {
        ArrayList<Complaints> complaintsWithStatus = new ArrayList<>();
        
        // Collect complaints matching the status
        for (ArrayList<Complaints> complaintsList : holder.values()) {
            for (Complaints complaint : complaintsList) {
                if (complaint.getStatus().equalsIgnoreCase(status)) {
                    complaintsWithStatus.add(complaint);
                }
            }
        }

        if (complaintsWithStatus.isEmpty()) {
            System.out.println("No complaints with status: " + status);
        } else {
            System.out.println("Complaints with status '" + status + "':");
            for (Complaints complaint : complaintsWithStatus) {
                System.out.println("Complaint ID: " + complaint.getComplaintId());
                System.out.println("Student Email: " + complaint.getStudentEmailId());
                System.out.println("Title: " + complaint.getTitle());
                System.out.println("Description: " + complaint.getDescription());
                System.out.println("Status: " + complaint.getStatus());
                System.out.println("Resolution Details: " + complaint.getResolutionDetails());
                System.out.println("Date: " + complaint.getDate());
                System.out.println("-----------------------------");
            }
        }
    }

    // Update complaint status and add resolution details by complaint ID
    public static void updateComplaintById(String complaintId) {
        Complaints targetComplaint = null;

        // Search for the complaint by ID
        for (ArrayList<Complaints> complaintsList : holder.values()) {
            for (Complaints complaint : complaintsList) {
                if (complaint.getComplaintId().equals(complaintId)) {
                    targetComplaint = complaint;
                    break;
                }
            }
        }

        if (targetComplaint != null) {
            Scanner scanner = new Scanner(System.in);

            // Ask admin to update the status
            System.out.println("Enter the new status for Complaint ID: " + complaintId);
            String newStatus = scanner.nextLine();
            targetComplaint.setStatus(newStatus);

            // Ask if they want to add resolution details
            System.out.println("Do you want to add resolution details? (y/n)");
            String addResolution = scanner.nextLine();
            if (addResolution.equalsIgnoreCase("y")) {
                System.out.println("Enter resolution details:");
                String resolutionDetails = scanner.nextLine();
                targetComplaint.setResolutionDetails(resolutionDetails);
            }

            System.out.println("Complaint updated successfully.");
        } else {
            System.out.println("Complaint with ID: " + complaintId + " not found.");
        }
    }

    // View all complaints for a specific student by email
    public static void viewComplaintsByStudentEmail(String studentEmailId) {
        if (holder.containsKey(studentEmailId)) {
            ArrayList<Complaints> complaintsList = holder.get(studentEmailId);
            System.out.println("Complaints for student email: " + studentEmailId);
            for (Complaints complaint : complaintsList) {
                System.out.println("Complaint ID: " + complaint.getComplaintId());
                System.out.println("Title: " + complaint.getTitle());
                System.out.println("Description: " + complaint.getDescription());
                System.out.println("Status: " + complaint.getStatus());
                System.out.println("Resolution Details: " + complaint.getResolutionDetails());
                System.out.println("Date: " + complaint.getDate());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No complaints found for this email.");
        }
    }
}