package ph.edu.liceo.portal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ph.edu.liceo.portal.MainApp;
import ph.edu.liceo.portal.model.Student;

/**
 * CONTROLLER for login.fxml.
 *
 * Its job is only to READ what the user typed, ASK the model whether it is
 * correct, and then SHOW the answer. It must not decide by itself what a
 * valid password is - that rule lives in StudentDirectory.
 */
public class LoginController {

    // ------------------------------------------------------------------
    // TODO 9: Declare the three fields the FXML will fill in. Each one needs
    //         the @FXML annotation, and the NAME must match the fx:id you
    //         wrote in login.fxml:
    //
    //           @FXML private TextField studentNoField;
    //           @FXML private PasswordField passwordField;
    //           @FXML private Label messageLabel;
    // ------------------------------------------------------------------


    /**
     * Runs when the LOG IN button is clicked
     * (because login.fxml says onAction="#handleLogin").
     *
     * TODO 10: Write the three steps.
     *
     *   Step 1 - read the two fields:
     *            String studentNo = studentNoField.getText().trim();
     *            String password  = passwordField.getText();
     *
     *   Step 2 - if either one is empty, put
     *            "Please fill in both fields." into messageLabel and return.
     *
     *   Step 3 - ask the model:
     *            Student student = MainApp.getDirectory().login(studentNo, password);
     *
     *            If student is null   -> messageLabel shows
     *                                    "Wrong student number or password."
     *                                    and passwordField.clear();
     *            If student is not null -> MainApp.showProfile(student);
     */
    @FXML
    private void handleLogin() {
        // TODO 10
    }
}
