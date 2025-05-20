package com.company.Mainusers;

import java.util.HashMap;
//basically aplace where emaila nd password mapping is initialsed nad created//encapsulation used here too///is inherited user abstract class which is further
//inherited by student,admin and prof
class TopLevelData {
    static private HashMap<String, String> Student_security = new HashMap<>();
    static private HashMap<String, String> Admin_security = new HashMap<>();
    static private HashMap<String, String> Professor_security = new HashMap<>();

    public static void Student_setter(String emailid, String passwd) {
        Student_security.put(emailid, passwd);
    }

    public static void Admin_setter(String emailid, String passwd) {
        Admin_security.put(emailid, passwd);
    }

    public static void Professor_setter(String emailid, String passwd) {
        Professor_security.put(emailid, passwd);
    }

    public static String Student_getter(String emailid) {
        return Student_security.get(emailid);
    }

    public static String Admin_getter(String emailid) {
        return Admin_security.get(emailid);
    }

    public static String Professor_getter(String emailid) {
        return Professor_security.get(emailid);
    }

    public static Boolean Professor_checker(String emailid) {
        return Professor_security.containsKey(emailid);
    }

    public static Boolean Student_checker(String emailid) {
        return Student_security.containsKey(emailid); // Updated to check Student_security
    }

    public static Boolean Admin_checker(String emailid) {
        return Admin_security.containsKey(emailid); // Updated to check Admin_security
    }

    static {
        Admin_security.put("Rahuladmin@iiitd.ac.in", "password");
        Student_security.put("a1@iiitd.ac.in", null);
        Student_security.put("a2@iiitd.ac.in", null);
        Student_security.put("a3@iiitd.ac.in", "iama3student");
        Professor_security.put("p1@iiitd.ac.in", "iamp1professor");
        Professor_security.put("p2@iiitd.ac.in", null);
        Student_security.put("a4@iiitd.ac.in", "student");
        Student_security.put("a5@iiitd.ac.in", "student123");
        Professor_security.put("p3@iiitd.ac.in", "iamp3professor");
        Professor_security.put("p4@iiitd.ac.in", null);
        Professor_security.put("p5@iiitd.ac.in", null);
        

    }
}