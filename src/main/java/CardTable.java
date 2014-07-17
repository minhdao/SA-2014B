import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by minh on 7/15/14.
 * CardTable can hold 4 players
 * Contain the logic for the game
 */

public class CardTable {

    private Player[] players;
    private ArrayList<Integer> cardDeck = new ArrayList<Integer>();

    public CardTable(){
        players = new Player[4];
    }

    // add player into the players array
    public void addPlayer(Player player){
        for (int i =0; i<players.length; i++){
            if (players[i]==null){
                players[i] = player;
            }
        }
    }

    public void shuffer(){
        for (int i = 3; i <= 15; i++){
            int temp = i*10;
            for(int j = 0; j < 4; j++){
                cardDeck.add(temp + j);
            }
        }
        Collections.shuffle(cardDeck);
        int count = 0;
        for (int i = 0; i < 52; i++){
            System.out.print(cardDeck.get(i)+"            ");
            count++;
            if (count % 4 == 0){
                System.out.println();
            }
        }
    }
}
