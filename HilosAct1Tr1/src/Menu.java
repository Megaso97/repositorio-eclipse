import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Menu {
    public static void main(String[] args) {
    	/*NOTA: he estado investigando y todo tiene su lógica cómo son hilos yo no sé como viaja la información
    	 * podría hacer synchronized pero no lo has explicado y para que me lo haga CHATGPT es engañarme a mi mismo y no a tí
    	 * otra solucion que yo veo fuera del synchronized es meter un semáforo estatico y común pero el enunciado no dice nada de que se tengan que 
    	 * imprimir por orden solo que impriman: 
    	 * ""Un hilo imprime números pares del 1 al 10 y la suma de dichos números""
    	 * De esta manera estoy haciendo que se ejecuten todos a la vez paralelamente pero los hago secuenciales a la hora de la impresion con el semaforo
    	 * y los 'paro' con el metodo join para poder sumar todo bien y que los hilos no mueran nada mas terminar*/
    	//variable
    	Semaphore semaforo= new Semaphore(1);
    	int sumaTotal;
        /* Crear instancias de los hilos como pone en el enunciado 
         * ""Cree dos instancias (hilos) de cada uno y muestre la salida""*/
    	
        Hilo_par ap = new Hilo_par(semaforo);
        Hilo_par bp = new Hilo_par(semaforo);
        Hilo_Impar aip = new Hilo_Impar(semaforo);
        Hilo_Impar bip = new Hilo_Impar(semaforo);

        // iniciamos los hilos con el metodo start
        ap.start();
        aip.start();
        bp.start();
        bip.start();

        try {
            // esperamos a que terminen todos los hilos
            ap.join();
            aip.join();
            bp.join();
            bip.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // obtenemos las sumas de los hilos
        sumaTotal = ap.getSumaPar() + bp.getSumaPar() + aip.getSumaImpar() + bip.getSumaImpar();

        // Imprimimos la suma total
        System.out.println("La suma total es " + sumaTotal);
    }
}

