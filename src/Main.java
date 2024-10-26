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

        // TODO: Make the time table.
        tt.printCourses();
        tt.makeTheTimeTable();
        tt.printTimeTable();
        System.exit(0);
    }
}
