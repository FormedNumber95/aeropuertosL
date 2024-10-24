package ctrl;

import java.io.IOException;
import java.util.Properties;

import db.ConexionBBDD;
import es.aketzagonzalez.aeropuertosL.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;
    
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
    //TODO 	Borrar esto al entregar
    @FXML
    private void initialize() {
    	Properties config=ConexionBBDD.loadProperties();
    	txtUser.setText(config.getProperty("user"));
    	txtPassword.setText(config.getProperty("password"));
    }

}
