package com.skilldistillery.blackjack;

import java.util.Scanner;
import com.skilldistillery.blackjack.cards.Items;
import com.skilldistillery.blackjack.cards.BlackJackHand;
import com.skilldistillery.blackjack.cards.Dealer;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Player;

public class BlackJackApp {

	// private char handCheck;

	// --INSTANCE VARIABLES---
	private Card gameCard;
	private int itemNumber;
	private String itemName;
	private String itemDescription;
	private Items foundItem;
	private boolean playerFoundItem = false;
	private boolean playerFoundCrestOfMercury = false;
	private boolean playerFoundGamblingRecipetAndPictureOfMary = false;
	private boolean playerFoundOldManCoin = false;
	private boolean playerFoundPrisonerCoin = false;
	private boolean playerFoundSnakeCoin = false;
	private boolean playerCheated = false;
	private int playerCheatedTotal;
	// Create deck
	private Deck dealersDeck = new Deck();
	// Creates dealers hand and players hand
	private BlackJackHand dealersHand = new BlackJackHand();
	private BlackJackHand playersHand = new BlackJackHand();
	// Create Dealer and Player
	private Dealer blackJackDealer = new Dealer(dealersHand, dealersDeck);
	private Player blackJackPlayer = new Player(playersHand);
	// Boolean game win/lose condition
	boolean gameover = false;
	// Blackjack condition
	boolean blackJack = false;
	// Create scanner
	private Scanner input = new Scanner(System.in);

	// Secret Game

	// ----------------MAIN METHOD-----------------
	public static void main(String[] args) {

		BlackJackApp app = new BlackJackApp();
		app.run();
	}

	// RUN METHOD
	public void run() {

		// Runs the game.
		// 4 primary methods
		// First turn
		// Players turn
		// Dealers Turn
		// winLoseConditions
		while (gameover == false) {

			System.out.println("Do you want to player a game...\n");
			startGame();
			if (gameover == false) {

				playersTurn();
			}
			if (gameover == false) {

				dealersTurn();
			}
			if (blackJack == false) {

				winLoseConditions();
			}
		}
	}

	// Game Starts
	// Dealer Sets up Game
	// Deals Cards
	public void startGame() {

		// Dealer draws three cards
		// Only dealer can draw cards from the deck

		// First card is added to players hand
		gameCard = blackJackDealer.dealCard();
		playersHand.addCardToHand(gameCard);

		// second card is added to dealers hand
		gameCard = blackJackDealer.dealCard();
		dealersHand.addCardToHand(gameCard);

		// third card is added to players hand
		gameCard = blackJackDealer.dealCard();
		playersHand.addCardToHand(gameCard);

		// fourth card is drawn later, to simulate the dealers card being placed face
		// down

		// add to subgame class
		System.out.println("Dealer Shuffles deck with a technique you can't quite understand...\n"
				+ "They deal two cards, face up in front of you.\n"
				+ "You look up, and see him grinning... An ominous feeling envelops you.\n"
				+ "You know something isn't right, but you somehow know the dealer isn't cheating...\n");

		// CHECK FOR BLACK JACK WIN CONDITIONS
		int playersTotal = getHandTotal('P');
		if (playersTotal == 21) {
			System.out.println("Black Jack");
			gameover = true;
			blackJack = true;
			blackJackWinCondition();

		} else {
			// IF BLACK JACK IS FALSE FOR PLAYER

			System.out.println("     ---PLAYERS CARDS---");
			// prints card names and values in players hand as a too string
			System.out.println("Players Total: " + playersTotal);
			System.out.println(blackJackPlayer.getPlayersHand());
			System.out.println("");
			System.out.println("      ---DEALERS CARDS---");
			int dealersTotal = getHandTotal('D');
			System.out.println("Dealers Total: " + dealersTotal);
			System.out.print(blackJackDealer.getDealersHand());
			System.out.println(" Second card is face down....");
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

			int playersTotal = getHandTotal('P');

			// only executes if players total is under 21
			if (playersTotal < 21) {

				// if player successfully cheated, value will change to true, and player will
				// stay
				if (playerCheated == false) {
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
						System.out.println("Player Hits");
						System.out.println("New Card: " + gameCard);
						System.out.println(getHandTotal('P'));
						System.out.println("");
						break;
					case 'B':
						System.out.println("Player Has Chosen to Stay");
						System.out.println("");
						turn = false;
						break;
					case 'C':

						System.out.println("       ---PLAYERS HAND---");
						System.out.println(getHandTotal('P'));
						System.out.println("Players Total: " + blackJackPlayer.getPlayersHand());
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
				} else if (playerCheated == true) {
					System.out.println("Player Has Chosen to Stay");
					System.out.println("");
					turn = false;

				}
			} else {
				turn = false;
				gameover = true;

			}
		}
	}

	// DEALERS TURN
	public void dealersTurn() {

		System.out.println("Dealers Turn");
		int dealersHandTotal = 0;
		boolean dealersTurn = true;
		while (dealersTurn == true) {

			dealersHandTotal = blackJackDealer.getDealersHandTotal(dealersHand);
			dealersTurn = blackJackDealer.dealersTurn(dealersHandTotal);
		}

		System.out.println("---Dealers Final Total---");
		System.out.println(dealersHandTotal);

	}

	// Method to check hand values for both player and dealer
	public void displayHandTotal(char handCheck) {

		if (handCheck == 'P') {
			if (playerCheated == false) {
				System.out.print("Player's Hand Total: ");

				int playersHandTotal = blackJackPlayer.getPlayersHandTotal(playersHand);
				System.out.println("PLAYERS TOTAL: " + playersHandTotal);
			}

			else if (playerCheated == true) {
				System.out.print("Player's Hand Total: ");
				int playersHandTotal = playerCheatedTotal;
				System.out.println("PLAYERS TOTAL: " + playersHandTotal);
			}
		} else if (handCheck == 'D') {
			System.out.print("Dealer's Hand Total: ");

			int dealersHandTotal = blackJackDealer.getDealersHandTotal(dealersHand);
			System.out.println("DEALER'S TOTAL: " + dealersHandTotal);

		} else {
			System.out.println("GAME OVER");
			System.out.println("Player has lost...");
			System.out.println("Dealer has won");

		}
	}

	public int getHandTotal(char handCheck) {

		int handTotal = 0;

		if (handCheck == 'P') {
			if (playerCheated == false) {
				handTotal = blackJackPlayer.getPlayersHandTotal(playersHand);
			} else if (playerCheated == true) {
				handTotal = playerCheatedTotal;
			}
			return handTotal;
		} else if (handCheck == 'D') {

			handTotal = blackJackDealer.getDealersHandTotal(dealersHand);

			return handTotal;
		} else {
			return handTotal;
		}

	}

	// Check win/lose conditions after every round
	public boolean winLoseConditions() {

		int dealersTotal = 0;
		int playersTotal = 0;
		// get the end game total for both hands
		if (playerCheated == false) {
			dealersTotal = getHandTotal('D');
			playersTotal = getHandTotal('P');
		} else if (playerCheated == true) {
			dealersTotal = getHandTotal('D');
			playersTotal = playerCheatedTotal;
			playerCheated = true;
		}

		// CHECKS FOR A TIE
		if (dealersTotal == playersTotal) {

			gameTie(dealersTotal, playersTotal);

			gameover = true;
			return gameover;

		} else {

			// ---PLAYERS TOTAL--- 21
			if (playersTotal == 21) {

				playerWon(dealersTotal, playersTotal);

				gameover = true;
				return gameover;

			}

			// --DEALERS TOTAL = 21
			if (dealersTotal == 21) {

				dealerWon(dealersTotal, playersTotal);

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

					playerWon(dealersTotal, playersTotal);

					gameover = true;
					return gameover;

				} else if (dealersDistanceFrom21 < playersDistanceFrom21) {

					dealerWon(dealersTotal, playersTotal);

					gameover = true;
					return gameover;
				}

			}

			// BOTH PLAYER AND DEALER ARE OVER 21
			if (dealersTotal > 21 && playersTotal > 21) {

				gameTie(dealersTotal, playersTotal);

				gameover = true;
				return gameover;
			} else {
				// DEALER OVER 21
				// PLAYER WINS
				if (dealersTotal > 21) {

					playerWon(dealersTotal, playersTotal);

					gameover = true;
					return gameover;

				}
				// PLAYER OVER 21
				// DEALER WINS
				if (playersTotal > 21) {

					dealerWon(dealersTotal, playersTotal);

					gameover = true;
					return gameover;
				}
			}

		}
		gameover = true;
		return gameover;

	}

	private void playersHand() {

		if (playerCheated == false) {
			System.out.println(blackJackPlayer.getPlayersHand());
		} else if (playerCheated == true) {
			System.out.println("Player Cheated.");
		}

	}

	// DISPLAY WIN, LOSS, OR TIE
	private void dealerWon(int dealersTotal, int playersTotal) {
		System.out.println("GAME OVER");
		System.out.println("Player has lost...");
		System.out.println("Dealer has won\n");
		displayHandTotal('P');
		playersHand();
		System.out.println("");
		displayHandTotal('D');
		System.out.println(blackJackDealer.getDealersHand());
		System.out.println("");
		System.out.println("You are banished to the shadow realm...\n" + "Was this some sort of test? Or Punishment?");
	}

	private void playerWon(int dealersTotal, int playersTotal) {
		System.out.println("GAME OVER");
		System.out.println("Player has Won!");
		System.out.println("Dealer has lost...\n");
		displayHandTotal('P');
		playersHand();
		System.out.println("");
		displayHandTotal('D');
		System.out.println(blackJackDealer.getDealersHand());
		System.out.println("");
		System.out.println("The room around you fades away...\n" + "You awaken in your bed, was it a dream? ");

	}

	private void gameTie(int dealersTotal, int playersTotal) {
		// TODO Auto-generated method stub

		displayHandTotal('P');
		playersHand();
		System.out.println("");
		displayHandTotal('D');
		System.out.println(blackJackDealer.getDealersHand());
		System.out.println("");
		System.out.println("The room around you fades away...\n" + "You awaken in your bed, was it a dream?\n "
				+ "You somehow feel it will happen again someday...");

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

	// -------------------------------------------------SECRET
	// GAME-------------------------------------------------

	// ---SECRET MENU METHOD---
	public void secretMenu() {

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

		System.out.println("Please enter A, B, C, D, E, or Q\n");

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
			// check pocket
			if (playerFoundItem == true) {
				System.out.println(foundItem.toString());
				System.out.println("");
				System.out.println("What is this? Why was it there...");
				System.out.println("Maybe it's for something.\n");
			} else if (playerFoundItem == false) {
				System.out.println("You find nothing in your pocket.");
			} else {
				System.out.println("You find nothing in your pocket.");
			}
			break;
		case 'Q':
			playersTurn();
			break;
		default:
			System.out.println("Invalid Option");
		}

	}

	private void tryToLeave() {
		// TODO Auto-generated method stub

		System.out.println(
				"You decide to try leave, you turn from the card table.\n" + "The room is empty and unremarkable.\n"
						+ "There is a door at the otherside of the room\n" + "and a window on the left.\n");

		System.out.println("Please make a choice...\n" + "A Choose the Door\n" + "B Choose the window\n");

		char escapeOption = input.next().toUpperCase().charAt(0);
		System.out.println("");

		if (playerFoundCrestOfMercury == false) {
			if (escapeOption == 'A') {
				System.out.println("You chose the door, the wooden floor creaks as you walk...\n"
						+ "The door isn't getting closer, regardless of how long you walk.\n"
						+ "You turn around, you are still where you started, next to the table with the Dealer... but how?\n");
			} else if (escapeOption == 'B') {
				System.out.println(
						"You head to the window, it's already open. From the window you feel a cold draft, carrying with it a thick fog \n"
								+ "You climb through and plunge into the depths below...\n"
								+ "You wake up from a genlte slumber, you are standing in front of the desk with the dealer...\n");
			}
		} else if (playerFoundCrestOfMercury == true) {
			if (escapeOption == 'A') {
				System.out.println("You chose the door, the wooden floor creaks as you walk...\n"
						+ "You open the door, and as soon you exit, you awaken in your bed.");

				gameover = true;
				System.exit(0);

			} else if (escapeOption == 'B') {
				System.out.println(
						"You head to the window, it's already open. From the window you feel a cold draft, carrying with it a thick fog \n"
								+ "You climb through and plunge into the depths below...\n"
								+ "You wake up from a genlte slumber, you are safe in your bed...\n");

				gameover = true;
				System.exit(0);
			}

		}

	}

	private int attemptToCheat() {
		// TODO Auto-generated method stub

		if ((playerFoundOldManCoin == false) && (playerFoundPrisonerCoin == false) && (playerFoundSnakeCoin == false)) {
			System.out.println("Before you can finish the thought, you drift into a nostolgic slumber...");

			System.out.println("You are banished to the shadow realm\n" + "Dealer wins...\n");
			System.out.println("Game Over\n");

			gameover = true;
			System.exit(0);

			return 0;

		} else if ((playerFoundOldManCoin == true) || (playerFoundPrisonerCoin == true)
				|| (playerFoundSnakeCoin == true)) {
			System.out.println("You decide to cheat..." + "You manage to swap your cards " + "your new total is... ");

			int intRandom = (int) (Math.random() * (21));
			System.out.println(intRandom);

			playerCheated = true;
			playerCheatedTotal = intRandom;
			return intRandom;
		}
		return 0;
	}

	private void speakWithDealer() {
		// TODO Auto-generated method stub

		if (playerFoundGamblingRecipetAndPictureOfMary == false) {
			System.out.println(
					"As you try to speak, you find that you can't. Your mouth isn't bound, you just... can't....\n"
							+ "You think the words, you think the action, but to no avail, you cannot speak...\n");

			System.out.println(
					"You look at the dealer, and you have trouble... understanding? It's right in front of you, \n"
							+ "you can see them, but you are unable to comprehend... and as soon as as you look away, all details are forgotten.\n");

		}

		else if (playerFoundGamblingRecipetAndPictureOfMary == true) {

			System.out.println(
					"You look at the dealer, the once distorted figure briefly resembled the women Mary from the picture.");
			System.out.println("Get Ready to fight...");

			int playersTotal = getHandTotal('P');
			int dealersTotal = getHandTotal('D');
			if (playersTotal < dealersTotal) {
				System.out.println("You beat the demonic incantation\n"
						+ "The world fades and you wake in your bed. Was it a dream?");
				System.out.println("");
				gameover = true;
				System.exit(0);
			} else if (playersTotal > dealersTotal) {
				System.out.println("You are defeated... " + "And banished to the shadow realm...");
				System.out.println("");
				System.out.println("Game Over\n");

				gameover = true;
				System.exit(0);
			}
		}

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
		int playersTotal = getHandTotal('P');
		itemNumber = intRandom - playersTotal;
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
				playerFoundCrestOfMercury = true;

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
				playerFoundGamblingRecipetAndPictureOfMary = true;

			} // player finds the Coin (Old Man)
			else if (itemNumber > 52 && itemNumber <= 57) {
				System.out.println("You look under the table....\n" + "You find the Coin (Old Man).");
				System.out.println("You put the item in your pocket.");
				itemName = "Coin (Old Man)";
				itemDescription = "Large old coin imprinted with the face of an old man.\n" + "It is very worn.";
				Items coinOldMan = new Items(itemName, itemDescription, itemNumber);
				foundItem = coinOldMan;
				playerFoundItem = true;
				playerFoundOldManCoin = true;

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
				playerFoundPrisonerCoin = true;

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
				playerFoundSnakeCoin = true;

			}
			// Player does't find anything
			else {
				System.out.println("You look under the table...");
				System.out.println("Nothing...\n");
				playerFoundItem = false;
			}
			// player has already found an item
		} else if (playerFoundItem = true) {
			System.out.println("You look under the table again...");
			System.out.println("But there is nothing there.\n");
		}

	}

	public void deckSize() {
		System.out.println("Cards remaing in deck..." + dealersDeck.checkDeckSize() + "\n");

	}

}
