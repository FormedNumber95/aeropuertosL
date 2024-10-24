package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConexionBBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ModeloAeropuerto;
import model.ModeloAeropuertoPublico;

public class DaoAeropuerto {

	private static Connection conection;
	
	public static ObservableList<ModeloAeropuerto>listaParaTabla(){
		ObservableList<ModeloAeropuerto>lst=FXCollections.observableArrayList();
		lst.addAll(DaoAeropuertoPrivado.cargarListaAeropuertosPrivados());
		lst.addAll(DaoAeropuertoPublico.cargarListaAeropuertosPublicos());
		return lst;
	}
	
}
