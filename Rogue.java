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
    public void setStealthLevel(int stealthLevel) {
        this.stealthLevel = stealthLevel;
        evade();
    }
    public void setDaggerType(String daggerType) {
        this.daggerType = daggerType;
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
        String info ="\nCharacter ID: " + super.getCharacterID() + "\nCharacter Name: " + super.getCharacterName()+"\nCharacter Level: "+super.getLevel()+"\nCharacter Health: "+super.getHealth()+"\nCharacter Skills: "+super.getSkills();

        info+="\nCurrent Dagger Type: "+getDaggerType()+"\nCurrent Stealth Level: "+getStealthLevel();
        return info;

    }

}
