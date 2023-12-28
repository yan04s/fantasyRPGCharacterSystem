public class Rogue extends Character {
    private int stealthLevel;
    private String daggerType;
    private int healthLock;

    protected Rogue(String characterID, String characterName, int level, int health,int stealthLevel,String daggerType){
        super(characterID, characterName, level, health);
        this.stealthLevel=stealthLevel;
        this.daggerType=daggerType;
    }

    public int getStealthLevel() {
        return stealthLevel;
    }
    public String getDaggerType() {
        return daggerType;
    }
    public int getHealthLock() {
        return healthLock;
    }
    public static boolean isNumeric(String str) {
        // Use regular expression to check if the string consists of only numeric characters
        return str.matches("\\d+");
    }
    public void setStealthLevel(String level) {
        if (isNumeric(level)) {
            this.stealthLevel = Integer.parseInt(level);
            evade();
        }else{
            System.out.println("[Set Stealth Level FAILED]\n!!Please input integer level!!");
        }
    }
    public void setDaggerType(String type) {
        this.daggerType = type;
    }
    public void stab(Character target){
        if(target.getHealthLock()==0){
            if(target.getLevel()>=1&&target.getLevel()<=3){
                target.setHealth(target.getHealth()-10);
            }else if(target.getLevel()>=4&&target.getLevel()<=5){
                target.setHealth(target.getHealth()-15);
            }else if(target.getLevel()>5){
                target.setHealth(target.getHealth()-20);
            };//end if
            System.out.println("!Attack Success!");
        }else{
            System.out.println("⌜\n["+target.getCharacterName()+" was in Protected State]\nAttack Failed!\n\t\t\t\t\t\t⌟");
        };//end if
    }
    public void evade(){
        if(getStealthLevel()<5&&getStealthLevel()>0){
            System.out.println("Stealth Level: "+getStealthLevel()+"\n[You must reach at least stealth level 5 to evading attacks]");
            this.healthLock=0;
        }else if(getStealthLevel()>=5){
            System.out.println("Stealth Level: "+getStealthLevel()+"\tCharacter Name: "+super.getCharacterName()+"\n[Successfully Evaded Incoming Attack]");
            this.healthLock=1;
        };//end if
    }

    @Override
    public String toString() {
        String info="";

        if(!(getPlayers().isEmpty())){
            for (Player player : getPlayers()) {
                info+="\nPlayer ID is "+player.getPlayerID()+"\nPlayer Name is "+player.getPlayerName();
            }
        }

        info +="\nCharacter ID: " + super.getCharacterID() + "\nCharacter Name: " + super.getCharacterName()+"\nCharacter Level: "+super.getLevel()+"\nCharacter Health: "+super.getHealth();//+"\nCharacter Skills: "+super.getSkills();

        if(!(getSkills().isEmpty())){
            info+="\nCharacter Skills: ";
            int count=1;
            for (Skill skill : getSkills()) {
                if(getSkills().size()>=2){
                    info+="\n"+count+"Skill Name: "+skill.getSkillName()+"\tSkill Description: "+skill.getSkillDescription();
                    count++;
                }else{
                    info+="\nSkill Name: "+skill.getSkillName()+"\nSkill Description: "+skill.getSkillDescription();
                }//end if
            }//end for loop
        }//end if

        info+="\nCurrent Dagger Type: "+getDaggerType()+"\nCurrent Stealth Level: "+getStealthLevel();
        return info;

    }

}
