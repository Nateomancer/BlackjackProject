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
	
	//list of cards???
	private List<Card> cards;

	// instance of players Hand
	public Hand playersHand;
	// instance of player card
	public Card card;


	// ---Constructors---
	// default constructor
	public Player() {

	}

//Primary Constructor
	public Player(Hand playersHand) {
		super();
		this.playersHand = playersHand;
		
	}
	//---Getters and Setters---
	public Hand getPlayersHand() {
		return playersHand;
	}
	
	public void setPlayersHand(Hand playersHand) {
		this.playersHand = playersHand;
	}
	//---toString---
	@Override
	public String toString() {
		return "Player's hand " + playersHand + ", Card:" + card;
	}

	public Card getCard() {
		return card;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	
	//---Methods---
}