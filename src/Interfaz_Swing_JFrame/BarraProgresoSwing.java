package Interfaz_Swing_JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BarraProgresoSwing extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		
					BarraProgresoSwing frame = new BarraProgresoSwing();
					frame.setVisible(true);
			
	}

	
	public BarraProgresoSwing() {
		setTitle("Barra de Progreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JProgressBar barProgreso = new JProgressBar();
		barProgreso.setBounds(10, 124, 501, 62);
		contentPane.add(barProgreso);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Hilo objHilo=new Hilo("miHilo");
				Thread varHilo= new Thread(objHilo);
				
				ProgresoHilo objHilo2= new ProgresoHilo(barProgreso);
				Thread varHilo2 = new Thread(objHilo2);
				varHilo.start();
				varHilo2.start();
				
			}
		});
		btnIniciar.setBounds(153, 55, 89, 23);
		contentPane.add(btnIniciar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnSalir.setBounds(282, 55, 89, 23);
		contentPane.add(btnSalir);
	}
}
