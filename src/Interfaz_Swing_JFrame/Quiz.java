package Interfaz_Swing_JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Quiz extends JFrame {

	int intCambio=-1;
	private JPanel contentPane;
	private JLabel lblPregunta;
	private JButton btnEvaluar;
	private JButton btnSiguiente;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Quiz frame = new Quiz();
					frame.setVisible(true);	
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Quiz() {
		setTitle("QUIZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 345);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 69, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		String [][]strCuestionario=new String[5][4];
		strCuestionario[0][0]="1. ¿Qué Empresa camercializó por primera vez la plataforma y lenguaje de programación Java?";
		strCuestionario[0][1]="Oracle Corporation";
		strCuestionario[0][2]="Sun Microsystems";
		strCuestionario[0][3]="Microsoft Corporation";
		
		strCuestionario[1][0]="2. ¿Qué quiere decir JDK?";
		strCuestionario[1][1]="Java Development kit/ Kit de Desarrollo de Java";
		strCuestionario[1][2]="Java developing keet / Java Desarrollo Keet";
		strCuestionario[1][3]="Java Development ket/ Ket de Desarrollo de Java";
		
		strCuestionario[2][0]="3. ¿Qué es  JRE/ Java Runtime Environment?";
		strCuestionario[2][1]="Son herramientas de desarrollo de aplicaciones Java";
		strCuestionario[2][2]="Es un entorno de ejecución de Java";
		strCuestionario[2][3]="Es para ejecutar aplicaciones de JavaScript";
		
		strCuestionario[3][0]="4. ¿Cuál es la función del JVM/ Java Virtual Machine?";
		strCuestionario[3][1]="Ejecutar aplicaiones de Java solamente para Windows";
		strCuestionario[3][2]="Interpretar aplicaciones JavaScript";
		strCuestionario[3][3]="Ejecutar el código compilado (bytecode) de Java";
		
		strCuestionario[4][0]="5. ¿Cuáles son las versiones del lenguaje de programación Java?";
		strCuestionario[4][1]="Java SE / Java EE / Java ME";
		strCuestionario[4][2]="JDK / JRE / JVM";
		strCuestionario[4][3]="Java 8 / Java 11 LTS / Java 17 LTS";
		
		int intRespuestas[]=new int[5];
		intRespuestas[0]=2;
		intRespuestas[1]=1;
		intRespuestas[2]=2;
		intRespuestas[3]=3;
		intRespuestas[4]=1;
		
		int[] intTusRespuestas=new int[5];
		
		
		lblPregunta = new JLabel("Acontinuación respondera un breve QUIZ, seleccione la respuesta respecto a su conocimineto,");
		lblPregunta.setForeground(new Color(0, 0, 205));
		lblPregunta.setBackground(new Color(255, 69, 0));
		lblPregunta.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblPregunta.setBounds(20, 45, 671, 14);
		contentPane.add(lblPregunta);
		
		JLabel lblResponde = new JLabel("cuando este listo Oprima \"Comerzar QUIZ\". ");
		lblResponde.setForeground(new Color(34, 139, 34));
		lblResponde.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblResponde.setBounds(20, 70, 667, 14);
		contentPane.add(lblResponde);
	
		JRadioButton radA = new JRadioButton("A");	
		radA.setVisible(false);
		radA.setSelected(true);
		radA.setBounds(33, 121, 459, 23);
		contentPane.add(radA);
		
		JRadioButton radB = new JRadioButton("B");
		radB.setVisible(false);
		radB.setBounds(33, 158, 459, 23);
		contentPane.add(radB);
		
		JRadioButton radC = new JRadioButton("C");
		radC.setVisible(false);
		radC.setBounds(33, 197, 459, 23);
		contentPane.add(radC);
		
		ButtonGroup radRespuestas =new ButtonGroup();
		radRespuestas.add(radA);
		radRespuestas.add(radB);
		radRespuestas.add(radC);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setVisible(false);
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				intCambio--;
				
				if(intCambio==-1)
					btnAnterior.setEnabled(false);
				
                if(intCambio>=-1) {
					btnSiguiente.setEnabled(true);}
						
						lblPregunta.setText(strCuestionario[intCambio+1][0]);
				        radA.setText(strCuestionario[intCambio+1][1]);
				        radB.setText(strCuestionario[intCambio+1][2]);
				        radC.setText(strCuestionario[intCambio+1][3]);
				        
				        if(intCambio<4)
				        	btnEvaluar.setEnabled(false);
				        
				}		        			
		});
		btnAnterior.setBounds(20, 261, 89, 23);
		contentPane.add(btnAnterior);
		
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setVisible(false);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				intCambio++;
				
				if(intCambio==0) {
					btnAnterior.setEnabled(false);
					btnEvaluar.setEnabled(false);
					}
				
				if(intCambio==4) {
					JOptionPane.showMessageDialog(contentPane,"Ha finalizado las preguntas, ya puede evaluar para obtener su resultado");
					btnSiguiente.setEnabled(false);
					btnEvaluar.setEnabled(true);
					
					if(radA.isSelected()) {if(radA.isSelected())intTusRespuestas[4]=1;}  else {intTusRespuestas[4]=0;}
					
				}else {
					
					if(intCambio>=0)
					btnAnterior.setEnabled(true);
					
					if(intCambio+1!=5)
					{
			        lblPregunta.setText(strCuestionario[intCambio+1][0]);
			        radA.setText(strCuestionario[intCambio+1][1]);
			        radB.setText(strCuestionario[intCambio+1][2]);
			        radC.setText(strCuestionario[intCambio+1][3]);
					}
					
			        switch(intCambio) {
			        case 0: if(radB.isSelected())intTusRespuestas[0]=2; else intTusRespuestas[0]=0;	        	
			        	break;
			        case 1:if(radA.isSelected())intTusRespuestas[1]=1;	else intTusRespuestas[1]=0;   
			        	break;
			        case 2: if(radB.isSelected())intTusRespuestas[2]=2;	else intTusRespuestas[2]=0;   
			        	break;
			        case 3:if(radC.isSelected())intTusRespuestas[3]=3;	else intTusRespuestas[3]=0; 
			        	break;
			        	default: JOptionPane.showMessageDialog(btnSiguiente, "No hay pregunta");
			        	break;
			        }	       
				}
				
			}
		});
		btnSiguiente.setBounds(119, 261, 89, 23);
		contentPane.add(btnSiguiente);
			
		btnEvaluar = new JButton(" Evaluar");
		btnEvaluar.setVisible(false);
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int intResultado=0;
				for(int j=0; j<5; j++) {
					if(intTusRespuestas[j]==intRespuestas[j]) {
						intResultado=intResultado+1;
					}
				}
				JOptionPane.showMessageDialog(btnEvaluar, "Tu evaluación son "+intResultado+" correcta(s)");
			}
		});
		btnEvaluar.setBounds(20, 11, 133, 23);
		contentPane.add(btnEvaluar);
	
		JButton btnComenzar = new JButton(" Comenzar QUIZ");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				radA.setVisible(true);
				radB.setVisible(true);
				radC.setVisible(true);
				btnSiguiente.setVisible(true);
				btnAnterior.setVisible(true);
				btnEvaluar.setVisible(true);
				btnComenzar.setVisible(false);
				
				lblPregunta.setText(strCuestionario[0][0]);
				lblResponde.setText("Eliga la respuesta respecto a tu criterio de conocimineto.");
		        radA.setText(strCuestionario[0][1]);
		        radB.setText(strCuestionario[0][2]);
		        radC.setText(strCuestionario[0][3]);	
		        
		        if(intCambio==-1) {
					btnAnterior.setEnabled(false);
					btnEvaluar.setEnabled(false);
					}
				
				
			}
		});
		btnComenzar.setBounds(20, 11, 133, 23);
		contentPane.add(btnComenzar);	
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(165, 11, 89, 23);
		contentPane.add(btnSalir);
	}
}
