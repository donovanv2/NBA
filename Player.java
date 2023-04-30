public class Player {
    private String name;
    private Double credit;
    private String level;
    private Integer age;
    private String team;
    private Integer No;
    
    public Player(String name, double credit, Integer age, String team, Integer No){
        this.name = name;
        this.credit = credit;
        this.level = level();
        this.age = age;
        this.team = team;
        this.No = No;

        
    }
    public Double getPCredit() {
        return this.credit; 
    }
    public String getPName(){
        return this.name;
    }
    public void setPTeam(String team) {
        this.team = team;
        
    }
    public int getAge() {
        return this.age;
    }
    public int getNo() {
        return this.No;
    }
    public String getTeam() {
        return this.team;
    }
    public void setName(String pName) {
        this.name = pName;
    }
    public void setCredit(double credScore) {
        this.credit = credScore;
    }
    public void setAge(Integer ageIn) {
        this.age = ageIn;
    }
    public void setNo(Integer noIn) {
        this.No = noIn;
    }



    public String level() {
        if(credit < 1000 && credit > 0) {
            return "Edge";
        }
        else if(credit >= 1000 && credit < 1500) {
            return "Common";
        }
        else if (credit >= 1500 && credit < 2000) {
            return "Core";
        }
        else {
            return "All Star";
        }
    }

}
