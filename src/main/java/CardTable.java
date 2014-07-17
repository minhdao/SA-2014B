import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by minh on 7/15/14.
 * CardTable can hold 4 players
 * Contain the logic for the game
 */

public class CardTable {

    private int count = 0;
    private ArrayList<Player> players;
    private ArrayList<Integer> cardDeck = new ArrayList<Integer>();

    public CardTable(){
        players = new ArrayList<Player>();
    }

    // add player into the players array
    public void addPlayer(Player player){

        if (players.size() < 4){
            players.add(player);
            players.get(count).run();
            count++;
        }

        if (count == 4){
            startGame();
        }
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

    private void startGame(){
        while (true){
            players.get(0).writeToClient();
        }
    }

    public int getPlayerNumber(){
        return players.size();
    }
}
