package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	// --DEALER ATTRIBUTES---
	// dealers has a deck
	// dealer has a hand
	// dealer has cards

	// ---Field variables---
	private List<Card> cards;

	// -----INSTANCES------
	// instance of BlackJack Hand
	// should it be hand??
	private Hand dealersHand;

	// Dealer Deck for game
	private Deck dealersDeck;

	// cards for game
	private Card gameCard;

	// ---Constructors---
	// Default constructor
	public Dealer() {

	}

	// Primary Constructor
	public Dealer(Hand dealersHand, Deck dealersDeck) {

		this.dealersHand = dealersHand;
		this.dealersDeck = dealersDeck;
		// this.gameCard = gameCard;
	}

	// ---Methods--

	// Make the card deck
	public Deck makeDeck(Deck dealersDeck) {

		dealersDeck.createDeck();
		return dealersDeck;

	}

	// draw cards
	public Card dealCard() {
		// List<Card> draw = new ArrayList<>();
		// Card drawnCard=new Card();
		// int totalValue=0;
		// for (int i = 0; i < 2; i++) {
		Card c = dealersDeck.dealCard();
		return c;
	}

	// ---DEALER LOGIC---
	public void dealersTurn() {
		// Needs BlackJack Hand
		// needs Card in hand
		// Needs hand value
		// If hand value is more than 17, pass
		// If hand value is less that 17, hit

	}

	// ---Getters and Setters---
	public Hand getDealersHand() {
		return dealersHand;
	}

	public void setDealersHand(Hand dealersHand) {
		this.dealersHand = dealersHand;
	}

	public Deck getDealersDeck() {
		return dealersDeck;
	}

	public void setDealersDeck(Deck dealersDeck) {
		this.dealersDeck = dealersDeck;
	}

	public Card getGameCard() {
		return gameCard;
	}

	public void setGameCard(Card gameCard) {
		this.gameCard = gameCard;
	}

	@Override
	public String toString() {
		return "Dealer's hand: " + dealersHand + ", DealersDeck: " + dealersDeck + ", Game card" + gameCard;
	}

//	public void getHandValue() {
//		
//		dealersHand.getHandValue(List <Card> cards);
//	}

//	old method from abstract hand class
// ???????????????????	
//	// get the hand value of the dealer
//	public Hand HandValue() {
//
//		System.out.println(dealersHand.getHandValue());
//		return dealersHand;
//	}
}
