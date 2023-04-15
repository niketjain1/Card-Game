package Main.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String playerName;
    private final List<Card> hand;

    public Player(String playerName) {
        this.playerName = playerName;
        this.hand = new ArrayList<>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }
    public boolean playCard(Card card, Card topCard) {
        if (card.getSuit() == topCard.getSuit() || card.getRank() == topCard.getRank()) {
            hand.remove(card);
            return true;
        }
        return false;
    }
}
