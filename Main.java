//method used polymorphism and abstraction,hiding inner details from the system
package com.company.Mainusers;
import java.util.Scanner;
//used polymorphism-run time 
public class Main {
    static void DisplayEntryMessage() {
        System.out.println("Welcome to the latest IIITD course registration system");
        System.out.println("Enter 1: for student\nEnter 2: for Professor\nEnter 3: for Admin\nEnter -1: for Exiting");
    }

    static void DisplayExitMessage() {
        System.out.println("Thanks for using the system, have a pleasant day");
    }

    public static void main(String[] args) {
        Course.display_hello();
        Stdacad.display_hello();
        Scanner scanner = new Scanner(System.in);
        String type = null;            //program entry points starts below

        while (!"-1".equals(type)) {
            DisplayEntryMessage();
            type = scanner.next();

            if ("-1".equals(type)) {                  
                break;
            } else if ("1".equals(type)) {
                User user1 = new Student();
                type = user1.Startprocedure();
            } else if ("2".equals(type)) {
                User user1 = new Professor();
                type = user1.Startprocedure();
            } else if ("3".equals(type)) {
                User user1 = new Admin();
                type = user1.Startprocedure();
            } else {
                System.out.println("Wrong entry, please try again.");
            }
        }

        DisplayExitMessage();
    }
}



