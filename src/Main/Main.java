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
            Player currentPlayer = game.getPlayers().get(game.getCurrentPlayerIndex());
            System.out.println(currentPlayer.getPlayerName() + "'s turn");
            System.out.println("Top card: " + game.getDiscardPile().peek());
            System.out.print("Your hand: ");
            for(int i = 0; i < currentPlayer.getHand().size();){
                System.out.print("(" +currentPlayer.getHand().get(i) + ", "+ ++i + ") ");
            }
            System.out.println();

            System.out.println("Enter the index of the card you want to play, or -1 to draw a card:");
            int cardIndex = scanner.nextInt();
            Card chosenCard = null;
            if (cardIndex >= 1 && cardIndex <= currentPlayer.getHand().size()) {
                chosenCard = currentPlayer.getHand().get(cardIndex - 1);

            }
            game.nextTurn(chosenCard);
            System.out.println();
        }
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println(winner.getPlayerName() + " wins!");
        } else {
            System.out.println("The game ended in a draw.");
        }
    }
}