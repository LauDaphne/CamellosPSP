package es.studium.Camellos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PanelCarrera {
	
	static int numCamellos, metros;
	static ArrayList <Camello> camellos = new ArrayList <Camello> ();
	
	public static void DatosCarrera() {
		BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Escribe el número de camellos que hay en la carrera (2-10): ");
			numCamellos=Integer.parseInt(lectura.readLine());
			System.out.println("Escribe la distancia en metros de la carrera(10-50): ");
			metros=Integer.parseInt(lectura.readLine());
			if(numCamellos>1 && numCamellos<11 && metros>9 &&metros<51 ) {
				System.out.println("¡Datos introducidos correctamente!");
				System.out.println("Pulsa la tecla Enter para que comience la carrera...");
				lectura.read();
			}else {
				System.out.println("Datos introducidos erroneos. Vuelva a intentarlo");
				DatosCarrera();
			}
			
		} catch (Exception e) {
			System.out.println("Datos introducidos erroneos. Vuelva a intentarlo");
			DatosCarrera();
		}
	}
	
	public static void CrearCamellos() {
		for(int i=0; i<numCamellos; i++) {
			new Thread(new HiloCamello(i+1)).start();
		}
	}
}
