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

    public void addCard(Card card){
        hand.add(card);
    }
   public Card removeCard(int index){
        return hand.remove(index);
   }

}
