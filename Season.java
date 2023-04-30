import java.util.ArrayList;
public class Season {
    private ArrayList<Game> schedule;
    private ArrayList<Team> currentTeamList;

    private ArrayList<Record>  records;

    public Season(){
        currentTeamList = new ArrayList<>();
        schedule = new ArrayList<>();


    }
    public void currentTeamList(Teams teams) {
        currentTeamList.addAll(teams.getTeams());
    }
    public ArrayList<Team> getTeams() {
        return currentTeamList;
    }
    public Team getTeamByName(String name) {
        for (Team team : currentTeamList) {
            if (team.getTName().equals(name)) {
                return team;
            }
        }
        return null;
    }
    public void arrangeSeason(Teams teams) {
        int gamesScheduled = 0;
        do{
            teams.currentTeams();
            System.out.print("Please enter the team's name that you want to schedule: ");
            String team1Name = In.nextLine();
            System.out.print("Please enter the team's name that you want to schedule: ");
            String team2Name = In.nextLine();
            Team team1 = getTeamByName(team1Name);
            Team team2 = getTeamByName(team2Name);
            Game game1 = new Game();
            game1.setTeams(team1, team2);
            schedule.add(1, game1);
            currentTeamList.remove(team1);
            currentTeamList.remove(team2);
            gamesScheduled++;
        }
            while (gamesScheduled == currentTeamList.size()/2);
            }
        }
    
