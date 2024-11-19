package timeTableSchedulinev2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

public class TimeTable {
    private ArrayList<Semester> sems = new ArrayList<Semester>();
    private Course[][][] timeTable   = null;

    public TimeTable(ArrayList<Semester> s) {
        sems = s;
    }

    public void printTimeTable(int sem, String filename) {
        String[] headings = new String[] {"Day \\ Time", "09:00-09:30", "09:30-10:00",
                "10:00-10:30", "Break", "10:45-11:15", "11:15-11:45", "11:45-12:15", "12:15-12:45",
                "12:45-13:15", "Break", "14:30-15:00", "15:00-15:30", "15:30-16:00", "16:00-16:30",
                "16:30-17:00", "17:00-17:30"};

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        String[][] data = new String[5][17];

        // making the first column as days
        // 4th and 10th column as a break

        for (int i = 0; i < 5; i++) {
            data[i][0]  = days[i];
            data[i][4]  = "Break";
            data[i][10] = "Break";
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 14; j++) {
                int k = 1; // displacement value
                if (j >= 3) k = 2;
                if (j >= 8) k = 3;
                if (timeTable[sem][i][j] != null)
                    data[i][j + k] = timeTable[sem][i][j].toString();
                else
                    data[i][j + k] = ""; // Keep it empty
            }
        }

        String[] coursesHeadings = {"Course Title", "Course Code", "L-T-P-S-C", "Lecturer"};
        String[][] coursesArray  = getCoursesAsArray(sem);

        String s1 = printTableHelper(data, headings);
        String s2 = printTableHelper(coursesArray, coursesHeadings, 200);

        writeToFile("timeTable/" + filename, s1 + s2);
    }

    private String[][] getCoursesAsArray(int sem) {
        ArrayList<Course> cs = sems.get(sem).getCourses();
        String[][] ccc       = new String[cs.size()][4];
        for (int i = 0; i < cs.size(); i++) {
            ccc[i][0] = cs.get(i).getCourseName();
            ccc[i][1] = cs.get(i).getCourseCode();
            //            int arr[] = cs.get(i).get_ltpsc();
            //            ccc[i][2] = arr[0] + "-" + arr[1] + "-" + arr[2] + "-" + arr[3] + "-" +
            //            arr[4];
            ccc[i][2]     = cs.get(i).getLtpsc();
            ccc[i][3]     = "";
            String[] temp = cs.get(i).getFaculty();
            for (int ii = 0; ii < temp.length; ii++) {
                if (ii == temp.length - 1) {
                    ccc[i][3] += temp[ii];
                    continue;
                }
                ccc[i][3] += temp[ii] + ", ";
            }
            //            ccc[i][4] = cs.get(i).get_instructor();
            //            ccc[i][5] = cs.get(i).get_labAssistance();
        }
        return ccc;
    }

    private String printTableHelper(String[][] data, String[] headings) {
        return printTableHelper(data, headings, 250);
    }

    private String printTableHelper(String[][] data, String[] headings, int width) {
        AsciiTable act = new AsciiTable();

        act.getContext().setWidth(width);

        act.setPadding(10);
        act.addRule();
        act.addRow(Arrays.asList(headings)); // no repetition
        act.addRule();

        ArrayList<ArrayList<String>> data2d = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < data.length; i++) {
            data2d.add(new ArrayList<String>());
            for (int j = 0; j < data[i].length; j++) {
                data2d.get(i).add(data[i][j]);
                if (j > 1) {
                    if (data2d.get(i).get(j).equals(data2d.get(i).get(j - 1))) {
                        data2d.get(i).set(j - 1, null);
                    }
                }
            }
        }

        for (int i = 0; i < data2d.size(); i++) {
            act.addRow(data2d.get(i));
            act.addRule();
        }

        act.setTextAlignment(TextAlignment.CENTER);
        act.getContext().setFrameLeftRightMargin(5);
        act.getContext().setFrameTopBottomMargin(1);

        //        act.getContext().setGrid(U8_Grids.borderDouble());
        System.out.println(act.render());

        return act.render();
    }

    private void writeToFile(String filepath, String contents) {
        Font outputFont = null;
        try {
            //    		outputFont = Font.createFont(Font.TRUETYPE_FONT, new
            //    File("assets/fonts/JetBrains-Mono-Nerd-Font-Complete.ttf")).deriveFont(28f);
            outputFont = Font.createFont(Font.TRUETYPE_FONT,
                                     new File("assets/fonts/CaskaydiaCoveNerdFont-Regular.ttf"))
                                 .deriveFont(28f);
        } catch (Exception _) {
            outputFont = new Font(Font.MONOSPACED, Font.PLAIN, 28);
        }
        FontMetrics fm = (new Canvas()).getFontMetrics(outputFont);

        String[] lines = contents.split("\n");

        final int WIDTH  = fm.stringWidth(lines[0]); // First line width is always the maximum
        final int HEIGHT = fm.getHeight() * lines.length + 1;

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d      = image.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        //        g2d.setColor(Color.BLACK);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        //        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setColor(Color.BLACK);
        g2d.setFont(outputFont);

        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        int lineHeight      = metrics.getHeight();
        int y               = metrics.getAscent();

        for (String line : lines) {
            g2d.drawString(line, 10, y);
            y += lineHeight;
        }
        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(filepath));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void makeTimeTable() {
        /*
         * Timings: 9:00 to 9:30 | 9:30 to 10 | 10 to 10:30 | <break> | 10:45 to
         * 11:15 | 11:15 to 11 : 45 | 11:45 to 12:15 | 12:15 to 12:45 | 12:45 to
         * 13:15 | <break> | 14:30 to 15 | 15 to 15:30 | 15:30 to 16:00 | 16:00
         * to 16:30 | 16:30 to 17 | 17 to 17:30 Duration: 30 | 30 | 30 | ... |
         * 30 | 30 | 30 | 30 | 30 | ... | 30 | 30 | 30 | 30 | 30 | 30 Array of
         * size : 5 x 14 (5 working days, 14 split time slots)
         */

        timeTable = new Course[4][5][14];

        int count = 0;
        for (Semester s : sems) {
            ArrayList<Course> courses = s.getCourses();
            for (Course c : courses) {
                double l = c.getL();
                for (int i = 0; i < 5 && l > 0; i++) {
                    for (int j = 0; j < 14 && l > 0; j++) {
                        if (j >= 3) {
                            if (timeTable[count][i][j - 1] != null
                                    && timeTable[count][i][j - 2] != null
                                    && timeTable[count][i][j - 3] != null)
                                if (timeTable[count][i][j - 1].equals(c)
                                        && timeTable[count][i][j - 2].equals(c)
                                        && timeTable[count][i][j - 3].equals(c)) {
                                    break;
                                }
                        }

                        if (j == 2 && !timeTable[count][i][j - 1].equals(c)) continue;

                        // To avoid breaks
                        if (j == 6 || j == 7) j = 8;

                        if (timeTable[count][i][j] == null) {
                            timeTable[count][i][j] = c;
                            l -= 0.5;
                        }
                    }
                }
            }

            for (Course c : courses) {
                double p = c.getP();
                Course x = new Course(c);
                x.setLectureType("Lab");
                for (int i = 0; i < 5 && p > 0; i++) {
                    int j               = 3;
                    boolean assignedLab = false;
                    if (timeTable[count][i][j] == null && timeTable[count][i][j + 1] == null
                            && timeTable[count][i][j + 2] == null
                            && timeTable[count][i][j + 3] == null) {
                        timeTable[count][i][j]     = x;
                        timeTable[count][i][j + 1] = x;
                        timeTable[count][i][j + 2] = x;
                        timeTable[count][i][j + 3] = x;
                        p -= 2;
                        assignedLab = true;
                    }
                    j = 8;
                    if (timeTable[count][i][j] == null && timeTable[count][i][j + 1] == null
                            && timeTable[count][i][j + 2] == null
                            && timeTable[count][i][j + 3] == null && !assignedLab) {
                        timeTable[count][i][j]     = x;
                        timeTable[count][i][j + 1] = x;
                        timeTable[count][i][j + 2] = x;
                        timeTable[count][i][j + 3] = x;
                        p -= 2;
                    }
                }
            }

            for (Course c : courses) {
                double t = c.getT();
                Course x = new Course(c);
                x.setLectureType("Tutorial");

                for (int i = 0; i < 5 && t > 0; i++) {
                    if (searchDayForAnyOtherLecture(c, i, count)) continue;

                    for (int j = 0; j < 13 && t > 0; j++) {
                        if (j == 2 || j == 7) continue; // Avoid breaks
                        if (timeTable[count][i][j] == null && timeTable[count][i][j + 1] == null) {
                            timeTable[count][i][j]     = x;
                            timeTable[count][i][j + 1] = x;
                            t -= 1;
                            break;
                        }
                    }
                }
            }

            count += 1;
        }
    }

    private boolean searchDayForAnyOtherLecture(Course c, int day, int sem) {
        for (Course x : timeTable[sem][day]) {
            if (x == null) continue;
            if (!x.getLectureType().equals("Lab")) {
                if (x.getCourseCode().equals(c.getCourseCode())) {
                    return true;
                }
            }
        }
        return false;
    }
}
