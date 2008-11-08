package mobi.playeoj.android.model;

import java.util.Arrays;

public class Definition {
    private String name;
    private String description;
    
    // GENERATED CODE, CHANGE IN data:android:definitions TASK
    public static final Definition ACTIVATION_COST = new Definition("Activation Cost", "The amount of mana you must spend to make one of your creatures attack or turn 90º on its field.");
    public static final Definition ADJACENT = new Definition("Adjacent", "A neighboring field, on the horizontal or vertical axis (not diagonal).");
    public static final Definition AFFILIATION = new Definition("Affiliation", "A creature group label used to trigger certain special rules and combos. For example: Flame Magus and Aluhja Priestess are both affiliated to the Church of Parmus.");
    public static final Definition ATTACK = new Definition("Attack", "All creatures have an Attack score. This is the amount of damage it inflicts (Hit Points deducted) when it attacks another creature. An attack may be either physical or a Magic Attack.");
    public static final Definition ATTACK_COST = new Definition("Attack Cost", "The amount of mana you must spend to make one of your creatures attack.");
    public static final Definition ATTACK_ZONES = new Definition("Attack Zones", "The fields that a creature can attack with respect to its location and orientation. The black box shows the creature’s location on the board with the white side at the front. Red arrows show default target(s), pink arrows are optional targets. For Magic Attacks a pink arrow on a purple burst indicates that the field will be targeted if conditions are met.");
    public static final Definition BLIND_SIDE = new Definition("Blind side", "If a creature is attacked from a field on its blind side, the attacker gains a +1 bonus to its Attack. The blind side is often located to a creature’s rear but this is not always the case. Some creatures have multiple blind sides, while others have none at all.");
    public static final Definition BOARD = new Definition("Board", "The playing area, consisting of 9 fields.");
    public static final Definition DECK = new Definition("Deck", "Each player must have a deck of 30 Summoning Cards to play THE EYE OF JUDGMENT™.");
    public static final Definition DECOY = new Definition("Decoy", "A creature with the decoy ability distracts affected enemy creatures so that they can only target creatures with decoy. Note: if a creature with a multi-field Attack Zone targets the decoy creature, it will attack all creatures in the other default fields as well.");
    public static final Definition DEFENSE_ZONES = new Definition("Defense Zones", "Each of the four fields adjacent to a creature can be described as strong (the creature can counterattack if attacked from this field), weak (it cannot counterattack) or blind (it cannot counterattack and its attacker gains a +1 Attack bonus). The black box shows the creature’s location on the board with the white side at the front. A blue arrow indicates a strong field, white fields are weak and B is blind.");
    public static final Definition DESTROYED = new Definition("Destroyed", "When one of your creatures on the board reaches zero Hit Points, it must be put into your Graveyard. This normally gives you 1 point of exit mana.");
    public static final Definition DISCARD = new Definition("Discard", "Placing a card from your hand into your graveyard.");
    public static final Definition DODGE = new Definition("Dodge", "A creature with Dodge avoids all damage from physical attacks half the time. A creature may have more than one Dodge attempt – only one needs to succeed to negate all damage.");
    public static final Definition DODGE_ATTEMPT = new Definition("Dodge Attempt", "A creature with Dodge avoids all damage from physical attacks half the time.");
    public static final Definition DRAW = new Definition("Draw", "Taking a card from your library into your hand.");
    public static final Definition ELEMENT = new Definition("Element", "There are five elements in THE EYE OF JUDGMENT™: the four Prime Elements (Fire, Water, Earth and Wood) and Biolith. Fire is the opposite of Water; Earth is the opposite of Wood; Biolith has no opposite.");
    public static final Definition ENEMY_CREATURE = new Definition("Enemy creature", "Any creature owned by your opponent.");
    public static final Definition EXIT_MANA = new Definition("Exit mana", "When one of your creatures is destroyed, you receive 1 mana. Some creatures in BIOLITH REBELLION SET 2 have the ability to steal or deprive the opposing player of exit mana.");
    public static final Definition FIELD = new Definition("Field", "There are 9 Fields arranged in a 3 x 3 grid to form the board. Field tiles are double-sided and show an element on each side.");
    public static final Definition FIELD_BONUS = new Definition("Field bonus", "A creature’s Hit Points are increased (+2) while it occupies a field that matches its element.");
    public static final Definition FIELD_ORDER = new Definition("Field order", "The position of each field is numbered as follows:  1 2 3  4 5 6  7 8 9  When several events need to be resolved at the same time, they are worked out in field order.");
    public static final Definition FIELD_PENALTY = new Definition("Field penalty", "A creature’s Hit Points are reduced (-2) while it occupies a field whose element is the opposite of its own.");
    public static final Definition FIELDMORPH = new Definition("Fieldmorph", "The target field becomes the same element as the creature occupying it. Fieldmorph is lost if the creature is moved from the field.");
    public static final Definition FIELDQUAKE = new Definition("Fieldquake", "An effect that causes a field tile to be flipped over to its reverse side.");
    public static final Definition FORTRESS = new Definition("Fortress", "A Fortress cannot attack. It may counterattack, if able to do so.");
    public static final Definition GRAVEYARD = new Definition("Graveyard", "A face-up card pile where you must place any of your cards that are discarded, sacrificed, destroyed or cast (spells).");
    public static final Definition HALF_THE_TIME = new Definition("Half the time", "Literally, a 50% chance that something will happen.");
    public static final Definition HAND = new Definition("Hand", "The cards held by a player and kept hidden from his opponent. You start with a hand of 5 cards and may never hold more than 7 cards at the end of your turn.");
    public static final Definition HIT_POINTS_HPS = new Definition("Hit Points (HPs)", "Used to measure a creature’s life. Hit Points are reduced when a creature takes damage from an attack or spell. When a creature’s HPs reach zero, it is destroyed.");
    public static final Definition INCARNATION = new Definition("Incarnation", "Incarnation is a form of summoning. A creature with Incarnation may be brought onto the board on top of an existing allied creature of the same element. You must sacrifice the allied creature on the board to summon the new creature onto that field, paying the difference between the Summoning Cost of the new creature and that of the sacrificed creature. The summoned creature cannot attack on the turn it is summoned, but this does not end your turn. You cannot use Incarnation to summon a creature of the same name as the one you sacrifice. Any power that is triggered by summoning will also be triggered by Incarnation.");
    public static final Definition INTERCEPT = new Definition("Intercept", "Every time a new enemy creature is summoned, a creature with this ability attacks at no Activation Cost the summoned enemy half the time before it can make its attack. This happens if the enemy is within the intercepting creature’s Attack Zone, and is not treated as an Activation.");
    public static final Definition INVISIBILITY = new Definition("Invisibility", "When a creature gains Invisibility it avoids all damage from physical and Magic Attacks and spells which cause direct damage.");
    public static final Definition INVOCATION = new Definition("Invocation", "Lets you incarnate (see incarnation) a creature onto another creature of the same element / race etc. However, you cannot summon the same creature as one that was summoned in this turn or with the same name as the sacrificed creature.");
    public static final Definition LIBRARY = new Definition("Library", "The deck of 30 cards that you draw from throughout the game. Shuffled and placed face down at the start of the game.");
    public static final Definition LOCATION = new Definition("Location", "The field that a creature is standing on.");
    public static final Definition MAGIC_ATTACK = new Definition("Magic Attack", "Unless otherwise stated on the card, a Magic Attack targets 1 enemy creature of your choice. Magic Attacks cannot be counter-attacked and are not affected by Dodge attempts or Protection.");
    public static final Definition MAGIC_PROTECTION = new Definition("Magic Protection", "This functions like Protection but only protects against Magic Attack (not physical) damage.");
    public static final Definition MANA = new Definition("Mana", "Magical energy used for summoning and activating creatures, and casting spells. You receive 2 points of mana in the second phase of your turn. When one of your creatures is destroyed, you receive 1 point of exit mana.");
    public static final Definition MULLIGAN = new Definition("Mulligan", "Before starting the duel, if you are not happy with your hand of 5 cards, you can shuffle them back into your library and draw another 5 cards. You can only do this once per game.");
    public static final Definition ORIENTATION = new Definition("Orientation", "The direction a creature is facing with the top edge of the card always considered to be the front. Orientation must be considered when working out a creature’s Attack and Defense Zones.");
    public static final Definition OWNER = new Definition("Owner", "The owner of the card remains the same throughout the duel, even if a creature is possessed.");
    public static final Definition PERFECT_DODGE = new Definition("Perfect Dodge", "A creature with Perfect Dodge avoids all damage from physical attacks all the time.");
    public static final Definition PHASE = new Definition("Phase", "A player’s turn is divided into 5 phases which must be carried out in order: 1) Draw card 2) Mana charge 3) Actions/Spells 4) Summon a creature 5) Turn Resolution.");
    public static final Definition PHYSICAL_ATTACK = new Definition("Physical Attack", "All attacks cause physical damage unless the attack is specified as a Magic Attack. Physical attacks can be reduced by Protection or negated completely by a successful Dodge attempt.");
    public static final Definition POSSESSION = new Definition("Possession", "When you gain Possession of an enemy creature you can activate it in your actions phase as if it were one of your own creatures. The possessed creature cannot be activated by its original owner. Creatures that are possessed upon summoning do not carry out their initial attack. A possessed creature cannot be activated on the turn it is possessed. Creatures with the power of Possession may themselves be possessed.");
    public static final Definition PRAYER = new Definition("Prayer", "Creatures affected by prayer cannot dodge by any means.");
    public static final Definition PROTECTION = new Definition("Protection", "When a creature has Protection, the damage from a physical attack is reduced by the amount of that protection. For example, Protection +2 would reduce an Attack of 4 to an Attack of 2. In the case of a creature that attacks more than once, each attack is reduced by the Protection.");
    public static final Definition QUICKNESS = new Definition("Quickness", "A creature with Quickness counterattacks before the attack of a creature without Quickness. Attacking a creature with Quickness can be dangerous – if the counterattack destroys the attacking creature, it cannot attack at all. If both attacker and target have Quickness, the attacker attacks first as normal.");
    public static final Definition RACE = new Definition("Race", "A creature group label used to trigger certain special rules and combos. For example: Dancing Temptress and Skeleton Soldier are both of the Undead race.");
    public static final Definition RESURRECTION = new Definition("Resurrection", "If a creature with this ability is destroyed and you hold a duplicate of it in your hand, you may summon the duplicate to the previously occupied field by spending 1 mana. This summoning occurs in your opponent’s turn and the summoned creature does not receive a free attack.");
    public static final Definition RETURN = new Definition("Return", "If a creature is destroyed, you may return it to your hand (instead of the graveyard) by paying 1 mana. Note: all the rules for creature destruction apply even if the creature is returned, including exit mana.");
    public static final Definition SACRIFICE = new Definition("Sacrifice", "You must remove one of your creatures from the board and put it into your graveyard. Unlike creature destruction, this does not generate exit mana.");
    public static final Definition SPELL = new Definition("Spell", "A magical effect that may be cast in your actions phase. Spells may help you and/or your creatures or harm your opponent. When a spell’s effects have been resolved, its card is put into your graveyard.");
    public static final Definition SUMMONING_CARDS = new Definition("Summoning Cards", "THE EYE OF JUDGMENT™ creature and spell cards are collectively known as Summoning Cards.");
    public static final Definition SUMMONING_COST = new Definition("Summoning Cost", "The amount of mana that you must spend to summon a creature or cast a spell.");
    public static final Definition SUMMONING_LOCK = new Definition("Summoning Lock", "The summoning lock is lifted when there are a total of 4 or more creatures on the board. Creatures with the padlock icon cannot be summoned until the summoning lock is lifted. Biolith creatures ignore the summoning lock if they are summoned to a Biolith field.");
    public static final Definition TURN = new Definition("Turn", "A player’s turn consists of 5 phases.");

    public static final Definition[] ALL_DEFINITIONS = { ACTIVATION_COST, ADJACENT, AFFILIATION, ATTACK, ATTACK_COST, ATTACK_ZONES, BLIND_SIDE, BOARD, DECK, DECOY, DEFENSE_ZONES, DESTROYED, DISCARD, DODGE, DODGE_ATTEMPT, DRAW, ELEMENT, ENEMY_CREATURE, EXIT_MANA, FIELD, FIELD_BONUS, FIELD_ORDER, FIELD_PENALTY, FIELDMORPH, FIELDQUAKE, FORTRESS, GRAVEYARD, HALF_THE_TIME, HAND, HIT_POINTS_HPS, INCARNATION, INTERCEPT, INVISIBILITY, INVOCATION, LIBRARY, LOCATION, MAGIC_ATTACK, MAGIC_PROTECTION, MANA, MULLIGAN, ORIENTATION, OWNER, PERFECT_DODGE, PHASE, PHYSICAL_ATTACK, POSSESSION, PRAYER, PROTECTION, QUICKNESS, RACE, RESURRECTION, RETURN, SACRIFICE, SPELL, SUMMONING_CARDS, SUMMONING_COST, SUMMONING_LOCK, TURN };
    public static final String[] ALL_NAMES = { "Activation Cost", "Adjacent", "Affiliation", "Attack", "Attack Cost", "Attack Zones", "Blind side", "Board", "Deck", "Decoy", "Defense Zones", "Destroyed", "Discard", "Dodge", "Dodge Attempt", "Draw", "Element", "Enemy creature", "Exit mana", "Field", "Field bonus", "Field order", "Field penalty", "Fieldmorph", "Fieldquake", "Fortress", "Graveyard", "Half the time", "Hand", "Hit Points (HPs)", "Incarnation", "Intercept", "Invisibility", "Invocation", "Library", "Location", "Magic Attack", "Magic Protection", "Mana", "Mulligan", "Orientation", "Owner", "Perfect Dodge", "Phase", "Physical Attack", "Possession", "Prayer", "Protection", "Quickness", "Race", "Resurrection", "Return", "Sacrifice", "Spell", "Summoning Cards", "Summoning Cost", "Summoning Lock", "Turn" };

    /**
     * Custom generator that initializes name and description.
     * @param name
     * @param description
     */
    public Definition(String name, String description) {
	this.name = name;
	this.description = description;
    }
    
    /**
     * Find a definition object from the name
     * @param name
     * @return
     */
    public static Definition findByName(String name) {
	int index = Arrays.binarySearch(ALL_NAMES, name);
	return ALL_DEFINITIONS[index];
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
