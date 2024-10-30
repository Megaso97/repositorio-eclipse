package Interfaz;

public class GalgosI implements Runnable{
	//generamos los atributos 
private String nombre;
private double tiempoCorriendo;
// generamos constructor
public GalgosI(String nombre, double tiempoCorriendo) {
	super();
	this.nombre = nombre;
	this.tiempoCorriendo = tiempoCorriendo;
}
//generamos get y set 
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getTiempoCorriendo() {
	return tiempoCorriendo;
}
public void setTiempoCorriendo(double tiempoCorriendo) {
	this.tiempoCorriendo = tiempoCorriendo;
}
//generamos un toString para practicar
@Override
public String toString() {
	return "[soy" + nombre + ", y he corrido " + tiempoCorriendo + "]";
}
@Override
//METODO RUN SIEMPRE OBLIGATORIO SI NO NO FUNCIONA
public void run() {{
	/*leyendo las recomendaciones que nos da eclipse 
	 * metemos en un try catch ya que el usuario puede meter un tiempo negativo*/
		
		try {
			System.out.println(nombre+" ha comenzado a correr");
			Thread.sleep((long) (tiempoCorriendo*1000));
			System.out.println(nombre+" ha terminado de correr");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Introduzca un valor de tiempo positivo");
			
		}
	
}
}
}
