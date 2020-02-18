package model.logic;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.logic.Comparendo;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */	

	private Queue<Comparendo> queue;

	private Stack<Comparendo> stack;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		queue = new Queue<Comparendo>();
		stack = new Stack<Comparendo>();
	}

	public int darCantidadQueue() {
		return queue.size();
	}

	public int darCantidadStack() {
		return stack.size();
	}

	public String darPrimerElementoQueue() {
		return stack.darPrimero().toString();
	}

	public String darPrimerElementoStack() {
		return queue.darPrimerElemento().toString();
	}

	public Queue<Comparendo> clusterConsecutivoMasGrande() {
		Queue<Comparendo> queueTemp = new Queue<Comparendo>();
		Queue<Comparendo> respuesta = new Queue<Comparendo>();

		Comparendo primero = queue.dequeue();
		queueTemp.enqueue(primero);
		
		int cantidad = queue.size();

		
		for (int i = 1 ; i < cantidad ; i++) {
			Comparendo comparendo = queue.dequeue();
			if (comparendo.darInfraccion().compareToIgnoreCase(primero.darInfraccion()) == 0) {
				queueTemp.enqueue(comparendo);

			}
			else {
				if (respuesta.size() < queueTemp.size() || respuesta.size() == 0) {
					respuesta.reemplazarCola(queueTemp);
				}
				queueTemp.vaciar();
				queueTemp.enqueue(comparendo);
			}
			primero = comparendo;
		}
		
		return respuesta;
	}
	
	public Queue<Comparendo> ultimosN(int n, String tipoComparendo) {
		Queue<Comparendo> cola = new Queue<Comparendo>();
		int tamano = stack.size();
		int tempTamano = 0;
		
		for (int i = 0 ; i < tamano && tempTamano < n; i++) {
			Comparendo comparendo = stack.pop();

			if (comparendo.darInfraccion().compareToIgnoreCase(tipoComparendo) == 0) {
				cola.enqueue(comparendo);
				tempTamano++;
			}
		}
		return cola;
	}

	public void cargarDatos() {
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader("data/comparendos_dei_2018_small.geojson"));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			SimpleDateFormat parser = new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				Date FECHA_HORA = parser.parse(s); 
				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();
				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, CLASE_VEHI, TIPO_SERVI, INFRACCION , DES_INFRAC, LOCALIDAD, longitud, latitud);
				queue.enqueue(c);
				stack.push(c);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}

