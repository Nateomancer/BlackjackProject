package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

//abstract hand class
//Blackjack Hand Has a List of Cards

public abstract class Hand {

	// Instance variable
	// EVERY HAND HAS A LIST OF CARDS
	protected List<Card> cards;

	// ---CONSTRUCTORS---

	// Default constructor
	public Hand() {
		cards = createHand();
	}
	
	public List <Card> createHand(){
		List<Card> Hand=new ArrayList<>();
		return Hand;
	}

	// ---METHODS---
	public void addCardToHand(Card drawnCard) {
		cards.add(drawnCard);

	}

	// Clears the hand
	public void clear() {
		cards.clear();

	}

	// FIND HAND TOTAL
	public int getHandValue(List<Card> cardHand) {
		// Iterate through cards in hand.
		// Adding the total amount

		int totalValue = 0;
		for (Card card : cardHand) {

			int value = card.getValue();
			totalValue += card.getValue();

		}
		return totalValue;
	}
}