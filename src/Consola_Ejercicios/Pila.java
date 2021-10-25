package Consola_Ejercicios;

import java.util.Stack;

public class Pila {

	public static void main(String[] args) {
		
		Stack<String> varPila=new Stack<String>();
		
        String strExpresion="(4+3)*(10/5)";
        char chrCaracter=' ';
        
        for(int x=0; x<strExpresion.length(); x++) {
        	chrCaracter=strExpresion.charAt(x);
        	System.out.println(chrCaracter);
        	if (chrCaracter=='('){
        		varPila.push("Push "+chrCaracter);
        	}
        	if (chrCaracter==')'){
        		varPila.pop();
        	}
        }
        if(varPila.isEmpty()) {
        	System.out.println("Exprsión Correcta");
        }else {
        	System.out.println("Exprsión Incorrecta");
        }       
	}

}
