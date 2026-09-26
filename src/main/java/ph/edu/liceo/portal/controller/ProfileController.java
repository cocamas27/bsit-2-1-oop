package ph.edu.liceo.portal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ph.edu.liceo.portal.MainApp;
import ph.edu.liceo.portal.model.Student;

public class ProfileController {

    @FXML private Label initialsLabel;
    @FXML private Label nameLabel;
    @FXML private Label studentNoLabel;
    @FXML private Label courseLabel;
    @FXML private Label emailLabel;

    // TODO 12: Fill in labels from Student object
    public void setStudent(Student student) {
        if (student == null) return;

        String[] parts = student.getFullName().trim().split("\\s+");
        String initials = "";
        if (parts.length > 0 && !parts[0].isEmpty()) {
            initials += parts[0].substring(0, 1).toUpperCase();
        }
        if (parts.length > 1) {
            initials += parts[parts.length - 1].substring(0, 1).toUpperCase();
        }

        initialsLabel.setText(initials);
        nameLabel.setText(student.getFullName());
        studentNoLabel.setText(student.getStudentNo());
        courseLabel.setText(student.getCourse() + " - Year " + student.getYearLevel());
        emailLabel.setText(student.getEmail());
    }

    @FXML
    private void handleLogout() {
        MainApp.showLogin();
    }
}