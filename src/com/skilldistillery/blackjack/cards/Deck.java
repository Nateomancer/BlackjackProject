package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// --Field Variables---
	// List of cards
	private List<Card> cards;

	// ---Constructor---
	// Makes the deck
	public Deck() {
		cards = createDeck();
	}

	// ---Constructor---
	// Makes the deck of 52 cards
	// Deck is an array list of object type Card.
	// Card Object consists of variables Suit and Rank.
	// Has 52 indexes for each card.
	// Iterates through each suit, adding all Ranks(Card Value) to each Suit (Card
	// Type).
	// to the deck.
	public List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		// Shuffle the deck
		// I added this
		shuffleDeck(deck);
		return deck;
	}

	// Checks the current amount of cards in the deck
	public int checkDeckSize() {
		return cards.size();
	}

	// ---Shuffles the Deck---
	// Collections is a java library
	// shuffle is a method in the collections library
	// Shuffles the cards(Array List) in a random order
	public List<Card> shuffleDeck(List<Card> cards) {
		Collections.shuffle(cards);
		return cards;
	}

	// ---Deals A card---
	// remove(0)a card from the deck
	public Card dealCard() {
		return cards.remove(0);
	}

	//---toString---
	@Override
	public String toString() {
		return "Deck of cards: "+ cards;
	}
	
	

	//---Setters and Getters---
	public List<Card> getCards() {
		return cards;
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
