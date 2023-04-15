package Main;

import Main.entities.Card;
import Main.entities.Player;
import Main.service.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        System.out.println("Enter the number of players (2-4):");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter the name of player " + (i + 1) + ":");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }
        Game game = new Game(players);
        while (!game.isGameOver()) {
            Player currentPlayer = game.getPlayers().get(game.currentPlayerIndex);
            System.out.println(currentPlayer.getPlayerName() + "'s turn");
            System.out.println("Top card: " + game.getDiscardPile().peek());
            System.out.println("Your hand: " + currentPlayer.getHand());
            System.out.println("Enter the index of the card you want to play, or -1 to draw a card:");
            int cardIndex = scanner.nextInt();
            Card chosenCard = null;
            if (cardIndex >= 0 && cardIndex < currentPlayer.getHand().size()) {
//                Card card = currentPlayer.getHand().get(cardIndex);
//                if (!currentPlayer.playCard(card, game.getDiscardPile().peek())) {
//                    System.out.println("Invalid move. You must play a card that matches the suit or rank of the top card.");
//                } else {
//                    game.discardPile.push(card);
//                }
//            } else if (cardIndex == -1) {
//                currentPlayer.addCardToHand(game.deckService.drawCard());
//            } else {
//                System.out.println("Invalid input. Please try again.");
//            }

                chosenCard = currentPlayer.getHand().get(cardIndex);

            }
            game.nextTurn(chosenCard);
        }
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println(winner.getPlayerName() + " wins!");
        } else {
            System.out.println("The game ended in a draw.");
        }
    }
}