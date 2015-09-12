package principal;

import Controlador.Controlador;
import grafo.Grafo;

public class principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Grafo g = new Grafo();
		Controlador c = new Controlador();
		c.setModelo(g);
				
	}
}
