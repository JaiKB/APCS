public class Character {
    private String description; 
    private String name; 
    private Item[] inventory; 
    public Character(String name, String description, Item[] inventory){
        this.name = name; 
        this.description = description; 
        this.inventory = inventory; 
    }
    
    public String getDescription() {
        return description; 
    }
    
    public String getName() {
        return name; 
    }

    public Item[] inventory() {
        return inventory; 
    }
    
    public String talk(String dialogue) {
        return dialogue; 
    }
    
}