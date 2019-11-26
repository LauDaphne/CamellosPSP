package es.studium.Camellos;

public class Camello {
	
	int nombre, posicionActual;
	
	public Camello(int nombre, int posicionActual) {
		super();
		this.nombre = nombre;
		this.posicionActual = posicionActual;
	}
	
	Camello(int n){
		nombre=n;
		posicionActual=0;
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
	

	int avanzarCamello (int a) {
		posicionActual += a;
		return posicionActual;
	}
	
}
