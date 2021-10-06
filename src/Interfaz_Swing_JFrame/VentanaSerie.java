package Interfaz_Swing_JFrame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class VentanaSerie extends JFrame {

	private JPanel contentPane;
	private JTextField inpNumero1;
	private JTextField inpNumero2;
	private JLabel lblIteraciones;
	private JTextField inpIteraciones;
	private JButton btnGenerar;
	private JTextArea txtSerie;
	private JButton btnLimpiar;

	public static void main(String[] args) {
		
					VentanaSerie frame = new VentanaSerie();
					frame.setVisible(true);
				
	}

	public VentanaSerie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(267, 177, 86, 23);
		contentPane.add(btnSalir);
		
		inpNumero1 = new JTextField();
		inpNumero1.setBounds(240, 35, 86, 20);
		contentPane.add(inpNumero1);
		inpNumero1.setColumns(10);
		
		JLabel lblNumero1 = new JLabel("Ingrese n\u00FAmero inicial 1:");
		lblNumero1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		lblNumero1.setBounds(94, 36, 136, 17);
		contentPane.add(lblNumero1);
		
		inpNumero2 = new JTextField();
		inpNumero2.setBounds(240, 66, 86, 20);
		contentPane.add(inpNumero2);
		inpNumero2.setColumns(10);
		
		JLabel lblNumero2 = new JLabel("Ingrese n\u00FAmero inicial 2:");
		lblNumero2.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		lblNumero2.setBounds(94, 68, 136, 14);
		contentPane.add(lblNumero2);
		
		lblIteraciones = new JLabel("Iteraciones:");
		lblIteraciones.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		lblIteraciones.setBounds(161, 99, 69, 14);
		contentPane.add(lblIteraciones);
		
		inpIteraciones = new JTextField();
		inpIteraciones.setColumns(10);
		inpIteraciones.setBounds(240, 97, 86, 20);
		contentPane.add(inpIteraciones);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Contador=1,Suma;
				String Cadena="";
				String Nuro1=inpNumero1.getText();
				String Nuro2=inpNumero2.getText();
				String TxtIndice=inpIteraciones.getText();
				int Indice=Integer.parseInt(TxtIndice);
				int Nro1=Integer.parseInt(Nuro1);
				int Nro2=Integer.parseInt(Nuro2);
				
				Cadena=Cadena+Nuro1+" "+Nuro2;
				while(Contador<=Indice){
			        Suma=Nro1+Nro2;
			        Cadena=Cadena+"  "+Suma;
			        Nro1=Nro2;
			        Nro2=Suma;
			        Contador++;
			    }
				txtSerie.setText(Cadena);
			}
		});
		btnGenerar.setBounds(71, 177, 94, 23);
		contentPane.add(btnGenerar);
		
		txtSerie = new JTextArea();
		txtSerie.setBounds(71, 128, 282, 22);
		contentPane.add(txtSerie);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inpNumero1.setText(null);
				inpNumero2.setText(null);
				inpIteraciones.setText(null);
				txtSerie.setText(null);
			}
		});
		btnLimpiar.setBounds(178, 177, 79, 23);
		contentPane.add(btnLimpiar);
	}
}
