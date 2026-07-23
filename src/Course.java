public class Course {
    private String courseCode;
    private String title;
    private int units;
    private int capacity;
    private int enrolledCount;

    public Course(String courseCode, String title, int units, int capacity) {
        this.courseCode = courseCode;
        this.title      = title;
        this.units      = units;
        this.capacity   = capacity;
        this.enrolledCount = 0;
    }

    public boolean isFull() {
        return enrolledCount >= capacity;
    }

    public void addOneEnrollee() {
        if (!isFull()) {
            enrolledCount++;
        }
    }

    private String getCourseCode() {
        return courseCode;
    }

    private String getTitle() {
        return title;
    }

    private int getUnits() {
        return units;
    }

    private int getCapacity() {
        return capacity;
    }

    private int getEnrolledCount() {
        return enrolledCount;
    }
}