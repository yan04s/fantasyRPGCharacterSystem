public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("01","Player1");
        Player player2 = new Player("02","Player2");

        Character Gideon=new Warrior("GS001", "Gideon Stoneheart", 5, 100,"Sword","Chainmail");
        Character Elara=new Mage("EF001", "Elara Frostweaver", 1, 100,"Ice");
        Character Darian=new Rogue("DW001","Darian Whisperwind",10,100,15,"Shuriken");

        Skill whirlwindSlash = new Skill("Whirlwind Slash", "A powerful slashing attack that hits multiple enemies.");
        Skill dualWielding = new Skill("Dual Wielding", "The ability to fight with two weapons simultaneously.");
        Skill frostNova = new Skill("Frost Nova", "Unleashes a burst of cold energy, freezing nearby enemies.");
        Skill lockpicking = new Skill("Lockpicking", "Skillful manipulation of locks and mechanisms.");

        Gideon.addSkill(whirlwindSlash);
        Gideon.addSkill(dualWielding);

        // Assign skill to Elara
        Elara.addSkill(frostNova);

        // Assign skill to Darian
        Darian.addSkill(lockpicking);

        player1.addCharacter(Gideon);
        player1.addCharacter(Elara);
        player2.addCharacter(Darian);

        Gideon.addPlayer(player1);
        Elara.addPlayer(player1);
        Darian.addPlayer(player2);

        System.out.println("::Attack Statement::");
        ((Warrior) Gideon).chargeAttack(Darian);
        System.out.println("-----------------------");
        ((Mage) Elara).castElementalSpell("Teleportation");
        System.out.println("-----------------------");
        ((Rogue) Darian).stab(Gideon);
        System.out.println("-----------------------");
        ((Warrior) Gideon).shieldBlock();
        System.out.println("-----------------------");
        ((Rogue) Darian).evade();
        System.out.println("-----------------------\n");

        //I have extra set the healthLock method,which prevent the attack. 
        ((Warrior) Gideon).chargeAttack(Darian);//will not affect health, due to already evade
        System.out.println("-----------------------\n");
        ((Warrior) Gideon).setArmorType("shield");//((Warrior) Gideon).shieldBlock(); //run again shieldBlock() is not require, after setArmorType will auto switch shieldBlock Type 
        System.out.println("-----------------------\n");
        ((Rogue) Darian).stab(Gideon);//will not affect health, due to already shieldBlock
        System.out.println("-----------------------\n");

        System.out.println("::Character Statement::");
        Character h=new Character();
        System.out.println("#Default Statement::\n"+h+"\n");
        System.out.println("1)Gideon Statement::"+Gideon+"\n");
        System.out.println("2)Elara Statement::"+Elara+"\n");
        System.out.println("3)Darian Statement::"+Darian+"\n");

        
        /*from Character.java direct add:: SKILL, PLAYER through skill and player's instance*/
        Skill swordSkill = new Skill("Sword Mastery", "Mastering the art of wielding a sword");
        Player player = new Player("P001", "Player One");
        h.addSkill(swordSkill);
        h.addPlayer(player);

        // Print
        System.out.println("\n\nDirect add and get Character's Skill and Player::");
        System.out.println(h);
        /*END*/


        /*Player.java direct add: CHARACTER AND SKILL through character's instance*/
        Player w=new Player();
        Character a=new Character("aID is here","I am Character A",1,100);
        a.addSkill(swordSkill);
        //w.addCharacter(h);
        w.addCharacter(a);

        // Print
        System.out.println("\n\nDirect add and get Player's Character and Skill::");
        System.out.println(w);
        for (Character character : w.getCharacters()) {//loop the all character(s) added into w 
            //System.out.println("Character ID: " + character.getCharacterID());
            for (Skill skill : character.getSkills()) {//then,loop current character's skill //Iterating over each skill associated with the current character
                System.out.println("Character Skills: \n\tSkill Name: " + skill.getSkillName() + "\tDescription: " + skill.getSkillDescription());
            }
        }
        /*END*/
        
    }
}
