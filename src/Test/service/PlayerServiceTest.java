//package Test.service;
//
//import Main.constant.Rank;
//import Main.constant.Suit;
//import Main.entities.Card;
//import Main.entities.Player;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static junit.framework.TestCase.assertTrue;
//
//public class PlayerServiceTest {
//    Player player = new Player("Ram");
//    PlayerService playerService = new PlayerService(player);
//
//    @Test
//    public void testCreatePlayer() {
//        Assert.assertEquals("Ram", player.getPlayerName());
//        assertTrue(player.getHand().isEmpty());
//    }
//
//    @Test
//    public void testAddCard() {
//        playerService.addCard(player, new Card(Suit.HEARTS, Rank.FIVE));
//        playerService.addCard(player, new Card(Suit.SPADES, Rank.FIVE));
//
//        Assert.assertEquals(2, player.getHand().size());
//    }
//
//    @Test
//    public void testRemoveCard(){
//        playerService.addCard(player, new Card(Suit.HEARTS, Rank.FIVE));
//        playerService.addCard(player, new Card(Suit.SPADES, Rank.FIVE));
//
//        Card removedCard = playerService.removeCard(player, 0);
//
//        Assert.assertEquals(Suit.HEARTS, removedCard.getSuit());
//        Assert.assertEquals(Rank.FIVE, removedCard.getRank());
//    }
//
//}
