package ctrl;

import java.sql.SQLException;

import dao.DaoAeropuertoPrivado;
import dao.DaoAeropuertoPublico;
import db.ConexionBBDD;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.ModeloAeropuertoPrivado;
import model.ModeloAeropuertoPublico;

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
    private TableView<ModeloAeropuertoPrivado> idTablaPrivado;

    @FXML
    private TableView<ModeloAeropuertoPublico> idTablaPublico;

    @FXML
    private MenuItem mostarInfoAeropuerto;

    @FXML
    private RadioButton radPrivate;

    @FXML
    private RadioButton radPublic;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, Integer> tblAnioPrivado;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, Integer> tblAnioPublico;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, String> tblCallePrivado;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, String> tblCallePublico;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, Integer> tblCapacidadPrivado;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, Integer> tblCapacidadPublico;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, String> tblCiudadPrivado;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, String> tblCiudadPublico;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, Float> tblFinanciacion;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, Integer> tblIdPrivado;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, Integer> tblIdPublico;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, String> tblNombrePrivado;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, String> tblNombrePublico;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, Integer> tblNumSocios;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, Integer> tblNumeroPrivado;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, Integer> tblNumeroPublico;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, Integer> tblNumeroTrabajadores;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado, String> tblPaisPrivado;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, String> tblPaisPublico;

    @FXML
    private MenuItem toggleAvion;

    @FXML
    private TextField txtFiltro;

    @FXML
    private ToggleGroup visibilidad;
    
    private static ObservableList<ModeloAeropuertoPrivado> listaTodasPrivado;
    
    private static ObservableList<ModeloAeropuertoPublico> listaTodasPublico;
    
    private FilteredList<ModeloAeropuertoPrivado> filtroPrivado;
    
    private FilteredList<ModeloAeropuertoPublico> filtroPublico;

    @FXML
    void toggleTipoAeropuerto(ActionEvent event) {
    	if(radPublic.isSelected()) {
    		idTablaPublico.setVisible(true);
    		idTablaPrivado.setVisible(false);
    	}else {
    		idTablaPublico.setVisible(false);
    		idTablaPrivado.setVisible(true);;
    	}
    }
    
    @FXML
    void accionFiltrar() {
    	String filtro = txtFiltro.getText().toLowerCase();

        if (filtro.isEmpty()) {
            filtroPrivado.setPredicate(null);
            filtroPublico.setPredicate(null);
            idTablaPrivado.setItems(listaTodasPrivado);
            idTablaPublico.setItems(listaTodasPublico);
        } else {
            filtroPrivado.setPredicate(aeropuerto -> aeropuerto.getNombre().toLowerCase().contains(filtro));
            filtroPublico.setPredicate(aeropuerto -> aeropuerto.getNombre().toLowerCase().contains(filtro));
            idTablaPrivado.setItems(filtroPrivado);
            idTablaPublico.setItems(filtroPublico);
        }
    }
    
    @FXML
    private void initialize() {
    	try {
			ConexionBBDD con=new ConexionBBDD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	txtFiltro.setOnKeyReleased(event -> accionFiltrar());
		//Tabla publico
    	tblAnioPublico.setCellValueFactory(new PropertyValueFactory<>("anioInauguracion"));
    	tblCallePublico.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getDireccion().getCalle()));
    	tblCapacidadPublico.setCellValueFactory(new PropertyValueFactory<>("capacidad"));
    	tblCiudadPublico.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getDireccion().getCiudad()));
    	tblFinanciacion.setCellValueFactory(new PropertyValueFactory<>("financiacion"));
    	tblIdPublico.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tblNombrePublico.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	tblNumeroPublico.setCellValueFactory(cellData -> 
        new SimpleIntegerProperty(cellData.getValue().getDireccion().getNumero()).asObject());
    	tblPaisPublico.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getDireccion().getPais()));
    	tblNumeroTrabajadores.setCellValueFactory(new PropertyValueFactory<>("numTrabajadores"));
    	listaTodasPublico=DaoAeropuertoPublico.cargarListaAeropuertosPublicos();
    	filtroPublico=new FilteredList<ModeloAeropuertoPublico>(listaTodasPublico);
    	idTablaPublico.setItems(listaTodasPublico);
    	//Tabla privado
    	tblAnioPrivado.setCellValueFactory(new PropertyValueFactory<>("anioInauguracion"));
    	tblCallePrivado.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getDireccion().getCalle()));
    	tblCapacidadPrivado.setCellValueFactory(new PropertyValueFactory<>("capacidad"));
    	tblCiudadPrivado.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getDireccion().getCiudad()));
    	tblIdPrivado.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tblNombrePrivado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	tblNumeroPrivado.setCellValueFactory(cellData -> 
        new SimpleIntegerProperty(cellData.getValue().getDireccion().getNumero()).asObject());
    	tblPaisPrivado.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getDireccion().getPais()));
    	tblNumSocios.setCellValueFactory(new PropertyValueFactory<>("numSocios"));
    	listaTodasPrivado=DaoAeropuertoPrivado.cargarListaAeropuertosPrivados();
    	filtroPrivado=new FilteredList<ModeloAeropuertoPrivado>(listaTodasPrivado);
    	idTablaPrivado.setItems(listaTodasPrivado);
    }

}
