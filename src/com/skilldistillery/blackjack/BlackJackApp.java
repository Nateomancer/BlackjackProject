package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.blackjack.cards.Hand;
import com.skilldistillery.blackjack.cards.BlackJackHand;
import com.skilldistillery.blackjack.cards.Dealer;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Player;
import java.util.ArrayList;
import java.util.List;

public class BlackJackApp {

	public static void main(String[] args) {

		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	public void run() {

		// create data structures

		// create instances
		// create deck
		Deck deck = new Deck();

		// create hands
		// dealers hand
		BlackJackHand dealersHand = new BlackJackHand();
		// player hand
		BlackJackHand playersHand = new BlackJackHand();

		// create the dealer
		Dealer blackJackDealer = new Dealer(dealersHand, deck);
		// create the player
		Player blackJackPlayer = new Player(playersHand);
	
		//create scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("Want to play a game.... ");

		// Draw two cards
		// dealer draws the cards
		// adds card to players hand
		Card gameCard = blackJackDealer.dealCard();
		//playersHand.addCard(gameCard);
	
		System.out.println("Dealers: "+gameCard);
		// dealer draws again
		// adds card to dealers hand
		gameCard=blackJackDealer.dealCard();
		//dealersHand.addCard(gameCard);
		System.out.println("Players: "+gameCard);
		

	}

}
