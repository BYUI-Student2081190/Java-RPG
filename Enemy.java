/**
 * This is the Enemy Class - This class is used to handle enemy creation and health. This will also handle damage
 * enemies take from the player to determine if they have been defeated or not.
 */

public class Enemy {
    // Attributes of Enemy.
    private String enemyName; // The name of the enemy.
    private int enemyId; // What number of enemy this is in the bestiary.
    private int enemyHealth; // How much health the enemy has.
    private int enemyAttack; // How hard this enemy attacks.
    private int enemyMind; // How hard this enemy's magic attacks are.
    private int enemyArmor; // How resistant this enemy is to damage.
    private int enemyMagicDef; // How resistant this enemy is to magic.
    private int enemyExpDrop; // How much Exp this enemy gives the player.
    // private Item enemyLoot; // What this enemy drops after battle.
    private int dropRate; // How often this enemy drops it's item after the battle. This would be drop rate / 100.
    private int maxHealth; // This is here to make sure an enemy does not heal over it's max health.

    // Constructor - Used to create the enemy for the battle about to happen.
    public Enemy(String enemyName, int enemyId, int enemyHealth, int enemyAttack, int enemyMind, int enemyArmor, int enemyMagicDef, int enemyExpDrop, int dropRate) {
        // Set all the values, NOTE: ADD THE ITEM LATER.
        this.enemyName = enemyName;
        this.enemyId = enemyId;
        this.enemyHealth = enemyHealth;
        this.enemyAttack = enemyAttack;
        this.enemyMind = enemyMind;
        this.enemyArmor = enemyArmor;
        this.enemyMagicDef = enemyMagicDef;
        this.enemyExpDrop = enemyExpDrop;
        this.dropRate = dropRate;
        this.maxHealth = this.enemyHealth;
    }

    // Get the enemy name.
    public String getEnemyName(){
        // Return the name.
        return enemyName;
    }

    // Get the enemy current Health.
    public int getEnemyHealth(){
        //Return the health.
        return enemyHealth;
    }

    // Get the enemy stats.
    public String getEnemyAllStats(){
        // Return all the stats for testing.
        return "Enemy Stats: \nEnemy Name: " + enemyName + "\nEnemy Id: " + enemyId + "\nHP: " + enemyHealth + "\nAttack: " + enemyAttack + "\nMind: " + enemyMind + "\nArmor: " + enemyArmor + "\nMagic Def: " + enemyMagicDef + "\nEXP Drop: " + enemyExpDrop + "\nItem Drop Rate: " + dropRate;
    }
}
