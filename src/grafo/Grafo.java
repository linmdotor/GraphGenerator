package grafo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import grafo.Nodo;

public class Grafo {

	//para cada Integer (id de nodo) guardamos ArrayList de los Nodos con que enlaza
	private HashMap<Integer, Nodo> nodos;
	private int L;
	
	public Grafo() {
		this.nodos = new HashMap<Integer, Nodo>();
		this.L = 0;
	}
	
	/**
	 * Genera un grafo aleatorio con un n�mero de nodos determinado siguiendo una funci�n de probabilidad.
	 * Para ello genera n�meros aleatorios por cada enlace posible, si el n�mero generado es menor que la probabilidad, se cera el enlace.
	 * @param num_nodos N�mero de nodos del grafo (>0)
	 * @param probabilidad N�mero decimal entre (0 <= p <= 1)
	 * @return
	 */
	public Grafo generarGrafoAleatorio(int num_nodos, double probabilidad)
	{
	
		this.nodos = new HashMap<Integer, Nodo>();
		this.L = 0;
		//inicaliza los id de cada nodo
		for(int i=0; i<num_nodos; i++)
		{
			nodos.put(i, new Nodo(i));
		}
		
		int generados = 0;
		int no_generados = 0;
		
		//recorre solo la diagonal de arriba a la derecha
		for(int i=0; i<num_nodos; i++)
		{
			for(int j=i+1; j<num_nodos; j++)
			{
				double aleatorio = Math.random();	
				//crea enlace si el aleatorio es menor que la probabilidad
				if(aleatorio < probabilidad)
				{
					generados++;
					nodos.get(i).anadirEnlace(j);
					nodos.get(j).anadirEnlace(i);
					L = L+2;
				} 
				else 
				{
					no_generados++;
				}
			}
		}
		
		System.out.println("generados: " + generados + ", no generados: " + no_generados);
		
		return this;
	}
	
	/**
	 * 
	 * @param m0
	 * @param m
	 * @param iteraciones
	 * @return
	 */
	public Grafo generarGrafoBarabasi(int m0, int m, int iteraciones) //m numero de enlaces , iteraciones =>> N = m0 + t
	// m0 = m+1
	{
		//conectar m0 nodos aleatoriamente (todos deben tener al menos 1 enlace)
		
		this.nodos = new HashMap<Integer, Nodo>();
		this.L = 0; 

		Grafo grafo_aux = generarGrafoAleatorio(m0, 1);// Utilizamos el metodo que genera un grafo aleatorio haciendo que cada nodo este conectado con todos los demas
		this.nodos = grafo_aux.getNodos(); 
		this.L = grafo_aux.getL();
		
		for(int i=0;i<iteraciones;i++){ //se genera m nodos nuevos
			int numEnlaces = 0;
			
			//tenemos que incrementar el m0 e insertar en nuevo nodo
			Nodo nuevo = new Nodo(this.nodos.size()); //Creamos el nuevo nodo
			ArrayList<Nodo> enlazados = new ArrayList<Nodo>();
			while(numEnlaces < m){
				int j = 0;
				while(j<this.nodos.size() && numEnlaces<m){ // hay que guardar los id de los ya generados
					double aleatorio = Math.random(); // num aleatorio de 0 a 1
					double prob = probabilidadEnlace(this.nodos.get(j), L);
					if(aleatorio < prob && !enlazados.contains(this.nodos.get(j))) { // Si la probabibilidad aleatoria generada es menor que PIsubK y ademas no existe enlace aun 
						nuevo.anadirEnlace(j);
						this.nodos.get(j).anadirEnlace(nuevo.get_id());
						
						enlazados.add(this.nodos.get(j));
						numEnlaces++;
						
					}
					
					j++;	
				}
				
			}
			this.nodos.put(nuevo.get_id(), nuevo);
			L = L + 2*m;
			
		}
		return this;
	}
	
	
	public int getL() {
		return L;
	}

	public void setL(int l) {
		L = l;
	}

	/**
	 * 
	 * @param grafo
	 */
	public void imprimirGrafoAleatorio(int numNodos, double probabilidad)
	{
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("grafo_aleatorio_" + numNodos + "nodos_" + probabilidad + "prob" + ".gdf");
            pw = new PrintWriter(fichero);
 
            
            pw.println("nodedef>name VARCHAR");            
            Iterator<Entry<Integer, Nodo>> it = nodos.entrySet().iterator();
            while (it.hasNext())
            {
            	pw.println(it.next().getKey());
            }
            
            pw.println("edgedef>node1 VARCHAR, node2 VARCHAR");
            it = nodos.entrySet().iterator();
            while (it.hasNext())
            {
            	Entry<Integer, Nodo> elementos = it.next();
            	Nodo nodoactual = elementos.getValue();
            	for (int enlace: nodoactual.get_enlaces((int)elementos.getKey()))
            	{
            		
            		if(enlace > (int)elementos.getKey()) {
            			pw.println(elementos.getKey() + ", " + enlace);
            		}
            			
            	}
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		
		
		
	}
	
	/**
	 * 
	 * @param grafo
	 */
	public void imprimirGrafoBarabasi(int m0, int m, int iter)
	{
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("grafo_barabasi_" + m0 + "nodosIni_" + m + "enlaces_" + iter + "iter_" + ".gdf");
            pw = new PrintWriter(fichero);
 
            
            pw.println("nodedef>name VARCHAR");            
            Iterator<Entry<Integer, Nodo>> it = nodos.entrySet().iterator();
            while (it.hasNext())
            {
            	pw.println(it.next().getKey());
            }
            
            pw.println("edgedef>node1 VARCHAR, node2 VARCHAR");
            it = nodos.entrySet().iterator();
            while (it.hasNext())
            {
            	Entry<Integer, Nodo> elementos = it.next();
            	Nodo nodoactual = (Nodo)elementos.getValue();
            	for (int enlace: nodoactual.get_enlaces((int)elementos.getKey()))
            	{
            		
            		if(enlace > (int)elementos.getKey()) {
            			pw.println(elementos.getKey() + ", " + enlace);
            		}
            			
            	}
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		
		
		
	}
	
	/**
	 * Calcula la probabilidad de que un nodo ya existente sea enlazada a un nuevo nodo
	 * 
	 * @param nodo
	 * @param L
	 * @return
	 */
	public double probabilidadEnlace(Nodo nodo, int L) {
		
		int k = nodo.get_enlaces(nodo.get_id()).size(); //Obtenemos el grado del nodo en cuestion
		return k / ((double)L - k);
		
	}
	


	public HashMap<Integer, Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(HashMap<Integer, Nodo> nodos) {
		this.nodos = nodos;
	}
}
