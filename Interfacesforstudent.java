package com.company.Mainusers;

/**
 * Interfacesforoutput
 */
//these three interfaces below provid ethe menu to be printed, alllows me tokeep code clean as well makes it faster to do many thing
public interface Interfacesforstudent {
    static void display_main(){
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");
        System.out.println("Press 2 to go to complaints");
        System.out.println("Press 3 to go to academic");



    }
    static void display_complaints(){
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");
        System.out.println("Press 2 to create a complaint");
        System.out.println("Press 3 to view all complaints");
        System.out.println("Press 4 to view all complaints sorted by date");



    }
    static void display_after_task(){
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");

    }
    static void display_academics() {
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");
        System.out.println("Press 2 to display current sem courses");
        System.out.println("Press 3 to get sgpa/gpa");
        System.out.println("Press 4 to add/drop a course");
        System.out.println("Press 5 to view schedule");
        System.out.println("Press 6 to display courses taken this sem");
        
        



    
}
    static void displaycourses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displaycourses'");
    }}

interface Interfacesforprofessors {
    static void display_main(){
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");
        System.out.println("Press 2 to go to academics");


    }
    static void display_after_task(){
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");

    }
    static void display_academics() {
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");
        System.out.println("Press 2 to view courses");
        System.out.println("Press 3 to update course details");
        System.out.println("Press 4 to view students enrolled in course");
        
        
    }
    

    
}

interface Interfacesforadmin {
    static void display_main(){
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");
        System.out.println("Press 2 to go to complaints");
        System.out.println("Press 3 to go to view personal info\nNOTE:To view and change grades choose academics");
        System.out.println("Press 4 to go to academics");





    }
    static void display_after_task(){
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");

    }
    static void display_complaints(){
        System.out.println("Press -1 to close the program");
        System.out.println("Press 0 to logout");
        System.out.println("Press 1 to go back to the previous directory");
        System.out.println("Press 2 to update complaint status");
        System.out.println("Press 3 to view complaints by status");
        System.out.println("Press 4 to view all complaints sorted by date");
        System.out.println("Press 5 to view all complaints by a student");

    




    }
    static void display_personal_data_menu(){
        System.out.println("Press -1 to close program");
        System.out.println("Press 0 to close log out");
        System.out.println("Press 1 to go back to previous directory");
        System.out.println("Press 2 to update name");
        System.out.println("Press 3 to update branch");
        System.out.println("Press 4 to update year");
        System.out.println("Press 5 to update mother name");



    }
    static void display_personal_info_menu(){
        System.out.println("Press -1 to close program");
        System.out.println("Press 0 to close log out");
        System.out.println("Press 1 to go back to previous directory");
        System.out.println("Press 2 to view student data ");
        System.out.println("Press 3 to view and change password");
        System.out.println("Press 4 to update student data");
        }
    
    static void display_academics() {
            System.out.println("Press -1 to close the program");
            System.out.println("Press 0 to logout");
            System.out.println("Press 1 to go back to the previous directory");
            System.out.println("Press 2 to view/add/delete courses");
            System.out.println("Press 3 to view student record,update grades");
            System.out.println("Press 4 to assign prof to a course");

            
            
         //need to implement just three functions,we can do it   
    
    
    
        
    }
    
    
    }

    
    



    

    
