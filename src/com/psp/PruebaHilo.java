package com.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaHilo {

	public static void main(String[] args) {
		HiloInterrupt hilito = new HiloInterrupt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tecla;
		
		while (hilito.vive()) {
			System.out.println("Hilo vivo, [i] interrumpir, [k] matar");
			try {
				tecla = br.readLine();
				if (tecla.equals("i"))
					hilito.interrumpir();
				if (tecla.equals("k"))
					hilito.detener();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hilito.esperar();
		System.out.println("Hilo principal finalizado");
	}

}
