package timeTableSchedulinev2;

import java.util.*;

public class Semester {
	private int semNo;
	private ArrayList<Course> courses;
	
	public Semester(int semNo) {
		this.setSemNo(semNo);
		this.courses = new ArrayList<Course>();
	}
	
	public void addCourse(Course c) {
		courses.add(c);
	}
	
	public static ArrayList<Semester> convertToSems(List<Course> courses) {
		ArrayList<Semester> sems = new ArrayList<>();
		
		sems.add(new Semester(1));
		sems.add(new Semester(3));
		sems.add(new Semester(5));
		
		for (Semester s : sems) {
			for (Course c : courses) {
				if (s.getSemNo() == c.getSemester()) {
					s.addCourse(c);
				}
			}
		}
		
		return sems;
		
	}

	@Override
	public String toString() {
		return semNo + "";
	}


	public ArrayList<Course> getCourses() {
		return courses;
	}



	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}



	public int getSemNo() {
		return semNo;
	}



	public void setSemNo(int semNo) {
		this.semNo = semNo;
	}
}
