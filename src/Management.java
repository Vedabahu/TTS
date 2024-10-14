
public class Management {
	private int id;
	private String name;

	Management(int id, String name) {
		this.id = id;
		this.name = name;
	}

	int get_id() {
		return id;
	}

	String get_name() {
		return name;
	}

	void set_name(String name) {
		this.name = name;
	}

}
