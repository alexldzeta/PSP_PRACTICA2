package Practica2;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> numeroMaximo = new ArrayList<Integer>(); //CREAMOS UN NUEVO ARRAYLIST

		Almacen almacen = new Almacen(numeroMaximo); //INSTANCIAMOS UN NUEVO ALMACEN Y LE PASAMOS POR PARAMETRO EL NUEVO ARRAYLIST

		Productor productor = new Productor(10, almacen); //CREAMOS UN NUEVO PRODUCTOR CON 10 VUELTAS Y EL NUEVO ALMACEN DONDE SE GUARDARAN LOS NUMEROS EN EL ARRAYLIST

		Consumidor consumidor = new Consumidor(10, almacen); //LO MISMO CON EL CONSUMIDOR

		// --------------------------------------------------------------------------------------------------------------------

		ArrayList<Thread> AThreads = new ArrayList<Thread>(); //CREAMOS UN ARRAYLIST DE THREADS 

		for (int z = 0; z < 15; z++) { //CON UN FOR AÑADIMOS NUEVOS HILOS DE TIPO PRODUCTOR

			AThreads.add(new Thread(productor));

		}

		for (int z = 0; z < 15; z++) { //LO MISMO CON EL CONSUMIDOR

			AThreads.add(new Thread(consumidor));

		}

		for (Thread t : AThreads) { //RECORREMOS EL ARRAYLIST DE THREADS Y LOS INICIAMOS TODOS

			t.start();

		}

		for (Thread t : AThreads) { //LOS RECORREMOS Y ESPERAMOS A QUE MUERAN

			try {

				t.join();

			} catch (InterruptedException e) {

				System.out.println("NO SE HAN FINALIZADO LOS HILOS");

				e.printStackTrace();
			}

		}

	}

}
