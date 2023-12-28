import java.util.ArrayList;

public class Character {
    private String characterID,characterName;
    private int level,health,healthLock;;
    private ArrayList<Player> players;
    private ArrayList<Skill> skills;

    protected Character(){
        this.characterID="Default ID";
        this.characterName="Default Name";
        this.health=100;
        this.level=1;
        this.players=new ArrayList<Player>();
        this.skills=new ArrayList<Skill>();
    }
    protected Character(String characterID,String characterName,int level,int health){
        this.characterID=characterID;
        this.characterName=characterName;
        this.level=level;
        this.health=health;
        this.players=new ArrayList<Player>();
        this.skills=new ArrayList<Skill>();
    }

    public String getCharacterID() {
        return characterID;
    }
    public String getCharacterName() {
        return characterName;
    }
    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public ArrayList<Skill> getSkills() {
        return skills;
    }
    public int getHealthLock() {
        return healthLock;
    }
    public void addSkill(Skill c) {
        this.skills.add(c);
    }
    public void removeSkill(Skill c) {
        this.skills.remove(c);
    }
    public void setCharacterID(String id) {
        this.characterID = id;
    }
    public void setCharacterName(String name) {
        this.characterName = name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public void levelUp(){
        this.level+=1;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        
        info.append("Character ID: ").append(characterID).append("\n");
        info.append("Character Name: ").append(characterName).append("\n");
        info.append("Character Level: ").append(level).append("\n");
        info.append("Character Health: ").append(health).append("\n");

        if (players != null && !players.isEmpty()) {
            info.append("Player Details: \n");
            for (Player player : players) {
                info.append("\tPlayer ID is ").append(player.getPlayerID()).append("\tPlayer Name is ").append(player.getPlayerName()).append("\n");
            }
        } else {
            Player defaultPlayer = new Player();
            info.append("Player Details: \n");
            info.append("\tPlayer ID is ").append(defaultPlayer.getPlayerID()).append("\tPlayer Name is ").append(defaultPlayer.getPlayerName()).append("\n");
        }
    
        if (skills != null && !skills.isEmpty()) {
            info.append("Character Skills: \n");
            for (Skill skill : skills) {
                info.append("\tSkill Name is ").append(skill.getSkillName()).append("\tSkill Description is ").append(skill.getSkillDescription()).append("\n");
            }
        } else {
            Skill defaultSkill = new Skill();
            info.append("Character Skills: \n");
            info.append("\tSkill Name is ").append(defaultSkill.getSkillName()).append("\tSkill Description is ").append(defaultSkill.getSkillDescription()).append("\n");
        }
    

        return info.toString();
    }
}
