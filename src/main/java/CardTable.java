import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by minh on 7/15/14.
 * CardTable can hold 4 players
 * Contain the logic for the game
 */

public class CardTable {

    private ArrayList<Player> players;
    private ArrayList<Integer> cardDeck = new ArrayList<Integer>();

    public CardTable(){
        players = new ArrayList<Player>();
    }

    // add player into the players array
    public void addPlayer(Player player){
        players.add(player);
    }

    public void shuffer(){
        for (int i = 1; i <= 52; i++){
            cardDeck.add(i);
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

    public int getPlayerNumber(){
        return players.size();
    }
}
