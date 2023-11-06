import java.util.ArrayList;

public class Association {
    
    private Teams teams;
    private Season season;
    private Utils utils = new Utils();
    
    public Association() {
        season = new Season();

    }
System.out.println("Donovan is the GOAT");

        private void exploreTeams() {
            char choice;
            teamOut();
            choice = readChoice(); {
                switch (choice) {
                    case '1' : displayTeams(); break;
                    case '2' : displayPlayers(); break;
                    case '3' : addTeams(); break;
                    case '4' : manageTeams(null); break;
                    case '5' : deleteTeams(); break;
                    case '6' : displayPlayersLevel(null); exploreTeams(); break;
                    case 'R' : assOut(); break;
                    default: teamOut(); break;
                }
            }
        }
        private void displayTeams() {
                teams.printTeam();
                exploreTeams();
            }
        private void displayPlayers() {
            teams.printPlayers();
            exploreTeams();
        }
        private void addTeams() {
            boolean teamAdded = false;
            System.out.print("Please enter the name of the team: ");
            while (!teamAdded) {
                String teamName = readInput();
                if (!teams.doesTeamExist(teamName)) {
                    teams.addTeam(teamName);
                    teamAdded = true;
                } else {
                    System.out.print("Team " + teamName + " already exist! Please enter a new name: ");
                }
            }
            exploreTeams();
        }
        private void deleteTeams() {
            System.out.print("Please enter the team's name that you want to delete: ");
            teams.deleteTeam(In.nextLine());
            exploreTeams();
        }
        private void manageTeams(String teamName) {
            System.out.print("Please enter the team's name that you want to manage: ");
            teamName = In.nextLine();
            if(teams.doesTeamExist(teamName)){
                manageMenu(teamName, teamName);
                
            }
            else {
                System.out.println("Team does not exist!");
                exploreTeams();
            }
        }
        private void manageMenu(String teamName, String playerName) {
            System.out.println("Welcome to the " + teamName + " 's Page! Please make a selection from the menu:");
            manageOut();
            char choice;
            choice = readChoice(); {
                switch (choice) {
                    case '1' : teams.teamPlayers(teamName); manageMenu(teamName, playerName); break;
                    case '2' : addPlayer(teamName); manageMenu(teamName, playerName); break;
                    case '3' : updatePlayer(teamName, playerName); manageMenu(teamName, playerName); break;
                    case '4' : deletePlayer(teamName, playerName); manageMenu(teamName, playerName);break;
                    case 'R' : exploreTeams(); break;
                    default: manageMenu(teamName, playerName); break;
                }
            }
        }
        private void addPlayer(String teamName) {
            teams.addPlayer(teamName);

        }
        private void updatePlayer(String teamName, String playerName) {
            teams.playerName(teamName, playerName);
        }
        private void deletePlayer(String teamName, String playerName) {
            teams.playerNameNo(teamName, playerName);
        }

        private void displayPlayersLevel(String level) {
            System.out.print("Please enter the player's level that you want to view: ");
            level = In.nextLine();
            while (teams.doesLevelExist(level)) {
                teams.isLevel(level);
                break;
            }
               if(!teams.doesLevelExist(level)) {
                    System.out.print("No such level! Please re-enter the level: ");
                    teams.isLevel(In.nextLine());
            }
        }
        //season





        private char readChoice(){
            System.out.print("Enter a choice: ");
            return In.nextChar();
        }
        private String readInput() {
            return In.nextLine();
        }
        
        private void assOut() {
            System.out.println("Welcome to the Association! Please make a selection from the menu:");
            System.out.println("1. Explore the teams.");
            System.out.println("2. Arrange a new season.");
            System.out.println("X. Exit the system.");
        }
        private void teamOut() {
            System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
            System.out.println("1. Display all teams.");
            System.out.println("2. Display all players.");
            System.out.println("3. Add a new team.");
            System.out.println("4. Manage an existing team.");
            System.out.println("5. Delete an existing team.");
            System.out.println("6. Display all players by an level.");
            System.out.println("R. Return to previous menu.");
        }
        private void manageOut() {
            System.out.println("1. Display team's players.");
            System.out.println("2. Add a new player.");
            System.out.println("3. Update an existing player.");
            System.out.println("4. Delete an existing player.");
            System.out.println("R. Return to previous menu.");
        }
        private void seasonOut() {
            System.out.println("Welcome to the season page! Please make a selection from the menu:");
            System.out.println("1. Add a team to the round.");
            System.out.println("2. Display the current round.");
            System.out.println("3. Play games.");
            System.out.println("4. Display the game result records.");
            System.out.println("R. Return to previous menu.");
        }
            private void topMenu(){
            teams = new Teams();
            assOut();
            char choice;
            while ((choice = readChoice()) != 'X') {
                switch (choice) {
                    case '1': exploreTeams(); break;
                    case '2': arrangeSeason(); break;
                    case 'x': error(); assOut(); break;
                    default: assOut(); break;
                }
            }
            System.out.println("Done");
            
        }
        private void arrangeSeason() {
            seasonOut();
            char choice;
            choice = readChoice();
                switch(choice) {
                    case '1' : arrangeTheSeason(); break;
            }
        }
        
        private void arrangeTheSeason() {
            season.arrangeSeason(teams);
        }


        private void error() {
            System.out.println("Please enter a number 1 or 2, or press X to exit.");
        }
        public static void main(String[] args) { 
            new Association().topMenu();
        }
}
