package com.company.Mainusers;

// Inheritance and abstraction used here
public abstract class User extends TopLevelData {

    protected String email;
    public String getEmail() {
        return email;
    }
    

    // Abstract methods to be implemented by subclasses
    public abstract String Startprocedure();

    public abstract String showfunctionalities();

    // Static method for entry message
    public static void Entry() {
        System.out.println("Enter -1: to exit");
        System.out.println("Enter 0: to logout");
        System.out.println("Enter 2: to see functionalities");

    }
}