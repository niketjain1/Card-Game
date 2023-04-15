//package Test.entities;
//
//import Main.constant.Rank;
//import Main.constant.Suit;
//import Main.entities.Card;
//import Main.entities.Player;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static junit.framework.TestCase.assertEquals;
//
//public class PlayerTest {
//
//
//    List<Card> hand = new ArrayList<>();
//    @Test
//    public void testGetName(){
//        Player player = new Player("Ram");
//        Assert.assertEquals("Ram", player.getPlayerName());
//    }
//
//    @Test
//    public void testAddCardAndGetHand() {
//        Player player = new Player("Ram");
//        Card card1 = new Card(Suit.SPADES, Rank.ACE);
//        Card card2 = new Card(Suit.HEARTS, Rank.TWO);
//
//        player.addCard(card1);
//        player.addCard(card2);
//
//        assertEquals(Arrays.asList(card1, card2), player.getHand());
//    }
//
//    @Test
//    public void testRemoveCard() {
//        Player player = new Player("Ram");
//        Card card1 = new Card(Suit.DIAMONDS, Rank.THREE);
//        Card card2 = new Card(Suit.CLUBS, Rank.FOUR);
//
//        player.addCard(card1);
//        player.addCard(card2);
//
//        assertEquals(card1, player.removeCard(0));
//        assertEquals(Arrays.asList(card2), player.getHand());
//    }
//
//
//}
