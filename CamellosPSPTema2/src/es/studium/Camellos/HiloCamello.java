package es.studium.Camellos;

public class HiloCamello implements Runnable {
	
	boolean fin = false;
	
	HiloCamello (int n){
		new Camello(n,0);
	}
	
	@Override
	public void run() {
		while(!fin) {
			
			//Sacar el avance (Puede ser 0)
			//Avanzar el camello (Actualizar posicion)
			//Mostrar como va ESTE camello la carrera, incluyendo si fin
			
			fin=true;
		}
		
	}

}
