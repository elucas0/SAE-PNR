package view;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class Connection {
    @FXML
    private TextField id;

    @FXML
    private PasswordField mdp;

    @FXML
    private Button bouton_connexion;

    @FXML
    public void register(ActionEvent event) throws SQLException {

        Window owner = bouton_connexion.getScene().getWindow();

        System.out.println(id.getText());
        System.out.println(mdp.getText());
        if (id.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }
        if (mdp.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            return;
        }

        String fullName = id.getText();
        String password = mdp.getText();

        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertRecord(fullName, password);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
            "Welcome " + id.getText());
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}

