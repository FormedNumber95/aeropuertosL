package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConexionBBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ModeloAeropuertoPrivado;
import model.ModeloAeropuertoPublico;

public class DaoAeropuertoPublico {

	private static Connection conection;
	
	public static ObservableList<ModeloAeropuertoPublico> cargarListaAeropuertosPublicos(){
		ObservableList<ModeloAeropuertoPublico>lst=FXCollections.observableArrayList();
		try {
			conection=ConexionBBDD.getConnection();
			String select="SELECT financiacion,num_trabajadores,nombre,anio_inauguracion,capacidad,id_direccion,imagen FROM aeropuertos_publicos,aeropuertos WHERE id=id_aeropuerto";
			PreparedStatement pstmt = conection.prepareStatement(select);
			ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	lst.add(new ModeloAeropuertoPublico(rs.getString("nombre"),rs.getInt("anio_inauguracion"),rs.getInt("capacidad"), DaoDireccion.crearModeloDireccionPorID(rs.getInt("id_direccion")), rs.getBlob("imagen"),rs.getFloat("financiacion"), rs.getInt("num_trabajadores")));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
}
