package com.company.Mainusers;

import java.util.Scanner;
//works similar to complaint functions, just this is just a basic method more than a class tbh
public class Info_for_admin implements Interfacesforadmin {

    public static String handlePersonalinfo(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (!"-1".equals(input) && !"0".equals(input)) {
            Interfacesforadmin.display_personal_info_menu();
            input = scanner.next();
            if ("1".equals(input)) {
                return input; // Go back to the previous directory
            } else if ("2".equals(input)) {
                System.out.println("Enter student's email id");
                String emailid = scanner.next();
                Personal_info_methods.display_alldata(emailid);
                Interfacesforadmin.display_after_task();
                input = scanner.next();
            } else if ("3".equals(input)) {
                System.out.println("Enter student's email id");
                String emailid = scanner.next();
                Personal_info_methods.view_change_password(emailid);
                Interfacesforadmin.display_after_task();
                input = scanner.next();
            } else if ("4".equals(input)) {
                System.out.println("Enter student's email id");
                String emailid = scanner.next();
                input = Personal_info_methods.change_personal_data(emailid);
                // No need to display after task here, not required
            } else if ("0".equals(input) || "-1".equals(input)) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
        return input;
    }
}
