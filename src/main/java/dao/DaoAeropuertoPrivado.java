package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConexionBBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ModeloAeropuertoPrivado;

public class DaoAeropuertoPrivado {

	private static Connection conection;
	
	public static ObservableList<ModeloAeropuertoPrivado> cargarListaAeropuertosPrivados(){
		ObservableList<ModeloAeropuertoPrivado>lst=FXCollections.observableArrayList();
		try {
			conection=ConexionBBDD.getConnection();
			String select="SELECT id,numero_socios,nombre,anio_inauguracion,capacidad,id_direccion,imagen FROM aeropuertos_privados,aeropuertos WHERE id=id_aeropuerto";
			PreparedStatement pstmt = conection.prepareStatement(select);
			ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	ModeloAeropuertoPrivado modelo=new ModeloAeropuertoPrivado(rs.getString("nombre"),rs.getInt("anio_inauguracion"),rs.getInt("capacidad"), DaoDireccion.crearModeloDireccionPorID(rs.getInt("id_direccion")), rs.getBlob("imagen"),rs.getInt("numero_socios"));
            	modelo.setId(rs.getInt("id"));
            	lst.add(modelo);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
}
