package Main.entities;

import Main.constant.Rank;
import Main.constant.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cards;

    public Deck(){
        cards = new Stack<>();
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
