
public class Lab {
	private int lab_number;
	private boolean is_occupied = false;
	private String lab_type = "CSE";
	
	Lab(int lab_number, boolean is_occupied, String lab_type) {
		this.lab_number = lab_number;
		this.is_occupied = is_occupied;
		this.lab_type = lab_type;
	}
	
	int get_lab_number() {
		return lab_number;
	}
	
	boolean isOccupied() {
		return is_occupied;
	}
	
	String get_lab_type() {
		return lab_type;
	}
	
	void set_is_occupied(boolean occupied) {
		is_occupied = occupied;
	}
}
