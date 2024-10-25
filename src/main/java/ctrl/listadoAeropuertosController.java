package ctrl;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ModeloAeropuertoPrivado;
import model.ModeloAeropuerto;
import model.ModeloAeropuertoPublico;
import model.ModeloDireccion;

import java.sql.SQLException;

import dao.DaoAeropuerto;
import db.ConexionBBDD;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

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
    private TableView<ModeloAeropuerto> idTabla;

    @FXML
    private MenuItem mostarInfoAeropuerto;

    @FXML
    private RadioButton radPrivate;

    @FXML
    private RadioButton radPublic;

    @FXML
    private TableColumn<ModeloAeropuerto,Integer> tblAnio;

    @FXML
    private TableColumn<ModeloAeropuerto, String> tblCalle;

    @FXML
    private TableColumn<ModeloAeropuerto,Integer> tblCapacidad;

    @FXML
    private TableColumn<ModeloAeropuerto,String> tblCiudad;

    @FXML
    private TableColumn<ModeloAeropuertoPublico,Float> tblFinanciacion;

    @FXML
    private TableColumn<ModeloAeropuerto, Integer> tblId;

    @FXML
    private TableColumn<ModeloAeropuerto,String> tblNombre;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado,Integer> tblNumSocios;

    @FXML
    private TableColumn<ModeloAeropuerto,Integer> tblNumero;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, Integer> tblNumeroTrabajadores;

    @FXML
    private TableColumn<ModeloAeropuerto,String> tblPais;

    @FXML
    private MenuItem toggleAvion;

    @FXML
    private TextField txtFiltro;

    @FXML
    private ToggleGroup visibilidad;
    
    private static ObservableList<ModeloAeropuerto> listaTodas;
    
    @FXML
    private void initialize() {
    	try {
			ConexionBBDD con=new ConexionBBDD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	tblAnio.setCellValueFactory(new PropertyValueFactory<>("anioInauguracion"));
    	tblCalle.setCellValueFactory(new PropertyValueFactory<>("direccion.calle"));
    	tblCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidad"));
    	tblCiudad.setCellValueFactory(new PropertyValueFactory<>("direccion.ciudad"));
    	tblFinanciacion.setCellValueFactory(new PropertyValueFactory<>("financiacion"));
    	tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tblNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	tblNumero.setCellValueFactory(new PropertyValueFactory<>("direccion.numero"));
    	tblNumSocios.setCellValueFactory(new PropertyValueFactory<>("numSocios"));
    	tblPais.setCellValueFactory(new PropertyValueFactory<>("direccion.pais"));
    	tblNumeroTrabajadores.setCellValueFactory(new PropertyValueFactory<>("numTrabajadores"));
    	listaTodas=DaoAeropuerto.listaParaTabla();
    	idTabla.setItems(listaTodas);
    	
    }
    
    @FXML
    void toggleTipoAeropuerto(ActionEvent event) {
    	if(radPrivate.isSelected()) {
    		tblNumSocios.setVisible(true);
    		tblNumeroTrabajadores.setVisible(false);
    		tblFinanciacion.setVisible(false);
    	}else {
    		tblNumSocios.setVisible(false);
    		tblNumeroTrabajadores.setVisible(true);
    		tblFinanciacion.setVisible(true);
    	}
    }

}
