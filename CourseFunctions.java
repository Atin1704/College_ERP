package com.company.Mainusers;
import com.company.Mainusers.*;

//basically more a function than a class, used to keep code organized, also method overriding a feature of polymorphism used here
//similar definition can be used for complaint functions
import java.util.Scanner;

public class CourseFunctions implements Interfacesforadmin,Interfacesforprofessors,Interfacesforstudent {

    public static String handleCourses(Professor professor) {
        Courserunner runforprof = new Profcourserunner();
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforprofessors.display_academics();
            input = scanner.next();
            scanner.nextLine(); 
    
            if ("1".equals(input)) {
                return input; // Go back to the previous directory
            } else if ("2".equals(input)) {
                runforprof.displaycourses(professor.email);
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            } else if ("3".equals(input)) { 
                System.out.println("Enter course title: ");
                String courseTitle = scanner.nextLine();
                input = runforprof.update_data(courseTitle);
            } else if ("4".equals(input)) {
                System.out.println("Enter course title: ");
                String courseTitle = scanner.nextLine();
                runforprof.displaystudentdata(courseTitle);
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

    public static String handleCourses(Student student) {
        Courserunner runforStd = new Studentcourserunner();
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforstudent.display_academics();
            input = scanner.next();
            scanner.nextLine(); 
    
            if ("1".equals(input)) {
                return input; // Go back to the previous directory
            } else if ("2".equals(input)) {
                
                runforStd.displaycourses(student.email);
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            } else if ("3".equals(input)) {
                runforStd.displaystudentdata(student.email);
                Interfacesforstudent.display_after_task();
                input = scanner.next();
                
                
            } else if ("4".equals(input)) {
                input=runforStd.update_data(student.email);


                
                
            }
            else if ("5".equals(input)) {
                runforStd.display_schedule(student.email);
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            }
            else if ("6".equals(input)) {
                runforStd.display_course_titles(student.email);
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            }  
            
            else if ("0".equals(input) || "-1".equals(input)) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
        return input;
        
    }

    public static String handleCourses(Admin admin) {

        Courserunner runforAdmin = new Admincourserunner();
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforadmin.display_academics();
            input = scanner.next();
            scanner.nextLine(); 
    
            if ("1".equals(input)) {
                return input; // Go back to the previous directory
            } else if ("2".equals(input)) {
                runforAdmin.displaycourses();
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            } else if ("3".equals(input)) {
                runforAdmin.displaystudentdata();
                Interfacesforstudent.display_after_task();
                input = scanner.next();
                
            } else if ("4".equals(input)) {
                runforAdmin.update_data();
                Interfacesforstudent.display_after_task();
                input = scanner.next();
            }
            else if ("0".equals(input) || "-1".equals(input)) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
        return input;
        
        
    }
    

}
