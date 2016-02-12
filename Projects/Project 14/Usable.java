public class Usable extends Item {
    private String name; 
    private String description; 
    private String use; 
    public Usable(String name, String description, String use) {
        super(name, description); 
        this.use = use; 
    }
    
    public String getDescription() {
        return description; 
    }
    
    public String getName() {
        return name; 
    }
    
    public void use() {
        System.out.println(use); 
    }
    
    public void use(Character target) {
        
    }
}