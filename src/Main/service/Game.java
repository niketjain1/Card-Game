package Main.service;

import Main.constant.Rank;
import Main.entities.Card;
import Main.entities.Deck;
import Main.entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Deck deck;
    private final List<Player> players;
    private final List<Card> discardPile;
    private boolean clockwise;
    private int currentPlayerIndex;
    private DeckService deckService;
    private PlayerService playerService;

    public Game(){
        deck = new Deck();
        deckService.shuffle(deck);

        players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players (2-4): ");
        int numberOfPlayers = sc.nextInt();

        for(int i = 1; i <= numberOfPlayers; i++){
            System.out.println("Enter player " + i +" name: ");
            String name = sc.nextLine();
            players.add(new Player(name));
        }

        discardPile = new ArrayList<>();
        Card firstCard = deckService.drawCard(deck);
        while (firstCard.getRank() == Rank.ACE || firstCard.getRank() == Rank.KING ||
                firstCard.getRank() == Rank.QUEEN || firstCard.getRank() == Rank.JACK) {
            deckService.shuffle(deck);
            firstCard = deckService.drawCard(deck);
        }
        discardPile.add(firstCard);

        clockwise = true;
        currentPlayerIndex = 0;

    }

    public void play(){
        boolean gameOver = false;
        while(!gameOver){
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer +"'s turn");

            System.out.println("Top card: " + discardPile.get(discardPile.size() - 1));
            System.out.println(currentPlayer);
        }
    }
}
