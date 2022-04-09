package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

//abstract hand class
//Blackjack Hand Has a List of Cards

public abstract class Hand {

	// instance variable
	protected List<Card> cards;

	// ---CONSTRUCTORS---
	// Default constructor
	public Hand() {

	}

	// Primary Constructor
	public Hand(List<Card> cards) {
		super();
		this.cards = cards;
	}

	// ---METHODS---
	public void addCard(Card drawnCard) {
		cards.add(drawnCard);

	}

	// Clears the hand
	public void clear() {
		cards.clear();

	}

	// Abstract method
	// no method body
	// public abstract int getHandValue();

	public int getHandValue(List<Card> cardHand) {
		// Iterate through cards in hand.
		// Adding the total amount

		int totalValue = 0;
		for (Card card : cardHand) {
			
			int value = card.getValue();
			totalValue += card.getValue();
			
			System.out.println("IN METHOD");
			System.out.println("Card Value: "+value);
			System.out.println("Cards Value: "+totalValue);

		}
		return totalValue;
	}
}