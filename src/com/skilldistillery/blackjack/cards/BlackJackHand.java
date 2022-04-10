package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand {

	// Instance Variable
	// EVERY HAND HAS A LIST OF CARDS
	private List<Card> cards;

	// ---CONSTRUCTORS---

	// Default constructor
	// Primary constructor
	public BlackJackHand() {
		//super(cards);
	
		cards = createBlackJackHand();
	}

	//Create the hand of cards for blackjack
	public List<Card> createBlackJackHand(){
		List<Card> blackJackHand=new ArrayList<>();
		return blackJackHand;
	}
	
	// ---METHODS---
	// Black Jack addCard to hand
	public void addCardToHand(Card drawnCard) {
		cards.add(drawnCard);
	}

	// Clears the hand
	public void clear() {
		cards.clear();
	}

	// FIND HAND TOTAL
	public int getHandTotal(BlackJackHand handTotal) {
		// Iterate through cards in hand.
		// Adding the total amount
		// WORKS
		int totalValue = 0;
		for (Card card : handTotal.getCards()) {

			int value = card.getValue();
			totalValue += card.getValue();

		}
		return totalValue;

	}

	// FINDS IF HAND IS A BLACK JACK
	// 21 ON FIRST TURN
	public boolean isBlackjack() {
		return false;

	}

	// FINDS IF HAND IS A BUST
	// HAND TOTAL GOES OVER 21
	public boolean isBust() {
		return false;

	}

	// GETTER AND SETTERS
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "Cards in hand: " + cards;
	}

}
