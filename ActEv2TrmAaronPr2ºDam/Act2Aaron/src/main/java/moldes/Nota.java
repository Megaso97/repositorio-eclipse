package moldes;

public class Nota {
private int calificacion;
private int idAlumno;
private int idAsignatura;


public Nota() {
	super();
}

public Nota(int calificacion, int idAlumno, int idAsignatura) { 
    super();
    this.calificacion = calificacion;
    this.idAlumno = idAlumno;
    this.idAsignatura = idAsignatura;
}

public int getIdAlumno() {
	return idAlumno;
}

public void setIdAlumno(int idAlumno) {
	this.idAlumno = idAlumno;
}

public int getidAsignatura() {
	return idAsignatura;
}

public void setidAsignatura(int idAsignatura) {
	this.idAsignatura = idAsignatura;
}

public int getCalificacion() {
	return calificacion;
}

public void setCalificacion(int nota) {
	this.calificacion = calificacion;
}

}
