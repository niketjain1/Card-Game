package entities;

import java.util.List;

public class Player {
    private final String playerName;
    private final List<Card> hand;

    public Player(String playerName, List<Card> hand) {
        this.playerName = playerName;
        this.hand = hand;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Card> getHand() {
        return hand;
    }

    public Card getCard(int index){
        return hand.get(index);
    }

}
