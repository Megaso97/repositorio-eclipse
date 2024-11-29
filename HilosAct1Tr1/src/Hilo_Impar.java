
import java.util.concurrent.Semaphore;

public class Hilo_Impar extends Thread {
    private int sumaImpar = 0;
    private static Semaphore semaforo;

    public Hilo_Impar(Semaphore semaforo) {
        super();
        this.semaforo = semaforo;  // Pasamos el semáforo al hilo
    }

    public void setSumaImpar(int sumaImpar) {
		this.sumaImpar = sumaImpar;
	}

	public int getSumaImpar() {
        return sumaImpar;
    }
    public void ImprimirConSemaforo() {
    	// Intentar obtener el semáforo
    	try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
            	System.out.println("Número Impar: " + i);
                    sumaImpar += i;   
            }
         
             
        }
     // Salir el semáforo pero primero imprimo ya que si no la maquina imprime raro
        System.out.println("Suma de números Impares: " + sumaImpar);
        semaforo.release();
      
    }
    @Override
    public void run() {
    	ImprimirConSemaforo();
    }
}