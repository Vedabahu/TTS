package oop.veda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Course {

    private String courseName;
    private String courseCode;
    private int L, T, P, S, C;
    private String lectureType = "Lecture";

    public Course(String name, String code, int L, int T, int P, int S, int C) {
        courseName = name;
        courseCode = code;
        this.L = L;
        this.T = T;
        this.P = P;
        this.S = S;
        this.C = C;
    }

    public Course(Course another) {
    	// Copy constructor
    	this.courseName = another.get_courseName();
    	this.courseCode = another.get_courseCode();
    	int[] ltpsc = another.get_ltpsc();
    	this.L = ltpsc[0];
        this.T = ltpsc[1];
        this.P = ltpsc[2];
        this.S = ltpsc[3];
        this.C = ltpsc[4];
    }
    
    public void printCourseDetails() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("Course code: " + courseCode);
        System.out.printf("L-T-P-S-C  : %d-%d-%d-%d-%d\n", L, T, P, S, C);
    }

    public static ArrayList<Course> acceptCourse()
        throws IOException, ParseException, FileNotFoundException {
        FileReader f = new FileReader("cources.json");
        JSONObject jo = (JSONObject) new JSONParser().parse(f);
        JSONArray c = (JSONArray)jo.get("courses");

        ArrayList<Course> courses = new ArrayList<Course>();

        for (Object o : c) {
            JSONObject o1 = (JSONObject)o;
            String title = (String)o1.get("title");
            String code = (String)o1.get("code");
            JSONArray ltpsc = (JSONArray)o1.get("LTPSC");

            courses.add(new Course(title, code, ((Long)ltpsc.get(0)).intValue(),
                                   ((Long)ltpsc.get(1)).intValue(),
                                   ((Long)ltpsc.get(2)).intValue(),
                                   ((Long)ltpsc.get(3)).intValue(),
                                   ((Long)ltpsc.get(4)).intValue()));
        }

        return courses;
    }

    public int[] get_ltpsc() { return new int[] {L, T, P, S, C}; }
    public String get_courseName() { return courseName; }
    public int[] get_ltp() { return new int[] {L, T, P}; }
    public String get_courseCode() { return courseCode; }
    public void set_lectureType(String type) { lectureType = type; } 
    public String get_lectureType() { return lectureType; }
    public String toString() { return get_courseCode() + "   " + get_lectureType(); }
}
