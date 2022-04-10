package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Player {

	// instance variables
	private BlackJackHand blackJackHand = new BlackJackHand();

	// ---Object variables---
	// Every Player Has a hand
	private List<Card> playersCards;

	// Player's Hand
	public Hand playersHand;
	// Player's Deck
	public Deck playersDeck;
	// Player's Card
	public Card playersCard;

	// ---Constructors---

	// Default Constructors
	public Player() {
		playersCards = createPlayersHand();
	}

	public List<Card> createPlayersHand() {
		List<Card> playersHand = new ArrayList<>();
		return playersHand;
	}

	// Primary Constructor
	public Player(Hand playersHand) {
		this.playersHand = playersHand;

	}

	// 2 Arg Constructor
	public Player(Hand playersHand, Deck playersDeck) {
		this.playersHand = playersHand;
		this.playersDeck = playersDeck;
	}

	// 3 Arg Constructor
	public Player(Hand playersHand, Deck playersDeck, Card playersCard) {
		this.playersHand = playersHand;
		this.playersDeck = playersDeck;
		this.playersCard = playersCard;
	}

	// ---METHODS---
	public void playerDrawCard(Card drawnCard) {
		playersCards.add(drawnCard);
	}

	// GET HAND TOTAL FOR BLACK JACK
	public int getPlayersHandTotal(BlackJackHand playersHand) {

		int handTotal = blackJackHand.getHandTotal(playersHand);

		return handTotal;

	}

	// ---Getters and Setters---
	public Hand getPlayersHand() {
		return playersHand;
	}

	public void setPlayersHand(Hand playersHand) {
		this.playersHand = playersHand;
	}

	public Deck getPlayersDeck() {
		return playersDeck;
	}

	public void setPlayersDeck(Deck playersDeck) {
		this.playersDeck = playersDeck;
	}

	public Card getCard() {
		return playersCard;
	}

	public void setCard(Card card) {
		this.playersCard = card;
	}

	// ---toString---
	@Override
	public String toString() {
		return "Player's hand: " + playersHand + " Card:" + playersCard;
	}

}