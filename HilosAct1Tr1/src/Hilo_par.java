import java.util.concurrent.Semaphore;

public class Hilo_par extends Thread {
    private int sumaPar = 0;
    private static Semaphore semaforo;

    public Hilo_par(Semaphore semaforo) {
        super();
        this.semaforo = semaforo;  // Pasamos el semáforo al hilo
    }

    public void setSumaPar(int sumaPar) {
		this.sumaPar = sumaPar;
	}

	public int getSumaPar() {
        return sumaPar;
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
            if (i % 2 == 0) {
            	System.out.println("Número par: " + i);
                    sumaPar += i;   
            }
         
             
        }
     // Salir el semáforo pero primero imprimo ya que si no la maquina imprime raro
        System.out.println("Suma de números pares: " + sumaPar);
        semaforo.release();
       
    }
    @Override
    public void run() {
    	ImprimirConSemaforo();
    	
    }
}

