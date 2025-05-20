package com.company.Mainusers;

//inheritance used here


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student_complain extends Complaints {

    // Constructor
    Student_complain(String emailId, String title, String description) {
        super(emailId, title, description);
        System.out.println("Please note the complaint ID: " + this.getComplaintId());
    }

    // Method to view all complaints for a given student
    public static void viewAllComplaints(String studentEmailId) {
        if (holder.containsKey(studentEmailId)) {
            ArrayList<Complaints> complaintsList = holder.get(studentEmailId);
            System.out.println("Complaints for email: " + studentEmailId);
            for (Complaints complaint : complaintsList) {
                System.out.println("Complaint ID: " + complaint.getComplaintId());
                System.out.println("Title: " + complaint.getTitle());
                System.out.println("Description: " + complaint.getDescription());
                System.out.println("Status: " + complaint.getStatus());
                System.out.println("Remarks: " + complaint.getResolutionDetails());
                System.out.println("Date: " + complaint.getDate());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No complaints found for this email.");
        }
    }

    // Method to view complaints sorted by date for a given student
    public static void viewComplaintsSortedByDate(String studentEmailId) {
        if (holder.containsKey(studentEmailId)) {
            ArrayList<Complaints> complaintsList = holder.get(studentEmailId);

            // Sorting the list of complaints by date (newest first)
            Collections.sort(complaintsList, new Comparator<Complaints>() {
                @Override
                public int compare(Complaints c1, Complaints c2) {
                    return c2.getDate().compareTo(c1.getDate()); // Compare dates (descending order)
                }
            });

            System.out.println("Complaints for email (sorted by date): " + studentEmailId);
            for (Complaints complaint : complaintsList) {
                System.out.println("Complaint ID: " + complaint.getComplaintId());
                System.out.println("Title: " + complaint.getTitle());
                System.out.println("Description: " + complaint.getDescription());
                System.out.println("Status: " + complaint.getStatus());
                System.out.println("Remarks: " + complaint.getResolutionDetails());
                System.out.println("Date: " + complaint.getDate());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No complaints found for this email.");
        }
    }
}





