package Test.service;

import Main.constant.Rank;
import Main.constant.Suit;
import Main.entities.Card;
import Main.entities.Deck;
import Main.service.DeckService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckServiceTest {

    private Deck deck;
    private DeckService deckService;
    @Before
    public void setUp(){
        deck = new Deck();
        deckService = new DeckService(deck);
    }
    @Test
    public void testDrawCard() {
        int initialSize = deck.getCards().size();
        Card drawnCard = deckService.drawCard();
        int newSize = deck.getCards().size();

        assertNotEquals(initialSize, newSize);
        assertEquals(newSize, initialSize - 1);
        assertNotNull(drawnCard);
    }

    @Test
    public void testEmptyDeck() {
        deck.getCards().clear();

        Assert.assertTrue(deck.getCards().isEmpty());
    }

    @Test
    public void testSize() {
        int expectedSize = deck.getCards().size();
        int actualSize = deckService.size(deck);

        assertEquals(expectedSize, actualSize);
    }
}
