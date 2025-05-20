package com.company.Mainusers;
//interface that is used t run studnet course runner,admincourserunner, used for abstraction and polymorphism
public interface Courserunner {

    default void displaycourses(String emailid){};
    void displaystudentdata(String emailid);
    String update_data(String emailid);
    default public void display_course_titles(String emailid){
        System.out.println();
    }
    default public void display_schedule(String emailid){
        System.out.println();
    }
    default void displaycourses(){};
    default void displaystudentdata(){};
    default void  update_data(){};
    


    

    
}
