import java.util.Vector;
import java.util.Enumeration;

public class Course {
    private String title;
    private Vector<CourseRecord> courseRecords;

    Course() {
        courseRecords = new Vector<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    public void printCourseStudents() {
        System.out.println("Course Students:");
        for (CourseRecord cr : courseRecords) {
            System.out.println("Student: " + cr.getStudent().getName());
        }
    }

    public void printBestStudent() {
        System.out.println("Best Student:");
        double maxAvg = 0;
        CourseRecord bestStudentRecord = null;

        for (CourseRecord cr : courseRecords) {
            double avg = calculateAverage(cr);
            if (avg > maxAvg) {
                maxAvg = avg;
                bestStudentRecord = cr;
            }
        }

        if (bestStudentRecord != null) {
            System.out.println("Student: " + bestStudentRecord.getStudent().getName());
        }
    }

    public void printFinalExamStudents() {
        System.out.println("Students Eligible for Final Exam:");
        for (CourseRecord cr : courseRecords) {
            if (isEligibleForFinalExam(cr)) {
                System.out.println("Student: " + cr.getStudent().getName());
            }
        }
    }

    private double calculateAverage(CourseRecord cr) {
        double totalMark = 0;
        int assignmentCount = 0;

        for (Assignment assignment : cr.getAssignments()) {
            try {
                totalMark += assignment.getMark();
                assignmentCount++;
            } catch (NotYetSetException e) {
                System.out.println(e.getMessage());
            }
        }

        if (assignmentCount > 0) {
            return totalMark / assignmentCount;
        } else {
            return 0.0;
        }
    }

    private boolean isEligibleForFinalExam(CourseRecord cr) {

        return false;
    }
}
