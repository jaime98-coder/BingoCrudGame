package bingocrud;

import java.util.Random;

public class Card {
	int[][] card = new int[3][5];
	Random rd = new Random();

	private int generateNumber() {
		int cardNumber;

		cardNumber = rd.nextInt(1, 100);
		return cardNumber;
	}

	public void fillCard() {
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card[i].length; j++) {

			}
		}
	}

	public void showCard() {
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < card[i].length; j++) {

			}
		}
	}
}
