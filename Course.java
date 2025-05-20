package com.company.Mainusers;
import com.company.Mainusers.*;

//courses initialsed here,multiple dat strcutures were created here for mapping, for better info on all classes use readme plz

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String coursecode;
    private int courseCredits;
    private String profEmailId;
    private char sem;
    private String location;
    private String schedule;
    private String coursetitle;
    private String day;  // Added field
    private String officehrs;

    protected static HashMap<String, Course> coursecodeMapping = new HashMap<>();
    protected static HashMap<String, ArrayList<Course>> professorCoursesMapping = new HashMap<>();
    protected static HashMap<Character, ArrayList<Course>> semCourseMapping = new HashMap<>();
    protected static HashMap<Course, ArrayList<Course>> prereqMapping = new HashMap<>();

    public Course(String coursecode, int courseCredits, String profEmailId, char sem, String location, String schedule, String coursetitle, String day, String officehrs) {
        this.coursecode = coursecode;
        this.courseCredits = courseCredits;
        this.profEmailId = profEmailId;
        this.sem = sem;
        this.location = location;
        this.schedule = schedule;
        this.coursetitle = coursetitle;
        this.day = day;  
        this.officehrs = officehrs;
    
        // Add course to coursecodeMapping
        coursecodeMapping.put(coursecode, this);
    
        // Add course to professor's course list
        ArrayList<Course> professorCourses = professorCoursesMapping.get(profEmailId);
        if (professorCourses == null) {
            professorCourses = new ArrayList<>();
            professorCoursesMapping.put(profEmailId, professorCourses);
        }
        if (!professorCourses.contains(this)) {  // Check for duplicate before adding
            professorCourses.add(this);
        }
    
        // Add course to semester course mapping
        ArrayList<Course> semesterCourses = semCourseMapping.get(sem);
        if (semesterCourses == null) {
            semesterCourses = new ArrayList<>();
            semCourseMapping.put(sem, semesterCourses);
        }
        semesterCourses.add(this);
    }

    // Getters and Setters
    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public String getProfEmailId() {
        return profEmailId;
    }

    public void setProfEmailId(String profEmailId) {
        this.profEmailId = profEmailId;
    }

    public char getSem() {
        return sem;
    }

    public void setSem(char sem) {
        this.sem = sem;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOfficehrs() {
        return officehrs;
    }

    public void setOfficehrs(String officehrs) {
        this.officehrs = officehrs;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public String getDay() {
        return day;  // Getter for day
    }

    public void setDay(String day) {
        this.day = day;  // Setter for day
    }

    
    public static void addPrerequisite(String coursecode, Course prerequisiteCourse) {
        Course course = coursecodeMapping.get(coursecode);
        if (course != null) {
            ArrayList<Course> prerequisites = prereqMapping.get(course);
            if (prerequisites == null) {
                prerequisites = new ArrayList<>();
                prereqMapping.put(course, prerequisites);
            }
            if (!prerequisites.contains(prerequisiteCourse)) {
                prerequisites.add(prerequisiteCourse);
            }
        } else {
            System.out.println("Course with code " + coursecode + " not found.");
        }
    }

    // Remove a prerequisite course
    public static void removePrerequisite(String coursecode, Course prerequisiteCourse) {
        Course course = coursecodeMapping.get(coursecode);
        if (course != null) {
            ArrayList<Course> prerequisites = prereqMapping.get(course);
            if (prerequisites != null && prerequisites.contains(prerequisiteCourse)) {
                prerequisites.remove(prerequisiteCourse);
            }
        } else {
            System.out.println("Course with code " + coursecode + " not found.");
        }
    }
    

    // Get a Course object by coursecode
    public static Course getCourseByCode(String coursecode) {
        return coursecodeMapping.get(coursecode);
    }

    static {
        Course.initialize();
    }

    public static void initialize() {
        String[] professors = {"p1@iiitd.ac.in", "p2@iiitd.ac.in", "p3@iiitd.ac.in", "p4@iiitd.ac.in", "p5@iiitd.ac.in"};
        Course cs1 = new Course("CS1", 4, professors[0], '1', "Room 101", "09:00-10:30", "CS1 Course", "MW","10:-11.00");
        Course m1 = new Course("M1", 4, professors[1], '1', "Room 102", "11:00-12:30", "M1 Course", "TTH","10:-11.00");
        Course ece1 = new Course("ECE1", 4, professors[2], '1', "Room 103", "09:00-10:30", "ECE1 Course", "MW","10:-11.00");
        Course a1 = new Course("A1", 4, professors[3], '1', "Room 104", "11:00-12:30", "A1 Course", "TTh","10:-11.00");
        Course ent1 = new Course("ENT1", 4, professors[4], '1', "Room 105", "09:00-10:30", "ENT1 Course", "F","10:-11.00");

        // Adding Semester 2 Courses
        Course cs2 = new Course("CS2", 4, professors[0], '2', "Room 201", "10:45-12:15", "CS2 Course", "MW","10:-11.00");
        Course m2 = new Course("M2", 4, professors[1], '2', "Room 202", "08:45-10:00", "M2 Course", "TTh","10:-11.00");
        Course ece2 = new Course("ECE2", 4, professors[2], '2', "Room 203", "10:45-12:15", "ECE2 Course", "T","10:-11.00");
        Course a2 = new Course("A2", 4, professors[3], '2', "Room 204", "08:45-10:00", "A2 Course", "MW","10:-11.00");
        Course ent2 = new Course("ENT2", 4, professors[4], '2', "Room 205", "10:45-12:15", "ENT2 Course", "TTh","10:-11.00");
        Course cs3 = new Course("CS3", 2, professors[0], '2', "Room 206", "10:45-12:15", "CS3 Course", "F","10:-11.00");
        Course m3 = new Course("M3", 2, professors[1], '2', "Room 207", "10:45-12:15", "M3 Course", "F","10:-11.00");

        // Adding Semester 3 Courses
        Course cs4 = new Course("CS4", 4, professors[0], '3', "Room 301", "13:00-14:30", "CS4 Course", "M","10:-11.00");
        Course m4 = new Course("M4", 4, professors[1], '3', "Room 302", "13:00-14:30", "M4 Course", "T","10:-11.00");
        Course ece3 = new Course("ECE3", 4, professors[2], '3', "Room 303", "13:00-14:30", "ECE3 Course", "W","10:-11.00");
        Course a3 = new Course("A3", 4, professors[3], '3', "Room 304", "13:00-14:30", "A3 Course", "Th","10:-11.00");
        Course ent3 = new Course("ENT3", 4, professors[4], '3', "Room 305", "13:00-14:30", "ENT3 Course", "F","10:-11.00");
        Course cs5 = new Course("CS5", 2, professors[0], '3', "Room 306", "11:00-12:30", "CS5 Course", "M","10:-11.00");
        Course m5 = new Course("M5", 2, professors[1], '3', "Room 307", "11:00-12:30", "M5 Course", "T","10:-11.00");

        cs2.addPrerequisite("CS2", cs1);
        m2.addPrerequisite("M2", m1);
        ece2.addPrerequisite("ECE2", ece1);

        cs3.addPrerequisite("CS3", cs2);
        m3.addPrerequisite("M3", m2);
        ece3.addPrerequisite("ECE3", ece2);
        a2.addPrerequisite("A2", a1);
        ent2.addPrerequisite("ENT2", ent1);

        cs4.addPrerequisite("CS4", cs3);
        m4.addPrerequisite("M4", m3);
        ece3.addPrerequisite("ECE3", ece2);
        a3.addPrerequisite("A3", a2);
        ent3.addPrerequisite("ENT3", ent2);
    }

    public static ArrayList<Course> getPrerequisites(String coursecode) {
        Course course = coursecodeMapping.get(coursecode);
        if (course != null) {
            return prereqMapping.getOrDefault(course, new ArrayList<>());
        } else {
            System.out.println("Course with code " + coursecode + " not found.");
            return new ArrayList<>();
        }
    }
    
    // Get the list of courses taught by a specific professor (based on professor's email)
    public static ArrayList<Course> getCoursesByProfessorEmail(String profEmailId) {
        ArrayList<Course> professorCourses = professorCoursesMapping.get(profEmailId);
        if (professorCourses != null) {
            return professorCourses;
        } else {
            System.out.println("No courses found for professor with email " + profEmailId);
            return new ArrayList<>();
        }
    }

    public static void display_hello() {
        System.out.println();
    }

    public static ArrayList<Course> getCoursesForSemester(char semester) {
        return semCourseMapping.getOrDefault(semester, new ArrayList<>());
    }
    
    
    
   
    
    
}

