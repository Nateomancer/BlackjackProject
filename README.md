## Blackjack Application

# Description

This is a a OOP implementation of Blackjack written in java.  Several classes are used to implement the objects and rules of the game.  BlackJackApp launches the program
and contains the logic for turn order and the Black Jack Dealer logic.  When the game starts, a Black Jack Deck is created, with a player object, a dealer object, and two Black Jack Hands.  The dealer is instantiated and instantiated with the Deck, and the second black jack hands.  The player is instantiated with the other Black Jack Hand. Only the dealer can draw and deal cards, which is why they contain deck. When the dealer deals a card, it is either added to the players hand or the dealers hand.

Both the player and dealer deck contain constructor and to create a deck and draw cards. This way the player class can be implemented in other card games where there is no "dealer". They also contain methods to get their hand total, and print each card in their hand to the terminal. As well as shuffle the deck and print the number of cards remaining in the deck.
The logic the dealers actions, either hit or stay, is contained in one of the dealers methods.  If the dealer is under 17, they automatically hit, if they are above 17, they pass.  If the player begins with a total of 21 with the first two cards dealt to them, they are declared the winner with the BLACK JACK win condition. Otherwise the game continues.  Payer can chose to hit, where the dealer will deal a card from the deck and it to the players hand. If the player stays, their turn ends and they are no longer able add cards to their hand. The player can also view their hand total, and print the rank and suite of each card in their hand. They can then choose to hit or stay. The player can also choose to quit from this menu, which ends the game.

After the player is finished (After a pass).  The dealers turn starts. The dealer acts automatically using the dealers logic method, and the outcome of their turn is printed to the terminal.  It displays the dealers hand, the first card, the second card which as face down previously, and any new cards the dealer pay have added to their hands.  If their total is below 17, they hit, if over 17, they pass.

If at any point the either the payer or the dealer go over 21, the game ends, and the party with the total over 21 is declared the loser. If both parties are under 21, and both choose to stay, the winner is then determined based on who was closer to 21, or if they have an equal total, a tie is declared.

There is a secret sub game underneath the black jack game which can be accessed by selection the option for secret game in the players menu.  The player is then brought to the secret menu which displays a list of additional actions the player can make.  I wanted to implement a bit of story/flavor in this game.  In this game, the player awakens to find themselves with no memories, facing dealer, and are forced to play a game of black jack.  They player can either play the game, and if they win they wake from a dream. If they lose, they are banished forever to the shadow realm by the dealer.

Playing the game isn't the only way out of this situation. By accessing the secret menu, the player can either talk to the dealer, try to leave the room, or cheat.  At first, all three options provide a bit of flavor text, and that the player was unsuccessful in their action.  (Unable to leave, cannot speak.). If the player chooses to cheat they lose. This prompts the player to investigate.  There are two other options in the secret menu.  Look under table and check pockets.  If the player looks under the table, there is a chance they may find one of 5 items.  The item found is determined with some random number logic by generating a random number and then subtracting the players current hand total from that number.  Each item is assigned a number range to make the item appear. If the player's number doesn't fall in that range, they do not find anything. The player is allowed to look as many times as they want until an item is found.

When an item is found, some flavor text is shown.  The item is then added to the players pocket.  If the player tries to look for a second item after finding one, no new item can be found.

The player can choose the pocket option in the secret menu to examine the object, which simply prints the items to string which contains the name of the item, and some flavor text describing the item found.  And a hint that the item can be used for something.

Depending on which item was found, the output for one of the three options, talk to dealer, try to leave, or cheat change. The items found are listed below.

Crest of Mercury
Gambling Receipt and A picture of a woman named Mary.
The old man coin.
The prisoners coin.
The snake coin.

If the player finds the Crest of Mercury, they are able to successfully leave the room, and wake from the dream.
If the player finds the receipt and picture, they are able to successfully speak with the Dealer. This results in a battle with Mary, they outcome of the battle is determined on who has the higher card value. If the player has a the higher value, they defeat the Dealer, and they wake up. Otherwise the player is defeated and loses.

The three coins have the same affect, three were added to provide additional flavor to the game. Thy are the least likely item to appear. If the player finds one of them, they can successfully cheat, which replaces the players hand total with a randomly generated number. This can be either higher or lower than the players original total.  The players turn then ends, and the game continues until dealer stays and the winner is declared.

The idea behind the game is that the player awakens at a black jack table with a spirit from beyond. The "Spirit" is actually the spirit of Mary, who is found in the picture along with the gambling receipt. Mary was a woman who liked to gamble, she now punishes those who gamble from the after life. The Crest of Mercury is a peculiar crest that depicts Mercury's staff with a snake. This represents the toll that Gambling took on Mary. The three coins found represent greed and desperation.

# Technologies used
Mac *Java *Eclipse *ZSH *Git Program uses the four principles of OOP, abstraction, polymorphism, inheritance, and encapsulation.
It has a multi-class structure and variety of logic operations, data structures, and objects. Enums were used to create the cards for the deck.
