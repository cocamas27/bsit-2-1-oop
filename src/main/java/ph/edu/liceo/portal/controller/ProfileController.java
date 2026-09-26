package ph.edu.liceo.portal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ph.edu.liceo.portal.MainApp;
import ph.edu.liceo.portal.model.Student;

/**
 * CONTROLLER for profile.fxml.
 *
 * MainApp.showProfile(...) loads the FXML and then calls setStudent(...) on
 * this class. Your job is to copy the student's details into the labels.
 */
public class ProfileController {

    @FXML private Label initialsLabel;
    @FXML private Label nameLabel;
    @FXML private Label studentNoLabel;
    @FXML private Label courseLabel;
    @FXML private Label emailLabel;

    /**
     * TODO 12: Fill in the five labels from the student that was passed in.
     *
     *   initialsLabel  -> initialsOf(student.getFullName())
     *   nameLabel      -> student.getFullName()
     *   studentNoLabel -> student.getStudentNo()
     *   courseLabel    -> student.getCourseAndYear()
     *   emailLabel     -> student.getEmail()
     *
     *   Use setText(...) on each label.
     */
    public void setStudent(Student student) {
        // TODO 12
    }

    /** Already written for you - returns to the login screen. */
    @FXML
    private void handleLogout() {
        MainApp.showLogin();
    }

    /** Already written for you. "Ana Marie Dela Cruz" -> "AC" */
    private String initialsOf(String fullName) {
        String[] parts = fullName.split(" ");
        String first = parts[0].substring(0, 1);
        String last = parts[parts.length - 1].substring(0, 1);
        return (first + last).toUpperCase();
    }
}
