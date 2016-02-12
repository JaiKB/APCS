public class Equippable extends Item {
    private String name; 
    private String description; 
    public Equippable(String name, String description) {
        super(name, description); 
    }
    
    public String getDescription() {
        return description; 
    }
    
    public String getName() {
        return name; 
    }
    
    public void equip(Equippable e) {
        System.out.println("You have equipped this item");
    }
}