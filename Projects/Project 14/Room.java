
public class Room {
    private Item[] stuff;
    private Character[] people; 
    private String name;
    private String description; 
    private Room north, south, west, east, up, down; 

    public Room(Item[] s, Character[] p, String n, String d){
        this.stuff = s; 
        this.people = p; 
        this.name = n; 
        this.description = d;
    }

    @Override
    public boolean equals(Object o) {
        Room r = (Room)o; 
        if(this.getName() == r.getName()){
            return true; 
        } else {  
            return false; 
        }
    }

    public void setNorth(Room r) {
        north = r; 
    }

    public void setSouth(Room r){
        south = r; 
    }

    public void setWest(Room r) {
        west = r; 
    }

    public void setEast(Room r) {
        east = r; 
    }

    public void setUp(Room r) {
        up = r; 
    }

    public void setDown(Room r){
        down = r;
    }

    public Room goNorth() {
        if(north == null) {
            System.out.println("You can't go this way \n"); 
            return this; 
        } else {
            return north; 
        } 
    }

    public Room goEast() {
        if(east == null) {
            System.out.println("You can't go this way\n"); 
            return this; 
        } else {
            return east; 
        }
    }

    public Room goSouth() {
        if(south == null) {
            System.out.println("You can't go this way \n"); 
            return this;
        } else {
            return south; 
        }
    }

    public Room goWest() {
        if(west == null) {
            System.out.println("You can't go this way \n"); 
            return this;
        } else {
            return west; 
        }
    }

    public Room goUp() {
        if(up == null) {
            System.out.println("You can't go this way"); 
            return this;
        } else {
            return up; 
        }
    }

    public Room goDown() {
        if(down == null) {
            System.out.println("You can't go this way \n"); 
            return this;
        } else {
            return down; 
        }
    }

    public void setDescription(String str) {
        description = str; 
    }

    public String getDescription() {
        return description; 
    }

    public String getName() {
        return name; 
    }

    public Item[] getItemInventory() {
        return stuff; 
    }

}