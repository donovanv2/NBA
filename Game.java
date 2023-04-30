import java.util.ArrayList;
public class Game
{
    private ArrayList<Team> teams;
    private String result;
    private ArrayList<Team> results;
    public Integer term;
    public Game(){
        teams = new ArrayList<>();


    }
    public void setTeams(Team team1, Team team2) {
        teams.add(team1);
        teams.add(team2);
    }
    

}