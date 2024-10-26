package dao;

import java.sql.Blob;
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
	
	public static Integer conseguirID(String nombre,int anioInauguracion,int capacidad,int idDireccion,Blob imagen) {
		conection=ConexionBBDD.getConnection();
		String select="SELECT id FROM aeropuertos WHERE nombre=? AND anio_inauguracion=? AND capacidad=? AND id_direccion=?";
				//select +=" AND imagen=?";
		try {
			PreparedStatement pstmt;
			pstmt=conection.prepareStatement(select);
			pstmt.setString(1,nombre);
			pstmt.setInt(2,anioInauguracion);
			pstmt.setInt(3,capacidad);
			pstmt.setInt(4,idDireccion);
			//pstmt.setBlob(5,imagen);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void aniadir(String nombre,int anioInauguracion,int capacidad,int idDireccion,Blob imagen) {
		conection=ConexionBBDD.getConnection();
		String insert="INSERT INTO aeropuertos (nombre,anio_inauguracion,capacidad,id_direccion,imagen) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pstmt;
			pstmt=conection.prepareStatement(insert);
			pstmt.setString(1,nombre);
			pstmt.setInt(2,anioInauguracion);
			pstmt.setInt(3,capacidad);
			pstmt.setInt(4,idDireccion);
			pstmt.setBlob(5,imagen);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void modificarPorId(int id,String nombre,int anioInauguracion,int capacidad,int idDireccion,Blob imagen) {
		conection=ConexionBBDD.getConnection();
		String update="UPDATE aeropuertos SET nombre=?,anio_inauguracion=?,capacidad=?,id_direccion=?,imagen=? WHERE id=?";
		try {
			PreparedStatement pstmt=conection.prepareStatement(update);
			pstmt.setString(1,nombre);
			pstmt.setInt(2,anioInauguracion);
			pstmt.setInt(3,capacidad);
			pstmt.setInt(4,idDireccion);
			pstmt.setBlob(5,imagen);
			pstmt.setInt(6,id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
