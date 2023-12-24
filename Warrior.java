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
    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
    public void setArmorType(String armorType) {
        this.armorType = armorType;
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
        String info ="\nCharacter ID: " + super.getCharacterID() + "\nCharacter Name: " + super.getCharacterName()+"\nCharacter Level: "+super.getLevel()+"\nCharacter Health: "+super.getHealth()+"\nCharacter Skills: "+super.getSkills();

        info+="\nCurrent Armor Type: "+getArmorType()+"\nCurrent Weapon Type: "+getWeaponType();
        return info;

    }
    
}
