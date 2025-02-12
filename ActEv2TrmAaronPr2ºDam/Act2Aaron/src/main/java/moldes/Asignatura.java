package moldes;

public class Asignatura {
private String nombreAsignatura;
private int IdAsignatura;
public Asignatura(String nombreAsignatura) {
	super();
	this.nombreAsignatura = nombreAsignatura;
}
public Asignatura() {
	super();
}
public String getNombreAsignatura() {
	return nombreAsignatura;
}
public void setNombreAsignatura(String nombreAsignatura) {
	this.nombreAsignatura = nombreAsignatura;
}
public int getIdAsignatura() {
	return IdAsignatura;
}
public void setIdAsignatura(int idAsignatura) {
	IdAsignatura = idAsignatura;
}

}
