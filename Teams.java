import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Teams {
    public ArrayList<Team> teams;
    public Teams(){
        teams = new ArrayList<>();
        
        

        Players sunsPlayers = new Players();
        sunsPlayers.addPlayer(new Player("Devin Booker", 2500.0, 26, "Suns", 1));
        sunsPlayers.addPlayer(new Player("Chris Paul", 1500.0, 37, "Suns", 3));
        sunsPlayers.addPlayer(new Player("Deandre Ayton", 2000.0, 24, "Suns", 22));
        sunsPlayers.addPlayer(new Player("Kevin Durant", 3000.0, 34, "Suns", 35));
        sunsPlayers.addPlayer(new Player("Terrence Ross", 1000.0, 32, "Suns", 8));
        Team suns = new Team("Suns", sunsPlayers);

        Players bullsPlayers = new Players();
        bullsPlayers.addPlayer(new Player("Andre Drummond", 1500.0, 29, "Bulls", 3));
        bullsPlayers.addPlayer(new Player("Zach LaVine", 3000.0, 28, "Bulls", 8));
        bullsPlayers.addPlayer(new Player("Dalen Terry", 900.0, 20, "Bulls", 25));
        bullsPlayers.addPlayer(new Player("Terry Taylor", 1000.0, 23, "Bulls", 32));
        bullsPlayers.addPlayer(new Player("Carlik Jones", 800.0, 25, "Bulls", 22));
        Team bulls = new Team("Bulls", bullsPlayers);

        Players hawksPlayers = new Players();
        hawksPlayers.addPlayer(new Player("Trae Young", 2200.0, 24, "Hawks", 11));
        hawksPlayers.addPlayer(new Player("John Collins", 2000.0, 25, "Hawks", 20));
        hawksPlayers.addPlayer(new Player("Aaron Holiday", 800.0, 26, "Hawks", 3));
        hawksPlayers.addPlayer(new Player("Jalen Johnson", 1000.0, 21, "Hawks", 1));
        hawksPlayers.addPlayer(new Player("Trent Forrest", 1200.0, 24, "Hawks", 2));
        Team hawks = new Team("Hawks", hawksPlayers);

        Players netsPlayers = new Players();
        netsPlayers.addPlayer(new Player("Mikal Bridges", 2400.0, 26, "Nets", 1));
        netsPlayers.addPlayer(new Player("Ben Simmons", 2000.0, 26, "Nets", 10));
        netsPlayers.addPlayer(new Player("Patty Mills", 900.0, 34, "Nets", 8));
        netsPlayers.addPlayer(new Player("Joe Harris", 1200.0, 31, "Nets", 12));
        netsPlayers.addPlayer(new Player("Seth Curry", 1900.0, 32, "Nets", 30));
        Team nets = new Team("Nets", netsPlayers);
        
        teams.add(suns);
        teams.add(bulls);
        teams.add(hawks);
        teams.add(nets);
        


    }
    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void printTeam() {
        Utils.teamsHeader();
        for(Team team : teams) {
            String teamName = team.getTName();
            int numOfPlayers = team.getTSize();
            double averageCredit = team.avgTCredit();
            double avgAge = team.avgAge();
            System.out.format(Utils.teamsFormat, teamName, numOfPlayers, averageCredit, avgAge);
        }
        Utils.teamTableEnd();
    }
    public void printPlayers() {
        Utils.DisplayPlayerFromAllTeamsHeader();
        for(Team team : teams) {
            for(Player player: team.getPlayer().getPlayers()) {
                String playerName = player.getPName();
                double playerCredit = player.getPCredit();
                String playerLevel = player.level();
                int playerNum = player.getNo();
                int playerAge = player.getAge();
                String playerTeam = player.getTeam();

                System.out.format(Utils.DisplayPlayerFromAllTeamsFormat, playerName, playerCredit, playerLevel, playerAge, playerNum, playerTeam);
        }
        Utils.DisplayPlayerFromAllTeamsEnd();
    }
    }
    public boolean doesTeamExist(String teamName) {
        for(Team team : teams) {
            if(teamName.equals(team.getTName())){
                return true;
            } 
        }
        return false;
    }

    public void addTeam(String teamName) {
        if (!doesTeamExist(teamName)) {
            System.out.println("Team " + teamName + " added!");
            Team newTeam = new Team(teamName, new Players());
            teams.add(newTeam);
        } else {
            System.out.println("Team " + teamName + " already exists!");
        }
    }
    public void deleteTeam(String teamName) {
        Team teamToRemove = null;
        for(Team team : teams){
            if(teamName.equals(team.getTName())) {
                teamToRemove = teamToRemove;
                teams.remove(team);
                System.out.println("The team " + teamName + " has been deleted.");
                break;
                
            }
        }   
    }
    public void teamPlayers(String teamName) {
        Utils.playerHeader();
        for(Team team : teams) {
            for(Player player: team.getPlayer().getPlayers()) {
                if(teamName.equals(player.getTeam())) {
                    String playerName = player.getPName();
                    double playerCredit = player.getPCredit();
                    String playerLevel = player.level();
                    Integer playerNum = player.getNo();
                    Integer playerAge = player.getAge();

                    System.out.format(Utils.PlayerFormat, playerName, playerCredit, playerLevel, playerNum, playerAge);

                }
            }
        }
        Utils.playerTableEnd();
    }
    public boolean doesLevelExist(String level) {
        for(Team team : teams) {
            for(Player player: team.getPlayer().getPlayers()) {
            if(level.equals(player.level())){
                return true;
            } 
        }
    }  
    return false;    
    }
    
    public void isLevel(String level) {
        Utils.DisplayPlayerFromAllTeamsHeader();
        for(Team team : teams) {
            for(Player player : team.getPlayer().getPlayers()) {
                String playerLevel = player.level();
                String playerName = player.getPName();
                double playerCredit = player.getPCredit();
                Integer playerNum = player.getNo();
                Integer playerAge = player.getAge();
                String playerTeam = player.getTeam();
                if(playerLevel.equals(level)) {
                    System.out.format(Utils.DisplayPlayerFromAllTeamsFormat, playerName, playerCredit, playerLevel, playerAge, playerNum, playerTeam);
                    
                }

            }
        }
        Utils.DisplayPlayerFromAllTeamsEnd();
    }
    public boolean doesNoExist(int No, String teamName) {
        for(Team team : teams) {
            for(Player player : team.getPlayer().getPlayers()) {
                if(teamName.equals(player.getTeam()) && player.getNo() == No) {

                    return false;
                }
                
            }
            
        }
        return true;
    }

    public void addPlayer(String teamName) {
        for (Team team : teams) {
            if (teamName.equals(team.getTName())) {
                System.out.print("Please enter the player's name: ");
                String playerIn = In.nextLine();
                System.out.print("Please enter the player's credit: ");
                double pCredit = In.nextDouble();
                System.out.print("Please enter the player's age: ");
                int pAge = In.nextInt();
                System.out.print("Please enter the player's No: ");
                int pNo = In.nextInt();

                while (!doesNoExist(pNo, teamName)) {
        
                    
                    if (!doesNoExist(pNo, teamName)) {
                        System.out.print("This No has been occupied by: " + getPlayerNo(pNo, teamName) + ". Please re-enter the No: ");
                        pNo = In.nextInt();
                    }
                }

                Player newPlayer = new Player(playerIn, pCredit, pAge, teamName, pNo);
                team.getPlayer().addPlayer(newPlayer);
                System.out.println("Player " + playerIn + " added!");
                break;
            }
        }
    }

                

    public String getPlayerNo(Integer pNo, String teamName) { 
        for(Team team : teams) {
            for(Player player : team.getPlayer().getPlayers()) {
                if(teamName.equalsIgnoreCase(player.getTeam())) {
                    if(player.getNo() == pNo) {
                        return player.getPName();
                    }
                }
            }
        }  
    return null;
    }

    public void playerName(String teamName, String playerName) {
        System.out.print("Please enter the player's name: ");
        playerName = In.nextLine();    
        if(doesPExist(teamName, playerName)) {
            updatePlayer(teamName, playerName);
        }
        else {
            System.out.println("Player does not exist.");
        }
    }

    public void updatePlayer(String teamName, String playerName) {
        for(Team team : teams) {
            for(Player player : team.getPlayer().getPlayers()) {
                if (teamName.equalsIgnoreCase(player.getTeam()) && player.getPName().equalsIgnoreCase(playerName)) {
                    System.out.print("Please enter the name: ");
                    String pName = In.nextLine();    
                    System.out.print("Please enter the credit: ");
                    double credScore = In.nextDouble();
                    System.out.print("Please enter the age: ");
                    int ageIn = In.nextInt();
                    System.out.print("Please enter the No: ");
                    int noIn = In.nextInt();
        
                    
                        while (!doesNoExist(noIn, teamName)) {
                            System.out.print("This No has been occupied by: " + getPlayerNo(noIn, teamName) + ". Please re-enter the No: ");
                            noIn = In.nextInt();
                    }
                    player.setName(pName);
                    player.setCredit(credScore);
                    player.setAge(ageIn);
                    player.setNo(noIn);

                    System.out.println("Player information updated.");
                }
            }
        }
    }
    
    public void removePlayer(String teamName, String playerName) {
        for(Team team : teams) {
                List<Player> players = team.getPlayer().getPlayers();
                for (int i = 0; i < players.size(); i++) {
                    Player player = players.get(i);
                    if (teamName.equalsIgnoreCase(player.getTeam()) && player.getPName().equalsIgnoreCase(playerName)) {
                        if(getPNo(teamName, playerName) != -1) {
                            players.remove(i);
                            System.out.println("Player deleted.");
                            break;
                    }
                }
            }
        }
    }
    //             if (teamName.equalsIgnoreCase(player.getTeam()) && player.getPName().equalsIgnoreCase(playerName)) {
    //                 playerName = player.getPName();
    //                 if(getPNo(teamName, playerName) != -1) {
    //                     teams.remove(getPNo(teamName, playerName));
    //                     System.out.println("Player deleted.");
    //                 break;
    //                 }
    //             }
                
    //         }
    //         break;   
    //     }
    // }
    public int getPNo(String teamName, String playerName) { 
        for(Team team : teams) {
            for(Player player : team.getPlayer().getPlayers()) {
                if (teamName.equalsIgnoreCase(player.getTeam()) && playerName.equalsIgnoreCase(player.getPName())) {
                    return player.getNo();
                    }
                }
            }  
    return -1;
    }
    public void playerNameNo(String teamName, String playerName) {
        System.out.print("Please enter the player's name: ");
        playerName = In.nextLine();    
        if(doesPExist(teamName, playerName)) {
            removePlayer(teamName, playerName);
        }
        else {
            System.out.println("Player does not exist.");
        }
    }


    public boolean doesPExist(String teamName, String playerName) {
        for(Team team : teams) {
            for(Player player : team.getPlayer().getPlayers()) {
                if (teamName.equalsIgnoreCase(player.getTeam()) && player.getPName().equalsIgnoreCase(playerName)) {
                    return true;
            }
        }
    }
        return false;
    }
    public void currentTeams() {
        System.out.println("The existing teams are as follows:");
        for(Team team : teams) {
            System.out.print(team.getTName() + " ");
        }
        System.out.println();
    }

}