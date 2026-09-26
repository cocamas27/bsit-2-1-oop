package ph.edu.liceo.portal.model;

import java.util.ArrayList;

public class StudentDirectory {
    // TODO 4: Private final ArrayList<Student> field
    private final ArrayList<Student> students;

    // TODO 5: Add the three accounts in constructor
    public StudentDirectory() {
        students = new ArrayList<>();
        students.add(new Student("2026-00123", "liceo123", "Ana Marie Dela Cruz", "BS Information Technology", 3, "ana.delacruz@liceo.edu.ph"));
        students.add(new Student("2026-00456", "gcash456", "Jerome Bacaltos", "BS Computer Science", 2, "jerome.bacaltos@liceo.edu.ph"));
        students.add(new Student("2026-00789", "maya789", "Liza Manalo", "BS Information Systems", 4, "liza.manalo@liceo.edu.ph"));
    }

    // TODO 6: Loop, compare with .equals(), and return Student or null
    public Student login(String studentNo, String password) {
        for (Student s : students) {
            if (s.getStudentNo().equals(studentNo) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }
}