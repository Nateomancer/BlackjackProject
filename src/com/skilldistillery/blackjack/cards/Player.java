package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

// --DEALER ATTRIBUTES---
//player has a hand
//player has a card

// ----DEALER ACTIONS----
//Player can hit
//player can stay
//player can getValue of cards

//---Field variables---

// -----INSTANCES------
// instance of Black Jack Hand
//for player
public class Player {


	private List<Card> playersCards;

	// instance of players Hand
	public Hand playersHand;
	// instance of player card
	public Card playersGameCard;

	// ---Constructors---
	// default constructor
	public Player() {

	}

//Primary Constructor
	public Player(Hand playersHand) {
		this.playersHand = playersHand;

	}

	// ---Getters and Setters---
	public Hand getPlayersHand() {
		return playersHand;
	}

	public void setPlayersHand(Hand playersHand) {
		this.playersHand = playersHand;
	}

	public Card getCard() {
		return playersGameCard;
	}

	public void setCard(Card card) {
		this.playersGameCard = card;
	}

	// ---toString---
	@Override
	public String toString() {
		return "Player's hand: " + playersHand + " Card:" + playersGameCard;
	}

	// ---Methods---
}