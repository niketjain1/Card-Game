package Main.service;

import Main.entities.Card;
import Main.entities.Deck;

import java.util.Collections;

public class DeckService {

    public void shuffle(Deck deck){
        Collections.shuffle(deck.getCards());
    }

    public Card drawCard(Deck deck){
        return deck.getCards().remove(0);
    }

    public int size(Deck deck){
        return deck.getCards().size();
    }
}
