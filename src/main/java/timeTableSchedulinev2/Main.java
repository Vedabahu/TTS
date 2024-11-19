package timeTableSchedulinev2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> c   = ReadCSE.readCoursesFromCSV("inputFiles/CSE.csv");
        ArrayList<Semester> s = Semester.convertToSems(c);

        TimeTable tt = new TimeTable(s);
        tt.makeTimeTable();
        tt.printTimeTable(0, "CSE-1st-sem.png");
        tt.printTimeTable(1, "CSE-3rd-sem.png");
        tt.printTimeTable(2, "CSE-5th-sem.png");

        ArrayList<Course> c1   = ReadCSE.readCoursesFromCSV("inputFiles/ECE.csv");
        ArrayList<Semester> s1 = Semester.convertToSems(c1);

        TimeTable tt1 = new TimeTable(s1);
        tt1.makeTimeTable();
        tt1.printTimeTable(1, "ECE-3rd-sem.png");
        tt1.printTimeTable(2, "ECE-5th-sem.png");
        tt1.printTimeTable(3, "ECE-7th-sem.png");

        ArrayList<Course> c2   = ReadCSE.readCoursesFromCSV("inputFiles/DSAI.csv");
        ArrayList<Semester> s2 = Semester.convertToSems(c2);

        TimeTable tt2 = new TimeTable(s2);
        tt2.makeTimeTable();
        tt2.printTimeTable(0, "DSAI-1st-sem.png");
        tt2.printTimeTable(1, "DSAI-3st-sem.png");
        tt2.printTimeTable(2, "DSAI-5st-sem.png");
    }
}
