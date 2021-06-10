package Practica2;

public class Consumidor extends Thread{
	
	public int id;
	public int numeroVueltas = 0;
	private Almacen almacen;
	
	public Consumidor(int numeroVueltas, Almacen almacen) { //LO MISMO QUE EN LA CLASE PRODUCTOR
		
		this.numeroVueltas = numeroVueltas;
		this.almacen = almacen;
		
	}
	
	public void run() {
		
		int z = 0;
		
		while(z < numeroVueltas) { //MIENTRAS QUE EL NUMERO DE VUELTAS SEA MENOR QUE Z
			
			if(almacen.quitarTarea()) { //SI HA PARA QUITAR UNA TAREA
				
				z++; //VAMOS QUITANDO
			}
			
		}
		
	}
	

}
