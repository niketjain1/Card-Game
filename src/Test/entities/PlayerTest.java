package Test.entities;

import Main.constant.Rank;
import Main.constant.Suit;
import Main.entities.Card;
import Main.entities.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PlayerTest {


    List<Card> hand = new ArrayList<>();
    @Test
    public void testGetName(){
        Player player = new Player("Ram");
        Assert.assertEquals("Ram", player.getPlayerName());
    }

    @Test
    public void testAddCardAndGetHand() {
        Player player = new Player("Ram");
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.HEARTS, Rank.TWO);

        player.addCardToHand(card1);
        player.addCardToHand(card2);

        assertEquals(Arrays.asList(card1, card2), player.getHand());
    }

    @Test
    public void testPlayCard() {
        Player player = new Player("Ram");
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.SPADES, Rank.ACE);
        Card card3 = new Card(Suit.CLUBS, Rank.JACK);

        Assert.assertTrue(player.playCard(card1, card2));
        Assert.assertFalse(player.playCard(card2, card3));
    }
}
