import java.util.ArrayList; 
import java.util.Scanner; 
import java.io.File;
import java.io.IOException; 
import java.io.FileWriter; 
import java.io.PrintWriter; 
/**
 * Class to create a GroceryList and it's features
 * @author Jai Bansal 
 */
public class GroceryList {
    private ArrayList<ListItem> list; 
    /**
     * GroceryList Constructor, creates a new empty grocery list containing ListItem
     */
    public GroceryList() {
        list = new ArrayList<ListItem>(); 
    }

    /**
     * Runs the Grocery list program
     */
    public static void main(String[] args) {
        GroceryList gl = new GroceryList();
        int item = 0; 
        int index = 0; 
        int pos = 0; 
        Scanner in = new Scanner(System.in);
        String str = ""; 
        System.out.println("Your Grocery List");
        System.out.println("Use \"add\", \"insert\", \"remove\", \"complete\", \"clear\", \"export\", or \"exit\""); 
        while(true) {
            System.out.println("There is " + item + " items on your list"); 
            str = in.nextLine().trim().toLowerCase(); 
            switch(str) {
                case "add": 
                    System.out.println("What would you like to add?");
                    str = in.nextLine().trim().toLowerCase(); 
                    gl.add(str); 
                    System.out.println(gl.toString());
                    item++; 
                    break; 
                case "insert": 
                    System.out.println("What would you like to insert?"); 
                    String insert = in.nextLine().trim().toLowerCase(); 
                    System.out.println("Where would you like to add this?"); 
                    str = in.nextLine().trim().toLowerCase();
                    index = Integer.parseInt(insert); 
                    gl.insert(str, index); 
                    System.out.println(gl.toString()); 
                    item++; 
                    break;
                case "complete": 
                    System.out.println("What would you like to complete?"); 
                    str = in.nextLine().trim().toLowerCase(); 
                    gl.complete(gl.list.indexOf(str)); 
                    System.out.println(gl.toString()); 
                    item--; 
                    break; 
                case "clear": 
                    System.out.println("Clear which item?"); 
                    str = in.nextLine().trim().toLowerCase(); 
                    gl.remove(gl.list.indexOf(str));
                    System.out.println(gl.toString()); 
                    item--; 
                    break;
                case "export":
                    System.out.println("Your Grocery List was exported to file name \"list.htm\""); 
                    gl.exportAsHTML(); 
                    System.out.println(gl.toString()); 
                    break; 
                case "exit": 
                    System.out.println("Goodbye"); 
                    System.exit(1); 

                default: 
                    System.out.println("I don't understand that command"); 
                    break;
            }
        }
    }

    /**
     * Adds a list item to the end of the list
     * @param li List Item to add 
     */
    public void add(String li) {
        ListItem addLi = new ListItem(li); 
        list.add(addLi); 
    }

    /**
     * Inserts the list item at the specified index
     * @param li List item to insert
     * @param index Where to insert the list item
     */
    public void insert(String li, int index) {
        ListItem addLi = new ListItem(li); 
        list.add(index - 1, addLi); 
    }

    /**
     * Removes the list item at the index
     * @param index Index to remove from the list
     */
    public void remove(int index) {
        list.remove(index); 
    }

    /**
     * Marks the list item complete
     * @param index The index to mark complete
     */
    public void complete(int index) {
        list.get(index).complete(); 
    }

    /**
     * Removes all the completed items from the list
     */
    public void removeAllCompleted() {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).complete) {
                list.remove(i); 
            } 
        }
    }

    /**
     * Exports the grocery list to show in a webpage
     */
    public void exportAsHTML() {
        try {
            File f = new File("list.html"); 
            FileWriter fw = new FileWriter(f); 
            PrintWriter pw = new PrintWriter(fw); 
            pw.println("<!DOCTYPE html>"); 
            pw.println("<html>"); 
            pw.println("\t<head>"); 
            pw.println("\t\t<title> Your Grocery List </title>"); 
            pw.println("\t</head>");
            pw.println("\t<body>");
            pw.println("\t\t<h1> Items: </h1>"); 
            pw.println("\t\t<hr></hr>"); 
            pw.println("\t\t<ol>"); 
            for(ListItem item: this.list) {
                pw.println("\t\t\t<li>" + item.name + "</li>"); 
            }
            pw.println("\t\t</ol>"); 
            pw.println("</html>"); 
            pw.close(); 
            fw.close(); 
        } 
        catch (IOException e) {
            System.out.println("FNF"); 
            System.exit(1); 
        }
    }

    /**
     * Creates a String reprsentation of the Grocery List
     * @return String representation of the Grocery List
     */
    public String toString() {
        String str = "\nGrocery List\n";
        for(int i = 0; i < list.size(); i++) {
            str += (i + 1) + ")" + list.get(i).name + "\n"; 
        }
        return str; 
    }

    /**
     * ListItem class that creates a list item for grocery list
     */
    private class ListItem {
        private String name; 
        private boolean complete = false; 
        /**
         * Creates a new ListItem that is not done with a specificed name
         * @param name The specified name to give to the list
         */
        public ListItem(String name) {
            this.name = name; 
            this.complete = false; 
        }

        /**
         * Marks the list item complete
         */
        public void complete() {
            complete = true; 
        }
    }
}