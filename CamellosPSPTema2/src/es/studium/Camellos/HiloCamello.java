package es.studium.Camellos;

import java.util.Arrays;

public class HiloCamello implements Runnable {
	
	static boolean fin = false;
	static int camelloPrimero = 0;
	static boolean primero = false;
	Camello cmll;
	
	HiloCamello (int n){
		cmll=new Camello(n,0);
	}
	
	@Override
	public void run() {
		while(!fin) {
			int avance = tirada();
			cmll.avanzarCamello(avance);
			comprobarPosicion(avance, cmll);

			try {
				Thread.sleep((int)(Math.random()*50)+20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int tirada() {
		int tirada =  (int)(Math.random()*100);
		int puntos=0;
		if(tirada<10) {
			puntos=3;
		}else if(tirada<30) {
			puntos=2;
		}else if(tirada<70) {
			puntos=1;
		}
		return puntos;
	}
	
	public static synchronized void comprobarPosicion(int avance, Camello camelloHilo) {
		if (camelloPrimero <= camelloHilo.getPosicionActual()) {
			camelloPrimero = camelloHilo.getPosicionActual();
			primero = true;
		}else {
			primero=false;
		}
		if (Carrera.metros <= camelloHilo.getPosicionActual()) {
			HiloCamello.fin = true;
			System.out.println("El camello " + camelloHilo.getNombre() + " ha ganado la carrera.\n");
			Arrays.sort(Carrera.camellos);
			System.out.println("El ranking ha quedado del siguiente modo: \n1º Camello " + camelloHilo.getNombre());
			for (int i = 0; i < Carrera.camellos.length; i++) {
				if (Carrera.camellos[i].getNombre() != camelloHilo.getNombre()) {
					System.out.println((i + 1) + "º Camello " + Carrera.camellos[i].getNombre() + " a "+ (Carrera.metros - Carrera.camellos[i].getPosicionActual()) + " posiciones.");
				}
			}
		} else if (!HiloCamello.fin) {
			if (primero) {
				System.out
						.println("Camello " + camelloHilo.getNombre() + " avanza " + avance + " posiciones y lleva "+camelloHilo.getPosicionActual()+" posiciones, y va en primera posición.");
			} else {
				System.out.println("Camello " + camelloHilo.getNombre() + " avanza " + avance + " posiciones y lleva "+camelloHilo.getPosicionActual()+" posiciones, a "
						+ (camelloPrimero - camelloHilo.getPosicionActual()) + " del líder.");
			}
		}
		
	}

}
