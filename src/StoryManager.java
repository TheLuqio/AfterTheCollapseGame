import java.util.Random;
import java.util.Scanner;

public class StoryManager {
    private Player player;
    private Scanner sc;
    private Random rand;

    public StoryManager(Scanner sc) {
        this.sc = sc;
        this.rand = new Random();
    }

    public void startGame() {
        intro();
        chooseCharacter();
        scene1Shelter();
    }

    private void intro() {
        System.out.println("After World War III, the world collapsed. ");
        waitMs(2000);
        System.out.println("The global population decreased to an estimated 300,000 but the real number is unknown.");
        waitMs(2000);
        System.out.println("As a famous quote once said");
        waitMs(1000);
        System.out.println("\"After World War III, people will fight with sticks.\"");
        waitMs(2000);
        System.out.println("That turned out almost true.\n");
        waitMs(3000);

        System.out.println("Year 2032");
        waitMs(1000);
        System.out.println("Survivors live in shelters now.");
        waitMs(1000);
        System.out.println("There is no trust between people anymore.");
        waitMs(1000);
        System.out.println("Only one rule remains;");
        waitMs(2000);
        System.out.println("SURVIVE\n");
        waitMs(3000);
    }

    private void chooseCharacter() {
        System.out.println("Choose your character;");
        waitMs(1000);
        System.out.println("1) Ella Wilson (21) - Fast and Strong");
        System.out.println(" Starts with 85 health and a Knife");
        System.out.println("2) John Miles (48) - Experienced but Wounded");
        System.out.println(" Starts with 75 health, a Baseball Bat, and a Medical Bandage");
        System.out.println("Enter 1 or 2: ");

        String choice = sc.nextLine();
        if (choice.equals("1")) {
            player = new Player("Ella Wilson");
            player.setHealth(85);
            player.getInventory().addItem(new Item("Knife", "weapon", 0));
            System.out.println("You chose Ella Wilson.");
        }
        else {
            player = new Player("John Miles");
            player.setHealth(75);
            player.getInventory().addItem(new Item("Baseball Bat", "weapon", 0));
            player.getInventory().addItem(new Item("Medical Tape", "health", 15));
            System.out.println("You chose John Miles.");
        }
        waitMs(2000);
    }


    private void scene1Shelter() {
        System.out.println("\n--- Scene 1: The Shelter ---");
        waitMs(3000);
        System.out.println("You wake up in a cold, silent shelter.");
        waitMs(1000);
        System.out.println("The walls are cracked and dust fills the air");
        waitMs(1000);
        System.out.println("You don't know how long this place will keep you safe.\n");
        waitMs(1000);

        System.out.println("What do you do?");
        waitMs(1000);
        System.out.println("1) Leave the shelter");
        System.out.println("2) Search around");
        System.out.println("3) Use an item");

        System.out.println("Enter 1 or 2 or 3: ");
        String choice = sc.nextLine();

        if (choice.equals("2")) {
            int chance = rand.nextInt(3);
            if (chance == 0) {
                Item water = new Item("Water Bottle", "stamina", 20);
                player.getInventory().addItem(water);
                System.out.println("You found a Water Bottle.");
            }
            else if (chance == 1) {
                Item food = new Item("Canned Food", "stamina", 20);
                player.getInventory().addItem(food);
                System.out.println("You found a can of food");
            }
            else {
                System.out.println("You searched the place but found nothing useful.");
            }
            scene1Shelter();
            return;
        }
        else if (choice.equals("3")) {
            useItemMenu();
            scene1Shelter();
            return;
        }
        else {
            System.out.println("You decided to leave the shelter.");
        }
        System.out.println("\nYour current inventory:");
        player.getInventory().printItems();
        waitMs(4000);

        System.out.println("\nYou step outside into the ruined world...");
        waitMs(3000);
        scene2Highway();
    }

    private void scene2Highway() {
        System.out.println("\n--- Scene 2: Highway Checkpoint ---");
        waitMs(2000);
        System.out.println("You walk toward an old highway checkpoint.");
        waitMs(1000);
        System.out.println("Burned cars sit on the road like skeletons");
        waitMs(1000);
        System.out.println("The sun reflects from the shattered glass");
        waitMs(1000);
        int event = rand.nextInt(3);

        if (event == 0) {
            System.out.println("You spot an abandoned backpack near a truck");
            waitMs(1000);
            System.out.println("1) Search the backpack");
            System.out.println("2) Ignore it and keep moving");
            System.out.println("Choose 1 or 2: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                int roll = rand.nextInt(100);
                if (roll < 60) {
                    player.getInventory().addItem(new Item("Water Bottle", "stamina", 20));
                    System.out.println("You found a bottle of water inside the backpack");
                } else {
                    player.getInventory().addItem(new Item("Canned Food", "stamina", 20));
                    System.out.println("You found canned food inside the backpack");
                }
            } else {
                System.out.println("You left. Some things are safer untouched...");
            }
        } else if (event == 1) {
            waitMs(1000);
            System.out.println("Someone steps onto the road, pointing at you.");
            waitMs(1000);
            System.out.println("\"Stop right there! What are you carrying?\"");
            waitMs(1000);
            System.out.println("1) Talk calmly");
            System.out.println("2) Intimidate the person and walk past");
            System.out.println("Enter 1 or 2: ");
            String choice = sc.nextLine();

            boolean hasKnife = player.getInventory().hasItem("Knife");
            boolean hasBat = player.getInventory().hasItem("Baseball Bat");

            if (choice.equals("2")) {
                if (hasKnife) {
                    System.out.println("You show your knife and look the stranger in the eye");
                    waitMs(1000);
                    System.out.println("The stranger hesitates and steps back.");
                    waitMs(1000);
                    System.out.println("You pass with no further trouble");
                } else if (hasBat) {
                    System.out.println("The stranger notices the bat on your back");
                    waitMs(1000);
                    System.out.println("Stranger hesitates but keep distance");
                    waitMs(1000);
                    System.out.println("You pass, but the tension stays with you...");
                }
            } else {
                System.out.println("You kept your voice calm and hands visible");
                waitMs(1000);
                System.out.println("After a tense moment, the stranger turns around and walks away");
                waitMs(1000);
                System.out.println("You continue");
            }
        } else {
            System.out.println("The road is blocked by remains of a collapsed building ");
            System.out.println("1) Climb over (tiring)");
            System.out.println("2) Take the longer road around (safer)");
            System.out.println("Enter 1 or 2: ");
            String choice = sc.nextLine();


            if (choice.equals("1")) {
                System.out.println("You climbed over");
                waitMs(1000);
                System.out.println("You make it through, you are covered in dust and feel exhausted");
                player.setStamina(player.getStamina() - 5);
            } else {
                System.out.println("You took the long way around");
                waitMs(1000);
                System.out.println("It took some time, but you stay safe.");
                waitMs(1000);
                System.out.println("At least, for now...");
            }
        }
        waitMs(4000);
        System.out.println("\nInventory check:");
        player.getInventory().printItems();
        System.out.println("\n(Next: Scene 3 The Gas Station)");
        scene3GasStation();
        waitMs(3000);
    }

        private void scene3GasStation() {
            System.out.println("\n--- Scene 3: Gas Station ---");
            waitMs(1000);
            System.out.println("You reach an old gas station. The sign is hanging and covered in dust");
            waitMs(1000);
            System.out.println("The store door is closed, but the windows are cracked");
            waitMs(1000);
            System.out.println("It feels quiet. Too quiet...\n");
            waitMs(2000);

            System.out.println("What do you do?");
            System.out.println("1) Enter the store");
            System.out.println("2) Search outside");
            System.out.println("3) Use an item");
            System.out.println("Enter 1 or 2 or 3: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                int roll = rand.nextInt(100);
                if (roll < 50) {
                    player.getInventory().addItem(new Item("First Aid Kit", "health", 40));
                    System.out.println("You found a First Aid Kit under the cashier desk");
                }
                else if (roll < 80) {
                    player.getInventory().addItem(new Item("Water Bottle", "stamina", 20));
                    System.out.println("You found a Bottle of Water in the fridge");
                }
                else {
                    System.out.println("You hear a noise!");
                    System.out.println("It was an ambush!");
                    waitMs(2000);
                    System.out.println("People jump you!");
                    System.out.println(" -5 Health");
                    System.out.println(" -5 stamina");
                    player.setStamina(player.getStamina() - 5);
                    player.setHealth(player.getHealth() - 5);
                }
            }
            else if (choice.equals("3")) {
                useItemMenu();
                scene3GasStation();
                return;
            }
            else {
                int roll = rand.nextInt(100);
                if (roll < 60) {
                    player.getInventory().addItem(new Item("Canned Food", "stamina", 20));
                    System.out.println("You found a can of food inside a car");
                }
                else {
                    System.out.println("You found nothing useful outside");
                }
            }
            waitMs(4000);
            System.out.println("\nInventory check:");
            player.getInventory().printItems();
            System.out.println("\nNext: Scene 4 Hospital");
            scene4Hospital();
            waitMs(3000);
        }
        private void scene4Hospital() {
            System.out.println("\n--- Scene 4: Abandoned Hospital ---");
            waitMs(1000);
            System.out.println("You arrive at an old hospital.");
            waitMs(1000);
            System.out.println("There are some documents and waste around.");
            waitMs(1000);
            System.out.println("The place looks like it was in use by some people not too long ago.");
            waitMs(2000);
            System.out.println("But now, silence fills the halls...");
            waitMs(1000);
            System.out.println("You step inside carefully.\n");
            waitMs(1000);

            String otherName;
            if (player.getName().equals("Ella Wilson")) {
                otherName = "John Miles";
            } else {
                otherName = "Ella Wilson";
            }
            System.out.println("A voice echoes from the hallway");
            waitMs(3000);
            System.out.println("\"Easy... I'm not here to hurt you.\"");
            waitMs(1000);
            System.out.println("You recognize the voice");
            System.out.println("The figure steps closer");
            System.out.println("It's " + otherName + ".\n");
            waitMs(1000);

            System.out.println("What do you do?");
            System.out.println("1) Trust them");
            System.out.println("2) Stay cautious");
            System.out.println("Enter 1 or 2: ");
            String choice = sc.nextLine();
            waitMs(2000);

            if (choice.equals("1")) {
                System.out.println("You lower your guard.");
                waitMs(1000);
                System.out.println("After a moment of silence, you both nod.");
                waitMs(1000);
            }
            else {
                System.out.println("You keep your weapon ready, watching every move carefully");
                waitMs(1000);
                System.out.println("After a long tense moment, you realize you share the same goal");
                waitMs(1000);
            }
            System.out.println("\nYou agree on moving together for now");
            waitMs(1000);
            System.out.println("Surviving alone is hard. Surviving together gives hope...");
            waitMs(3000);

            player.getInventory().addItem(new Item("Medical Supplies", "health", 20));
            System.out.println("You found some Medical Supplies around the hospital.");

            System.out.println("\nInventory check:");
            player.getInventory().printItems();
            endingScreen();
            waitMs(3000);

        }
        private void endingScreen() {
            System.out.println("=================");
            System.out.println("THE END");
            System.out.println("=================");
            waitMs(3000);
            System.out.println("You made it through alive");
            waitMs(1000);
            System.out.println("In a world full of darkness...");
            waitMs(1000);
            System.out.println("Search for the light");
            waitMs(5000);

            System.out.println("Final Stats:");
            System.out.println("Name: " + player.getName());
            System.out.println("Final Health: " + player.getHealth());
            System.out.println("Final Stamina: " + player.getStamina());
            waitMs(3000);

            System.out.println("\nFinal Inventory:");
            player.getInventory().printItems();
            waitMs(3000);

            System.out.println("Thanks for playing!");

        }
    private void useItemMenu () {
        System.out.println("\n--- Use Item ---");
        player.getInventory().printItems();
        System.out.println("Type the name of an item to use (or type 'back'): ");

        String name = sc.nextLine();
        if(name.equalsIgnoreCase("back")) return;

        Item item = player.getInventory().getItemByName(name);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }
        if (item.getType().equalsIgnoreCase("health")) {
            player.heal(item.getEffectValue());
            player.getInventory().removeItem(item);
            System.out.println("Used " + item.getName() + ". New Health is: " + player.getHealth());
        }
        else if (item.getType().equalsIgnoreCase("stamina")) {
            player.restoreStamina(item.getEffectValue());
            player.getInventory().removeItem(item);
            System.out.println("Used " + item.getName() + ". New Stamina is: " + player.getStamina());
        }
        else {
            System.out.println("Can't use this item right now.");
        }
    }
    private void waitMs(long ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
