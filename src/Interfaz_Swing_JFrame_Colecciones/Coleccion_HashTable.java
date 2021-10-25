package Interfaz_Swing_JFrame_Colecciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Coleccion_HashTable extends JFrame {

	int intKey=0;
	private JPanel contentPane;
	private JTextField inpNombre;

	public static void main(String[] args) {
		
					Coleccion_HashTable frame = new Coleccion_HashTable();
					frame.setVisible(true);
			
	}

	public Coleccion_HashTable() {
		setTitle("Hashtable");
		
		
		//Hashtable: es una estructura de datos dinamica que nos permite guardar objetos en ella, se lleva acabo con valores y llaves es semejante como las tablas de base de datos.
		
		//Hashtable tabla=new Hashtable();
		Hashtable<Integer,String>tabla2=new Hashtable<>();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblObjeto = new JLabel("Objetos");
		lblObjeto.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		lblObjeto.setBounds(131, 11, 100, 37);
		contentPane.add(lblObjeto);
		
		JLabel lblNombreDelObjeto = new JLabel("Nombre del Objeto:");
		lblNombreDelObjeto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelObjeto.setBounds(100, 59, 147, 14);
		contentPane.add(lblNombreDelObjeto);
		
		inpNombre = new JTextField();
		inpNombre.setColumns(10);
		inpNombre.setBounds(64, 84, 213, 20);
		contentPane.add(inpNombre);
		
		JTextArea txtMostrar = new JTextArea();
		txtMostrar.setBounds(10, 146, 332, 38);
		contentPane.add(txtMostrar);
		
		JButton btnPut = new JButton("Agregar(Put)");
		btnPut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(inpNombre.getText().isEmpty())
				{
					
					JOptionPane.showMessageDialog(btnPut, "Llene campo");
					
				}else {
					intKey++;
					tabla2.put(intKey,inpNombre.getText());
					inpNombre.setText(null);
					txtMostrar.setText(tabla2.toString());
				}				
				
			}
		});
		btnPut.setBounds(37, 112, 127, 23);
		contentPane.add(btnPut);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
if(tabla2.isEmpty()) {
	JOptionPane.showMessageDialog(btnBuscar, "Tabla vacia");
}else {
	
	if(inpNombre.getText().isEmpty())
	{
		
		JOptionPane.showMessageDialog(btnPut, "Llene campo");
		
	}else {
	JOptionPane.showMessageDialog(btnBuscar, "Busqueda exitosa: "+tabla2.get(Integer.parseInt(inpNombre.getText())));
	inpNombre.setText(null);
	txtMostrar.setText(tabla2.toString());
	}
}
}catch(Exception ex) {
	
	JOptionPane.showMessageDialog(btnBuscar, "No se puede buscar una cadena tiene que ser entero positivo");
	
}
				
			}
		});
		btnBuscar.setBounds(174, 115, 121, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnSalir.setBounds(120, 227, 100, 23);
		contentPane.add(btnSalir);
	}
}
