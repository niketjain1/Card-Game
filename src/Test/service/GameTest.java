package Test.service;

import Main.constant.Rank;
import Main.constant.Suit;
import Main.entities.Card;
import Main.entities.Deck;
import Main.entities.Player;
import Main.service.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class GameTest {
    private Game game;
    private List<Player> players;

    private Deck deck;
    @Before
    public void setUp() {
        players = new ArrayList<>();
        players.add(new Player("A")); // 5 cards
        players.add(new Player("B")); // 5 cards
        players.add(new Player("C")); // 5 cards
        game = new Game(players);
        deck = new Deck();
    }

    // discardPile - 1 card
    @Test
    public void testInitialGameState() {
        assertEquals(36, game.getDeck().getCards().size());
        assertEquals(1, game.discardPile.size());
        assertEquals(5, game.getPlayers().get(0).getHand().size());
        assertEquals(5, game.getPlayers().get(1).getHand().size());
        assertEquals(5, game.getPlayers().get(2).getHand().size());
        assertNotNull(game.getPlayers().get(0).getPlayerName());
        assertNotNull(game.getPlayers().get(1).getPlayerName());
        assertNotNull(game.getPlayers().get(2).getPlayerName());
        assertFalse(game.isGameOver());
        assertNull(game.getWinner());
    }

    @Test
    public void testNextTurn() {
        Player initialPlayer = game.getPlayers().get(game.getCurrentPlayerIndex());
        game.nextTurn(initialPlayer.getHand().get(0));
        Player nextPlayer = game.getPlayers().get(game.getCurrentPlayerIndex());
        assertNotEquals(initialPlayer, nextPlayer);
    }

    @Test
    public void testIsGameOver() {
        game.getDeck().getCards().clear();
        players.get(0).getHand().clear();
        assertTrue(game.isGameOver());
    }

    @Test
    public void testGetWinner() {
        players.get(0).getHand().clear();
        assertEquals(players.get(0), game.getWinner());
    }
}
