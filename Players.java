import java.lang.reflect.Array;
import java.util.ArrayList;

public class Players {
    ArrayList<Player> players;
    public Players(){
        
        players = new ArrayList<>();

    }
    public void remove(Player player) {
       players.remove(player);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    public int size() {
        return players.size();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    


}
