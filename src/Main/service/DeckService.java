package Main.service;

import Main.entities.Card;
import Main.entities.Deck;

import java.util.Collections;

public class DeckService {

    private final Deck deck;

    public DeckService(Deck deck) {
        this.deck = deck;
    }

    public void shuffle(Deck deck){
        Collections.shuffle(deck.getCards());
    }

    public Card drawCard(){
        if (deck.getCards().isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return deck.getCards().pop();
    }

    public int size(Deck deck){
        return deck.getCards().size();
    }
}
