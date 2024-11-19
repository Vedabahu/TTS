package timeTableSchedulinev2;

public class Batch {
	private String name;
	private int number_of_students;
	private String allocated_room;
	private String allocated_lab;
	public String getAllocated_lab() {
		return allocated_lab;
	}
	public void setAllocated_lab(String allocated_lab) {
		this.allocated_lab = allocated_lab;
	}
	public String getAllocated_room() {
		return allocated_room;
	}
	public void setAllocated_room(String allocated_room) {
		this.allocated_room = allocated_room;
	}
	public int getNumber_of_students() {
		return number_of_students;
	}
	public void setNumber_of_students(int number_of_students) {
		this.number_of_students = number_of_students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
