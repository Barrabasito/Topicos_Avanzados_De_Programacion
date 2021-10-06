package Interfaz_Swing_JFrame;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Sexo extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sexo frame = new Sexo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Sexo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(228, 183, 89, 23);
		contentPane.add(btnSalir);
		
		JRadioButton radMasculino = new JRadioButton("Masculino");
		radMasculino.setSelected(true);
		radMasculino.setBounds(182, 85, 109, 23);
		contentPane.add(radMasculino);
		
		JRadioButton radFemenino = new JRadioButton("Femenino");
		radFemenino.setBounds(182, 111, 109, 23);
		contentPane.add(radFemenino);
		
		ButtonGroup radSexo=new ButtonGroup();
		radSexo.add(radMasculino);
		radSexo.add(radFemenino);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(127, 89, 46, 14);
		contentPane.add(lblSexo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radMasculino.isSelected()) {
					System.out.println("Selecciono Masculino");
					JOptionPane.showMessageDialog(contentPane, radMasculino.getText());
					JOptionPane.showMessageDialog(contentPane, "Selecciono Masculino");
				}else {
					JOptionPane.showMessageDialog(contentPane, radFemenino.getText());
					System.out.println("Selecciono Femenino");
					JOptionPane.showMessageDialog(contentPane, "Selecciono Femenino");
				}
				
			}
		});
		btnAceptar.setBounds(127, 183, 89, 23);
		contentPane.add(btnAceptar);
	}

}
