/**
 * This class is the Character Class - This class is used
 * to create custom characters with stats and jobs that a
 * player can use in the game.
 */
// Imports
import java.util.Random;

public class Character {
    // Attributes of the Character.
    private String firstName; // Does nothing for the character. Just fun detail.
    private String lastName; // Does nothing for the character. Just fun detail.
    private int gender; // 1 = male, 2 = female. // Does nothing for the character. Just fun detail.
    private int age; // Does nothing for the character. Just fun detail.
    private String species; // Does nothing for the character. Just fun detail.
    private int job; // 1 = warrior, 2 = mage, 3 = healer, 4 = clown.
    private int exp = 0; // Current experiance. Maybe use a equation like this to calc levels, XP_required = base_xp * (level^growth_factor).
    private int nextLevel = 0; // Default this to 0 so the first level up can happen after the first battle.
    private int level = 1; // Current level. Default is 1.
    private int health; // Hp. Additional determined on hit dice for hp of job.
    private int magic; // Mp. Additional determined on hit dice for mp of job.
    private int offence; // Total Physical damage.
    private int defence; // Resistance to Physical damage.
    private int strength; // Physical damage.
    private int resistance; // Resistance to physical damage.
    private int mind; // Magic damage.
    private int spirit; // Healing effect.
    private int intellect; // Magic resistance.
    private double vision; // Chance of a critical strike. This is a 1/20 chance to happen.
    private double growthFactor = 0.15; // Used in helping level up characters.
    private int hitDiceHp; // This is a number that is determined by job to help with level up stats. 10 = warrior, 6 = mage, 5 = healer, clown = 8.
    private int hitDiceMp; // This is a number that is determined by job to help with level up stats. 4 = warrior, 10 = mage, 10 = healer, clown = 6.
    private boolean firstTime = true; // This is a stat that tests to see if a character has been used before. If so it skips part of the story.
    private int maxHealth; // This is here to make sure a character does not heal over it's max health.
    private int maxMagic; // This is here to make sure a character does not heal over it's max magic.
    // Add lists for armor equipment, weapons, abilities, and items.

    // Constructor - Used to set the name, gender, age, and job.
    public Character(String firstName, String lastName, int gender, int age, String species, int job) {
        // Set these values when creating the object.
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.species = species;
        this.job = job;
        // Set these based on job.
        switch (this.job) {
            case 1:
                // Set the values for a warrior.
                this.hitDiceHp = 10;
                this.hitDiceMp = 4;
                this.strength = 15;
                this.resistance = 12;
                this.mind = 4;
                this.spirit = 8;
                this.intellect = 7;
                this.vision = 0.8;
                this.offence = 20;
                this.defence = 15;
                this.health = this.hitDiceHp * 10; // Calculates base HP.
                this.magic = this.hitDiceMp * 10; // Calculates base MP.
                this.maxHealth = this.health;
                this.maxMagic = this.magic;
                break;
            case 2:
                // Set the values for a mage.
                this.hitDiceHp = 6;
                this.hitDiceMp = 10;
                this.strength = 8;
                this.resistance = 9;
                this.mind = 15;
                this.spirit = 7;
                this.intellect = 12;
                this.vision = 0.6;
                this.offence = 8;
                this.defence = 10;
                this.health = this.hitDiceHp * 10;
                this.magic = this.hitDiceMp * 10;
                this.maxHealth = this.health;
                this.maxMagic = this.magic;
                break;
            case 3:
                // Set the values for healer.
                this.hitDiceHp = 5;
                this.hitDiceMp = 10;
                this.strength = 4;
                this.resistance = 7;
                this.mind = 10;
                this.spirit = 16;
                this.intellect = 11;
                this.vision = 0.4;
                this.offence = 5;
                this.defence = 10;
                this.health = this.hitDiceHp * 10;
                this.magic = this.hitDiceMp * 10;
                this.maxHealth = this.health;
                this.maxMagic = this.magic;
                break;
            case 4:
                // Set the values for clown.
                this.hitDiceHp = 8;
                this.hitDiceMp = 6;
                this.strength = 7;
                this.resistance = 7;
                this.mind = 7;
                this.spirit = 7;
                this.intellect = 7;
                this.vision = 0.7;
                this.offence = 7;
                this.defence = 7;
                this.health = this.hitDiceHp * 10;
                this.magic = this.hitDiceMp * 10;
                this.maxHealth = this.health;
                this.maxMagic = this.magic;
                break;
        }
    }

    // Getter Functions.
    public String getStats() {
        // String Gender.
        String genderString;
        // String Job.
        String jobString;

        switch (gender) {
            case 1:
                genderString = "Male";
                break;
            case 2:
                genderString = "Female";
                break;
            default:
            genderString = "Unknown";
        }

        switch (job) {
            case 1:
                jobString = "Warrior";
                break;
            case 2:
                jobString = "Mage";
                break;
            case 3:
                jobString = "Healer";
                break;
            case 4:
                jobString = "Clown";
                break;
            default:
                jobString = "Unknown";
        }

        // Obtain all the stats and return as a string to the user.
        String stats = "Character Stats: \nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nGender: " + genderString + "\nAge: " + age + "\nSpecies: " + species + "\nJob: " + jobString + "\nExp: " + exp + "\nNext Level: " + nextLevel + "\nLevel: " + level + "\nHP: " + health + "\nMP: " + magic + "\nOffence: " + offence + "\nDefence: " + defence + "\nStrength: " + strength + "\nResistance: " + resistance + "\nMind: " + mind + "\nSpirit: " + spirit + "\nIntellect: " + intellect + "\nVision: " + vision + "%";
        return stats;
    }

    // Set the first time stat to false when the character goes through the into.
    public void setCharacterFirstTimeStat() {
        // Update it to false for story.
        firstTime = false;
    }

    // Get the character's name.
    public String getCharacterName() {
        // Return the character's name.
        return firstName;
    }

    // Get the character's gender as a string.
    public String getCharacterStringGender() {
        // Return boy or girl dependant on the gender.
        if (gender == 1) {
            return "boy";
        } else {
            return "girl";
        }
    }

    // Get the proper pronoun for character.
    public String getCharacterPronoun() {
        // Return he or she dependant on the gender.
        if (gender == 1) {
            return "he";
        } else {
            return "she";
        }
    }

    // Get character's firsttimer stat.
    public boolean getCharacterFirstTimeStat() {
        // Return the stat.
        return firstTime;
    }

    // Get the character's current health.
    public int getHealth() {
        return health;
    }

    // Get the character's current magic.
    public int getMagic() {
        return magic;
    }

    // This function returns the character's level.
    public int getLevel() {
        return level;
    }

    // Function to test to see if the character is dead.
    public boolean isDead() {
        // Return true if the character has been defeated.
        if (health <= 0) {
            // If the character is dead also set their health to 0.
            health = 0;
            return true;
        } else {
            return false; // We are still in this.
        }
    }

    // Function to calculate a physical attack by the player.
    public int attackDamage() {
        // Calculate the damage from an attack.
        double damageMultiplier = Math.pow(strength, vision); // Get the damage multiplier from strength.
        int damage = offence + (int) Math.round(damageMultiplier); // Add offence to the multiplier.

        // Return total damage.
        return damage;
    }

    // Physical Damage taken by player.
    public int damageTaken(int incomingDamage) {
        // Total damage variable.
        int totalDamage;
        
        // Get the defence multiplier.
        double defMulti = Math.pow(resistance, vision);

        // Use the stats to see how much damage is taken.
        totalDamage = incomingDamage - (defence + (int) Math.round(defMulti));

        // Create a check to make sure the incoming damage is not negative if it is set it to 1.
        if (totalDamage < 1) {
            // Set totalDamage to 1.
            totalDamage = 1;
            // Only subract 1 from the total health.
            health -= totalDamage;
        } else {
            // Now subract that damage from the player health.
            health -= totalDamage;
        }

        // Now return the totalDamage to the user.
        return totalDamage;
    }

    // This function is a full heal function to fully heal the character.
    public void fullHeal() {
        // Set the values.
        health = maxHealth;
        magic = maxMagic;
        // Now return.
        return;
    }

    // This function sets the stats after a level up.
    public void setLeveledStats() {
        // Create a new random variable.
        Random random = new Random();

        // Set them based on job.
        switch (job) {
            case 1:
                // Warrior upgrade stats.
                maxHealth += (random.nextInt(hitDiceHp) + 1) * 10;
                maxMagic += (random.nextInt(hitDiceMp) + 1) * 10;
                offence += random.nextInt(hitDiceHp) + 1;
                defence += random.nextInt(hitDiceHp) + 1;
                strength += random.nextInt(hitDiceHp) + 1;
                resistance += random.nextInt(hitDiceHp) + 1;
                mind += random.nextInt(hitDiceMp) + 1;
                spirit += random.nextInt(hitDiceMp) + 1;
                intellect += random.nextInt(hitDiceMp) + 1;
            case 2:
                // Mage upgrade stats.
                maxHealth += (random.nextInt(hitDiceHp) + 1) * 10;
                maxMagic += (random.nextInt(hitDiceMp) + 1) * 10;
                offence += random.nextInt(hitDiceHp) + 1;
                defence += random.nextInt(hitDiceHp) + 1;
                strength += random.nextInt(hitDiceHp) + 1;
                resistance += random.nextInt(hitDiceHp) + 1;
                mind += random.nextInt(hitDiceMp) + 1;
                spirit += random.nextInt(hitDiceHp) + 1;
                intellect += random.nextInt(hitDiceMp) + 1;
            case 3:
                // Healer upgrade stats.
                maxHealth += (random.nextInt(hitDiceHp) + 1) * 10;
                maxMagic += (random.nextInt(hitDiceMp) + 1) * 10;
                offence += random.nextInt(hitDiceHp) + 1;
                defence += random.nextInt(hitDiceHp) + 1;
                strength += random.nextInt(hitDiceHp) + 1;
                resistance += random.nextInt(hitDiceHp) + 1;
                mind += random.nextInt(hitDiceHp) + 1;
                spirit += random.nextInt(hitDiceMp) + 1;
                intellect += random.nextInt(hitDiceMp) + 1;
            case 4:
                // Create a very special random int that determines what he gets.
                int detemination = random.nextInt(2) + 1;
                // Clown upgrade stats. These get a little crazy.
                maxHealth += (random.nextInt(hitDiceHp) + 1) * 10;
                maxMagic += (random.nextInt(hitDiceMp) + 1) * 10;
                if (detemination == 1){
                    offence += random.nextInt(hitDiceHp) + 1;
                } else {
                    offence += random.nextInt(hitDiceMp) + 1;
                }
                if (detemination == 2){
                    defence += random.nextInt(hitDiceHp) + 1;
                } else {
                    defence += random.nextInt(hitDiceMp) + 1;
                }
                if (detemination == 2){
                    strength += random.nextInt(hitDiceHp) + 1;
                } else {
                    strength += random.nextInt(hitDiceMp) + 1;
                }
                if (detemination == 1){
                    resistance += random.nextInt(hitDiceHp) + 1;
                } else {
                    resistance += random.nextInt(hitDiceMp) + 1;
                }
                if (detemination == 2){
                    mind += random.nextInt(hitDiceHp) + 1;
                } else {
                    mind += random.nextInt(hitDiceMp) + 1;
                }
                if (detemination == 1){
                    spirit += random.nextInt(hitDiceHp) + 1;
                } else {
                    spirit += random.nextInt(hitDiceMp) + 1;
                }
                if (detemination == 2){
                    intellect += random.nextInt(hitDiceHp) + 1;
                } else {
                    intellect += random.nextInt(hitDiceMp) + 1;
                }
        }
    }

    // This function handles leveling up.
    public void experianceAndLevels(int gainedExp) {
        // First things first we add our current exp with what came in.
        exp += gainedExp;

        // Now we test to see if we leveled up, if so we call another function to take care of stat increase.
        if (exp >= nextLevel) {
            // Level up the character.
            level += 1;
            // Do the equation to set the next level cap.
            double growthMulti = Math.pow(level, growthFactor);

            // Now do the math.
            nextLevel += exp * (int) Math.round(growthMulti);

            // Now set the stats.
            setLeveledStats();
            // Full heal after the battle.
            fullHeal();
        }

        // If we don't level up just return for now.
        return;
    }

    // Export character data as a String to save in the file.
    public String characterSaveData() {
        // Return the string "###---!!!---###" was added as a splitter to easly gain the data again.
        return firstName + "###---!!!---###" + lastName + "###---!!!---###" + gender + "###---!!!---###" + age + "###---!!!---###" + species + "###---!!!---###" + job + "###---!!!---###" + exp + "###---!!!---###" + nextLevel + "###---!!!---###" + level + "###---!!!---###" + health + "###---!!!---###" + magic + "###---!!!---###" + offence + "###---!!!---###" + defence + "###---!!!---###" + strength + "###---!!!---###" + resistance + "###---!!!---###" + mind + "###---!!!---###" + spirit + "###---!!!---###" + intellect + "###---!!!---###" + vision + "###---!!!---###" + firstTime + "###---!!!---###" + maxHealth + "###---!!!---###" + maxMagic;
    }

    // Load in the data from a loaded character.
    // The reason we do this is because we do not what to deal with
    // the constructor and this will make sure we don't need to break
    // something that already works.
    public void loadCharacter(String fname, String lname, int cGender, int cAge, String cSpecies, int cJob, int cexp, int cnextLevel, int clevel, int chealth, int cmagic, int cOffence, int cDefence, int cStrength, int cResistance, int cMind, int cSpirit, int cIntellect, double cVision, boolean cfirstTime, int cMaxHealth, int cMaxMagic) {
        // Lots of stuff getting passed in because how this will work is we will create a dummy character and then set all their
        // attributes to these afterwards.
        firstName = fname;
        lastName = lname;
        gender = cGender;
        age = cAge;
        species = cSpecies;
        job = cJob;
        exp = cexp;
        nextLevel = cnextLevel;
        level = clevel;
        health = chealth;
        magic = cmagic;
        offence = cOffence;
        defence = cDefence;
        strength = cStrength;
        resistance = cResistance;
        mind = cMind;
        spirit = cSpirit;
        intellect = cIntellect;
        vision = cVision;
        firstTime = cfirstTime;
        maxHealth = cMaxHealth;
        maxMagic = cMaxMagic;

        // Now set the hitDice to the right job.
        switch (job) {
            case 1:
                // Warrior.
                this.hitDiceHp = 10;
                this.hitDiceMp = 4;
                break;
            case 2:
                // Mage.
                this.hitDiceHp = 6;
                this.hitDiceMp = 10;
                break;
            case 3:
                // Healer.
                this.hitDiceHp = 5;
                this.hitDiceMp = 10;
                break;
            case 4:
                // Clown.
                this.hitDiceHp = 8;
                this.hitDiceMp = 6;
                break;
        }
    }
}