package poo;

import javax.swing.*;

public class CronometroEdad extends Thread {
	
	private JLabel mostrar_edad;
			
	public CronometroEdad(JLabel mostrar_edad) {
		// TODO Auto-generated constructor stub
		
		this.mostrar_edad = mostrar_edad;
		
		
	}
	
	public void run() {
		
		try {
									
			for(int i = 0; i<6000; i ++) {
				
					
						
						Thread.sleep(60000);					
						
						System.out.println("este es el de la edad");
						
						Mascota.setEdad();
						
						mostrar_edad.setText("Edad : " + Mascota.getEdad() + " a�os");
						
						System.out.println("La mascota tiene " + Mascota.getEdad() + " a�os" );
						
																	
					}
				    
				    
						
							
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
