package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.blackjack.cards.Hand;
import com.skilldistillery.blackjack.cards.Items;
import com.skilldistillery.blackjack.cards.BlackJackHand;
import com.skilldistillery.blackjack.cards.Dealer;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Player;
import java.util.ArrayList;
import java.util.List;

//---CORE PROGRAM FOR ASSIGNMENT---
//TODO BUILD DECK
//WHAT DECK IS BEING USED, DEALERS DECK OR DECKS DECK?
//AFTER TODAY I THINK ThEY ARE THE SAME
//TODO CLEAN UP COMMENTS/ OLD CODE
//TODO AN OPTION TO PLAY AGAIN
//TODO BETTER WAY T0 CREATE A BLACK JACK HAND FOR PLAYER AND DEALER
//TODO BETTER WAY TO CHECK HAND
//WHICH METHOD IS BEING CALLED, HAND MEHTOD OR BLACK JACK HAND??
//WHICH HAND IS BEING INSTANTIATED?? PROBABLY BLACKJACK
//IMPORVE ON THE ABSTRACTION AND THE INCAPSULATION
//REMMEBER OOP PRINCIPLES
//TODO SHUFFLE DECK OPTION
//TODO AMOUNT OF CARDS IN DECK

//-----FOR SUB GAME-----
//TODO Implement item abilities (PROBABLY IN ITEM CLASS)
//TODO Implement effect items will have on actions (PROBABLY IN SUB GAME CLASS)
//TODO Implement battle mode (PROBABLY SUB GAME CLASS
//TODO MAKE CODE DRY (REMOVE OLD CODE, IMPLEMENT NEW METHODS FOR REPRETED CODE)
//TODO ADD FLAVOR COMMENTS TO NEW CLASS
//TODO ADD SUB GAME TO DIFFERENT CLASS
//TODO GO OVER HAND ABSTRACT METHOD
//TODO GO OVER BLACK JACK HAND METHOD
//TODO GO OVER PLAYER  CLASS/METHODS
//TODO GO OVER DEALER CLASS/METHODS

public class BlackJackApp {

	// Holds Items
	// CHANGE LATER
	// List<Items> gameItems = new ArrayList<>();

	// --INSTANCE VARIABLES---
	private Card gameCard;
	private int itemNumber;
	private String itemName;
	private String itemDescription;
	private Items foundItem;
	boolean playerFoundItem = false;

	// Create Deck
	private Deck deck = new Deck();

	// create hands
	// dealers hand and players hand
	private BlackJackHand dealersHand = new BlackJackHand();
	public BlackJackHand playersHand = new BlackJackHand();

	// Create Dealer and Player
	private Dealer blackJackDealer = new Dealer(dealersHand, deck);
	private Player blackJackPlayer = new Player(playersHand);

	// handCheck
	private char handCheck;

	// boolean game win/lose condition
	boolean gameover = false;
	boolean blackJack = false;

	// Create scanner
	private Scanner input = new Scanner(System.in);

	// ----------------MAIN METHOD-----------------
	public static void main(String[] args) {

		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	// RUN METHOD
	public void run() {

		while (gameover == false) {

			System.out.println("Do you want to player a game...\n");
			firstTurn();
			if (gameover == false) {

				playersTurn();
			}
			if (gameover == false) {

				dealersTurn();
			}
			if (blackJack == false) {

				// check win conditions
				gameConditions();
			}
		}
	}

	// first turn
	public void firstTurn() {

		// Dealer draws three cards
		// Only dealer can draw cards from the deck

		// First card to added to players hand
		gameCard = blackJackDealer.dealCard();
		playersHand.addCardToHand(gameCard);

		// second card is added to dealers hand
		gameCard = blackJackDealer.dealCard();
		dealersHand.addCardToHand(gameCard);

		// third card is added to players hand
		gameCard = blackJackDealer.dealCard();
		playersHand.addCardToHand(gameCard);

		// add to subgame class
		System.out.println("Dealer Shuffles deck with a technique you can't quite understand...\n"
				+ "They deal two cards, face up in front of you.\n"
				+ "You look up, and see him grinning... An ominous feeling envelops you.\n"
				+ "You know something isn't right, but you somehow know the dealer isn't cheating...\n");

		// CHECK FOR BLACK JACK WIN CONDITIONS
		int playerFirstRoundTotal = playersHand.getHandValue(playersHand);
		if (playerFirstRoundTotal == 21) {
			System.out.println("Black Jack");
			gameover = true;
			blackJack = true;
			blackJackWinCondition();

		} else {
			// IF BLACK JACK IS FALSE FOR PLAYER

			System.out.println("     ---PLAYERS CARDS---");
			System.out.println("--------------------------------------------------------");
			// prints card names and values in players hand as a too string
			getHandValue(handCheck = 'P');
			System.out.println(blackJackPlayer.getPlayersHand());
			System.out.println("--------------------------------------------------------");
			System.out.println("");

			System.out.println("      ---DEALERS CARDS---");
			System.out.println("--------------------------------------------------------");
			// System.out.println(dealersHand.getHandValue(dealersHand));
			getHandValue(handCheck = 'D');
			System.out.print(blackJackDealer.getDealersHand());
			System.out.println(" Second card is face down....");
			System.out.println("--------------------------------------------------------");
			System.out.println("");

			// dealer draws fourth card
			// last card is added to dealer hand
			// the card is placed face down.
			// NOT VISIBLE TO PLAYER TILL DEALERS TURN
			gameCard = blackJackDealer.dealCard();
			dealersHand.addCardToHand(gameCard);
		}
	}

	// PLAYERS TURN
	public void playersTurn() {
		// add to subgame class
		// call with method
		System.out.println("It's your turn... The dealer doesnt say anything, but you know they are waitng\n"
				+ "You can't quite remember where you are, or how you arrived here\n"
				+ "And just as you think you remember, it slips away...\n");

		// Menu for players turn
		// Player can hit, stay, check hand, or quit...
		// Players Also have a secret menu...
		boolean turn = true;
		while (turn == true) {

			int playersTotal = playersHand.getHandValue(playersHand);

			if (playersTotal < 21) {
				char hitOrStay;

				System.out.println();
				System.out.println("============== MENU =============");
				System.out.println("|     ---PLAYER'S TURN---       |");
				System.out.println("|     --- BLACK  JACK ---       |");
				System.out.println("|        Enter A to Hit         |");
				System.out.println("|        Enter B to Stay        |");
				System.out.println("|      Enter C to View Hand     |");
				System.out.println("|    Enter D for Secret Menu    |");
				System.out.println("|        Enter Q to Quit        |");
				System.out.println("|                               |");
				System.out.println("=================================");
				System.out.println();

				hitOrStay = input.next().toUpperCase().charAt(0);

				switch (hitOrStay) {

				case 'A':
					gameCard = blackJackDealer.dealCard();
					playersHand.addCardToHand(gameCard);
					System.out.println("");
					System.out.println("---PLAYER'S TOTAL---");
					System.out.println("Player Hits");
					System.out.println("New Card: " + gameCard);
					// System.out.println("Player's new total: ");
					// System.out.println(playersHand.getHandValue(playersHand));
					getHandValue(handCheck = 'P');
					System.out.println("");
					break;
				case 'B':
					System.out.println("Player Has Chosen to Stay");
					System.out.println("");
					turn = false;
					break;
				case 'C':

					System.out.println("           ---Players Current Total---");
					System.out.println("--------------------------------------------------------");
					getHandValue(handCheck = 'P');
					System.out.println(blackJackPlayer.getPlayersHand());
					System.out.println("--------------------------------------------------------");
					System.out.println("");
					turn = true;
					break;
				case 'D':
					// What could this be....
					secretMenu();
					break;
				case 'Q':
					System.out.println("Goodbye");
					turn = false;
					gameover = true;
					input.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option");
					turn = true;
					break;

				}

			} else {
				turn = false;
				gameover = true;

			}
		}
	}

	// DEALERS TURN
	public void dealersTurn() {

		boolean turn = true;
		while (turn == true) {
			// get dealers current value
			int dealersHandValue = dealersHand.getHandValue(dealersHand);
			getHandValue(handCheck = 'D');

			System.out.println("---DEALERS TURN---");
			// Dealer Logic
			// Dealer will hit if value is under 17
			// Dealer will pass if over 17
			if (dealersHandValue < 17) {
				System.out.println("Dealer Hits");
				gameCard = blackJackDealer.dealCard();
				dealersHand.addCardToHand(gameCard);
				System.out.println("New Card: " + gameCard);
				System.out.println("Dealers new total: ");
				// System.out.println(dealersHand.getHandValue(dealersHand) + "\n");
				getHandValue(handCheck = 'D');
				System.out.println("");

			} else if (dealersHandValue >= 17) {
				System.out.println("Dealer choses to pass");
				System.out.println("");
				turn = false;
				// dealersHand.getHandValue(dealersHand);
			} else
				System.out.println("Something is wrong....DEALER LOGIC");
			gameover = true;
			turn = false;
			System.out.println("");
		}

	}

	// Method to check hand values for both player and dealer
	public void getHandValue(char handCheck) {

		if (handCheck == 'P') {
			System.out.print("Players Hand Total: ");
			System.out.println(playersHand.getHandValue(playersHand));

		} else if (handCheck == 'D') {
			System.out.print("Dealers Hand Total: ");
			System.out.println(dealersHand.getHandValue(dealersHand));
		} else {
			System.out.println("Something happened....GET HAND TOTAL");
			gameover = true;
		}
	}

	// Check win/lose conditions after every round
	public boolean gameConditions() {

		// get the end game total for both hands
		int dealersTotal = dealersHand.getHandValue(dealersHand);
		int playersTotal = playersHand.getHandValue(playersHand);

		// CHECKS FOR A TIE
		if (dealersTotal == playersTotal) {
			System.out.println("GAME OVER");
			System.out.println("Game is a tie");
			System.out.println("Dealer's total: " + dealersTotal);
			System.out.println("Player's total: " + playersTotal);
		} else {

			// ---PLAYERS TOTAL--- 21
			if (playersTotal == 21) {

				System.out.println("GAME OVER");
				System.out.println("Dealer has lost...");
				System.out.println("Player has won!");
				System.out.println("--------------------------------------------------------");
				System.out.println("Dealers total: ");
				// System.out.println(dealersHand.getHandValue(dealersHand));
				getHandValue(handCheck = 'D');
				System.out.println(blackJackDealer.getDealersHand());
				System.out.println("\nPlayer's total: ");
				getHandValue(handCheck = 'P');
				System.out.println(blackJackPlayer.getPlayersHand());
				System.out.println("--------------------------------------------------------");
				System.out.println("Your vision fades and you wake up in your bed, was it just a dream?");
				gameover = true;
				return gameover;

			}

			// --DEALERS TOTAL = 21
			if (dealersTotal == 21) {
				System.out.println("GAME OVER");
				System.out.println("Player has lost...");
				System.out.println("Dealer has won");
				System.out.println("--------------------------------------------------------");
				System.out.println("Player's total: ");
				getHandValue(handCheck = 'P');
				System.out.println(blackJackPlayer.getPlayersHand());
				System.out.println("--------------------------------------------------------");
				System.out.println("\nDealers total: ");
				getHandValue(handCheck = 'D');
				System.out.println(blackJackDealer.getDealersHand());
				System.out.println("--------------------------------------------------------");
				System.out.println("You are banished to the shadow realm...");
				gameover = true;
				return gameover;
			}
			// BOTH DEALER AND PLAYER ARE UNDER 21
			if ((dealersTotal < 21) && (playersTotal < 21)) {
				// LOGIC THAT DETMINES WHO IS CLOSER TO 21

				// finds distance from 21 for both players total and dealers total
				// determines winner based on who is closer
				int dealersDistanceFrom21 = 21 - dealersTotal;
				int playersDistanceFrom21 = 21 - playersTotal;

				if (dealersDistanceFrom21 > playersDistanceFrom21) {
					System.out.println("GAME OVER");
					System.out.println("Dealer has lost...");
					System.out.println("Player has won!");
					System.out.println("--------------------------------------------------------");
					System.out.println("Dealers total: ");
					// System.out.println(dealersHand.getHandValue(dealersHand));
					getHandValue(handCheck = 'D');
					System.out.println(blackJackDealer.getDealersHand());
					System.out.println("\nPlayer's total: ");
					getHandValue(handCheck = 'P');
					System.out.println(blackJackPlayer.getPlayersHand());
					System.out.println("--------------------------------------------------------");
					System.out.println("Your vision fades and you wake up in your bed, was it just a dream?");
					gameover = true;
					return gameover;
				} else if (dealersDistanceFrom21 < playersDistanceFrom21) {
					System.out.println("GAME OVER");
					System.out.println("Player has lost...");
					System.out.println("Dealer has won");
					System.out.println("--------------------------------------------------------");
					System.out.println("Player's total: ");
					// System.out.println(playersHand.getHandValue(playersHand));
					getHandValue(handCheck = 'P');
					System.out.println(blackJackPlayer.getPlayersHand());
					System.out.println("--------------------------------------------------------");
					System.out.println("\nDealers total: ");
					getHandValue(handCheck = 'D');
					System.out.println(blackJackDealer.getDealersHand());
					System.out.println("--------------------------------------------------------");
					System.out.println("You are banished to the shadow realm...");
					gameover = true;
					return gameover;
				}

			}

			// BOTH PLAYER AND DEALER ARE OVER 21
			if (dealersTotal > 21 && playersTotal > 21) {
				System.out.println("GAME OVER");
				System.out.println("BOTH PLAYER AND DEALER LOSE");
				System.out.println("--------------------------------------------------------");
				System.out.println("Dealers total: ");
				// System.out.println(dealersHand.getHandValue(dealersHand));
				getHandValue(handCheck = 'D');
				System.out.println(blackJackDealer.getDealersHand());
				System.out.println("\nPlayer's total: ");
				getHandValue(handCheck = 'P');
				System.out.println(blackJackPlayer.getPlayersHand());
				System.out.println("--------------------------------------------------------");
				gameover = true;
				return gameover;
			} else {
				// DEALER OVER 21
				// PLAYER WINS
				if (dealersTotal > 21) {
					System.out.println("GAME OVER");
					System.out.println("Dealer has lost...");
					System.out.println("Player has won");
					System.out.println("--------------------------------------------------------");
					System.out.println("Dealers total: ");
					getHandValue(handCheck = 'D');
					System.out.println(blackJackDealer.getDealersHand());
					System.out.println("\nPlayer's total: ");
					getHandValue(handCheck = 'P');
					System.out.println(blackJackPlayer.getPlayersHand());
					System.out.println("--------------------------------------------------------");
					gameover = true;
					return gameover;

				}
				// PLAYER OVER 21
				// DEALER WINS
				if (playersTotal > 21) {
					System.out.println("GAME OVER");
					System.out.println("Player has lost...");
					System.out.println("Dealer has won");
					System.out.println("--------------------------------------------------------");
					System.out.println("Player's total: ");
					getHandValue(handCheck = 'P');
					System.out.println(blackJackPlayer.getPlayersHand());
					System.out.println("--------------------------------------------------------");
					System.out.println("\nDealers total: ");
					getHandValue(handCheck = 'D');
					System.out.println(blackJackDealer.getDealersHand());
					System.out.println("--------------------------------------------------------");
					System.out.println("You are banished to the shadow realm...");
					gameover = true;
					return gameover;
				}
			}

		}
		gameover = true;
		return gameover;

	}

	// checks for BlackJack on players first turn
	public boolean blackJackWinCondition() {
		int playersTotal = 21;// playersHand.getHandValue(playersHand);
		if (playersTotal == 21) {
			System.out.println("GAME OVER");
			System.out.println("Dealer has lost...");
			System.out.println("Player has won");
			System.out.println("You wake up in your bed, was it a dream?");

			System.out.println("Players Total: " + playersTotal);

			blackJack = true;
			return blackJack;
		}
		return blackJack;

	}

	// ---SECRET MENU METHOD---
	public String secretMenu() {

		// Dispays Secret menu...
		System.out.println();
		System.out.println("===========SECRET MENU =========");
		System.out.println("|                               |");
		System.out.println("|  Enter A Speak with Dealer    |");
		System.out.println("|  Enter B Attempt to Cheat     |");
		System.out.println("|  Enter C Try to Leave         |");
		System.out.println("|  Enter D Look Under Table     |");
		System.out.println("|  Enter E To Check Pocket      |");
		System.out.println("|  Enter Q Main Menu            |");
		System.out.println("|                               |");
		System.out.println("=================================");
		System.out.println();

		System.out.println("Please enter A, B, C, D, E, or Q ");

		// input for secret menu
		char secretMenuSelection = input.next().toUpperCase().charAt(0);
		System.out.println("");

		// Switch to control secret menu input
		switch (secretMenuSelection) {

		case 'A':
			speakWithDealer();
			break;
		case 'B':
			attemptToCheat();
			break;
		case 'C':
			tryToLeave();
			break;
		case 'D':
			lookUnderTable();
			break;
		case 'E':
			if (playerFoundItem = true) {
				System.out.println(foundItem.toString());
				System.out.println("");
				System.out.println("What is this? Why was it there...");
				System.out.println("Maybe it's for something.\n");
			} else
				System.out.println("You find nothing in your pocket.");
			break;
		case 'Q':
			break;
		default:
			System.out.println("Invalid Option");
		}

		return null;

	}

	// add to subgame class
	private String tryToLeave() {
		// TODO Auto-generated method stub
		System.out.println(
				"You decide to try leave, you turn from the card table.\n" + "The room is empty and unremarkable.\n"
						+ "There is a door at the otherside of the room\n" + "and a window on the left.\n");

		System.out.println("Please make a choice...\n" + "A for Door\n" + "B for the window\n");

		char escapeOption = input.next().toUpperCase().charAt(0);

		if (escapeOption == 'A') {
			System.out.println("You chose the door, the wooden floor creaks as you walk...\n"
					+ "The door isn't getting closer, regardless of how long you walk.\n"
					+ "You turn arround, you are still where you started, next to the table with the Dealer... but how?\n");
		} else if (escapeOption == 'B') {
			System.out.println(
					"You head to the window, it's already open. From the window you feel a cold draft, carrying with it a thick fog \n"
							+ "thats been filling the room. You climb through and plunge into the depths below...\n"
							+ "You wake up from a genlte slumber, you are standing in front of the desk with the dealer...\n");
		}

		return null;
	}

	private String attemptToCheat() {
		// TODO Auto-generated method stub
		System.out.println("Before you can finish the thought, you drift into a nostolgic slumber...");

		System.out.println("You are banished to the shadow realm\n" + "Dealer wins...\n");

		System.exit(0);
		return null;
	}

	private String speakWithDealer() {
		// TODO Auto-generated method stub
		System.out
				.println("As you try to speak, you find that you can't. Your mouth isn't bound, you just... can't....\n"
						+ "You think the words, you think the action, but to no avail, you cannot speak...\n");

		System.out
				.println("You look at the dealer, and you have trouble... understanding? It's right in front of you, \n"
						+ "you can see them, but you are unable to comprehend... and as soon as as you look away, all details are forgotten.\n");
		return null;
	}

	// add to sub game class
	private void lookUnderTable() {

		// The item found is determined by generating a random number between 22 and 91,
		// and then
		// subtracting the random number from the current total of players hand.
		// The resulting number is then matched to a item.
		// Each item has a number range associated with it.
		// If the resulting number above matches a number in the item range then
		// The player will find the item
		// The item is then constructed calling it's constructor
		// It is then added to the players inventory (Pocket)
		// The player will be able to examine the item when they check their pockets
		// Having a specific item may change things tried before...
		int intRandom = 15 + (int) (Math.random() * (91));
		int playersHandTotal = playersHand.getHandValue(playersHand);
		itemNumber = intRandom - playersHandTotal;
		System.out.println("");

		// if player has not found an item yet...
		if (playerFoundItem == false) {

			// player finds the Crest of mercury
			if (itemNumber <= 22) {
				System.out.println("You look under the table....\n" + "You find the Crest of Mercury");
				System.out.println("You put the item(s) in your pocket.");
				itemName = "Crest of Mercury";
				itemDescription = "The crest is named after Mercury, the Roman messenger god.\n"
						+ "The shape of the crest offers room for confusion,\nas it is a combination of Mercury's staff "
						+ "and a snake.";
				Items crestOfMercury = new Items(itemName, itemDescription, itemNumber);
				// gameItems.add(crestOfMercury);
				foundItem = crestOfMercury;
				playerFoundItem = true;

				// player finds the Gambling Receipt and Picture of Mary
			} else if (itemNumber > 22 && itemNumber <= 52) {
				System.out.println(
						"You look under the table....\n" + "You find the Gambling Receipt and Picture of Mary.");
				System.out.println("You put the item(s) in your pocket.");
				itemName = "Gambling Receipet and Picture Of Mary";
				itemDescription = "A Gambling Recipet and a Picture of a woman named Mary...\n"
						+ "Written on the back of the picture is Anniversary 05/20/1998 \n"
						+ "The Gambling Recipt is for a large debt. Dated a year later.";
				Items gamblingRecipetAndPictureOfMary = new Items(itemName, itemDescription, itemNumber);
				foundItem = gamblingRecipetAndPictureOfMary;
				playerFoundItem = true;

			} // player finds the Coin (Old Man)
			else if (itemNumber > 52 && itemNumber <= 57) {
				System.out.println("You look under the table....\n" + "You find the Coin (Old Man).");
				System.out.println("You put the item in your pocket.");
				itemName = "Coin (Old Man)";
				itemDescription = "Large old coin imprinted with the face of an old man.\n" + "It is very worn.";
				Items coinOldMan = new Items(itemName, itemDescription, itemNumber);
				foundItem = coinOldMan;
				playerFoundItem = true;

			} // player finds the Coin (Prisoner)
			else if (itemNumber > 57 && itemNumber <= 62) {
				System.out.println("You look under the table....\n" + "You find the Coin (Prisoner).");
				System.out.println("You put the item in your pocket");
				itemName = "Coin (Prisoner)";
				itemDescription = "Large old coin imprinted with the face of a prisoner.\n"
						+ "It looks like it was never truly appreciacted.";
				Items coinPrisoner = new Items(itemName, itemDescription, itemNumber);
				foundItem = coinPrisoner;
				playerFoundItem = true;

				// gameItems.add(coinPrisoner);
			} // player finds the Coin (Snake)
			else if (itemNumber > 62 && itemNumber <= 68) {
				System.out.println("You look under the table....\n " + "You find the Coin (Snake).");
				System.out.println("You put the item in your pocket");
				itemName = "Coin (Snake)";
				itemDescription = "Small old coin imprinted with a snake. " + "It's very dirty.";
				Items coinSnake = new Items(itemName, itemDescription, itemNumber);
				foundItem = coinSnake;
				playerFoundItem = true;

			}
			// Player does't find anything
			else {
				System.out.println("You look under the table...");
				System.out.println("Nothing...\n");
				playerFoundItem = false;
			}
		} else if (playerFoundItem = true) {
			System.out.println("You look under the table again...");
			System.out.println("But there is nothing there.\n");
		}
		//
		// 1-8 Crest of Mercury--You can Move to the Door or Window
		// 8-20 Receipt and Picture of Mary--You can Move
		// 20-22 Coin (Old Man)
		// 22-24 Coin (Prisoner)
		// 24-26 Coin (Snake)

	}

	public void deckSize() {
		System.out.println("Cards remaing in deck..." + deck.checkDeckSize() + "\n");

	}

}
