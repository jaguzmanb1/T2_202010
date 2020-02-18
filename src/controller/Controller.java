package controller;

import java.util.Scanner;

import model.data_structures.Queue;
import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

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
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int dato = 0;
		String respuesta = null;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \nRealizar carga comparendos: ");
				modelo = new Modelo(); 
				modelo.cargarDatos();
				view.printMessage("Carga completada, hay un total de " + modelo.darCantidadQueue() + " registros en la cola y " + modelo.darCantidadStack() + " registros en la pila");
				view.printMessage("El primer elemento de la cola es: " + modelo.darPrimerElementoQueue());
				view.printMessage("El primer elemento de la pila es: " + modelo.darPrimerElementoStack());

				break;

			case 2: 
				String rta = "";
				Queue<Comparendo> qRespuesta = modelo.clusterConsecutivoMasGrande();
				int qSize = qRespuesta.size();

				
				view.printMessage("El cluster mas grande lo conforman los siguientes comparendos con " + qRespuesta.size() + " registros:");
				for (int i = 0 ; i < qRespuesta.size(); i++) {
					view.printMessage(qRespuesta.dequeue().toString());
				}
				break;	

			case 3: 
				rta = "";
				
				view.printMessage("Digite n:");
				Scanner lector2 = new Scanner(System.in);
				int n = lector2.nextInt();
				
				view.printMessage("Digite la infraccion:");
				Scanner lector3 = new Scanner(System.in);
				String infraccion = lector3.nextLine();
				
				qRespuesta = modelo.ultimosN(n, infraccion);
				qSize = qRespuesta.size();

				view.printMessage("Se encontraron " + qRespuesta.size() + " comparendos y son los siguientes: ");
				
				for (int i = 0 ; i < qSize ; i++) {
					view.printMessage(qRespuesta.dequeue().toString());
				}
				view.printMessage(rta);
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
