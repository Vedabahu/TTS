import java.util.Scanner;

public class Course {

    private String courseName;
    private String courseCode;
    private int L, T, P, S, C;

    public Course(String name, String code, int L, int T, int P, int S, int C) {
        courseName = name;
        courseCode = code;
        this.L = L;
        this.T = T;
        this.P = P;
        this.S = S;
        this.C = C;
    }

    public void printCourseDetails() {
        System.out.println("\nCourse Name: " + courseName);
        System.out.println("Course code: " + courseCode);
        System.out.printf("L-T-P-S-C: %d-%d-%d-%d-%d\n", L, T, P, S, C);
    }

    public static Course acceptCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the course title: ");
        String courseName = sc.nextLine();
        System.out.print("Enter the course code: ");
        String courseCode = sc.nextLine();
        System.out.println("Enter the LTPSC details:-");
        System.out.print("Enter L - ");
        int L = sc.nextInt();
        System.out.print("Enter T - ");
        int T = sc.nextInt();
        System.out.print("Enter P - ");
        int P = sc.nextInt();
        System.out.print("Enter S - ");
        int S = sc.nextInt();
        System.out.print("Enter C - ");
        int C = sc.nextInt();

        return new Course(courseName, courseCode, L, T, P, S, C);
    }

    public int[] get_ltpsc() { return new int[] {L, T, P, S, C}; }
    public String get_courseCode() { return courseCode; }
}
