package poo;
import javax.swing.*;

public class CronometroHambre extends Thread {
	
	private JLabel mostrar_hambre;
	
	
	public CronometroHambre(JLabel mostrar_hambre) {
		
		this.mostrar_hambre = mostrar_hambre;
	}
	
	public void run() {
		
		try {
			
			
			for(int i = 0; i<6000; i ++) {
				
				
				
				Thread.sleep(30000);					
				
				System.out.println("este es el de la vida");
				
				Mascota.setHambre();
				
				mostrar_hambre.setText("Nivel de hambre : " + Mascota.getHambre());
				
				System.out.println("La mascota tiene " + Mascota.getHambre() + " de hambre" );
				
															
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
