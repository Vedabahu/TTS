package timeTableSchedulinev2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSE {
	public static ArrayList<Course> readCoursesFromCSV(String filePath) {
        ArrayList<Course> courses = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            // Skip header if there is one
            reader.readNext();
            
            while ((line = reader.readNext()) != null) {
                // Assuming the CSV columns follow the order:
                // Semester, Sl. No, Course Code, Course Name, Credits, L-T-P-S-C, Faculty

            	int semester = Integer.parseInt(line[0]);
                String courseCode = line[2];
                String courseName = line[3];
                int credits = Integer.parseInt(line[4]);
                String ltpsc = line[5];
                
                // Parse L-T-P-S-C fields from ltpsc string if available
                String[] ltpscSplit = ltpsc.split("-");
                int l = Integer.parseInt(ltpscSplit[0]);
                int t = Integer.parseInt(ltpscSplit[1]);
                int p = Integer.parseInt(ltpscSplit[2]);
                int s = Integer.parseInt(ltpscSplit[3]);
                int c = Integer.parseInt(ltpscSplit[4]);

                String[] faculty = line[6].split(","); // Split faculty names if multiple

                // Create Course object
                Course course = new Course(semester, courseCode, courseName, credits, ltpsc, l, t, p, s, c, faculty);
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }	
}
