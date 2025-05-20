package com.company.Mainusers;

import java.util.HashMap;
//a class where stduent personal info is stored, differnet class to amke it scalable  inherited by admin info methods
public class Studentpersonal_info {
    private String emailid;
    private String name;
    private String mother_name;
    private String branch;
    private char year;
    private static HashMap<String, Studentpersonal_info> personaldata = new HashMap<>();

    
    // Constructor
    public Studentpersonal_info(String emailid, String name, String mother_name, String branch, char year) {
        this.emailid = emailid;
        this.name = name;
        this.mother_name = mother_name;
        this.branch = branch;
        this.year = year;   
        // Add this instance to the HashMap when it's created
        personaldata.put(emailid, this);
    }
     
    static {
        // Initialize Studentpersonal_info instances for a1 to a5
        new Studentpersonal_info("a1@iiitd.ac.in", "a1", "motherofa1", "cse", '1');
        new Studentpersonal_info("a2@iiitd.ac.in", "a2", "motherofa2", "ece", '2');
        new Studentpersonal_info("a3@iiitd.ac.in", "a3", "motherofa3", "me", '3');
        new Studentpersonal_info("a4@iiitd.ac.in", "a4", "motherofa4", "bio", '4');
        new Studentpersonal_info("a5@iiitd.ac.in", "a5", "motherofa5", "phy", '5');
    }
    
    // Getter and Setter for emailid
    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for mother_name
    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    // Getter and Setter for branch
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    // Getter and Setter for year
    public char getYear() {
        return year;
    }

    public void setYear(char year) {
        this.year = year;
    }

    // Static method to retrieve student personal info by email ID
    public static Studentpersonal_info getPersonalInfoByEmail(String emailid) {
        return personaldata.get(emailid);
    }
}

