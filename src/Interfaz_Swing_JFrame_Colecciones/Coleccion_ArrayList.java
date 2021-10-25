package Interfaz_Swing_JFrame_Colecciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

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

public class Coleccion_ArrayList extends JFrame {

	private JPanel contentPane;
	private JTextField inpNombre;


	public static void main(String[] args) {
	
					Coleccion_ArrayList frame = new Coleccion_ArrayList();
					frame.setVisible(true);
	
	}

	public Coleccion_ArrayList() {
		setTitle("ArrayList");
		
		//ArrayList: Guardar la imformacion de forma de lista, estructura dinamica, se puede definir un tamaño pero lo recomendable es que sea dinamica
		//add: insertar elemento
		//get: buscar mediante el indice 
		//size: el tamaño de la lista
		
		ArrayList<String> flores=new ArrayList<String>();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblFlores = new JLabel("Flores");
		lblFlores.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		lblFlores.setBounds(135, 11, 74, 23);
		contentPane.add(lblFlores);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la flor:");
		lblNombreDeLa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDeLa.setBounds(103, 59, 130, 14);
		contentPane.add(lblNombreDeLa);
		
		inpNombre = new JTextField();
		inpNombre.setColumns(10);
		inpNombre.setBounds(59, 84, 213, 20);
		contentPane.add(inpNombre);
		
		JTextArea txtMostrar = new JTextArea();
		txtMostrar.setBounds(10, 154, 312, 38);
		contentPane.add(txtMostrar);
		
		JButton btnAgregaradd = new JButton("Agregar(add)");
		btnAgregaradd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(inpNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAgregaradd, "LLene el campo");
				}else {
					flores.add(inpNombre.getText());
					inpNombre.setText(null);
					txtMostrar.setText(flores.toString());
				}
				
			}
		});
		btnAgregaradd.setBounds(10, 108, 109, 23);
		contentPane.add(btnAgregaradd);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnSalir.setBounds(135, 233, 72, 23);
		contentPane.add(btnSalir);
		
		JButton btnBuscarget = new JButton("Buscar(get)");
		btnBuscarget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(flores.isEmpty()) {
						JOptionPane.showMessageDialog(btnAgregaradd, "Lista vacia");
					}else {
						
						if(inpNombre.getText().isEmpty()) {
							JOptionPane.showMessageDialog(btnAgregaradd, "LLene el campo");
						}else {
							
								JOptionPane.showMessageDialog(btnAgregaradd, "Busqueda exitoso: "+flores.get(Integer.parseInt(inpNombre.getText())));
							
						}
					}		
					}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(btnAgregaradd, "No se aceptan cadenas solo enteros de >=0");
				}
			
				
			}
		});
		btnBuscarget.setBounds(123, 108, 109, 23);
		contentPane.add(btnBuscarget);
		
		JButton btnTamao = new JButton("Tama\u00F1o");
		btnTamao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flores.isEmpty()) {
					JOptionPane.showMessageDialog(btnAgregaradd, "Lista vacia");
				}else {
					
					JOptionPane.showMessageDialog(btnAgregaradd, "Tamaño de la lista: "+flores.size());
				}
				
			}
		});
		btnTamao.setBounds(236, 108, 86, 23);
		contentPane.add(btnTamao);
	}

}
