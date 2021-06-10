package Practica2;

public class Productor extends Thread {
	
	public int id;
	public int numeroVueltas = 0; //METEMOS UNAS VARIABLES
	private Almacen almacen;
	
	public Productor(int numeroVueltas, Almacen almacen) { //CONSTRUCTOR DE PRODUCTORES CON EL NUMERO DE VUELTAS Y UN ALMACEN
		
		this.numeroVueltas = numeroVueltas;
		this.almacen = almacen;
		
	}
	
	public void run() { //METODO RUN DEL THREAD
		
		int z = 0;
		
		while(z < numeroVueltas) { //MIENTRAS QUE Z ES MENOR QUE EL NUMERO DE VUELTAS
			
			almacen.añadirTarea(); //LLAMAMOS AL METODO DE AÑADIR UNA TAREA
			z++; //Y SUMAMOS DE UNA EN UNA
			
		}
	}

}
