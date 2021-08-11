package poo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Ventana extends JFrame {
	
	
	//---------------ZONA DE VARIABLES-------------------------------
	
				
	private Mascota mascota = new Mascota();
	private JPanel panel1, panel2;
	private JButton iniciar, salir; 
	private JButton revivir, alimentar, desinfectar;
	private JLabel mostrar_nombre, mostrar_vida, mostrar_edad, mostrar_hambre;
	private JLabel corna, corna_muerto, eti_actividad;
	private String accion;
		
	
	
	//---------------CONSTRUCTOR DE LA VENTANA-------------------------------
	
		
	public Ventana() {
		
		this.setSize(400, 350);
		this.setTitle("Mascota Virtual");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		iniciarComponentes();
	}
	
	//---------------ZONA DE COMPONENTES---------------------------------------
	
	private void iniciarComponentes() {
		
		panel1 = new JPanel(); 
		panel1.setLayout(null); 
		this.getContentPane().add(panel1); 
		colocarBotones();
		
		
	}
	
	private void colocarBotones() {
		
		iniciar = new JButton("Iniciar");
		iniciar.setBounds(140, 100, 100, 40);
		ActionListener oyenteIni = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					panel1.setVisible(false);
				    cargarPanel2();
					
				    iniciarHiloEdad();
					iniciarHiloVida();
					iniciarHiloHambre();
									
			}
			
			
		};
		
		iniciar.addActionListener(oyenteIni);
		panel1.add(iniciar);
		
        
		
		salir = new JButton("Salir");
		salir.setBounds(140, 150, 100, 40);
		ActionListener oyenteExit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
			
			
		};
		
		salir.addActionListener(oyenteExit);
        panel1.add(salir);
				
		}
	
	
	private void cargarPanel2() {
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		this.getContentPane().add(panel2);
		colocarJLabels();
		colocarBotones2();
		
				
       	}
	
private void colocarJLabels() {
		
		mostrar_nombre = new JLabel(mascota.getNombre());
		mostrar_nombre.setBounds(250, 60, 120, 40);
		panel2.add(mostrar_nombre);
		
		mostrar_vida = new JLabel(Mascota.getVida() + " %" );
		mostrar_vida.setBounds(250, 90, 120, 40);
		panel2.add(mostrar_vida);
		
		mostrar_edad = new JLabel("Edad : " + Mascota.getEdad() + " a�os");
		mostrar_edad.setBounds(250, 120, 120, 40);
		panel2.add(mostrar_edad);
		
		mostrar_hambre = new JLabel("Nivel de hambre : " + Mascota.getHambre());
		mostrar_hambre.setBounds(250, 150, 120, 40);
		panel2.add(mostrar_hambre);
		
		eti_actividad = new JLabel();
		eti_actividad.setBounds(50, 30, 180, 40);
		panel2.add(eti_actividad);
		eti_actividad.setVisible(false);
		
		corna = new JLabel(new ImageIcon("Cornavairus.gif"));
		corna.setBounds(90, 90, 80, 80);
		panel2.add(corna);
		
		corna_muerto = new JLabel(new ImageIcon("Cornavairus_muerto.png"));
		corna_muerto.setBounds(90, 90, 80, 80);
		corna_muerto.setVisible(false);
		panel2.add(corna_muerto);
		
				
	}
	
	private void colocarBotones2() {
		
		
		alimentar = new JButton();
		alimentar.setText("Alimentar");
		alimentar.setBounds(37, 263, 100, 40);
				
		ActionListener oyenteAlim = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Mascota.getHambre() > 10) {
					
					accion = "alimentando";
					Mascota.setAlimentar();
					mostrar_hambre.setText("Nivel de hambre : " + mascota.getHambre());
					
					iniciarHiloLabelActividad();
					
				}
				
				
																
			}
			
			
		};
		
		alimentar.addActionListener(oyenteAlim);
		panel2.add(alimentar);
		
		desinfectar = new JButton();
		desinfectar.setText("Desinfectar");
		desinfectar.setBounds(147, 263, 100, 40);
				
		ActionListener oyenteDesin = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				accion = "desinfectando";
				Mascota.setDesinfectar();
				mostrar_vida.setText(Mascota.getVida() + " %" );
				
								
				iniciarHiloLabelActividad();
				
								
				
			}
			
			
		};
		
		desinfectar.addActionListener(oyenteDesin);
		panel2.add(desinfectar);
        
        revivir = new JButton();
		revivir.setText("Revivir");
		revivir.setBounds(257, 263, 100, 40);
		ActionListener oyenteReviv = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
									
					mascota.setRevivir();
					
					Mascota.estado = true;
					
					reiniLabels();
					
					System.out.println("Vamos a ver que pasa");
												
			}
			
			
		};
		
		revivir.addActionListener(oyenteReviv);
		panel2.add(revivir);
        
        		
		
			
		
	}
	
	//-------------------ZONA DE THREADS PRINCIPALES-------------------------
	
	
	private void iniciarHiloEdad() {
		
				
		CronometroEdad hiloEdad = new CronometroEdad(mostrar_edad);
		hiloEdad.start();
	}
	
	
    private void iniciarHiloVida() {
		
				
		CronometroVida hiloVida = new CronometroVida(mostrar_vida);
		hiloVida.start();
	
    }
    
    private void iniciarHiloHambre() {
    	
    	CronometroHambre hiloHambre = new CronometroHambre(mostrar_hambre);
    	hiloHambre.start();
    		
    	
    	
    }
    
    
    //------------------------------------------------------------------------------
    
    
   private void iniciarHiloLabelActividad() {
	   
	        	
    	Thread tAct = new Thread(new Runnable() {
    		
    		   
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				 try {
					 	
					 if(accion == "alimentando") {
						 
						 
						 eti_actividad.setVisible(true);
							eti_actividad.setText("Ñam...ñam...Estoy comiendo");
							Thread.sleep(6000);
							eti_actividad.setVisible(false);
						 
						 
					 }
					 else if(accion == "desinfectando") {
						 
						 eti_actividad.setVisible(true);
							eti_actividad.setText("Grr...grr... Hijos de #%!#");
							Thread.sleep(6000);
							eti_actividad.setVisible(false);
						 
					 }
					 
					 
					} catch (Exception ex) {
						// TODO: handle exception
				  }
																							
			}
    		
    		
    	});    	
    	
    	tAct.start();
    }
    
 
 private void reiniLabels() {
    	
    	    	
    	mostrar_vida.setText(mascota.getVida() + " %");
    	mostrar_vida.setVisible(true);
		mostrar_edad.setText("Edad : " + mascota.getEdad() + " años");
		mostrar_edad.setVisible(true);
		mostrar_hambre.setText("Nivel de hambre : " + Mascota.getHambre());
		mostrar_hambre.setVisible(true);
		eti_actividad.setVisible(false);
    	
    }
 

}
