public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nChoices: ");
            System.out.println("1 : Add a course.");
            System.out.println("2 : Make the time table and exit.");
            System.out.print("Enter you choice: ");

            int choice = sc.nextInt();

            switch (choice) {
            case 1:
                Course x = Course.acceptCourse();
                x.printCourseDetails();
                break;

            case 2:
                // TODO: Make the time table.
                System.exit(0);

            default:
                System.out.println("Please enter the correct option.");
            }
        }
    }
}
