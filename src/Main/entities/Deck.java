package Main.entities;

import Main.constant.Rank;
import Main.constant.Suit;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
