import java.util.ArrayList;
public class Team {
    private String name;
    private Players players;
    public Team(String name, Players players){
        this.name = name;
        this.players = players;
    }
    
    public String getTName() {
        return this.name;
    }
    public String displayTeams() {
        return "";
    }
    public Players getPlayer() {
        return this.players;
    }
    public int getTSize() {
        return this.players.size();
    }


    public double creditSum() {
        double sum = 0.0;
        ArrayList<Player> teamPlayers = players.getPlayers();
        for(Player player : teamPlayers) {
            sum += player.getPCredit();

        }
        return sum;
    }
    public double avgTCredit() {
        if (getTSize() == 0) {
            return 0.0;
        }
        return creditSum() / getTSize();
    }
    public double ageSum() {
        double sum = 0;
        ArrayList<Player> teamPlayers = players.getPlayers();
        for(Player player : teamPlayers) {
            sum += player.getAge();
        }
        return sum;
    }
    public double avgAge() {
        if (getTSize() == 0) {
            return 0.0;
        }
        return ageSum() /getTSize();
    }
    
    

}
