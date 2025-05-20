package com.company.Mainusers;
import java.util.Scanner;
//inheritance used here ,called thru polymorphism
public class Ta extends Student {



    @Override
    public String showfunctionalities() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            InterfacesforTa.display_main();
            input = scanner.next();
            if ("1".equals(input)) {
                return input;
            } else if ("2".equals(input)) {
                input = ComplaintFunctions.handleComplaints(this);
            } 
            else if("3".equals(input)){
                input=CourseFunctions.handleCourses(this);
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
