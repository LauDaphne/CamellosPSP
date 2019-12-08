package es.studium.Camellos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Carrera {
	
	static int numCamellos, metros;
	static Camello [] camellos;
	
	public static void DatosCarrera() {
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Escribe el número de camellos que hay en la carrera (2-10): ");
			numCamellos=Integer.parseInt(lectura.readLine());
			System.out.println("Escribe la distancia en metros de la carrera(10-50): ");
			metros=Integer.parseInt(lectura.readLine());
			if(numCamellos>1 && numCamellos<11 && metros>9 &&metros<51 ) {
				System.out.println("¡Datos introducidos correctamente!");
				camellos = new Camello[numCamellos];
				System.out.println("Pulsa la tecla Enter para que comience la carrera...");
				lectura.read();
			}else {
				System.out.println("Datos introducidos erroneos. Vuelva a intentarlo \n\n");
				DatosCarrera();
				
			}
			
		} catch (Exception e) {
			System.out.println("Datos introducidos erroneos. Vuelva a intentarlo \n\n");
			DatosCarrera();
		}
	}
	
	public static void CrearCamellos() {
		for(int i=0; i<numCamellos; i++) {
			HiloCamello hiloCmll = new HiloCamello(i+1);
			camellos[i]=hiloCmll.cmll;
			new Thread(hiloCmll).start();
			 
		}
	}
		
	
	public static void main(String[] args) {
		DatosCarrera();
		CrearCamellos();
		
	}
}
