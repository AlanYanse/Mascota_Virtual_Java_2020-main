package poo;

public class Mascota {
	
	    // Atributos
	
	    private String nombre;
	    private static int edad;
	    private static int vida;
	    private static int hambre;
	    static boolean estado = true;
	
	    // Constructor
	
	   
	    public Mascota () {
		
		nombre = "Cornavairus";
		vida = 100;
		edad =  0;
		hambre = 50;
		
							
	}

		//  Métodos setters
		
		public void setNombre (String nombre) { // este quizas no tenga sentido porque siempre va a tener el mismo nombre
			
			this.nombre = nombre;
		}
	   
						
		
		public void	setRevivir() {
			
			vida = 100;
			edad = 0;
			hambre = 50;
			
		}
		
			
		
		public static void setEdad() { 
			
			edad ++;
		}
		
		public static void setVida() {
			
			vida--;
		}
		
		public static void setHambre() {
			
			
			hambre += 5;	 				
			
							
		}
		
		public static void setAlimentar() {
			
			hambre -= 10;
		}
		
		   	               
	       					
		// Getters
		
		         
		public String getNombre() {  
			
									
			return nombre;			
		}
	
		public static int getEdad() {
			
								
			return edad; 
		}
		
		public static int getVida() {
			
						
			return vida;
		}
			
		public static int getHambre() {
			
						
			return hambre;
		}
		
	     
        
		public static void setDesinfectar() {
			
			
			vida -= 5;
		
			
		}
		
}
		
		