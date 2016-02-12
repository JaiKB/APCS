public class Armor extends Equippable {
    private String name; 
    private String description; 
    public Armor(String name, String description) {
        super(name, description); 
    }
    
    public String getDescription() {
        return description; 
    }
    
    public String getName() {
        return name; 
    }
}