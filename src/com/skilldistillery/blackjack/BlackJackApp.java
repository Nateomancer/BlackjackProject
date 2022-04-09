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
		boolean gameover = false;
		while (gameover != true) {
			playersTurn();
			dealersTurn();
			gameConditions();
		}
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
		System.out.println("   ---ROUND 1---");
		System.out.println("---Player's total---");
		System.out.println(playersHand.getHandValue(playersHand));

		System.out.println("*    *    *   *    *");
		System.out.println("---Dealer's total---");
		System.out.println(dealersHand.getHandValue(dealersHand));
		System.out.println("");
	}

	// PLAYERS TURN
	public void playersTurn() {

		// Menu for players turn
		// Player can hit, stay, check hand, or quit
		char hitOrStay;
		System.out.println("***PLAYERS TURN***");
		System.out.println("Please enter A to Hit");
		System.out.println("Please enter B to Stay");
		System.out.println("Please enter C to See your " + "\ncurrent hand (Value)");
		System.out.println("Please enter Q to Quit");
		hitOrStay = input.next().toUpperCase().charAt(0);

		switch (hitOrStay) {

		case 'A':
			gameCard = blackJackDealer.dealCard();
			playersHand.addCard(gameCard);
			System.out.println("New Card: " + gameCard);
			System.out.println("---Player's total---");
			System.out.println(playersHand.getHandValue(playersHand)+"\n");
			break;
		case 'B':
			System.out.println("Player Has Chosen to Stay");
			System.out.println("Chicken");
			break;
		case 'C':
			// TODO Print Cards?
			System.out.println("Players Current Total");
			System.out.println(playersHand.getHandValue(playersHand)+"\n");
			break;
		case 'Q':
			System.out.println("Goodbye");
			input.close();
			break;
		default:
			System.out.println("Invalid Option");

		}

	}

	// DEALERS TURN
	public void dealersTurn() {

		// get dealers current value
		int dealersHandValue = dealersHand.getHandValue(dealersHand);
		System.out.println("---DEALERS TURB---");
		// Dealer Logic
		// Dealer will hit if value is under 17
		// Dealer will pass if over 17
		if (dealersHandValue < 17) {
			System.out.println("Dealer Hits");
			gameCard = blackJackDealer.dealCard();
			dealersHand.addCard(gameCard);
			System.out.println("Dealers new total: ");
			System.out.println(dealersHand.getHandValue(dealersHand)+"\n");

		} else if (dealersHandValue > 17) {
			System.out.println("Dealer choses to pass");
			//dealersHand.getHandValue(dealersHand);
		} else
			System.out.println("Something is wrong....DEALER LOGIC");
	}

	// Method to check hand values for both player and dealer
	public void getHandValue() {
		dealersHand.getHandValue(dealersHand);
		playersHand.getHandValue(playersHand);
	}

	// Check win conditions after every round
	public boolean gameConditions() {

		boolean gameover = true;

		int dealersTotal = dealersHand.getHandValue(dealersHand);
		int playersTotal = playersHand.getHandValue(playersHand);

		if ((dealersTotal < 21)&&(playersTotal<21)) {
			gameover = false;
			return gameover;

		} else if (dealersTotal > 21) {
			System.out.println("GAME OVER");
			System.out.println("Dealer has lost...");
			System.out.println("Dealers total: ");
			System.out.println(dealersHand.getHandValue(dealersHand));
			return gameover;
		}
			else if(playersTotal>21) {
				System.out.println("GAME OVER");
				System.out.println("Player has lost...");
				System.out.println("Player's total: ");
				System.out.println(dealersHand.getHandValue(dealersHand));
				System.out.println("You are banished to the shadow realm...");
				return gameover;
			}
		 else {
			System.out.println("Something happened... GAME CONDITIONS");
			return gameover;
		}
		
	}

}
