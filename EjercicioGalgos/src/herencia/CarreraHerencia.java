package herencia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarreraHerencia{

	public static void main(String[] args) {
		//variables
		double tiempo=0;
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
			System.out.println("Bienvenido al sistema de comprobacion de hilos por herencia");
			System.out.println("Nuestros hilos seran los galgos");
			System.out.println("comencemos a crearlo");
			
			GalgoH G1 = new GalgoH("Pequeño Santa Claus",0);
			GalgoH G2 = new GalgoH("Rayo",0);
			GalgoH G3 = new GalgoH("Speedy González",0);
			GalgoH G4 = new GalgoH("Chili con Carne",0);
			CrearGalgos(tiempo, sc,G1,G2,G3,G4);
			//HEREDANDO SE USA START PARA EJECUTAR EL HILO
			G1.start();
			G2.start();
			G3.start();
			G4.start();
			
/*corchete main*/		}
	public static void CrearGalgos(double tiempo,Scanner sc, GalgoH G1, GalgoH G2, GalgoH G3, GalgoH G4) {
		
		System.out.println("Pequeño Santa Claus es el primer galgo y correrá un tiempo de ");
		do {
			tiempo=IntroducirTiempo(sc);//la variable tiempo es igual a lo que devuelve el metodo	
		}while(ComprobarTiempo(tiempo)==false);
		
		G1.setTiempoCorriendo(tiempo);
		///////////////////////creamos el galgo dos ////////////////////////////////
		
		System.out.println("Rayo es el segundo galgo y correrá un tiempo de ");
		do {
			tiempo=IntroducirTiempo(sc);//la variable tiempo es igual a lo que devuelve el metodo	
		}while(ComprobarTiempo(tiempo)==false);
		
		G2.setTiempoCorriendo(tiempo);
		///////////////////////creamos el galgo tres ////////////////////////////////
		
		System.out.println("Speedy González es el tercer galgo y correrá un tiempo de ");
		do {
			tiempo=IntroducirTiempo(sc);//la variable tiempo es igual a lo que devuelve el metodo	
		}while(ComprobarTiempo(tiempo)==false);
		
		G3.setTiempoCorriendo(tiempo);
		///////////////////////creamos el galgo cuatro ////////////////////////////////

		
		System.out.println("Chili con Carne es el cuarto galgo y correrá un tiempo de ");
		do {
			tiempo=IntroducirTiempo(sc);//la variable tiempo es igual a lo que devuelve el metodo	
		}while(ComprobarTiempo(tiempo)==false);
		
		G4.setTiempoCorriendo(tiempo);
		System.out.println("La carrera empieza ya! ");
		
		
		
		
	}
private static int IntroducirTiempo(Scanner sc) {
		// TODO Auto-generated method stub
	int tiempo=0;
	boolean llave = false;//pongo llave porque hago referencia a la llave de una puerta si es true es valida y la puedo usar para abrir la puerta
	while (llave==false) {
        try {
            System.out.println("Introduzca el tiempo: ");
            tiempo = sc.nextInt(); 
            llave = true; 
        } catch (InputMismatchException e) {
            System.out.println("Introduzca solo números.");
            sc.next(); // Limpiamos el escáner para evitar un bucle infinito
        }
    }
    return tiempo; // Devolver el tiempo
	}
/*corchete clase*/
	private static boolean ComprobarTiempo(double tiempo) {
		if(tiempo>0) {
			System.out.println("tiempo correcto. ");
			return true;
		}else {
			System.out.println("Por favor introduce un valor logico. ");
			return false;
		}
		// TODO Auto-generated method stub
		
		
	}}
