package oop.veda;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseCode;
    private int L, T, P, S, C;
    private String lectureType = "Lecture";
    private String instructor;
    private String preRequsite = "";
    private String labAssistance;

    public Course(String name, String code, int L, int T, int P, int S, int C, String instructor) {
        courseName      = name;
        courseCode      = code;
        this.L          = L;
        this.T          = T;
        this.P          = P;
        this.S          = S;
        this.C          = C;
        this.instructor = instructor;
    }

    public Course(String name, String code, int L, int T, int P, int S, int C, String instructor,
            String preReq, String labAssistance) {
        this(name, code, L, T, P, S, C, instructor);
        set_preRequsite(preReq);
        set_labAssistance(labAssistance);
    }

    public Course(Course another) {
        // Copy constructor
        this.courseName  = another.get_courseName();
        this.courseCode  = another.get_courseCode();
        int[] ltpsc      = another.get_ltpsc();
        this.L           = ltpsc[0];
        this.T           = ltpsc[1];
        this.P           = ltpsc[2];
        this.S           = ltpsc[3];
        this.C           = ltpsc[4];
        this.instructor  = another.get_instructor();
        this.preRequsite = another.get_preRequsite();
    }

    public void printCourseDetails() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("Course code: " + courseCode);
        System.out.printf("L-T-P-S-C  : %d-%d-%d-%d-%d\n", L, T, P, S, C);
        System.out.printf("Instructor : %s", instructor);
    }

    public static ArrayList<Course> acceptCourse()
            throws IOException, ParseException, FileNotFoundException {
        FileReader f  = new FileReader("courses.json");
        JSONObject jo = (JSONObject) new JSONParser().parse(f);
        JSONArray c   = (JSONArray) jo.get("courses");

        ArrayList<Course> courses = new ArrayList<Course>();

        for (Object o : c) {
            JSONObject o1         = (JSONObject) o;
            String title          = (String) o1.get("title");
            String code           = (String) o1.get("code");
            JSONArray ltpsc       = (JSONArray) o1.get("LTPSC");
            String lect           = (String) o1.get("lecturer");
            String preReq         = (String) o1.get("pre-req");
            String lab_assistance = (String) o1.get("lab-assistance");

            if ((Long) ltpsc.get(2) <= 0 && (lab_assistance != null)) {
                System.err.println("Assigned Lab assistance when there is no lab.");
                System.err.println("Ignoring the lab assistance for " + code);
                lab_assistance = null;
            }

            if (preReq == null) preReq = "";
            if (lab_assistance == null) lab_assistance = "";

            courses.add(new Course(title, code, ((Long) ltpsc.get(0)).intValue(),
                    ((Long) ltpsc.get(1)).intValue(), ((Long) ltpsc.get(2)).intValue(),
                    ((Long) ltpsc.get(3)).intValue(), ((Long) ltpsc.get(4)).intValue(), lect,
                    preReq, lab_assistance));
        }

        return courses;
    }

    public int[] get_ltpsc() {
        return new int[] {L, T, P, S, C};
    }

    public String get_courseName() {
        return courseName;
    }

    public int[] get_ltp() {
        return new int[] {L, T, P};
    }

    public String get_courseCode() {
        return courseCode;
    }

    public void set_lectureType(String type) {
        lectureType = type;
    }

    public String get_lectureType() {
        return lectureType;
    }

    public String toString() {
        return get_courseCode() + "   " + get_lectureType();
    }

    public String get_instructor() {
        return instructor;
    }

    public String get_preRequsite() {
        return preRequsite;
    }

    public void set_preRequsite(String preRequsite) {
        this.preRequsite = preRequsite;
    }

    public String get_labAssistance() {
        return labAssistance;
    }

    public void set_labAssistance(String labAssistance) {
        this.labAssistance = labAssistance;
    }
}
