public class Warrior extends Character {
    private String weaponType,armorType;
    private int healthLock;

    protected Warrior(String characterID, String characterName, int level, int health,String weaponType,String armorType){
        super(characterID, characterName, level, health);
        this.weaponType=weaponType;
        this.armorType=armorType;
    }

    public String getWeaponType() {
        return weaponType;
    }
    public String getArmorType() {
        return armorType;
    }
    public void setWeaponType(String weapon) {
        this.weaponType = weapon;
    }
    public void setArmorType(String armor) {
        this.armorType = armor;
        shieldBlock();
    }
    public int getHealthLock() {
        return healthLock;
    }

    public void chargeAttack(Character target){
        if(target.getHealthLock()==0){
            int damage=0;
            if(weaponType.equalsIgnoreCase("sword")){
                damage=50;
            }else if(weaponType.equalsIgnoreCase("dagger")){
                damage=20;
            }else if(weaponType.equalsIgnoreCase("crossbow")){
                damage=50;
            }else if(weaponType.equalsIgnoreCase("staff")){
                damage=10;
            };//end if

            if(target.getLevel()>5){
                target.setHealth(target.getHealth()-damage);
            }else if(target.getLevel()<=5&&target.getLevel()>0){
                target.setHealth(target.getHealth()-(damage/2));
            };//end if
            System.out.println("!Attack Success!");
        }else{
            System.out.println("⌜\n["+target.getCharacterName()+" was in Protected State]\nAttack Failed!\n\t\t\t\t\t\t⌟");
        };//end if
    }//end charge ATTACK

    public void shieldBlock(){
        if(armorType.equalsIgnoreCase("shield")){
            System.out.println(super.getCharacterName()+"\tis raising its shield. ");
            this.healthLock=1;
        }else if(armorType.equalsIgnoreCase("gauntlet")){
            System.out.println(super.getCharacterName()+"\tis raising its gauntlets. ");
            this.healthLock=0;
        }else if(armorType.equalsIgnoreCase("helmet")){
            System.out.println(super.getCharacterName()+"'s head is protected. ");
            this.healthLock=0;
        }else {
            System.out.println(super.getCharacterName()+"\tI hope you're protected...somehow. ");
            this.healthLock=0;
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
                if(getSkills().size()>1){
                    info+="\n"+count+")Skill Name: "+skill.getSkillName()+"\tSkill Description: "+skill.getSkillDescription();
                    count++;
                }else{
                    info+="\nSkill Name: "+skill.getSkillName()+"\nSkill Description: "+skill.getSkillDescription();
                }//end if
            }//end for loop
        }//end if

        info+="\nCurrent Armor Type: "+getArmorType()+"\nCurrent Weapon Type: "+getWeaponType();
        return info;

    }
    
}
