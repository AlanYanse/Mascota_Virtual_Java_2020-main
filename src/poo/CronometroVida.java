package poo;

import javax.swing.JLabel;

public class CronometroVida extends Thread {
	
	private JLabel mostrar_vida;
	
	public CronometroVida(JLabel mostrar_vida) {
		// TODO Auto-generated constructor stub
		
		this.mostrar_vida = mostrar_vida;
		
	}
	
	public void run() {
		
		try {
											
				for (int j = 99; j>0; j--) {
					
											
						Thread.sleep(120000);
						
						Mascota.setVida();
																
						System.out.println("Este es el de la vida " + Mascota.estado);
						
						mostrar_vida.setText(Mascota.getVida() + " %");						
						
																		
				}
				
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	
}
