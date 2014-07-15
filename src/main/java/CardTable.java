/**
 * Created by minh on 7/15/14.
 * CardTable can hold 4 players
 * Contain the logic for the game
 */

public class CardTable {

    private Player[] players;
    private int[] cardDeck;

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

    // TODO
    public void shuffer(){

    }

}
