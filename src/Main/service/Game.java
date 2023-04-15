package Main.service;

import Main.constant.Rank;
import Main.entities.Card;
import Main.entities.Deck;
import Main.entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Game {
    public final Deck deck;
    private final List<Player> players;
    public final Stack<Card> discardPile;
    private int direction;
    public int currentPlayerIndex;
    public DeckService deckService;

    public Game(List<Player> players) {
        this.players = players;
        deck = new Deck();
        deckService = new DeckService(deck);
        discardPile = new Stack<>();
        currentPlayerIndex = 0;
        direction = 1;
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.addCardToHand(deckService.drawCard());
            }
        }
        discardPile.push(deckService.drawCard());
    }
    public void nextTurn(Card chosenCard) {
        Player currentPlayer = players.get(currentPlayerIndex);
        Card topCard = discardPile.peek();
        if(chosenCard != null) {
            if (currentPlayer.playCard(chosenCard, topCard)) {
                discardPile.push(chosenCard);
                if (chosenCard.getRank() == Rank.ACE) {
                    currentPlayerIndex += 2 * direction;
                } else if (chosenCard.getRank() == Rank.KING) {
                    direction *= -1;
                } else if (chosenCard.getRank() == Rank.QUEEN) {
                    nextPlayer().addCardToHand(deckService.drawCard());
                    nextPlayer().addCardToHand(deckService.drawCard());
                } else if (chosenCard.getRank() == Rank.JACK) {
                    nextPlayer().addCardToHand(deckService.drawCard());
                    nextPlayer().addCardToHand(deckService.drawCard());
                    nextPlayer().addCardToHand(deckService.drawCard());
                    nextPlayer().addCardToHand(deckService.drawCard());
                }
            }
                else {
                    System.out.println("Invalid move. You must play a card that matches the suit or rank of the top card.");
                }

            }else {
            currentPlayer.addCardToHand(deckService.drawCard());
        }
        currentPlayerIndex = (currentPlayerIndex + direction + players.size()) % players.size();;

    }

    public Player nextPlayer() {
        return players.get((currentPlayerIndex + direction + players.size()) % players.size());
    }

    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return deck.getCards().isEmpty();
    }

    public Player getWinner() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Stack<Card> getDiscardPile() {
        return discardPile;
    }
}