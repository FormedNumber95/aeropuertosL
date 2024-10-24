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
    private TableColumn<ModeloDireccion, String> tblCalle;

    @FXML
    private TableColumn<ModeloAeropuerto,Integer> tblCapacidad;

    @FXML
    private TableColumn<ModeloDireccion,String> tblCiudad;

    @FXML
    private TableColumn<ModeloAeropuertoPublico,Float> tblFinanciacion;

    @FXML
    private TableColumn<ModeloAeropuerto, Integer> tblId;

    @FXML
    private TableColumn<ModeloAeropuerto,String> tblNombre;

    @FXML
    private TableColumn<ModeloAeropuertoPrivado,Integer> tblNumSocios;

    @FXML
    private TableColumn<ModeloDireccion,Integer> tblNumero;

    @FXML
    private TableColumn<ModeloAeropuertoPublico, Integer> tblNumeroTrabajadores;

    @FXML
    private TableColumn<ModeloDireccion,String> tblPais;

    @FXML
    private MenuItem toggleAvion;

    @FXML
    private TextField txtFiltro;

    @FXML
    private ToggleGroup visibilidad;
    
    @FXML
    private void initialize() {
    	try {
			ConexionBBDD con=new ConexionBBDD();
		} catch (SQLException e) {
			e.printStackTrace();
		}/*
    	tblAnio.setCellValueFactory(new PropertyValueFactory<>("anio_inauguracion"));
    	tblCalle.setCellValueFactory(new PropertyValueFactory<>("id_direccion.calle"));
    	tblCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidad"));
    	tblCiudad.setCellValueFactory(new PropertyValueFactory<>("id_direccion.ciudad"));
    	tblFinanciacion.setCellValueFactory(new PropertyValueFactory<>("financiacion"));
    	tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tblNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	tblNumero.setCellValueFactory(new PropertyValueFactory<>("id_direccion.numero"));
    	tblNumSocios.setCellValueFactory(new PropertyValueFactory<>("numero_socios"));
    	tblPais.setCellValueFactory(new PropertyValueFactory<>("id_direccion.pais"));
    	idTabla.getItems().addAll(DaoAeropuerto.listaParaTabla());
    	*/
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
