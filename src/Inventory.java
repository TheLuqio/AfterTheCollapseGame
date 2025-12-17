import java.util.ArrayList;
public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
    public void printItems() {
        if (items.isEmpty()) {
            System.out.println("The Inventory is empty");
            return;
        }
        System.out.println("=== Inventory ===");
        for (Item item : items) {
            System.out.println(item);
        }
    }
    public ArrayList<Item> getItems() {
        return new ArrayList<>(items);
    }
    public boolean hasItem(String itemName) {
        for (Item item: items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name.trim())) {
                return item;
            }
        }
        return null;
    }
    public boolean removeItem (Item item) {
        return items.remove(item);
    }
}