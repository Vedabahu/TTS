
public class Student {
    private String name;
    private String roll_number; // eg: 23BCS141
    private Batch batch;

    Student(String name, String roll_number, Batch batch) {
        this.name = name;
        this.roll_number = roll_number;
        this.batch = batch;
    }

    Student(String name, String roll_number, String batch) {
        this.name = name;
        this.roll_number = roll_number;
        this.batch = new Batch(batch);
    }

    String get_name() { return name; }

    String get_roll_number() { return roll_number; }

    Batch get_batch() { return batch; }

    void set_name(String name) { this.name = name; }

    void set_roll_number(String roll) { roll_number = roll; }

    void set_batch(Batch b) { batch = b; }
}
