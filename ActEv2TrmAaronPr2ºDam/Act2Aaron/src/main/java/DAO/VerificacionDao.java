package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conectionBBDD.DBConnection;
import moldes.Alumno;
import moldes.Profesor;

public class VerificacionDao {
public static boolean verificarProfesor(Profesor profesorV) throws SQLException {
	//conexion 
	Connection conexion = new DBConnection().getConnection();
	//query
	String query="SELECT 1 FROM profesores where IdProfesor=? AND contrasenia=?";
	PreparedStatement ps= conexion.prepareStatement(query);
	//moldeamos
	ps.setInt(1,profesorV.getIdProfesor());
	ps.setString(2,profesorV.getContrasenia());
	//recogemos el resultado de la query preparada y la ejecutamos
	//recogemos el resultado de la query preparada y la ejecutamos
		ResultSet rs = ps.executeQuery();
		//si hay resultado es que existe 
		if (rs.next()) {
			System.out.println("Existe en la BBDD");
			return true;
			
		}
	ps.close();
	conexion.close();
	System.out.println("NO Existe en la BBDD");
	return false;
	}
public static boolean verificarAlumno(Alumno alumnoV) throws SQLException {
	//conexion 
	Connection conexion = new DBConnection().getConnection();
	//query
	String query="SELECT 1 FROM alumnos where IdAlumno=? AND contrasenia=?";
	PreparedStatement ps= conexion.prepareStatement(query);
	//moldeamos
	ps.setInt(1,alumnoV.getIdAlumno());
	ps.setString(2,alumnoV.getContrasenia());
	//recogemos el resultado de la query preparada y la ejecutamos
	//recogemos el resultado de la query preparada y la ejecutamos
		ResultSet rs = ps.executeQuery();
		//si hay resultado es que existe 
		if (rs.next()) {
			System.out.println("Existe en la BBDD");
			return true;
			
		}
	ps.close();
	conexion.close();
	System.out.println("NO Existe en la BBDD");
	return false;
	
}
}
