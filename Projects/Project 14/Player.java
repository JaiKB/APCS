public class Player {
    private String name; 
    private String description;
    private Equippable[] equipped; 
    private Item[] inventory; 
    public Player(String name, String description, Equippable[] equipped, Item[] startingInventory) {
        this.name = name; 
        this.description = description; 
        this.equipped = equipped; 
        this.inventory = startingInventory; 
    }
    
    public String getName() {
        return ""; 
    }
    
    public String getDescription() {
        return ""; 
    }
      
    public Item[] inventory() {
        return inventory;  
    }
    
    public void attack(Character target) {
        
    }
    
    public void equip(Equippable equipment) {
        
    }
}