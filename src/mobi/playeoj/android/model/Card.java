package mobi.playeoj.android.model;

public class Card {
    private int number;
    private String title;
    private String set;
    private String element;
    private String race;    
    private String summoning_cost;
    private String activation_cost;
    private String health_points;
    private String attack;
    private String rarity;
    private String body;
    private String affiliation;
    private String attack_direction;
    private String defence_direction;
    private String limit;
    
    /**
     * Custom generator that initializes all properties.
     */
    public Card(int number, String title, String set, String element, String race, String summoning_cost, String activation_cost,
		String health_points, String attack, String rarity, String body, String affiliation, String attack_direction, 
		String defence_direction, String limit) {
	this.number = number;
	this.title = title;
	this.set = set;
	this.element = element;
	this.race =     race;
	this.summoning_cost = summoning_cost;
	this.activation_cost = activation_cost;
	this.health_points = health_points;
	this.attack = attack;
	this.rarity = rarity;
	this.body = body;
	this.affiliation = affiliation;
	this.attack_direction = attack_direction;
	this.defence_direction = defence_direction; 
	this.limit = limit; 
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSet() {
        return set;
    }
    public void setSet(String set) {
        this.set = set;
    }
    public String getElement() {
        return element;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public String getSummoning_cost() {
        return summoning_cost;
    }
    public void setSummoning_cost(String summoning_cost) {
        this.summoning_cost = summoning_cost;
    }
    public String getActivation_cost() {
        return activation_cost;
    }
    public void setActivation_cost(String activation_cost) {
        this.activation_cost = activation_cost;
    }
    public String getHealth_points() {
        return health_points;
    }
    public void setHealth_points(String health_points) {
        this.health_points = health_points;
    }
    public String getAttack() {
        return attack;
    }
    public void setAttack(String attack) {
        this.attack = attack;
    }
    public String getRarity() {
        return rarity;
    }
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getAffiliation() {
        return affiliation;
    }
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }
    public String getAttack_direction() {
        return attack_direction;
    }
    public void setAttack_direction(String attack_direction) {
        this.attack_direction = attack_direction;
    }
    public String getDefence_direction() {
        return defence_direction;
    }
    public void setDefence_direction(String defence_direction) {
        this.defence_direction = defence_direction;
    }
    public String getLimit() {
        return limit;
    }
    public void setLimit(String limit) {
        this.limit = limit;
    }
}
