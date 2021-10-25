package Interfaz_Swing_JFrame_Colecciones;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import java.util.Stack;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class Pila extends JFrame {

	private JPanel contentPane;
	private JTextField inpExpresion;
	private JTextArea txtMostrar;
	
	public static void main(String[] args) {
		
				JFrame miMarco1=new MarcoDeLista();
				miMarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				miMarco1.setVisible(true);
				
				JFrame miMarco2=new Coleccion_Stack();
				miMarco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				miMarco2.setVisible(true);
				
					Pila frame = new Pila();
					frame.setVisible(true);
					
	}
	
	public Pila() {
		setTitle("Stack-Pila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//Stack: Pila es una estructura de datos dinamica que te permite aguardar elementos
		//Push - insertar elementos en la parte posterior de la pila
		//Pop - eliminar elemento en que seria el ultimo que se encuentra en la parte posterior
		
		Stack<String>miPila=new Stack<String>();
	  	  	
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(203, 125, 72, 23);
		contentPane.add(btnSalir);
		
			
		JLabel lblExpresionMatematica = new JLabel("Expresi\u00F3n Matem\u00E1tica");
		lblExpresionMatematica.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		lblExpresionMatematica.setBounds(50, 22, 255, 23);
		contentPane.add(lblExpresionMatematica);
		
		inpExpresion = new JTextField();
		inpExpresion.setColumns(10);
		inpExpresion.setBounds(62, 94, 213, 20);
		contentPane.add(inpExpresion);
		
		JLabel lblExpresion = new JLabel("Ingrese Expresi\u00F3n Matem\u00E1tica:");
		lblExpresion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpresion.setBounds(62, 69, 222, 14);
		contentPane.add(lblExpresion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strExpresion=inpExpresion.getText();
				char chrCaracter=' ';
				String strCadena=" ";
				
				for(int x=0; x<strExpresion.length(); x++) {
					chrCaracter=strExpresion.charAt(x);
					strCadena=strCadena+" "+ chrCaracter;
					
					if(chrCaracter=='(') {
						miPila.push("Push"+chrCaracter);
					}if(chrCaracter==')') {
						miPila.pop();
					}
				}
				txtMostrar.setText(strCadena);
				 if(miPila.isEmpty()) {
					 JOptionPane.showMessageDialog(contentPane,"Expresión Correcta");
			        }else {
			         JOptionPane.showMessageDialog(contentPane, "Expresión Incorrecta");
			        }   
				
			}
		});
		btnAceptar.setBounds(62, 125, 91, 23);
		contentPane.add(btnAceptar);
		
		txtMostrar = new JTextArea();
		txtMostrar.setBounds(62, 172, 213, 38);
		contentPane.add(txtMostrar);					
	}

}

class MarcoDeLista extends JFrame{
	
	private JTextField inpFruta;
	private JList<String>listaFrutas;
	Stack<String>miPila=new Stack<String>();
	private JPanel laminaDeLista,laminaDeTexto;
	private JLabel rotulo;	
	
	
	public DefaultListModel<String> LimpiarJList() {
		DefaultListModel<String> modelo=new DefaultListModel<String>();
		listaFrutas.setModel(modelo);
		return modelo;
	}
	
	public DefaultListModel<String> AgregarDato(){
		DefaultListModel<String> modelo= (DefaultListModel<String>)listaFrutas.getModel();
		modelo.addElement(inpFruta.getText());
		return modelo;
	}
	
	
	public MarcoDeLista() {
		
		setTitle("Prueba de lista de frutas con Pila");
		setBounds(400,300,400,300);
		
		//String []frutas= {"Manzana","Pera","Mango","Sandia","Ciruela"};	
		
		listaFrutas=new JList<String>();//Instancia del objeto
		listaFrutas.setVisibleRowCount(5);//Rango de elementos
	  	JScrollPane laminaDeDesplazamiento =new JScrollPane(listaFrutas);//Se agrega a la lamina
	  	
	  	laminaDeLista=new JPanel();//Instancia del objeto
	  	laminaDeLista.add(laminaDeDesplazamiento);//Se agrega a la lamina
	  	
	  	listaFrutas.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				List<String>valores=listaFrutas.getSelectedValuesList();
				StringBuilder texto =new StringBuilder("Fruta seleccionada: ");
				//Foreach o for mejorado
				for(String elemento: valores) {
					String palabra=elemento;
					texto.append(palabra);
					texto.append("");
				}
				
				rotulo.setText(texto.toString());
				
			}});
	  	  	
		laminaDeTexto=new JPanel();
		rotulo=new JLabel("Fruta seleccionada o fruta Pop: ");
		laminaDeTexto.add(rotulo);
		add(laminaDeLista, BorderLayout.CENTER);
		add(laminaDeTexto, BorderLayout.SOUTH);	
		
		inpFruta = new JTextField();
		add(inpFruta,BorderLayout.NORTH);
		
		JButton btnPushFruta=new JButton("Push");
		btnPushFruta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*String strFruta=inpFruta.getText();
				miPila.push(strFruta);	*/
				//AgregarDato();
				
			}
			
		});
		add(btnPushFruta,BorderLayout.WEST);
		
		JButton btnPopFruta = new JButton("Pop");
		btnPopFruta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				if(miPila.isEmpty()) {
					JOptionPane.showMessageDialog(null,"La Pila esta vacía");
				}else {
					rotulo.setText(miPila.pop());	
				}	
				
			}
		});
		add(btnPopFruta,BorderLayout.EAST);
}	

}

class Coleccion_Stack  extends JFrame{
	
	private JPanel contentPane;
	private JTextField inpNombre;
	private JTextArea txtMostrar;
	
	public Coleccion_Stack () {
		
        Stack<String> miPila2=new Stack<String>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblRopa = new JLabel("Ropa");
		lblRopa.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		lblRopa.setBounds(181, 23, 63, 23);
		contentPane.add(lblRopa);
		
		JLabel lblIngreseNombreDe = new JLabel("Ingrese nombre de Ropa:");
		lblIngreseNombreDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngreseNombreDe.setBounds(119, 67, 184, 14);
		contentPane.add(lblIngreseNombreDe);
		
		inpNombre = new JTextField();
		inpNombre.setColumns(10);
		inpNombre.setBounds(103, 95, 213, 20);
		contentPane.add(inpNombre);
		
		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(inpNombre.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(btnPush, "Llene el campo");
					
				}else {
					miPila2.push(inpNombre.getText());
					inpNombre.setText(null);
					txtMostrar.setText(miPila2.toString());
				}
			}
		});
		btnPush.setBounds(50, 126, 91, 23);
		contentPane.add(btnPush);
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(miPila2.isEmpty()) {
					JOptionPane.showMessageDialog(btnPop, "Pila vacia");
				}else {
					JOptionPane.showMessageDialog(btnPop, "Se elimino la cabeza de la pila: "+miPila2.pop());
					txtMostrar.setText(miPila2.toString());
				}
				
			}
		});
		btnPop.setBounds(153, 126, 91, 23);
		contentPane.add(btnPop);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnSalir.setBounds(259, 126, 91, 23);
		contentPane.add(btnSalir);
		
		txtMostrar = new JTextArea();
		txtMostrar.setBounds(10, 160, 392, 38);
		contentPane.add(txtMostrar);

	}
}
