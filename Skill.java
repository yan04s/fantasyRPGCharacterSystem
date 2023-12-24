public class Skill {
    private String skillName,skillDescription;

    protected Skill(){
        this.skillName="Default Skill Name";
        this.skillDescription="Default Skill Description";
    }

    protected Skill(String skillName,String skillDescription){
        this.skillName=skillName;
        this.skillDescription=skillDescription;
    }
    public String getSkillName() {
        return skillName;
    }
    public String getSkillDescription() {
        return skillDescription;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    @Override
    public String toString() {
        return "Skill Name: " + skillName + ", Description: " + skillDescription;
    }
}
