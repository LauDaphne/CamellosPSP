package es.studium.Camellos;

public class Camello implements Comparable<Camello> {

	private int nombre, posicionActual;


	public Camello(int nombre, int posicionActual) {
		this.nombre = nombre;
		this.posicionActual = posicionActual;
	}

	Camello(int n) {
		nombre = n;
		posicionActual = 0;
	}

	@Override
	public int compareTo(Camello comprCamello) {
		if (posicionActual < comprCamello.posicionActual) {
			return 1;
		}
		if (posicionActual > comprCamello.posicionActual) {
			return -1;
		}
		return 0;
	}

	public int getNombre() {
		return nombre;
	}

	public int getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(int posicionActual) {
		this.posicionActual = posicionActual;
	}

	public int avanzarCamello(int a) {
		posicionActual += a;
		if(posicionActual>Carrera.metros) {
			posicionActual=Carrera.metros;
		}
		return posicionActual;
	}

	

}
