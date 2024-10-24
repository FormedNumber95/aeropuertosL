package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConexionBBDD;
import model.ModeloDireccion;

public class DaoDireccion {

	private static Connection conection;
	
	public static ModeloDireccion crearModeloDireccionPorID(int id) {
		conection=ConexionBBDD.getConnection();
		String select="SELECT pais,ciudad,calle,numero FROM direcciones WHERE id=?";
		try {
			PreparedStatement pstmt;
			pstmt=conection.prepareStatement(select);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new ModeloDireccion(rs.getString("pais"),rs.getString("ciudad"),rs.getString("calle"),rs.getInt("numero"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
