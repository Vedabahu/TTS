package oop.veda;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) {
        TimeTable tt = new TimeTable();
        try {
            tt.set_courses(Course.acceptCourse());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            System.exit(1);
        }

        if (!tt.validateCourses()) {
            System.out.println("All the courses can not be acomodated in a week. Please "
                    + "change the LTPSC structure or reduce the number of courses.");
            System.exit(1);
        }

        tt.makeTheTimeTable();
        tt.printTimeTable();
    }
}
