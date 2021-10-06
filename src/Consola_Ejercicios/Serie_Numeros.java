package Consola_Ejercicios;

import java.util.Scanner;


public class Serie_Numeros {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		int Nro1;
		int Nro2;
		int Indice=10;
		int Suma;
		int Contador=0;
		
		System.out.println("Teclee el primer número: ");
		Nro1=teclado.nextInt();
		
		System.out.println("Teclee el segundo número: ");
		Nro2=teclado.nextInt();
		
		    while(Contador<=Indice){
		        Suma=Nro1+Nro2;
		        System.out.println("Resultado: "+Suma);
		        Nro1=Nro2;
		        Nro2=Suma;
		        Contador++;
		    }
		    teclado.close();
	}
	}

