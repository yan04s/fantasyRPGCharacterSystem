public class Mage extends Character {
    private String elementalAffinity;
    private int healthLock;

    protected Mage(String characterID, String characterName, int level, int health,String elementalAffinity){
        super(characterID, characterName, level, health);
        this.elementalAffinity=elementalAffinity;
    }

    public String getElementalAffinity() {
        return elementalAffinity;
    }
    public int getHealthLock() {
        return healthLock;
    }
    public void setElementalAffinity(String elementalAffinity) {
        this.elementalAffinity = elementalAffinity;
    }
    public void castElementalSpell(String spellType){
        if(super.getLevel()<5&&super.getLevel()>0){
            System.out.println("Level "+super.getLevel()+" is not support to cast Elemental Spell!! \n[You should reach at least Level 5 to unlock Elemental Spell]");
            this.healthLock=0;
        }else if(super.getLevel()>=5){
            if(spellType.equalsIgnoreCase("teleportation")){
                System.out.println("Teleporting "+super.getCharacterName()+" out of danger!");
                this.healthLock=1;
            }else if(spellType.equalsIgnoreCase("illusion")){
                System.out.println(super.getCharacterName()+" is creating illusions to confuse the enemy. ");
                this.healthLock=1;
            }else if(spellType.equalsIgnoreCase("detection")){
                System.out.println(super.getCharacterName()+" is detecting the presence of magic nearby... ");
                this.healthLock=0;
            }//end if
        };//end if
    }//end of cast ELEMENTAL SPELL

    @Override
    public String toString() {
        String info ="\nCharacter ID: " + super.getCharacterID() + "\nCharacter Name: " + super.getCharacterName()+"\nCharacter Level: "+super.getLevel()+"\nCharacter Health: "+super.getHealth()+"\nCharacter Skills: "+super.getSkills();

        info+="\nCurrent Elemental Affinity: "+getElementalAffinity();
        return info;

    }
}
