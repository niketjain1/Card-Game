package Test.entities;

import Main.constant.Rank;
import Main.constant.Suit;
import Main.entities.Card;
import org.junit.Assert;
import org.junit.Test;


public class CardTest {
    private static Suit suit;
    private static Rank rank;
    @Test
    public void checkCardTest(){
        Card card = new Card(suit.HEARTS, rank.FOUR);
        Assert.assertEquals(suit.HEARTS, card.getSuit());
        Assert.assertEquals(rank.FOUR, card.getRank());
    }

}
