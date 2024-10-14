
public class Room {
	private int room_number;
	private boolean is_occupied = false;

	Room(int room_number, boolean is_occupied) {
		this.room_number = room_number;
		this.is_occupied = is_occupied;
	}

	int get_room_number() {
		return room_number;
	}

	boolean isOccupied() {
		return is_occupied;
	}

	void set_is_occupied(boolean occupied) {
		is_occupied = occupied;
	}

}
