public class Weapon extends Equippable {
    private String name; 
    private String description; 
    
    public Weapon(String name, String description) {
        super(name, description); 
    }
    
    public String getDescription() {
        return description; 
    }
    
    public String getName() {
        return name; 
    }
}