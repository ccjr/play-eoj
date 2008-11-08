package mobi.playeoj.android.model;

public class Definition {
    private String name;
    private String description;
    
    public static final Definition ATTACK = new Definition("Attack", "attack is good");
    public static final Definition DEFENSE = new Definition("Defense", "defence hurts");

    public static final Definition[] ALL_DEFINITIONS = { ATTACK, DEFENSE };
    public static final String[] ALL_DESCRIPTIONS = {"Attack", "Defense"};
    
    public Definition(String name, String description) {
	this.name = name;
	this.description = description;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }    
}
