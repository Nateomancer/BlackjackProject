package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	// instance variables
	private BlackJackHand blackJackHand = new BlackJackHand();

	// ---Object variables---
	// Every Dealer has a Hand
	private List<Card> dealersCards;

	// Dealer's Default Hand
	private Hand dealersHand;

	// Dealer's Deck
	private Deck dealersDeck;

	// Dealer's Card
	private Card gameCard;

	// ---Constructors---
	// Default constructor

	public Dealer() {
		dealersCards = createDealersHand();
	}

	public List<Card> createDealersHand() {
		List<Card> dealersHand = new ArrayList<>();
		return dealersHand;
	}

	// Primary Constructor
	public Dealer(Hand dealersHand, Deck dealersDeck) {

		this.dealersHand = dealersHand;
		this.dealersDeck = dealersDeck;
	}

	public Dealer(Hand dealersHand, Deck dealersDeck, Card gameCard) {

		this.dealersHand = dealersHand;
		this.dealersDeck = dealersDeck;
		this.gameCard = gameCard;
	}

	// ---Methods--

	// DEALERS CAN MAKE THEIR OWN DECK IF NEEDED
	public Deck makeDeck(Deck dealersDeck) {

		dealersDeck.createDeck();
		return dealersDeck;

	}

	// DEAL CARD
	public Card dealCard() {
		Card dealCard = dealersDeck.dealCard();
		return dealCard;
	}

	// GET HAND TOTAL FOR BLACK JACK
	public int getDealersHandTotal(BlackJackHand dealersHand) {

		int handTotal = blackJackHand.getHandTotal(dealersHand);

		return handTotal;

	}

	// ---DEALER LOGIC---
	// FOR BLACK JACK
	public boolean dealersTurn(int dealersHandTotal) {

		boolean dealersTurn = true;

		// Dealer Logic
		// Dealer will hit if handTotal is under 17
		// Dealer will pass if handTotal is over 17
		if (dealersHandTotal < 17) {
			System.out.println("Dealer Hits");
			gameCard = dealCard();
			dealersHand.addCardToHand(gameCard);
			System.out.println("New Card: " + gameCard);
			dealersTurn = true;
			return dealersTurn;

		} else if (dealersHandTotal >= 17) {
			System.out.println("Dealer choses to pass");
			System.out.println("");
			dealersTurn = false;
			return dealersTurn;
		}
		return dealersTurn;
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
