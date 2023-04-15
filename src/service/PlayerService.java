package service;

import entities.Card;
import entities.Player;

public class PlayerService {
    private Player player;
    public void addCard(Card card){
        player.getHand().add(card);
    }

    public Card removeCard(int index){
        return player.getHand().remove(index);
    }


}
