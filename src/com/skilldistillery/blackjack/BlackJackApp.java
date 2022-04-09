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


//TODO CLEAN UP COMMENTS CODE
//TODO AN OPTION TO PLAY AGAIN
//TODO BETTER WAY TO CHECK HAND
//TODO BETTER WAY TP CREATE A BLACK JACK HAND
//TODO SHOW CARD NAME AND VALUE WHEN DRAWING A CARD
//TODO SHOW PLAYERS ENTIRE HAND, WITH EACH CARD WITH NAME AND VALUE, AND HAND TOTAL
//TODO BLACK JACK CONDITION=21 first turn
//TODO TURN AMOUNT/ AMOUNT


public class BlackJackApp {

	// --INSTANCE VARIABLES---
	private Card gameCard;

	// Create Deck
	private Deck deck = new Deck();

	// create hands
	// dealers hand and players hand
	private BlackJackHand dealersHand = new BlackJackHand();
	private BlackJackHand playersHand = new BlackJackHand();

	// Create Dealer and Player
	private Dealer blackJackDealer = new Dealer(dealersHand, deck);
	private Player blackJackPlayer = new Player(playersHand);

	// handCheck
	char handCheck;
	
	//boolean game win/lose condition
	boolean gameover = false;

	// Create scanner
	private Scanner input = new Scanner(System.in);

	// ----------------MAIN METHOD-----------------
	public static void main(String[] args) {

		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	public void run() {

		// create data structures

		// create instances
		// create deck
		// Deck deck = new Deck();

		// create hands
		// dealers hand
		// BlackJackHand dealersHand = new BlackJackHand();
		// player hand
		// BlackJackHand playersHand = new BlackJackHand();

		// create the dealer
		// Dealer blackJackDealer = new Dealer(dealersHand, deck);
		// create the player
		// Player blackJackPlayer = new Player(playersHand);

		// create scanner
		// Scanner sc = new Scanner(System.in);
		// ----------------------------------------------------------------------

//		// Draw two cards
//		// dealer draws the cards
//		// adds card to players hand
//		gameCard = blackJackDealer.dealCard();
//		playersHand.addCard(gameCard);
//
//		System.out.println("Dealers: " + gameCard);
//		// dealer draws again
//		// adds card to dealers hand
//		gameCard = blackJackDealer.dealCard();
//		dealersHand.addCard(gameCard);
//		System.out.println("Players: " + gameCard);

		// System.out.println("----After adding to hand---");

		// print hand with cards and values
		// WORKS

		// Draw Again
		// Switch to control menu input
		// WORKS
		// TODO MAKE NICER

		System.out.println("Want to play a game.... ");
		System.out.println("");
		firstTurn();
		
		do {
			playersTurn();
			dealersTurn();
			gameConditions();
		
		}while (gameover != true);
		}
	

	// GAME SET UP
	public void firstTurn() {
		// Draw two cards
		// Dealer Draws the for both player and dealer
		// Gives first card to player
		// Second card for dealer
		gameCard = blackJackDealer.dealCard();
		playersHand.addCard(gameCard);

		// dealer draws again
		// adds card to dealers hand
		gameCard = blackJackDealer.dealCard();
		dealersHand.addCard(gameCard);

		// Checks values
		// TODO PRINT CARDS IN HAND
		System.out.println("         ---ROUND 1---");
		System.out.println("     ---Player's total---");
		// System.out.println(playersHand.getHandValue(playersHand));
		getHandValue(handCheck = 'P');

		
		System.out.println("      ---Dealer's total---");
		// System.out.println(dealersHand.getHandValue(dealersHand));
		getHandValue(handCheck = 'D');
		System.out.println("");
	}

	// PLAYERS TURN
	public void playersTurn() {
		// PRINT CARDS IN HAND

		// Menu for players turn
		// Player can hit, stay, check hand, or quit
		char hitOrStay;
		System.out.println("---PLAYER'S TURN---");
		System.out.println("Please enter A to Hit");
		System.out.println("Please enter B to Stay");
		System.out.println("Please enter C to See your " + "\ncurrent hand (Value)");
		System.out.println("Please enter Q to Quit");
		hitOrStay = input.next().toUpperCase().charAt(0);

		switch (hitOrStay) {

		case 'A':
			gameCard = blackJackDealer.dealCard();
			playersHand.addCard(gameCard);
			System.out.println("");
			System.out.println("---PLAYER'S TOTAL---");
			System.out.println("Player Hits");
			System.out.println("New Card: " + gameCard);
			System.out.println("Player's new total: ");
			//System.out.println(playersHand.getHandValue(playersHand));
			getHandValue(handCheck = 'P');
			System.out.println("");
			break;
		case 'B':
			System.out.println("Player Has Chosen to Stay");
			System.out.println("Chicken");
			System.out.println("");
			break;
		case 'C':
			// TODO Print Cards?
			System.out.println("Players Current Total");
			//System.out.println(playersHand.getHandValue(playersHand));
			getHandValue(handCheck = 'P');
			playersTurn();
			System.out.println("");
			break;
		case 'Q':
			System.out.println("Goodbye");
			gameover=true;
			input.close();
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Option");

		}

	}

	// DEALERS TURN
	public void dealersTurn() {

		// TODO PRINT CARDS IN HAND

		// get dealers current value
		int dealersHandValue = dealersHand.getHandValue(dealersHand);
		System.out.println("---DEALERS TURN---");
		// Dealer Logic
		// Dealer will hit if value is under 17
		// Dealer will pass if over 17
		if (dealersHandValue < 17) {
			System.out.println("Dealer Hits");
			gameCard = blackJackDealer.dealCard();
			dealersHand.addCard(gameCard);
			System.out.println("New Card: " + gameCard);
			System.out.println("Dealers new total: ");
			//System.out.println(dealersHand.getHandValue(dealersHand) + "\n");
			getHandValue(handCheck = 'D');
			System.out.println("");

		} else if (dealersHandValue > 17) {
			System.out.println("Dealer choses to pass");
			System.out.println("");
			// dealersHand.getHandValue(dealersHand);
		} else
			System.out.println("Something is wrong....DEALER LOGIC");
			gameover = true;
			System.out.println("");
	}

	// Method to check hand values for both player and dealer
	public void getHandValue(char handCheck) {

		if (handCheck == 'P') {
			System.out.println(playersHand.getHandValue(playersHand));

		} else if (handCheck == 'D') {
			System.out.println(dealersHand.getHandValue(dealersHand));
		} else {
			System.out.println("Something happened....GET HAND TOTAL");
			gameover = true;
		}
	}

	// Check win conditions after every round
	public boolean gameConditions() {

		
		int dealersTotal = dealersHand.getHandValue(dealersHand);
		int playersTotal = playersHand.getHandValue(playersHand);
		
		//GAME CONTINUES
		//BOTH DEALER AND PLAYER ARE UNDER 21
		if ((dealersTotal < 21) && (playersTotal < 21)) {
			gameover = false;
			return gameover;
				
		//DEALER IS OVER 21
		//GAME ENDS DEALER LOSES
		} else if (dealersTotal > 21) {
			System.out.println("GAME OVER");
			System.out.println("Dealer has lost...");
			System.out.println("\nDealers total: ");
			//System.out.println(dealersHand.getHandValue(dealersHand));
			getHandValue(handCheck = 'D');
			System.out.println("\nPlayer's total: ");
			getHandValue(handCheck = 'P');
			gameover = true;
			return gameover;
			//PLAYER IS OVER 21
			//GAME ENDS PLAYER LOSES
		} else if (playersTotal > 21) {
			System.out.println("GAME OVER");
			System.out.println("Player has lost...");
			System.out.println("\nPlayer's total: ");
			//System.out.println(playersHand.getHandValue(playersHand));
			getHandValue(handCheck = 'P');
			System.out.println("\nDealers total: ");
			getHandValue(handCheck = 'D');
			System.out.println("You are banished to the shadow realm...");
			gameover = true;
			return gameover;
		} else {
			System.out.println("Something happened... GAME CONDITIONS");
			gameover = true;
			return gameover;
		}

	}

}
