package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

//Blackjack Hand Has a List of Cards

public class BlackJackHand extends Hand {

	// field variables
	// list of cards
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
	// Black Jack addCard to hand
	public void addCard(Card drawnCard) {
		cards.add(drawnCard);
	}

	// Get total value of hand
	public int getHandValue(BlackJackHand handValue) {
		// Iterate through cards in hand.
		// Adding the total amount
		// WORKS
		int totalValue = 0;
		for (Card card : handValue.getCards()) {

			int value = card.getValue();
			totalValue += card.getValue();

		}
		return totalValue;

	}

	// new method IGNORE FOR NOW
//	public void getHandInfo(BlackJackHand handValue) {
//		int totalValue = 0;
//		for (Card card : handValue.getCards()) {
//
//			int value = card.getValue();
//			String name = card.getName();
//			System.out.println("---------------------------------");
//			System.out.println("Card Name: " + name + " Card Value: " + value);
//			totalValue += card.getValue();
//		}
//
//		System.out.println("Hand Total: " + totalValue);
//		System.out.println("---------------------------------");
//
//	}

	// 21
	public boolean isBlackjack() {
		return false;

	}

	// over 21
	public boolean isBust() {
		return false;

	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Cards in hand: " + cards;
	}
//Old inherited method from abstract parent class hand
//abstract method get HandValue
//??????????????
//	@Override
//	public int getHandValue() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
