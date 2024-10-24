package ctrl;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class listadoAeropuertosController {

    @FXML
    private MenuItem aniadirAeropuerto;

    @FXML
    private MenuItem aniadirAvion;

    @FXML
    private MenuItem borrarAeropuerto;

    @FXML
    private MenuItem borrarAvion;

    @FXML
    private MenuItem editarAeropuerto;

    @FXML
    private TableView<?> idTabla;

    @FXML
    private MenuItem mostarInfoAeropuerto;

    @FXML
    private RadioButton radPrivate;

    @FXML
    private RadioButton radPublic;

    @FXML
    private TableColumn<?, ?> tblAnio;

    @FXML
    private TableColumn<?, ?> tblCalle;

    @FXML
    private TableColumn<?, ?> tblCapacidad;

    @FXML
    private TableColumn<?, ?> tblCiudad;

    @FXML
    private TableColumn<?, ?> tblId;

    @FXML
    private TableColumn<?, ?> tblNombre;

    @FXML
    private TableColumn<?, ?> tblNumSocios;

    @FXML
    private TableColumn<?, ?> tblNumero;

    @FXML
    private TableColumn<?, ?> tblPais;

    @FXML
    private MenuItem toggleAvion;

    @FXML
    private TextField txtFiltro;

    @FXML
    private ToggleGroup visibilidad;

}
