package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.EventListener;

@SuppressWarnings({ "serial" })
public class vistaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumnodos;
	private JTextField txtProbabilidad;
	private JTextField txtM0field;
	private JTextField txtMfield;
	private JTextField txtIterfield;
	private JLabel lblTitulo;
	private JLabel lblFotoAleat;
	private JLabel lblFotoBar;
	private JLabel lblTituloAleat;
	private JLabel lblTituloBar;
	private JLabel lblNodos;
	private JLabel lblProb;
	private JButton btnGenerarAleat;
	private JLabel lblM0;
	private JLabel lblM;
	private JLabel lblIteraciones;
	private JButton btnGenerarBar;
	private JButton btnSalir;
	private JLabel lblAclaracion1;
	private JLabel lblAclaracion2;
	private JLabel lblAclaracion3;
	private JLabel lblAclaracion4;

	/**
	 * Create the frame.
	 */
	public vistaPrincipal() {
		setTitle("GENERADOR DE GRAFOS");
		setBounds(100, 100, 572, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Graph Generator");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitulo.setBounds(140, 11, 284, 33);
		contentPane.add(lblTitulo);
		
		lblFotoAleat = new JLabel("foto1");
		lblFotoAleat.setIcon(new ImageIcon(vistaPrincipal.class.getResource("/Vista/img/graph_original.png")));
		lblFotoAleat.setBounds(28, 81, 183, 160);
		contentPane.add(lblFotoAleat);
		
		lblFotoBar = new JLabel("foto2");
		lblFotoBar.setIcon(new ImageIcon(vistaPrincipal.class.getResource("/Vista/img/barabasi.jpg")));
		lblFotoBar.setBounds(308, 81, 183, 160);
		contentPane.add(lblFotoBar);
		
		lblTituloAleat = new JLabel("Modelo aleatorio");
		lblTituloAleat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTituloAleat.setBounds(51, 252, 142, 20);
		contentPane.add(lblTituloAleat);
		
		lblTituloBar = new JLabel("Modelo de Barabasi-Albert");
		lblTituloBar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTituloBar.setBounds(318, 254, 225, 17);
		contentPane.add(lblTituloBar);
		
		txtNumnodos = new JTextField();
		//txtNumnodos.setText("numNodos");
		txtNumnodos.setBounds(140, 317, 71, 20);
		contentPane.add(txtNumnodos);
		txtNumnodos.setColumns(10);
		
		txtProbabilidad = new JTextField();
		//txtProbabilidad.setText("probabilidad");
		txtProbabilidad.setBounds(140, 376, 71, 20);
		contentPane.add(txtProbabilidad);
		txtProbabilidad.setColumns(10);
		
		lblNodos = new JLabel("Nº de nodos");
		lblNodos.setBounds(28, 320, 80, 14);
		contentPane.add(lblNodos);
		
		lblProb = new JLabel("Probabilidad");
		lblProb.setBounds(28, 379, 80, 14);
		contentPane.add(lblProb);
		
		btnGenerarAleat = new JButton("Generar fichero");
		btnGenerarAleat.setBounds(66, 493, 145, 33);
		contentPane.add(btnGenerarAleat);
		
		lblM0 = new JLabel("m0");
		lblM0.setBounds(316, 301, 46, 14);
		contentPane.add(lblM0);
		
		lblM = new JLabel("m");
		lblM.setBounds(318, 363, 46, 14);
		contentPane.add(lblM);
		
		lblIteraciones = new JLabel("Iteraciones(t)");
		lblIteraciones.setBounds(318, 428, 97, 14);
		contentPane.add(lblIteraciones);
		
		txtM0field = new JTextField();
		//txtMfield.setText("m0_field");
		txtM0field.setBounds(470, 298, 86, 20);
		contentPane.add(txtM0field);
		txtM0field.setColumns(10);
		
		txtMfield = new JTextField();
		//txtM0field.setText("m_field");
		txtMfield.setBounds(470, 360, 86, 20);
		contentPane.add(txtMfield);
		txtMfield.setColumns(10);
		
		txtIterfield = new JTextField();
		//txtIterfield.setText("iter_field");
		txtIterfield.setBounds(470, 425, 86, 20);
		contentPane.add(txtIterfield);
		txtIterfield.setColumns(10);
		
		btnGenerarBar = new JButton("Generar fichero");
		btnGenerarBar.setBounds(355, 493, 145, 33);
		contentPane.add(btnGenerarBar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(231, 567, 106, 46);
		contentPane.add(btnSalir);
		
		lblAclaracion1 = new JLabel("numero comprendido entre 0 y  1 (usar punto)");
		lblAclaracion1.setEnabled(false);
		lblAclaracion1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAclaracion1.setBounds(28, 404, 190, 14);
		contentPane.add(lblAclaracion1);
		
		lblAclaracion2 = new JLabel("Nodos al inicio del grafo");
		lblAclaracion2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAclaracion2.setEnabled(false);
		lblAclaracion2.setBounds(318, 320, 142, 14);
		contentPane.add(lblAclaracion2);
		
		lblAclaracion3 = new JLabel("Enlaces que tendrá cada nuevo nodo");
		lblAclaracion3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAclaracion3.setEnabled(false);
		lblAclaracion3.setBounds(318, 382, 152, 14);
		contentPane.add(lblAclaracion3);
		
		lblAclaracion4 = new JLabel("Nodos que se añadirán");
		lblAclaracion4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblAclaracion4.setEnabled(false);
		lblAclaracion4.setBounds(318, 448, 106, 14);
		contentPane.add(lblAclaracion4);
		
		this.nombrarElementos();
		
		this.setVisible(true);
		this.setResizable(false);
		this.setLocation(350, 40); //mirar esto, comprobar datos
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void nombrarElementos() {
		//botones
		this.btnGenerarAleat.setName("btnGenerarAleat");
		this.btnGenerarBar.setName("btnGenerarBar");
		this.btnSalir.setName("btnSalir");
		//textos
		this.txtNumnodos.setName("txtNumnodos");
		this.txtProbabilidad.setName("txtProbabilidad");
		this.txtIterfield.setName("txtIterfield");
		this.txtMfield.setName("txtMfield");
		this.txtM0field.setName("txtM0field");
	}
	
	//metodo para encapsular el comportamiento de cerrar ventana
	public void cerrarVentana() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void fijarControlador(EventListener controlador) {
		this.btnGenerarAleat.addActionListener((ActionListener)controlador);
		this.btnGenerarBar.addActionListener((ActionListener)controlador);
		this.btnSalir.addActionListener((ActionListener)controlador);
	}
	
	public String getTextFieldNumNodos() {
		return this.txtNumnodos.getText();
	}
	
	public String getTextFieldProbabilidad() {
		return this.txtProbabilidad.getText();
	}
	
	public String getTextFieldM0() {
		return this.txtM0field.getText();
	}
	
	public String getTextFieldM() {
		return this.txtMfield.getText();
	}
	
	public String getTextFieldIteraciones() {
		return this.txtIterfield.getText();
	}
	
}
