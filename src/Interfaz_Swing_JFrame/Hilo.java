package Interfaz_Swing_JFrame;

public class Hilo implements Runnable {
	public static boolean blnTerminado=false;
	public static int intProgreso=0;
    public String strNombreHilo;
    
    public Hilo(String strNombre) {
    	this.strNombreHilo=strNombre;
    }
    
    public void run() {
    	blnTerminado=false;
    	for(int x=1; x<100; x++) {
    		intProgreso=x;
    		
    		try {
    			Thread.sleep(80);
    		}catch(InterruptedException e) {
    			System.out.println("Hilo interrumpido");
    		}	
    	}
    	blnTerminado=true;
    }
}
