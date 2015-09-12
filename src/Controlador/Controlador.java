package Controlador;

import grafo.Grafo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JOptionPane;

import Vista.vistaPrincipal;

public class Controlador implements ActionListener{
	
	private Grafo grafo;
	private vistaPrincipal vista;
	
	public Controlador() {
		this.vista = new vistaPrincipal();
		this.vista.fijarControlador(this);
		this.grafo =  new Grafo();
	}
	
	public void setModelo(Grafo g) {
		this.grafo = g;
	}

	private void tratarEventoGenerico(EventObject event) {
        Component fuente = (Component) event.getSource();
        this.cambiarModelo(fuente);
	}
	
	private void cambiarModelo(Component fuente) {
		String evento = fuente.getName(); //obtenemos el nombre y vemos que boton es
		
		if(evento == "btnSalir") {
			this.salir();
		}
		else if(evento == "btnGenerarAleat") {
			this.generarAleatorio(this.vista.getTextFieldNumNodos(), this.vista.getTextFieldProbabilidad());
		}
		else if(evento == "btnGenerarBar") {
			this.generarBarabasi(this.vista.getTextFieldM0(), this.vista.getTextFieldM(), this.vista.getTextFieldIteraciones());
		}
	}
	
	private void generarBarabasi(String textFieldM0, String textFieldM, String textFieldIteraciones) {
		// generar barabasi
		if(this.entradaValida(textFieldM0, textFieldM, textFieldIteraciones)) {
			Grafo ret = grafo.generarGrafoBarabasi(Integer.parseInt(textFieldM0), Integer.parseInt(textFieldM), Integer.parseInt(textFieldIteraciones));
				if(ret != null) {
					grafo.imprimirGrafoBarabasi(Integer.parseInt(textFieldM0), Integer.parseInt(textFieldM), Integer.parseInt(textFieldIteraciones));
					JOptionPane.showMessageDialog(null, "Grafo generado con éxito en la ruta del programa", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
				}
				else 
					JOptionPane.showMessageDialog(null, "Grafo no generado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "ATENCIÓN: Debe introducir un número entero válido", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	private void generarAleatorio(String textFieldNumNodos, String textFieldProbabilidad) {
		// generar aleatorio
		if(isDouble(textFieldNumNodos) && isDouble(textFieldProbabilidad) && (Double.parseDouble(textFieldProbabilidad) >= 0) && (Double.parseDouble(textFieldProbabilidad) <= 1)) {
			Grafo ret = grafo.generarGrafoAleatorio(Integer.parseInt(textFieldNumNodos), Double.parseDouble(textFieldProbabilidad));
			if(ret != null) {
				grafo.imprimirGrafoAleatorio(Integer.parseInt(textFieldNumNodos), Double.parseDouble(textFieldProbabilidad));
				JOptionPane.showMessageDialog(null, "Grafo generado con éxito en la ruta del programa", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
			}
			else 
				JOptionPane.showMessageDialog(null, "Grafo no generado", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "ATENCIÓN: Debe introducir un número válido", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	private void salir() {
		int aux = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir de la aplicación?", "ATENCIÓN", JOptionPane.YES_NO_OPTION);
        if (aux == JOptionPane.YES_OPTION) {
        	JOptionPane.showMessageDialog(null, "Gracias por usar Graph Generator");
        	this.vista.cerrarVentana();
        	System.exit(0); //terminar definitivamente
        }
        else {
          //nada, volvemos a donde estabamos
        }
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		this.tratarEventoGenerico(ae);
	}
	
	public static boolean isDouble(String cadena) {
	    try {
	        Double.parseDouble(cadena);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isInteger(String cadena) {
	    try {
	        Integer.parseInt(cadena);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
	
	public boolean entradaValida (String m0, String m, String iter) {
		return ((isInteger(m0) && isInteger(m) && isInteger(iter)) && 
				(Integer.parseInt(m0) > 0) && (Integer.parseInt(m) > 0) && (Integer.parseInt(iter) > 0)
				&& (Integer.parseInt(m0) >= Integer.parseInt(m)));
	}

}
