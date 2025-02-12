package moldes;

public class Modulo {
private int IdModulo;
private String nombreModulo;
public Modulo(String nombreModulo) {
	super();
	this.nombreModulo = nombreModulo;
}

public Modulo() {
	super();
}

public int getIdModulo() {
	return IdModulo;
}
public void setIdModulo(int idModulo) {
	IdModulo = idModulo;
}
public String getNombreModulo() {
	return nombreModulo;
}
public void setNombreModulo(String nombreModulo) {
	this.nombreModulo = nombreModulo;
}

}
