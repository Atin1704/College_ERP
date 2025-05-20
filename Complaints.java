package com.company.Mainusers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
//encapuslation used here;basically a constrcutor for complaints
public class Complaints {

    protected static HashMap<String, ArrayList<Complaints>> holder = new HashMap<>(); // Key is the email, value is the list of complaints
    private String complaintId;
    private String studentEmailId;
    private String title;
    private String description;
    private String status="pending";
    private String resolutionDetails="no update";
    private String date;

    // Constructor
    Complaints(String emailId, String title, String description) {
        this.complaintId = UUID.randomUUID().toString();
        this.studentEmailId = emailId;
        this.title = title;
        this.description = description;
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        holder.putIfAbsent(emailId, new ArrayList<>()); // Add new student entry if doesn't exist
        holder.get(emailId).add(this); // Add the complaint to the student's list of complaints
    }

    // Static block to initialize sample complaints
    static {
        Complaints complaint1=new Complaints("a1@iiitd.ac.in", "Course clash", "Course m3 and ap are clashing");
        Complaints complaint2 = new Complaints("a1@iiitd.ac.in", "Plagiarism complaint", "I didn't use GPT");
        complaint2.setStatus("Resolved");
        complaint2.setResolutionDetails("Checked by admin, found valid");
        Complaints complaint3=new Complaints("a2@iiitd.ac.in", "Non-marking soles in badminton court", "Badminton court misuse.");
        complaint1.complaintId="400";
        complaint2.complaintId="700";
        complaint3.complaintId="900";


    }

    // Getters
    public String getComplaintId() {
        return complaintId;
    }

    public String getStudentEmailId() {
        return studentEmailId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getResolutionDetails() {
        return resolutionDetails;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public void setStudentEmailId(String studentEmailId) {
        this.studentEmailId = studentEmailId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResolutionDetails(String resolutionDetails) {
        this.resolutionDetails = resolutionDetails;
    }

    public void setDate(String date) {
        this.date = date;
    }
}