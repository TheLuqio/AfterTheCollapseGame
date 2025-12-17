public class Item {
    private String name;
    private String type;
    private int effectValue;
    public Item(String name, String type, int effectValue) {
        this.name = name;
        this.type = type;
        this.effectValue = effectValue;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getEffectValue() {
        return effectValue;
    }
    @Override
    public String toString() {
        return name + " (" + type + ", value: " + effectValue + ")";

    }

}
