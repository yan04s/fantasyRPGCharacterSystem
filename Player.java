import java.util.ArrayList;

public class Player {
    private String playerID,playerName;
    private ArrayList<Character> characters;

    protected Player(){
        this.playerID="Default Player ID";
        this.playerName="Default Player Name";
        this.characters=new ArrayList<Character>();
    }

    protected Player(String playerID,String playerName){
        this.playerID=playerID;
        this.playerName=playerName;
        this.characters=new ArrayList<Character>();
    }

    public String getPlayerID() {
        return playerID;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerID(String id) {
        this.playerID = id;
    }
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    public ArrayList<Character> getCharacters() {
        return characters;
    }
    public void addCharacter(Character character){
        characters.add(character);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        
        info.append("Player ID: ").append(playerID).append("\n");
        info.append("Player Name: ").append(playerName).append("\n");
        

        if (characters != null && !characters.isEmpty()) {
            info.append("Character Details: \n");
            for (Character character : characters) {
                info.append("\tCharacter ID: ").append(character.getCharacterID()).append("\tCharacter Name: ").append(character.getCharacterName()).append("\tCharacter Level: ").append(character.getLevel()).append("\tCharacter Health: ").append(character.getHealth());
            }
        } else {
            Character defaultCharacter = new Character();
            info.append("Character Details: \n");
            info.append("\tCharacter ID: ").append(defaultCharacter.getCharacterID()).append("\tCharacter Name: ").append(defaultCharacter.getCharacterName()).append("\tCharacter Level: ").append(defaultCharacter.getLevel()).append("\tCharacter Health: ").append(defaultCharacter.getHealth());
        }
    
        
    

        return info.toString();
    }


}