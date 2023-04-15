package Test.entities;

import Main.entities.Deck;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {
    @Test
    public void testGetCards() {
        Deck deck = new Deck();
        assertEquals(52, deck.getCards().size());
    }

}
