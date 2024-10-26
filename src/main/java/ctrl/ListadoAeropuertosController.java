package ctrl;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoAeropuertoPrivado;
import dao.DaoAeropuertoPublico;
import db.ConexionBBDD;
import es.aketzagonzalez.aeropuertosL.MainApp;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.ModeloAeropuertoPrivado;
import model.ModeloAeropuertoPublico;

public class ListadoAeropuertosController {

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
    
    private static boolean esAniadir;
    
    private static boolean esPublico=true;
    
    private static Stage s;

    @FXML
    void toggleTipoAeropuerto(ActionEvent event) {
    	esPublico=radPublic.isSelected();
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
    void aniadirAeropuerto(ActionEvent event) {
    	esAniadir=true;
    	s=new Stage();
    	Scene scene;
		try {
			 FXMLLoader controlador = new FXMLLoader(MainApp.class.getResource("/fxml/aniadirAeropuerto.fxml"));
			scene = new Scene(controlador.load());
			s.setTitle("AVIONES - AÑADIR AEROPUERTO");
			s.setScene(scene);
			AniadirAeropuertoController controller = controlador.getController();
			controller.setIdTablaPrivado(idTablaPrivado);
			controller.setIdTablaPublico(idTablaPublico);
		} catch (IOException e) {
			e.printStackTrace();
		}
        s.setResizable(false);
        s.initOwner(MainApp.getStage());
        s.initModality(javafx.stage.Modality.WINDOW_MODAL);
        s.showAndWait();
        accionFiltrar();
        idTablaPrivado.refresh();
        idTablaPublico.refresh();
    }

    @FXML
    void aniadirAvion(ActionEvent event) {

    }

    @FXML
    void borrarAeropuerto(ActionEvent event) {

    }

    @FXML
    void borrarAvion(ActionEvent event) {

    }

    @FXML
    void editarAeropuerto(ActionEvent event) {
    	esAniadir=false;
    	if(idTablaPrivado.getSelectionModel().getSelectedItem()!=null||idTablaPublico.getSelectionModel().getSelectedItem()!=null) {
    		s=new Stage();
        	Scene scene;
    		try {
    			 FXMLLoader controlador = new FXMLLoader(MainApp.class.getResource("/fxml/aniadirAeropuerto.fxml"));
    			scene = new Scene(controlador.load());
    			s.setTitle("AVIONES - MODIFICAR AEROPUERTO");
    			s.setScene(scene);
    			AniadirAeropuertoController controller = controlador.getController();
    			controller.setIdTablaPrivado(idTablaPrivado);
    			controller.setIdTablaPublico(idTablaPublico);
    			if(esPublico) {
    				ModeloAeropuertoPublico modelo=idTablaPublico.getSelectionModel().getSelectedItem();
    				controller.setTxtAnioInauguracionText(modelo.getAnioInauguracion()+"") ;
    				controller.setTxtCalleText(modelo.getDireccion().getCalle());
    				controller.setTxtCapacidadText(modelo.getCapacidad()+"");
    				controller.setTxtCiudadText(modelo.getDireccion().getCiudad());
    				controller.setTxtFinanciacionText(modelo.getFinanciacion()+"");
    				controller.setTxtNombreText(modelo.getNombre());
    				controller.setTxtNumeroText(modelo.getDireccion().getNumero()+"");
    				controller.setTxtNumTrabajadoresText(modelo.getNumTrabajadores()+"");
    				controller.setTxtPaisText(modelo.getDireccion().getPais());
    			}else {
    				ModeloAeropuertoPrivado modelo=idTablaPrivado.getSelectionModel().getSelectedItem();
    				controller.setTxtAnioInauguracionText(modelo.getAnioInauguracion()+"") ;
    				controller.setTxtCalleText(modelo.getDireccion().getCalle());
    				controller.setTxtCapacidadText(modelo.getCapacidad()+"");
    				controller.setTxtCiudadText(modelo.getDireccion().getCiudad());
    				controller.setTxtNombreText(modelo.getNombre());
    				controller.setTxtNumeroText(modelo.getDireccion().getNumero()+"");
    				controller.setTxtNumSociosText(modelo.getNumSocios()+"");
    				controller.setTxtPaisText(modelo.getDireccion().getPais());
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
            s.setResizable(false);
            s.initOwner(MainApp.getStage());
            s.initModality(javafx.stage.Modality.WINDOW_MODAL);
            s.showAndWait();
            accionFiltrar();
            idTablaPrivado.refresh();
            idTablaPublico.refresh();
    	}else {
    		Alert al=new Alert(AlertType.ERROR);
        	al.setHeaderText(null);
        	al.setContentText("No hay nadie seleccionado, asi que no se puede seleccionar nadie");
        	al.showAndWait();
    	}
    }

    @FXML
    void mostarDatosAeropuerto(ActionEvent event) {

    }
    
    @FXML
    void toggleAvion(ActionEvent event) {

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
    
    
    
    public static Stage getS() {
		return s;
	}
    
    public static ObservableList<ModeloAeropuertoPrivado> getListaTodasPrivado() {
		return listaTodasPrivado;
	}
    
    public static ObservableList<ModeloAeropuertoPublico> getListaTodasPublico() {
		return listaTodasPublico;
	}
    
    public static boolean isEsAniadir() {
		return esAniadir;
	}
    
    public static void setListaTodasPrivado(ObservableList<ModeloAeropuertoPrivado> listaTodasPrivado) {
		ListadoAeropuertosController.listaTodasPrivado = listaTodasPrivado;
	}
    
    public static void setListaTodasPublico(ObservableList<ModeloAeropuertoPublico> listaTodasPublico) {
		ListadoAeropuertosController.listaTodasPublico = listaTodasPublico;
	}
    
    public static boolean isEsPublico() {
		return esPublico;
	}

}
