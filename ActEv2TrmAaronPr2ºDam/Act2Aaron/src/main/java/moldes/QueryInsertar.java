package moldes;

public class QueryInsertar {
private int modulo;
private int asignatura;
private int id;
private double nota;
public QueryInsertar(int numeroModulo, int asignatura, int id, double nota) {
	super();
	this.modulo = numeroModulo;
	this.asignatura = asignatura;
	this.id = id;
	this.nota = nota;
}
public QueryInsertar() {
	super();
}
public int getModulo() {
	return modulo;
}
public void setModulo(int modulo) {
	this.modulo = modulo;
}
public int getAsignatura() {
	return asignatura;
}
public void setAsignatura(int asignatura) {
	this.asignatura = asignatura;
}
public int getIdAlumno() {
	return id;
}
public void setIdAlumno(int idAlumno) {
	this.id = idAlumno;
}
public double getNota() {
	return nota;
}
public void setNota(double nota) {
	this.nota = nota;
}


}
