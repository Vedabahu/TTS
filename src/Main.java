import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	TimeTable tt = new TimeTable();

        while (true) {
            System.out.println("\nChoices: ");
            System.out.println("1 : Add a course.");
            System.out.println("2 : Make the time table and exit.");
            System.out.print("Enter you choice: ");

            int choice = sc.nextInt();

            switch (choice) {
            case 1:
                tt.addCourse(Course.acceptCourse());
                break;

            case 2:
                // TODO: Make the time table.
                tt.printCourses();
                tt.makeTheTimeTable();
                System.exit(0);

            default:
                System.out.println("Please enter the correct option.");
            }
        }
    }
}
