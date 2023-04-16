# Card-Game

This is a Java implementation of the card game according to the requirements as follows:
- Each player starts with a hand of 5 cards.
- The game starts with a deck of 52 cards ( a standard deck of playing cards).
- Players take turns playing cards from their hand, following a set of rules that define what cards can be played when.
- A player can only play a card if it matches either the suit or the rank of the top card on the discard pile.
- If a player cannot play a card, they must draw a card from the draw pile. If the draw pile is empty, the game ends in a draw and no player is declared a winner..
- The game ends when one player runs out of cardswho is declared the winner.

BONUS: Aces, Kings, Queens and Jack are action cards. When one of these is played the following actions occur:

- Ace(A): Skip the next player in turn
- Kings(K): Reverse the sequence of who plays next 
- Queens(Q): +2
- Jacks(J): +4
- NOTE: actions are not stackable i.e. if Q is played by player 1 then player two draws two cards and cannot play a Q from his hand on that turn even if available

## Requirements

- Java 8 or higher

## Getting Started

1. Clone the repository

git clone https://github.com/niketjain1/Card-Game.git

2. Compile the Java classes.
3. Run the main.java file.

## How to play the game.

After you run the main.java class:
- Enter the number of players (2-4).
- Enter the name of the respective player.    
*NOTE:* Random 5 cards will be added to each player's hand.
- The card is indexed with numbers, so it will be easy to pick. Pick an index.    
*NOTE:* If the card doesn't match the top card's suit or rank, then one card will be drawn automatically.
- Choosing the action card will affect the next player's hand or turn.
- The game will end once all the cards on a player's hand are drawn out.

## Unit test cases.

This project includes JUnit tests for all classes. To run the tests:
1. Compile the Java classes.
2. Run the tests in the src/Test directory.
