package Consola_Ejercicios;
import Exportar.Bota;
import java.util.Scanner;

public class Sistema_Botas {

	public static void main(String[] args) {
		Bota miBota =new Bota();
		Scanner teclado =new Scanner(System.in);
		miBota.strMarca=teclado.next();
		miBota.strTipo=teclado.next();
		miBota.dblPrecio=teclado.nextDouble();
		miBota.ImprimirDatos();
		teclado.close();
	}

}
