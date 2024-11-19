package timeTableSchedulinev2;

public class Course {
    private int semester      = 0;
    private String courseCode = "";
    private String courseName = "";
    private int credits       = 0;
    private String ltpsc      = "";
    private int l;
    private int t;
    private int p;
    private int s;
    private int c;
    private String[] faculty;
    private String lectureType = "";

    public Course(int semester, String courseCode, String courseName, int credits, String ltpsc,
            int l, int t, int p, int s, int c, String[] faculty) {
        this.semester   = semester;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits    = credits;
        this.ltpsc      = ltpsc;
        this.l          = l;
        this.t          = t;
        this.p          = p;
        this.s          = s;
        this.c          = c;
        this.faculty    = faculty;
    }

    public Course(Course c2) {
        this.semester   = c2.getSemester();
        this.courseCode = c2.getCourseCode();
        this.courseName = c2.getCourseName();
        this.credits    = c2.getCredits();
        this.ltpsc      = c2.getLtpsc();
        this.l          = c2.getL();
        this.t          = c2.getT();
        this.p          = c2.getP();
        this.s          = c2.getS();
        this.c          = c2.getC();
        this.faculty    = c2.getFaculty();
    }

    public String[] getFaculty() {
        return faculty;
    }

    public void setFaculty(String[] faculty) {
        this.faculty = faculty;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public String getLtpsc() {
        return ltpsc;
    }

    public void setLtpsc(String ltpsc) {
        this.ltpsc = ltpsc;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getLectureType() {
        return lectureType;
    }

    public void setLectureType(String lectureType) {
        this.lectureType = lectureType;
    }

    public String toString() {
        return courseCode + " " + lectureType;
    }
}
