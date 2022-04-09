package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

//Blackjack Hand Has a List of Cards

public class BlackJackHand extends Hand {

	// field variables
	List<Card> cards = new ArrayList<>();

	// ---CONSTRUCTORS---

	// Default constructor
	public BlackJackHand() {
		// TODO Auto-generated constructor stub
	}

	// Primary constructor
	// inherited from parent class, hand
	public BlackJackHand(List<Card> cards) {
		super(cards);
		this.cards = cards;
	}

	// ---METHODS---

	// Inherited method from parent, Hand
	@Override
	public int getHandValue() {
		// Iterate through cards in hand.
		// Adding the total amount

		return 0;
	}

	// 21
	public boolean isBlackjack() {
		return false;

	}

	// over 21
	public boolean isBust() {
		return false;

	}

}
