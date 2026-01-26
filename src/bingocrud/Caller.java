package bingocrud;

import java.util.Random;

public class Caller {
	
	//Variables
	private int numeroRandom;
	private int[] numerosACantar = new int[100]; 
	
	
	/**
	 * Genera un array de 100 números aleatorios entre 1 y 100 que no se repita
	 * @return array de números aleatorios
	 */
	public void cantarNumeros(){
		
		Random rand = new Random();
		
		for (int indice1 = 0; indice1 < numerosACantar.length; indice1++) {
			
			this.numeroRandom = rand.nextInt(1,100);
			
			comprobarNumero(numeroRandom);
			
			this.numerosACantar[indice1] = numeroRandom;
			
		}
	}
	
	/**
	 * Funcion para comprobar si el numero random esta ya dicho y cambiarlo
	 * @param numeroRandom
	 * @return new random number
	 */
	public void comprobarNumero(int numeroRandom) {
		
		Random rand = new Random();
		
		for (int indice2 = 0; indice2 < numerosACantar.length; indice2++) {
			
			if (this.numeroRandom == this.numerosACantar[indice2]) {
				
				this.numeroRandom = rand.nextInt(1,100);
				
				return;
			}
		}
		
		
	}
	
	//Getter and setter
		public int getNumeroRandom() {
			return numeroRandom;
		}

		public void setNumeroRandom(int numeroRandom) {
			this.numeroRandom = numeroRandom;
		}

		public int[] getNumerosACantar() {
			return numerosACantar;
		}

		public void setNumerosACantar(int[] numerosACantar) {
			this.numerosACantar = numerosACantar;
		}
	
		
}