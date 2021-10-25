package Interfaz_Swing_JFrame_Colecciones;

import java.util.LinkedList;
import java.util.Queue;

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

public class Cola extends JFrame {

	private JPanel contentPane;
	private JTextField inpNombre;

	
	public static void main(String[] args) {
		
					Cola frame = new Cola();
					frame.setVisible(true);
			
	}

	
	public Cola() {
		setTitle("Queue-Cola");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		//Queue - Cola es una estructura de datos dinamica para guardar elemntos
		//Add - Insertar elementos a la Cola
		//Poll - Eliminar la cabeza o frente de la Cola
		//Peek - Consulta la cabeza o frente de la Cola
		
		Queue<String> miCola=new LinkedList<String>();//No es una clase es una Interfaz y las interfaces no la podemos instanciar en Java.
		
		
		JLabel lblEstudiante = new JLabel("Estudiante");
		lblEstudiante.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		lblEstudiante.setBounds(154, 21, 119, 23);
		contentPane.add(lblEstudiante);
		
		JLabel lblNombre = new JLabel("Ingrese nombre del Estuadiante:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(88, 68, 236, 14);
		contentPane.add(lblNombre);
		
		inpNombre = new JTextField();
		inpNombre.setColumns(10);
		inpNombre.setBounds(98, 93, 213, 20);
		contentPane.add(inpNombre);
		
		JTextArea txtMostrar = new JTextArea();
		txtMostrar.setBounds(10, 155, 414, 38);
		contentPane.add(txtMostrar);
		
		JButton btnPeek = new JButton("Peek");
		btnPeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(miCola.isEmpty()) {
					JOptionPane.showMessageDialog(btnPeek, "La Cola esta vacia");
				}else {
				JOptionPane.showMessageDialog(btnPeek, "Consulta de la Cabeza de la Cola exitosa: "+miCola.peek());
				}
				
			}
		});
		btnPeek.setBounds(244, 121, 66, 23);
		contentPane.add(btnPeek);
		
		JButton btnPoll = new JButton("Poll");
		btnPoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(miCola.isEmpty()) {
					JOptionPane.showMessageDialog(btnPoll, "La Cola esta vacia");
				}else {
					JOptionPane.showMessageDialog(btnPoll, "Se elimino la cabeza de la Cola: "+miCola.poll());
					txtMostrar.setText(miCola.toString());
				}
				
			}
		});
		btnPoll.setBounds(167, 121, 72, 23);
		contentPane.add(btnPoll);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(inpNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe llenar el campo Nombre");
				}else {
					miCola.add(inpNombre.getText());
					txtMostrar.setText(miCola.toString());
					inpNombre.setText(null);
				}
				
			}
		});
		btnAdd.setBounds(96, 121, 66, 23);
		contentPane.add(btnAdd);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(154, 215, 100, 23);
		contentPane.add(btnSalir);
	
	}
}
