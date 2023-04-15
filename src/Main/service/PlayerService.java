package Main.service;

import Main.entities.Card;
import Main.entities.Player;

public class PlayerService {
    private Player player;

    public PlayerService(Player player) {
        this.player = player;
    }

    public void addCard(Player player, Card card){
        player.addCard(card);
    }

    public Card removeCard(Player player, int index) {
        return player.removeCard(index);
    }

    public static String handToString(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append("Player's hand: ");
        for (Card card : player.getHand()) {
            sb.append(card).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
