package oop.veda;

import java.util.ArrayList;

public class TimeTable {
    private ArrayList<Course> cs = new ArrayList<Course>();
    private String[][] timeTable;

    public void set_courses(ArrayList<Course> cs) { this.cs = cs; }

    public void printCourses() {
        System.out.println("\n\nList of Courses: ");
        for (Course c : cs) {
            c.printCourseDetails();
        }
    }

    public void printTimeTable() {
        for (String[] day : timeTable) {
            for (String slot : day) {
                System.out.println(slot + "\t");
            }
            System.out.println();
        }
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

        // TODO: Add a method to check if the LTPSC is valid. Like it should fit
        // in a week.

        for (Course c : cs) {
            int[] ltpsc = c.get_ltpsc();
            for (String[] day : timeTable) {
                // TODO : Assign the periods to the proper timings in the 2D
                // Array.

                for (String slot : day) {
                    if (ltpsc[0] > 0 && slot == null) {
                        slot = c.get_courseCode();
                        ltpsc[0] -= 0.5;
                    }
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
