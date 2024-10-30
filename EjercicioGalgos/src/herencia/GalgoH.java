// la clase se llama GalgoH porque 'H'ereda.
package herencia;

public class GalgoH extends Thread{
	//generamos los atributos 
private String nombre;
private double tiempoCorriendo;
// generamos constructor
public GalgoH(String nombre, int tiempoCorriendo) {
	super();
	this.nombre = nombre;
	this.tiempoCorriendo = tiempoCorriendo;
}
///generamos get y set siempre es bueno tenerlos 
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getTiempoCorriendo() {
	return tiempoCorriendo;
}
public void setTiempoCorriendo(double tiempo) {
	this.tiempoCorriendo = tiempo;
}
//generamos un toString para practicar
@Override
public String toString() {
	return "[soy" + nombre + ", y he corrido " + tiempoCorriendo + "]";
}
//metodo run siempre obligatorio

public void run(){
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
/*corchete final*/}
