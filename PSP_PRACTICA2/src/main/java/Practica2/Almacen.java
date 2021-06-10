package Practica2;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Almacen {

	ArrayList<Integer> numeros = new ArrayList<Integer>(10); //CREAMOS UN ARRAYLIST PARA GUARDAR LOS NUMEROS GENERADOS HASTA QUE HAYA 10

	public Almacen(ArrayList<Integer> numeros) { //LE PASAMOS UN ARRAY AL CONSTRUCTOR

		super();
		this.numeros = numeros;

	}

	public synchronized boolean añadirTarea() { //METODO SYNCHRONIZED DE AÑADIR TAREAS

		if (numeros.size() == 10) { //SI EL ARRAYLIST ES IGUAL A 10

			try {

				wait(); //PONEMOS A DORMIR EL HILO

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		int numero = ThreadLocalRandom.current().nextInt(0, 11); //GENERAMOS NUMEROS ALEATORIOS ENTRE 0 Y 10
		numeros.add(numero); //LOS AÑADIMOS AL ARRAYLIST
		System.out.println("Productor: " + Thread.currentThread().getId() + " produce el numero --> " + numero);// Y LO SACAMOS POR PANTALLA
		notify(); //DESPERTAMOS AL HILO
		return true;

	}

	public synchronized boolean quitarTarea() { //METODO SYNCHRONIZED DE QUITAR TAREAS

		if (!numeros.isEmpty()) { //SI EL ARRAY NO ESTA VACIO

			int dato = numeros.remove(numeros.size() - 1); //VAMOS QUITANDO NUMEROS DE 1 EN 1

			System.out.println("Consumidor " + Thread.currentThread().getId() + " consume el numero --> " + dato); //Y SACAMOS EL ID DEL HILO QUE QUITA UNA TAREA

			notify(); //DESPERTAMOS AL HILO
			return true;

		}

		return false;

	}

	public void mostrar() { //VEMOS COMO ESTA EL ARRYALIST DE NUMEROS

		for (int z = 0; z < numeros.size(); z++) {

			System.out.println(numeros.get(z));

		}

	}

}
