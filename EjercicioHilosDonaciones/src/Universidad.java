import java.util.ArrayList;

public class Universidad {
	static double Donaciontotal=0;
	public static void main(String[] args) {
		//variables
		
		ArrayList<Persona> ListaDonacion = new ArrayList<>();
		int NumAleatorio=(int) (20*Math.random());
		/*el ejercicio lo hice al principio usando persona p = new p(1,1,0)
		 * pero mientras estaba haciendolo me resultaba muy pesado entonces 
		 * pense y dije por que no usar un bucle mejor que me cree aleatoriamente 
		 * las personas y me inicie todo solo mediante otro bucle con un start y un join 
		 * pero al ejecutarlo me di cuenta que ocurria "paralelamente" si no secuencial, es decir 
		 * lo incio,lo paro,lo incio lo paro....
		-*  por eso decidi hacerlo en dos bucles for +*/
		
		for(int i=0;i<NumAleatorio;i++){
			Persona P = new Persona((int) (Math.random() * 1_000_000_00),Math.random() * 10,0);
			ListaDonacion.add(P);
		}
		for(Persona p: ListaDonacion) {
			p.start();
		}
		for(Persona p: ListaDonacion) {
			try {
				p.join();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Donaciontotal+=p.getDonacion();
		}
		
		System.out.printf("la universidad ha recaudado %.2f",Donaciontotal);
	}

}
