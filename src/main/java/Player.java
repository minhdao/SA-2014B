/**
 * Created by minh on 7/15/14.
 */

import java.util.ArrayList;

/**
 * Instance of this class represents a real life player
 * Each player is a thread and should be carefully manage TODO
 **/

public class Player {

    private String name;
    private ArrayList<Integer> cardDeck;
    private ArrayList<Integer> playingCards;
    private boolean isPlaying;
    private boolean isDone;
    private boolean isWaiting;

    public Player(String name){
        this.name = name;
        cardDeck = new ArrayList<Integer>();
        playingCards = new ArrayList<Integer>();
    }
}
