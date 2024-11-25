package controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

import model.data_structures.ILista;
import model.data_structures.NullException;
import model.data_structures.PosException;
import model.data_structures.VacioException;
import model.data_structures.YoutubeVideo;
import model.logic.Modelo;
import utils.Ordenamiento;
import view.View;

public class Controller<T> {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
	}
		
	

	public void run() {
		Scanner lector = new Scanner(System.in).useDelimiter("\n");
		boolean fin = false;
	
		while (!fin) {
			view.printMenu();
	
			int option = lector.nextInt();
			lector.nextLine(); // Consumir línea pendiente
	
			switch (option) {
				case 1:
					cargarDatos();
					break;
	
				case 2:
					procesarReq1(lector);
					break;
	
				case 3:
					procesarReq2();
					break;
	
				case 4:
					procesarReq3(lector);
					break;
	
				case 5:
					procesarReq4();
					break;
	
				case 6:
					procesarReq5(lector);
					break;
	
				case 7:
					despedida(lector);
					fin = true;
					break;
	
				default:
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
	}
	
	// Función para cargar datos
	private void cargarDatos() {
		view.printMessage("--------- \nCargar datos");
		modelo = new Modelo(1);
		try {
			modelo.cargar();
		} catch (IOException e) {
			e.printStackTrace();
		}
		view.printModelo(modelo);
	}
	
	// Función para procesar el requerimiento 1
	private void procesarReq1(Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del primer punto de conexión");
		String punto1 = lector.nextLine();
	
		view.printMessage("--------- \nIngrese el nombre del segundo punto de conexión");
		String punto2 = lector.nextLine();
	
		String res1 = modelo.req1String(punto1, punto2);
		view.printMessage(res1);
	}
	
	// Función para procesar el requerimiento 2
	private void procesarReq2() {
		String res2 = modelo.req2String();
		view.printMessage(res2);
	}
	
	// Función para procesar el requerimiento 3
	private void procesarReq3(Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del primer país");
		String pais1 = lector.nextLine();
	
		view.printMessage("--------- \nIngrese el nombre del segundo país");
		String pais2 = lector.nextLine();
	
		String res3 = modelo.req3String(pais1, pais2);
		view.printMessage(res3);
	}
	
	// Función para procesar el requerimiento 4
	private void procesarReq4() {
		String res4 = modelo.req4String();
		view.printMessage(res4);
	}
	
	// Función para procesar el requerimiento 5
	private void procesarReq5(Scanner lector) {
		view.printMessage("--------- \nIngrese el nombre del punto de conexión");
		String landing = lector.nextLine();
	
		String res5 = modelo.req5String(landing);
		view.printMessage(res5);
	}
	
	// Función para mostrar despedida y cerrar recursos
	private void despedida(Scanner lector) {
		view.printMessage("--------- \n Hasta pronto !! \n---------");
		lector.close();
	}
	
}
