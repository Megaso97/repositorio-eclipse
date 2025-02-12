package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import conectionBBDD.DBConnection;
import moldes.Alumno;
import moldes.Nota;

public class AlumnoDao {
	
	public static  List<Nota> cargarNotas(Alumno alumnoV,JComboBox comboBoxModulo) throws SQLException {
		Connection conexion = new DBConnection().getConnection();
		String query = "SELECT n.idAlumno, n.idAsignatura, n.calificacion " +
                "FROM notas n " +
                "JOIN asignaturas a ON n.idAsignatura = a.idAsignatura " +
                "JOIN modulo_asignatura ma ON a.idAsignatura = ma.idAsignatura " +
                "WHERE ma.idModulo = ? AND n.idAlumno = ?";
		 PreparedStatement ps = conexion.prepareStatement(query);
		 // Obtener el módulo seleccionado
	        String moduloSeleccionado = (String) comboBoxModulo.getSelectedItem();
	        int idModulo = obtenerIdModulo(moduloSeleccionado);
		 ps.setInt(1, idModulo);
	        ps.setInt(2, alumnoV.getIdAlumno());
		 ResultSet rs = ps.executeQuery();
		 List<Nota> listaNotas = new ArrayList<Nota>();
		 while (rs.next()) {
	            int idAlumno = rs.getInt("idAlumno");
	            int idAsignatura = rs.getInt("idAsignatura");
	            int calificacion = rs.getInt("calificacion");

	            Nota nota = new Nota(calificacion, idAlumno, idAsignatura);
	            listaNotas.add(nota);
	        }
		 return listaNotas;
	}

	private static int obtenerIdModulo(String moduloSeleccionado) {
		  switch (moduloSeleccionado) {
	        case "Primero": return 1;
	        case "Segundo": return 2;
	        case "Tercero": return 3;
	        case "Cuarto": return 4;
	        default: return 1; 
		  	}
	}
}
