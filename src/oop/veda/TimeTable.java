package oop.veda;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

public class TimeTable {
    private ArrayList<Course> cs = new ArrayList<Course>();
    private Course[][] timeTable = null;

    public void set_courses(ArrayList<Course> cs) { this.cs = cs; }

    public void printCourses() {
        System.out.println("\nList of Courses: ");
        for (Course c : cs) {
            c.printCourseDetails();
        }
    }

    public void printTimeTable() {
        String[] headings = new String[] {
            "Day \\ Time", "09:00-09:30", "09:30-10:00", "10:00-10:30",
            "Break",       "10:45-11:15", "11:15-11:45", "11:45-12:15",
            "12:15-12:45", "12:45-13:15", "Break",       "14:30-15:00",
            "15:00-15:30", "15:30-16:00", "16:00-16:30", "16:30-17:00",
            "17:00-17:30"};

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday",
                         "Friday"};

        String[][] data = new String[5][17];

        // making the first column as days
        // 4th and 10th column as a break

        for (int i = 0; i < 5; i++) {
            data[i][0] = days[i];
            data[i][4] = "Break";
            data[i][10] = "Break";
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 14; j++) {
                int k = 1; // displacement value
                if (j >= 3)
                    k = 2;
                if (j >= 8)
                    k = 3;
                if (timeTable[i][j] != null)
                    data[i][j + k] = timeTable[i][j].toString();
                else
                    data[i][j + k] = "No Class";
            }
        }

        JFrame f = new JFrame();
        f.setTitle("TimeTable Schedule");

        ImageIcon logo = new ImageIcon("images/logoMini.png");

        System.out.print(logo.getDescription());

        f.setIconImage(logo.getImage());

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });

        f.setSize(1400, 150);
        f.setLocation(250, 250);

        JTable table = new JTable(data, headings);

        f.add(new JScrollPane(table));
        f.setVisible(true);
    }

    public void makeTheTimeTable() {
        /*
         * Timings: 9:00 to 9:30 | 9:30 10 | 10 to 10:30 | <break> | 10:45 to
         * 11:15 | 11:15 to 11 : 45 | 11:45 to 12:15 | 12:15 to 12:45 | 12:45 to
         * 13:15 | <break> | 14:30 to 15 | 15 to 15:30 | 15:30 to 16:00 | 16:00
         * to 16:30 | 16:30 to 17 | 17 to 17:30
         * Duration: 30 | 30 | 30 | ... | 30 | 30 | 30 | 30 | 30 | ... | 30 | 30
         * | 30 | 30 | 30 | 30 Array of size : 5 x 14 (5 working days, 14 split
         * time slots)
         */

        timeTable = new Course[5][14];

        for (Course c : cs) {
            int[] ltp = c.get_ltp();
            double l = ltp[0], t = ltp[1], p = ltp[2];

            while (l + t + p > 0) {
                for (int i = 0; i < 5; i++) {
                    boolean trigger = false;
                    for (int j = 0; j < 14; j++) {
                        if (timeTable[i][j] == null) {
                            timeTable[i][j] = c;
                            l -= 0.5;
                            trigger = true;
                            break;
                            // l will go negative and compensate for t and p
                        }
                    }
                    if (trigger)
                        break;
                }
            }
        }
    }

    public boolean validateCourses() {

        int totalHours = 0;
        for (Course c : cs) {
            int[] ltp = c.get_ltp();
            totalHours += ltp[0] + ltp[1] + ltp[2];
        }

        if (totalHours < 35)
            return true;

        return false;
    }
}
