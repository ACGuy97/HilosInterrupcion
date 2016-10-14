package com.psp;

public class HiloInterrupt implements Runnable {
	private Thread miHilo;
	private volatile boolean vivo; //Garantiza la lectura limpia, sin leer el valor cacheado
	
	public HiloInterrupt() {
		miHilo = new Thread(this, "hilo hijo");
		this.vivo = true;
		miHilo.start();
	}
	
	public void detener() {
		this.vivo = false;
		// NO PONER this.miHilo.stop(); //MUY desaconsejado
	}
	
	public void	interrumpir() {
		if (this.miHilo != null)
			this.miHilo.interrupt();
	}
	
	public boolean vive() {
		return this.vivo;
		//return this.miHilo.isAlive();		No es tan fiable como nuestra guarda volatil
	}
	
	public void esperar() {
		try {
			this.miHilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("Corriendo el hilo ahora...");
		while (this.vivo) {
			System.out.println("El hilo va a dormir un rato...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("El hilo hijo ha sido interrumpido...");
			}
		}
		System.out.println("Hilo finalizado y saliendo de forma ordenada...");
	}

}
