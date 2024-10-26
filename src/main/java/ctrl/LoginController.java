package ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import dao.DaoAeropuerto;
import db.ConexionBBDD;
import es.aketzagonzalez.aeropuertosL.MainApp;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Clase LoginController.
 */
public class LoginController {

    /** EL btn login. */
    @FXML
    private Button btnLogin;

    /** EL txt password. */
    @FXML
    private PasswordField txtPassword;

    /** EL txt user. */
    @FXML
    private TextField txtUser;
    
    /**
     * Validar usuario.
     *
     * @param event the event
     */
    @FXML
    void validarUsuario(ActionEvent event) {
    	Properties config=ConexionBBDD.loadProperties();
    	if(txtUser.getText().equals(config.getProperty("user"))&&txtPassword.getText().equals(config.getProperty("password"))) {
    		try {
				MainApp.setRoot("listadoAeropuertos", "AVIONES - AEROPUERTOS");
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

}
