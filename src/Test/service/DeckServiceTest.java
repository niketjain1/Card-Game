package Test.service;

import Main.constant.Rank;
import Main.constant.Suit;
import Main.entities.Card;
import Main.entities.Deck;
import Main.service.DeckService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckServiceTest {
//    @Test
//    public void testShuffle() {
//        DeckService deckService = new DeckService();
//        Deck deck1 = new Deck();
//
//        List<Card> expectedCards = new ArrayList<>();
//        for (Suit suit : Suit.values()) {
//            for (Rank rank : Rank.values()) {
//                expectedCards.add(new Card(suit, rank));
//            }
//        }
//        List<Card> actualCards = deck1.getCards();
//        assertArrayEquals(expectedCards.toArray(), actualCards.toArray());
//
////        deckService.shuffle(deck2);
////
////        assertNotEquals(deck1.getCards(), deck2.getCards());
//    }
//
//    @Test
//    public void testDrawCard() {
//        DeckService deckService = new DeckService();
//        Deck deck = new Deck();
//
//        // Draw a card from the deck
//        Card card = deckService.drawCard(deck);
//
//        // Check that a card is returned
//        assertNotNull(card);
//
//        // Check that the card is removed from the deck
//        assertFalse(deck.getCards().contains(card));
//    }
//
//    @Test
//    public void testSize() {
//        DeckService deckService = new DeckService();
//        Deck deck = new Deck();
//
//        // Check that the deck size is 52
//        assertEquals(52, deckService.size(deck));
//
//        // Draw a card from the deck
//        deckService.drawCard(deck);
//
//        // Check that the deck size is now 51
//        assertEquals(51, deckService.size(deck));
//    }

}
