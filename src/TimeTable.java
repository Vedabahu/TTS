import java.util.ArrayList;

public class TimeTable {
	private ArrayList<Course> cs = new ArrayList<Course>();

	public void addCourse(Course c) {
		cs.add(c);
	}

	public void printCourses() {
		System.out.println("\n\nList of Courses: ");
		for ( Course c : cs) {
			c.printCourseDetails();
		}
	}
}
