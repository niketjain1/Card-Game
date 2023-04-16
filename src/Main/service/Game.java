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
    private Card lastActionCard = null;
    private int changedIndex = 0;
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
                    lastActionCard = chosenCard;
                    currentPlayerIndex += 2 * direction;
                    if (currentPlayerIndex >= players.size()) {
                        currentPlayerIndex -= players.size();
                        changedIndex = 1;
                        System.out.println("Next player turn skipped!!");
                    } else if (currentPlayerIndex < 0) {
                        currentPlayerIndex += players.size();
                        changedIndex = 1;
                        System.out.println("Next player turn skipped!!");
                    } else {
                        changedIndex = 1;
                        System.out.println("Next player turn skipped!!");
                    }
                } else if (chosenCard.getRank() == Rank.KING) {
                    lastActionCard = chosenCard;
                    direction *= -1;
                    System.out.println("Turn reversed!!");
                } else if (chosenCard.getRank() == Rank.QUEEN ) {
                    if (lastActionCard != null && lastActionCard.getRank() == Rank.QUEEN) {
                        currentPlayer.addCardToHand(deckService.drawCard());
                        System.out.println("Cannot play another Queen, one card drawn!");
                    } else {
                        lastActionCard = chosenCard;
                        nextPlayer().addCardToHand(deckService.drawCard());
                        nextPlayer().addCardToHand(deckService.drawCard());
                        System.out.println("2 cards added to the next player hand");
                    }
                } else if (chosenCard.getRank() == Rank.JACK) {
                    if (lastActionCard != null && lastActionCard.getRank() == Rank.JACK) {
                        currentPlayer.addCardToHand(deckService.drawCard());
                        System.out.println("Cannot play another Jack, one card drawn !");
                    } else {
                        lastActionCard = chosenCard;
                        nextPlayer().addCardToHand(deckService.drawCard());
                        nextPlayer().addCardToHand(deckService.drawCard());
                        nextPlayer().addCardToHand(deckService.drawCard());
                        nextPlayer().addCardToHand(deckService.drawCard());
                        System.out.println("4 cards added to the next player hand");
                    }
                } else {
                    lastActionCard = null;
                }
            }
                else {
                    lastActionCard = null;
                    System.out.println("Invalid move. You must play a card that matches the suit or rank of the top card.");
                }

            }else {
            lastActionCard = null;
            currentPlayer.addCardToHand(deckService.drawCard());
            System.out.println("Invalid index, one card drawn !");
        }
        if(changedIndex != 1) {
            currentPlayerIndex = (currentPlayerIndex + direction + players.size()) % players.size();
        }else{
            changedIndex = 0;
        }
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