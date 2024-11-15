
public class Persona  extends Thread {
//genero numeros aleatorios ya que estamos buscando el funcionamiento del join para ser mas practico
	
	    private int dni;
	    private double dinero;
	    private double donacion = 0;
	    //metodo run para la herencia del hilo
	    public void run() {
	    	DonarDinero();
	    }
	    	public double DonarDinero() {
	    		/*toqueteando los resultandos y viendo tu clases el metodo join lo que hace es pausar
	    		 * los hilos, es decir ya no los tengo que dormir porque se "duermen solos con el metodo join
	    		 * pero es verdad que con el metodo sleep la consola va mas despacio al imprimir es mas visual
	    		 * de esta forma te lo da a modo de collejón"*/
	    		 System.out.printf("La persona con DNI %s esta donando\n", dni);
	    		 //try {
	    			 //subo el tiempo a 5 segundo para que le de tiempo 
					//Thread.sleep((long)(5000));
					 donacion = dinero * 0.05; // Calcula el 5% de la cantidad  
					System.out.printf("La persona con DNI %s ha donado %.2f\n", dni, donacion);
			           
				//} catch (InterruptedException e) {
					//e.printStackTrace();
				//}
	          
	            return donacion;
	        }

	    public int getDni() {
			return dni;
		}

		public void setDni(int dni) {
			this.dni = dni;
		}

		public double getDinero() {
			return dinero;
		}

		public void setDinero(double dinero) {
			this.dinero = dinero;
		}

		public double getDonacion() {
			return donacion;
		}

		public void setDonacion(double donacion) {
			this.donacion = donacion;
		}

		public Persona(int dni, double dinero, double donacion) {
			super();
			this.dni = dni;
			this.dinero = dinero;
			this.donacion = donacion;
		}

		// Constructor vacío
	    public Persona() {}
}
