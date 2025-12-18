public class Player {
    private String name;
    private int health;
    private int maxHealth = 100;
    private int stamina;
    private Inventory inventory = new Inventory();

    public Player (String name) {
        this.name = name;
        this.health = 80;
        this.stamina = 100;
    }

    public void setHealth(int health){
        if (health > maxHealth) {
            this.health = maxHealth;
        }
        else {
            this.health = health;
        }
    }

    public String getName(){
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStamina () {
        return stamina;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
    }
    public void restoreStamina(int amount) {
        stamina += amount;
        if(stamina > 100) stamina = 100;
        if (stamina < 0) stamina = 0;
    }
    public void setStamina(int stamina) {
        if (stamina > 100) this.stamina = 100;
        else if (stamina < 0) this.stamina = 0;
        else this.stamina = stamina;
    }

}
