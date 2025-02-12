package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectionBBDD.DBConnection;
import conectionBBDD.SchemaBBDD;
import moldes.Profesor;
import moldes.QueryInsertar;

public class ProfesorDao {
	public static String[] cargarAsignaturas(Profesor profesor, int numeroModulo) throws SQLException {
	    Connection conexion = new DBConnection().getConnection();
	    
	    // Verificar si la conexión es nula
	    if (conexion == null) {
	        System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
	        return new String[0]; // Devuelve un array vacío en caso de error
	    }

	    String query = "SELECT a.nombreAsignatura "
	                 + "FROM profesor_modulo pm "
	                 + "JOIN modulo m ON pm.idModulo = m.idModulo "
	                 + "JOIN modulo_asignatura ma ON m.idModulo = ma.idModulo "
	                 + "JOIN asignaturas a ON ma.idAsignatura = a.idAsignatura "
	                 + "WHERE pm.idProfesor = ? AND pm.IdModulo=?;";

	    PreparedStatement ps = conexion.prepareStatement(query);
	    ps.setInt(1, profesor.getIdProfesor());
	    ps.setInt(2,numeroModulo);
	    ResultSet rs = ps.executeQuery();

	    List<String> asignaturas = new ArrayList<>();
	    while (rs.next()) {
	        asignaturas.add(rs.getString("nombreAsignatura")); // ✅ Obtener el valor correcto
	    }

	    // Cerrar recursos
	    rs.close();
	    ps.close();
	    conexion.close();

	    return asignaturas.toArray(new String[0]); // Nunca retorna null
	}
public static boolean agregarNota(QueryInsertar qi)throws SQLException{
	//antes de agregar la nota hay que verificar que el alumno existe 
	if(!comprobarAlumno(qi)) {
		return false;}
	
		//cogemos la conexion creada y si no hay la crea  
		Connection conexion = new DBConnection().getConnection();
		//creamos la query en este fornato para dar seguridad 
		String query=String.format("INSERT INTO %s(%s,%s,%s) VALUES (?,?,?)", 
				SchemaBBDD.TAB_NOTAS,SchemaBBDD.COL_IDALUMNO,SchemaBBDD.COL_IDASIGNATURA,SchemaBBDD.COL_NOTA);
				//mandamos la query en la conexion anterior
		PreparedStatement ps = conexion.prepareStatement(query);
		//rellenamos los datos de la query 
		ps.setInt(1,qi.getIdAlumno());
		ps.setInt(2, qi.getModulo());
		ps.setDouble(3, qi.getNota());
		//ejecutamos el prepared 
		int Filas=ps.executeUpdate();
		//cerramos el prepared
		ps.close();
		//cerramos la conexion
		conexion.close();
		//si devuelve mas de 0 es qeu hay una fila afectada es decir lo ha hecho 
		return Filas>0;
	}
public static  boolean comprobarAlumno(QueryInsertar qi) throws SQLException {
	//conectamos 
	Connection conexion = new DBConnection().getConnection();
	//la query seleccionamos 1 porque es el que buscamos 
	String query="SELECT 1 FROM alumnos where IdAlumno =?";
	//mandamos la query
	PreparedStatement ps = conexion.prepareStatement(query);
	//codifico la query para la seguridad ->?<-
	ps.setInt(1,qi.getIdAlumno());
	//recogemos el resultado de la query preparada y la ejecutamos
	ResultSet rs = ps.executeQuery();
	//si hay resultado es que existe 
	if (rs.next()) {
		return true;
	}
	//cerramos el prepared
		ps.close();
		//cerramos la conexion
		conexion.close();
	return false;
	}

}


