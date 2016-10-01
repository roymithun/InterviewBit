package com.interviewbit.maths;

import java.util.Arrays;
import java.util.Random;

public class ShuffleCards {
	public static void main(String[] args) {
		Card[] cards = new Card[52];
		int x = 0;
		char c = 'A';

		for (int i = 0; i < 52; i++) {
			if (x++ == 13 ) {
				x = 0;
				c++;
			}

			cards[i] = new Card(c, i);
		}
//		System.out.println(Arrays.toString(cards));
		shuffle(cards);
	}
	
	static public void shuffle(Card[] cards) {
		int n = cards.length;
	    int newI;
	    Card temp;
	    Random randIndex = new Random();

	    for (int i = 0; i < n; i++) {

	        // pick a random index between 0 and cardsInDeck - 1
	        newI = randIndex.nextInt(n);

	        // swap cards[i] and cards[newI]
	        temp = cards[i];
	        cards[i] = cards[newI];
	        cards[newI] = temp;
	    }
	    System.out.println("cards \n"+Arrays.toString(cards));
	}
}

class Card {
	char type;
	int faceValue;

	public Card(char type, int faceValue) {
		super();
		this.type = type;
		this.faceValue = faceValue;
	}

	@Override
	public String toString() {
		return "" + type + "|" + faceValue;
	}
}
