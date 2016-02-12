/**
 * Our awesome text adventure game!
 * @author Jai Bansal and Jacob Wagner
 */

import java.util.Scanner; 
import java.util.*; 
import java.util.ArrayList; 
/**
 * Main class that runs everything
 */
public class Main {
    private static Room currentRoom; 
    static Player player; 
    static int score; 
    private static Scanner in = new Scanner(System.in);
    private static String statement; 

    private static boolean condition = true; 
    private static int finalScore = 50; 
    private static Map<String, Room> m1 = new HashMap<String, Room>(); 
    private static boolean pictureFall = false; 
    private static boolean keyCheck = false; 
    private static boolean buttonPress = false;
    private static ArrayList<Item> inventory = new ArrayList(); 
    private static boolean batSuit = false; 
    private static boolean gadgets = false; 
    private static boolean batSuitWorn = false; 
    private static boolean riddlerDef = false;
    private static boolean penguinDef = false; 
    private static boolean jokerDef = false; 
    private static boolean twofaceDef = false; 
    private static boolean c = false; 
    private static boolean takeUmbrella = false; 

    /**
     * Main method that runs the game in a loop unless said otherwise
     */
    public static void main(String args[]) {
        setup(); 
        System.out.println("Welcome to Batman's last stand. \nThe only game where you can do stupid stuff that Batman would never do\n"); 
        System.out.println("Type exit any time to quit\n"); 
        while(condition){
            System.out.println("\n" + "You are in " + currentRoom.getName() + "\n" + currentRoom.getDescription() + "\n"); 
            String statement = in.nextLine().toLowerCase();
            readCommand(statement); 
        }
    }

    /**
     * Adds the amount of score due to the Player's action
     * @param s Amount of score to be added
     */
    public static void addScore(int s) {
        finalScore += s; 
    }

    /**
     * Reads the command and does the specified action
     * @param command The command that needs to be read
     */
    public static void readCommand(String command) {
        Weapon knife = new Weapon("Knife", "Joker's knife that is so elegant as soon as you set it cuts you"); 
        Item pen = new Item("Pen", "The pen that can be used to write"); 
        Equippable batsuit = new Equippable("Batsuit", "The suit that Batman wears"); 
        Weapon grapplingGun = new Weapon("Grappling Gun", "Used to clap onto an object and make Batman more mobile"); 
        Weapon smokePellet = new Weapon("Smoke Pellet", "Used to evade enemies and it also looks so cool!"); 
        Weapon batarang = new Weapon("Batarang", "Can be thrown at enemies and scar them to death!"); 
        Item umbrella = new Item("Umbrella", "Penguin's umbrella to block objects"); 
        Weapon gun = new Weapon("Gun", "The gun that Two Face uses to attempt defeat batman!"); 
        Item cane = new Item("Cane", "A cane used by the elderly and The Riddler");
        Item key = new Item("Key", "The key to the bathroom"); 
        Item scotchBottle = new Item("Scotch Bottle", "A vodka bottle with a removable cap"); 
        Item button = new Item("Don't Press Me Button", "A button that says don't press me"); 
        Usable picture = new Usable("Picture", "A picture on the east wall", "There is a key behind the wall"); 
        Usable scotch = new Usable("Scotch Bottle", "A bottle full of scotch on the dining room table", "The picture falls to the floor");
        Item bomb = new Item("Bomb", "Very powerful Bomb"); 

        Character penguin = new Character("Penguin", "Really short, wears an eye glass on one eye, and has an umbrella", new Item[]{umbrella});
        Character batman = new Character("Batman", "Wears a batsuit that is all black", new Item[]{}); 
        Character joker = new Character("Joker", "Purple suit and pants, lot of face powder, and green hair", new Item[]{knife}); 
        Character twoFace = new Character("Two Face", "Has two faces, one burned and one normal, has also two persoanlities along side with his two faces", new Item[]{gun}); 
        Character riddler = new Character("Riddler", "Has some mental disorders but ultimately loves riddles for Batman's doom", new Item[]{cane}); 
        Character fan = new Character("Fan", "Really wants to get an autograph from batman", new Item[]{}); 

        String i = command.toLowerCase().trim(); 
        String msg = ""; 
        if(i.equals("exit")) {
            System.out.println("\nGoodbye, Sir"); 
            System.exit(0); 
        } 
        else if (i.equals("n")|| i.equals("north") || i.equals("go north")) 
        {
            if(currentRoom.getName().equals("The Batcave: Center Platform")){
                if(gadgets == true && batSuit == true && batSuitWorn == true) {
                    System.out.println("\nAre you sure you want to go to the City Center?"); 
                    addScore(20); 
                    msg = in.nextLine().toLowerCase(); 
                    switch (msg) {        
                        case "yes": 
                        currentRoom = currentRoom.goNorth(); 
                        break; 
                        case "no": 
                        currentRoom = currentRoom.goSouth(); 
                        break;
                        default: 
                        System.out.println("\nI don't know what that means"); 
                    }
                } else if(gadgets == false) {
                    System.out.println("\nI would go get some gadgets before you leave"); 
                    addScore(-5); 
                } else if(batSuit == false) {
                    System.out.println("\nUm...you kind of need your Bat Suit when you go outside...or else bad things happen. Yea bad things"); 
                    addScore(-5); 
                } else if(batSuitWorn == false) {
                    System.out.println("\nYea it's great you have the Bat Suit, but I think the point of it is to wear it."); 
                    addScore(-5); 
                }
            } else if(currentRoom.getName().equals("The West Street End") && riddlerDef == false) {
                System.out.println("\nYou encounter the Riddler inside the Toy Store standing on the cashier checkout desk. He is messing with the various toys in the store. He turns around to you and says:\nRiddler: Well Batman I guess we are here at last. Make your move!\n"); 
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("attack riddler")){
                    System.out.println("\nAttack him with what?\n"); 
                    msg = in.nextLine().toLowerCase(); 
                    if(msg.equals("grappling gun")){
                        System.out.println("\nYour grappling gun reaches out and takes away one of his toy. In the despair of losing his toy the Riddler tries to reach out and catch it.\nBut it is too late and as he tries to reach out he falls of the cashier checkout hitting his head on the floor knocking him out\n"); 
                        System.out.println("\nWell we always knew the Riddler wasn't very hard to defeat\n"); 
                        addScore(100); 
                        riddlerDef = true; 
                        Room toyStore = m1.get("The Toy Store"); 
                        toyStore.setDescription("Riddler has been defeated so there is nothing for you to do here");
                    } else if(msg.equals("smoke pellet")){
                        System.out.println("\nYou use your smoke pellet but apparently the one you use is a dud. Riddler throws the toy he was messing with at you which was apparenlty a bomb.\nBOOM!\nWell you don't exist anymore. Better luck next time\n"); 
                        endGame(); 
                    } else if(msg.equals("batarang")) {
                        System.out.println("\nYou throw your batarang at the Ridller but it hits the toy he was holding which was apparenlty a bomb.\nBOOM!\nWell you killed Riddler but yourself too. Good job\n"); 
                        endGame(); 
                    } else {
                        System.out.println("\nWell I don't know what that is so Riddler just throws his toy at you which was a bomb, making a big hole in the floor and in you. You should really try harder next time\n"); 
                        endGame() ;
                    }
                } 
                else 
                {
                    System.out.println("\nI don't know what that means"); 
                }

            } 
            else if(currentRoom.getName().equals("The East Street End") && twofaceDef == false)
            {
                System.out.println("\nYou find Two Face robbing a bank. He hasn't noticed you yet. What will you do? Attack him? Use one of your gadgets? This is so exciting!");
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("attack twoface") || msg.equals("attack two face")){
                    System.out.println("\nJust before you could attack Two Face with something, one of his goons notices you hiding behind a pillar and starts firing at you. Yea I don't think insurance covers that"); 
                    endGame(); 
                } else if(msg.equals("use smokepellet") || msg.equals("use smokepellet")){
                    System.out.println("\nYour smoke pellet blinds all of Two Face's goons and himself too. Will you now:\n1)Go on to a perch 2) Attack Two Face 3) Climb into a grate into the floor\n*Type the number*"); 
                    msg = in.nextLine().toLowerCase(); 
                    switch(msg) {
                        case "1": 
                        System.out.println("\nYou go onto a perch. Two Face is luckily right underneath you. What is your plan of attack?");
                        msg = in.nextLine().toLowerCase(); 
                        if(msg.equals("attack twoface") || msg.equals("attack two face")){
                            System.out.println("\nYou succesfully perform a inverted stealth takedown, knocking Two Face out cold. Good job. Virtual Five!"); 
                            Room bank = m1.get("The Bank"); 
                            bank.setDescription("Two Face is still knocked out cold on that perch and my hand still hurts from that virtual five. You got some serious muscle, but back to crime fighting!"); 
                            twofaceDef = true; 
                            break;
                        } else {
                            System.out.println("\nOh no you acted too late, and everyone started shooting at you. Yea that must have hurt"); 
                            endGame(); 
                        }
                        case "2":
                        System.out.println("\nYou try to attack Two Face but you just ended up hitting your head on a wall because you can't see anything, knocking yourself out. I don't even want to know what happens after that\n"); 
                        endGame(); 
                        case "3": 
                        System.out.println("\nYou climb into the grate but you notice a rat inside the grates so you jump out only to be met by goons. Yeaaa....have fun!....Dying!");
                        endGame();
                        default:
                        System.out.println("\nYou can't do that. So you just stand there and after the smoke cleared up Two Face....shot you in the head and you died. The End!"); 
                        endGame(); 
                    }
                } else if(msg.equals("use batarang")) {
                    System.out.println("\nYou try to use the batarangs but apparenlty you pull out your non lethal batarangs. They don't really work on killing people so Two Face took a gun and shot you. At least you went out doing nice things"); 
                    endGame(); 
                } else if(msg.equals("use grappling gun")) {
                    System.out.println("\nYour grappling gun is out of battries, and that mistake leads to a bullet in your head! Violence is good kids."); 
                    endGame(); 
                } else {
                    System.out.println("\nThat is not a valid command"); 
                }
            } 
            else if(currentRoom.getName().equals("The South Street End") && (twofaceDef == true && riddlerDef == true && jokerDef == true && takeUmbrella == true))
            {
                Room cityCenter = m1.get("The City Center"); 
                cityCenter.setDescription("\nA robot seems to have appeared in the middle of the city\n"); 
                currentRoom = currentRoom.goNorth(); 
                fightRobot(); 
            }
            else
            {
                currentRoom = currentRoom.goNorth();
            }
        }
        else if (i.equals("s")|| i.equals("south") || i.equals("go south"))
        {
            if(currentRoom.getName().equals("The West Street End") && jokerDef == false) {
                System.out.println("\nYou enter the Magic Store to see that the Joker is waiting for you! Joker always loved magic tricks especially card tricks. Joker speaks saying:\nHey Bats, want to see a card trick?!\nYou should act before it's too late"); 
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("attack joker")) {
                    System.out.println("\nAttack him with what?\n"); 
                    msg = in.nextLine().toLowerCase(); 
                    if(msg.equals("batarang")) {
                        System.out.println("What will you throw your batarang at?\n1)Joker\n2)The bag of sand hanging above the Joker\n3)The electric unit right next to the Joker\n*Type the number*"); 
                        msg = in.nextLine().toLowerCase(); 

                        switch (msg) {
                            case "1":
                            System.out.println("Joker catches your batarang as it comes to his face. He then throws his stack of cards at your face which apparently were thin slices of steel cutting you in all kinds of places. Ouch.");
                            endGame(); 
                            case "2":
                            System.out.println("The bag of sand falls onto the floor, the Joker dodged it.\nJoker: You must think I'm a really bad villian if that was going to work.\nThe Joker then throws his stack of cards at you, which were thin slices of metal and they cut you in all kinds of place. Ouch."); 
                            endGame(); 
                            case "3":
                            System.out.println("The electric unit sparks and it zaps Joker who was for some reason carrying some fluids in his vest. He gets knocked out by the extreme jolt of electricity"); 
                            break; 
                            default:
                            System.out.println("That isn't one of the options so for that Joker kills you with his steel metal playing cards he throws at you. That must have hurt"); 
                            endGame(); 
                        }
                    } else if(msg.equals("smoke pellet")) {
                        System.out.println("Your smoke pellet makes a extreme fog around you, but the Joker escapes in the fog. That kind of backfired.");
                        endGame(); 
                    } else if(msg.equals("grappling gun")) {
                        System.out.println("You try to shoot your grappling gun, but it for some reason malfunctiones. Joker then throws his stack of cards he is holding at your which are thin slices of steel cutting you in all kinds of places. Ouch");
                        endGame(); 
                    }
                }
                else {
                    System.out.println("I don't understand"); 
                }
            }
            else if(currentRoom.getName().equals("The South Street End") && (twofaceDef == true && riddlerDef == true && jokerDef == true && takeUmbrella == true))
            {
                Room cityCenter = m1.get("The City Center"); 
                cityCenter.setDescription("A robot seems to have appeared in the middle of the city"); 
                currentRoom = currentRoom.goNorth(); 
                fightRobot(); 
            }
            else if(currentRoom.getName().equals("The East Street End"))
            {
                if(takeUmbrella == false) {
                    System.out.println("You enter the Ice Cream Shop expecting a villian but you just find Penguin's umbrella lying on the ground");
                    msg = in.nextLine().toLowerCase(); 
                    if(msg.equals("take umbrella") && takeUmbrella == false){
                        System.out.println("Taken"); 
                        Room iceCreamShop = m1.get("The Ice Cream Shop"); 
                        iceCreamShop.setDescription("There is nothing here, but leftover ice cream. Sounds pretty good place to get fat."); 
                        takeUmbrella = true; 
                        inventory.add(umbrella); 
                    } 
                    else 
                    {
                        System.out.println("You can't do that"); 
                    }
                } else if(takeUmbrella == true) {
                    currentRoom = currentRoom.goSouth(); 
                }
            } 
            else
            {
                currentRoom = currentRoom.goSouth();
            }
        } 
        else if (i.equals("w") || i.equals("west") || i.equals("go west")) 
        {   
            if(currentRoom.getName().equals("Bruce Wayne's Room") && keyCheck == false) 
            {
                System.out.println("\nThe bathroom door seems to be locked. Seems like a key is needed for it to be open"); 
                Room bathroom = m1.get("The Bathroom"); 
                currentRoom = bathroom.goEast(); 
            } 
            else if(currentRoom.getName().equals("The South Street End") && (twofaceDef == true && riddlerDef == true && jokerDef == true && takeUmbrella == true))
            {
                Room cityCenter = m1.get("The City Center"); 
                cityCenter.setDescription("A robot seems to have appeared in the middle of the city"); 
                currentRoom = currentRoom.goNorth(); 
                fightRobot(); 
            }
            else if(currentRoom.getName().equals("Bruce Wayne's Room") && keyCheck == true)
            {
                System.out.println("\nThe bathroom door seems to be locked. Seems like a key is needed for it to be open"); 
                msg = in.nextLine().toLowerCase(); 
                if((msg.equals("use")) && keyCheck == true) 
                {
                    System.out.println("\nUse what?\n"); 
                    msg = in.nextLine().toLowerCase(); 
                    if((msg.equals("key") || msg.equals("use key")) && keyCheck == true)
                    {
                        System.out.println("You have opened the door");
                        currentRoom = currentRoom.goWest();
                        inventory.clear(); 
                        addScore(10); 
                    }
                } 
                else if((msg.equals("use key")) && keyCheck == true)
                {
                    System.out.println("You have opened the door");
                    currentRoom = currentRoom.goWest();
                    inventory.clear(); 
                    addScore(10); 
                } 
                else
                {
                    System.out.println("I don't understand that command"); 
                }
            } else if(currentRoom.getName().equals("The North Street End") && riddlerDef == false) {
                System.out.println("\nYou encounter the Riddler inside the Toy Store standing on the cashier checkout desk. He is messing with the various toys in the store. He turns around to you and says:\nRiddler: Well Batman I guess we are here at last. Make your move!\n"); 
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("attack riddler")){
                    System.out.println("\nAttack him with what?\n"); 
                    msg = in.nextLine().toLowerCase(); 
                    if(msg.equals("grappling gun")){
                        System.out.println("Your grappling gun reaches out and takes away one of his toy. In the despair of losing his toy the Riddler tries to reach out and catch it.\nBut it is too late and as he tries to reach out he falls of the cashier checkout hitting his head on the floor knocking him out\n"); 
                        System.out.println("Well we always knew the Riddler wasn't very hard to defeat\n"); 
                        addScore(100); 
                        riddlerDef = true; 
                        Room toyStore = m1.get("The Toy Store"); 
                        toyStore.setDescription("Riddler has been defeated so there is nothing for you to do here");
                    } else if(msg.equals("smoke pellet")){
                        System.out.println("\nYou use your smoke pellet but apparently the one you use is a dud. Riddler throws the toy he was messing with at you which was apparenlty a bomb.\nBOOM!\nWell you don't exist anymore. Better luck next time\n"); 
                        endGame(); 
                    } else if(msg.equals("batarang")) {
                        System.out.println("\nYou throw your batarang at the Ridller but it hits the toy he was holding which was apparenlty a bomb.\nBOOM!\nWell you killed Riddler but yourself too. Good job\n"); 
                        endGame(); 
                    } else {
                        System.out.println("\nWell I don't know what that is so Riddler just throws his toy at you which was a bomb, making a big hole in the floor and in you. You should really try harder next time\n"); 
                        endGame() ;
                    }
                } else {
                    System.out.println("\nI don't know what that means"); 
                }
            } 
            else if(currentRoom.getName().equals("The South Street End") && jokerDef == false) 
            {
                System.out.println("\nYou enter the Magic Store to see that the Joker is waiting for you! Joker always loved magic tricks especially card tricks. Joker speaks saying:\nHey Bats, want to see a card trick?!\nYou should act before it's too late"); 
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("attack joker")) {
                    System.out.println("\nAttack him with what?\n"); 
                    msg = in.nextLine().toLowerCase(); 
                    if(msg.equals("batarang")) {
                        System.out.println("What will you throw your batarang at?\n1)Joker\n2)The bag of sand hanging above the Joker\n3)The electric unit right next to the Joker\n*Type the number*"); 
                        msg = in.nextLine().toLowerCase(); 

                        switch (msg) {
                            case "1":
                            System.out.println("\nJoker catches your batarang as it comes to his face. He then throws his stack of cards at your face which apparently were thin slices of steel cutting you in all kinds of places. Ouch.");
                            endGame(); 
                            case "2":
                            System.out.println("\nThe bag of sand falls onto the floor, the Joker dodged it.\nJoker: You must think I'm a really bad villian if that was going to work.\nThe Joker then throws his stack of cards at you, which were thin slices of metal and they cut you in all kinds of place. Ouch."); 
                            endGame(); 
                            case "3":
                            System.out.println("\nThe electric unit sparks and it zaps Joker who was for some reason carrying some fluids in his vest. He gets knocked out by the extreme jolt of electricity"); 
                            Room magicShop = m1.get("The Magic Shop"); 
                            magicShop.setDescription("Joker is been defeated, so go fight justice somewhere else now");
                            jokerDef = true; 
                            break; 
                            default:
                            System.out.println("\nThat isn't one of the options so for that Joker kills you with his steel metal playing cards he throws at you. That must have hurt"); 
                            endGame(); 
                        }
                    } else if(msg.equals("smoke pellet") || msg.equals("smokepellet")) {
                        System.out.println("\nYour smoke pellet makes a extreme fog around you, but the Joker escapes in the fog. That kind of backfired.");
                        endGame(); 
                    } else if(msg.equals("grappling gun")) {
                        System.out.println("\nYou try to shoot your grappling gun, but it for some reason malfunctiones. Joker then throws his stack of cards he is holding at your which are thin slices of steel cutting you in all kinds of places. Ouch");
                        endGame(); 
                    }
                } else {
                    System.out.println("\nI don't understand"); 
                }
            } 
            else if(currentRoom.getName().equals("The  Street End") && twofaceDef == false)
            {
                System.out.println("\nYou find Two Face robbing a bank. He hasn't noticed you yet. What will you do? Attack him? Use one of your gadgets? This is so exciting!");
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("attack twoface") || msg.equals("attack two face")){
                    System.out.println("Just before you could attack Two Face with something, one of his goons notices you hiding behind a pillar and starts firing at you. Yea I don't think insurance covers that"); 
                    endGame(); 
                } else if(msg.equals("use smokepellet") || msg.equals("use smokepellet")){
                    System.out.println("\nYour smoke pellet blinds all of Two Face's goons and himself too. Will you now:\n1)Go on to a perch 2) Attack Two Face 3) Climb into a grate into the floor\n*Type the number*"); 
                    msg = in.nextLine().toLowerCase(); 
                    switch(msg) {
                        case "1": 
                        System.out.println("\nYou go onto a perch. Two Face is luckily right underneath you. What is your plan of attack?");
                        msg = in.nextLine().toLowerCase(); 
                        if(msg.equals("attack twoface") || msg.equals("attack two face")){
                            System.out.println("\nYou succesfully perform a inverted stealth takedown, knocking Two Face out cold. Good job. Virtual Five!"); 
                            Room bank = m1.get("The Bank"); 
                            bank.setDescription("Two Face is still knocked out cold on that perch and my hand still hurts from that virtual five. You got some serious muscle, but back to crime fighting!"); 
                            twofaceDef = true; 
                            break;
                        } else {
                            System.out.println("Oh no you acted too late, and everyone started shooting at you. Yea that must have hurt"); 
                            endGame(); 
                        }
                        case "2":
                        System.out.println("\nYou try to attack Two Face but you just ended up hitting your head on a wall because you can't see anything, knocking yourself out. I don't even want to know what happens after that\n"); 
                        endGame(); 
                        case "3": 
                        System.out.println("\nYou climb into the grate but you notice a rat inside the grates so you jump out only to be met by goons. Yeaaa....have fun!....Dying!");
                        endGame();
                        default:
                        System.out.println("\nYou can't do that. So you just stand there and after the smoke cleared up Two Face....shot you in the head and you died. The End!"); 
                        endGame(); 
                    }
                } else if(msg.equals("use batarang")) {
                    System.out.println("\nYou try to use the batarangs but apparenlty you pull out your non lethal batarangs. They don't really work on killing people so Two Face took a gun and shot you. At least you went out doing nice things"); 
                    endGame(); 
                } else if(msg.equals("use grappling gun")) {
                    System.out.println("\nYour grappling gun is out of battries, and that mistake leads to a bullet in your head! Violence is good kids."); 
                    endGame(); 
                } else {
                    System.out.println("\nThat is not a valid command"); 
                }
            } 
            else 
            {
                currentRoom = currentRoom.goWest(); 
            }
        }
        else if (i.equals("e") || i.equals("east") || i.equals("go east")) 
        {
            if(currentRoom.getName().equals("The North Street End") && twofaceDef == false)
            {
                System.out.println("\nYou find Two Face robbing a bank. He hasn't noticed you yet. What will you do? Attack him? Use one of your gadgets? This is so exciting!");
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("attack twoface") || msg.equals("attack two face")){
                    System.out.println("\nJust before you could attack Two Face with something, one of his goons notices you hiding behind a pillar and starts firing at you. Yea I don't think insurance covers that"); 
                    endGame(); 
                } else if(msg.equals("use smokepellet") || msg.equals("use smokepellet")){
                    System.out.println("\nYour smoke pellet blinds all of Two Face's goons and himself too. Will you now:\n1)Go on to a perch 2) Attack Two Face 3) Climb into a grate into the floor\n*Type the number*"); 
                    msg = in.nextLine().toLowerCase(); 
                    switch(msg) {
                        case "1": 
                        System.out.println("\nYou go onto a perch. Two Face is luckily right underneath you. What is your plan of attack?");
                        msg = in.nextLine().toLowerCase(); 
                        if(msg.equals("attack twoface") || msg.equals("attack two face")){
                            System.out.println("\nYou succesfully perform a inverted stealth takedown, knocking Two Face out cold. Good job. Virtual Five!"); 
                            Room bank = m1.get("The Bank"); 
                            bank.setDescription("Two Face is still knocked out cold on that perch and my hand still hurts from that virtual five. You got some serious muscle, but back to crime fighting!"); 
                            twofaceDef = true; 
                            break;
                        } else {
                            System.out.println("Oh no you acted too late, and everyone started shooting at you. Yea that must have hurt"); 
                            endGame(); 
                        }
                        case "2":
                        System.out.println("\nYou try to attack Two Face but you just ended up hitting your head on a wall because you can't see anything, knocking yourself out. I don't even want to know what happens after that\n"); 
                        endGame(); 
                        case "3": 
                        System.out.println("\nYou climb into the grate but you notice a rat inside the grates so you jump out only to be met by goons. Yeaaa....have fun!....Dying!");
                        endGame();
                        default:
                        System.out.println("\nYou can't do that. So you just stand there and after the smoke cleared up Two Face....shot you in the head and you died. The End!"); 
                        endGame(); 
                    }
                } else if(msg.equals("use batarang")) {
                    System.out.println("\nYou try to use the batarangs but apparenlty you pull out your non lethal batarangs. They don't really work on killing people so Two Face took a gun and shot you. At least you went out doing nice things"); 
                    endGame(); 
                } else if(msg.equals("use grappling gun")) {
                    System.out.println("\nYour grappling gun is out of battries, and that mistake leads to a bullet in your head! Violence is good kids."); 
                    endGame(); 
                } else {
                    System.out.println("\nThat is not a valid command"); 
                }
            }
            else if(currentRoom.getName().equals("The South Street End") && (twofaceDef == true && riddlerDef == true && jokerDef == true && takeUmbrella == true))
            {
                Room cityCenter = m1.get("The City Center"); 
                cityCenter.setDescription("A robot seems to have appeared in the middle of the city"); 
                fightRobot(); 
            }
            else if(currentRoom.getName().equals("The South Street End"))
            {
                if(takeUmbrella == false) {
                    System.out.println("\nYou enter the Ice Cream Shop expecting a villian but you just find Penguin's umbrella lying on the ground");
                    msg = in.nextLine().toLowerCase(); 
                    if(msg.equals("take umbrella") && takeUmbrella == false){
                        System.out.println("\nTaken"); 
                        Room iceCreamShop = m1.get("The Ice Cream Shop"); 
                        iceCreamShop.setDescription("There is nothing here, but leftover ice cream. Sounds pretty good place to get fat."); 
                        takeUmbrella = true; 
                        inventory.add(umbrella); 
                    } 
                    else 
                    {
                        System.out.println("\nYou can't do that"); 
                    }
                }
                else if(takeUmbrella == true) 
                {
                    currentRoom = currentRoom.goEast(); 
                }
            } 
            else
            {
                currentRoom = currentRoom.goEast();
            }
        }
        else if(i.equals("down") || i.equals("go down")) 
        {
            if(buttonPress = false && currentRoom.getName().equals("The Bathroom")) 
            {
                System.out.println("\nYou can't go this way"); 
            } 
            else
            {
                currentRoom = currentRoom.goDown(); 
            }
        } 
        else if(i.equals("up") || i.equals("go up"))
        {
            currentRoom = currentRoom.goUp(); 
        }
        else if(currentRoom.getName().equals("The Picture Room")) 
        { 
            if(pictureFall == true) 
            {
                if(i.equals("take"))
                {
                    System.out.println("\nTake what?\n"); 
                    msg = in.nextLine().toLowerCase(); 
                    if(msg.equals("key") || msg.equals("take key")) 
                    {
                        keyCheck = true; 
                        System.out.println("\nYou have taken the key"); 
                        inventory.add(key); 
                        pictureFall = false; 
                        Room pictureRoom = m1.get("The Picture Room"); 
                        pictureRoom.setDescription("The fallen picture of Robert Schreiber lies on the floor (where it belongs)"); 
                    } 
                    else 
                    {
                        System.out.println("\nYou can't take that"); 
                    }
                } 
                else if(i.equals("take key"))
                {
                    keyCheck = true; 
                    System.out.println("\nYou have taken the key"); 
                    inventory.add(key); 
                    pictureFall = false; 
                    Room pictureRoom = m1.get("The Picture Room"); 
                    pictureRoom.setDescription("The fallen picture of Robert Schreiber lies on the floor (where it belongs)"); 
                } else {
                    System.out.println("\nI don't know what that means"); 
                }
            } 

        } 
        else if(currentRoom.getName().equals("The Dining Room")) 
        {
            if(i.equals("open"))
            {
                System.out.println("\nOpen what\n"); 
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("scotch bottle") || msg.equals("scotch"))
                {
                    scotch.use(); 
                    pictureFall = true; 
                    Room pictureRoom = m1.get("The Picture Room"); 
                    pictureRoom.setDescription("The picture of great Robert Schreiber has fallen and has revealed a key"); 
                    Room diningRoom = m1.get("The Dining Room"); 
                    diningRoom.setDescription("Someone seems to have opened the scotch bottle..."); 
                    Room livingRoom = m1.get("The Living Room"); 
                    livingRoom.setDescription("The east wall now contains a fallen picture of Robert Schreiber"); 
                    addScore(50); 
                } 
                else 
                {
                    System.out.println("\nYou can't open that"); 
                }
            } 
            else if(i.equals("open scotch bottle") || i.equals("open scotch")) 
            {
                scotch.use(); 
                pictureFall = true; 
                Room pictureRoom = m1.get("The Picture Room"); 
                pictureRoom.setDescription("The picture of great Robert Schreiber has fallen and has revealed a key"); 
                Room diningRoom = m1.get("The Dining Room"); 
                diningRoom.setDescription("Someone seems to have opened the scotch bottle..."); 
                Room livingRoom = m1.get("The Living Room"); 
                livingRoom.setDescription("The east wall now contains a fallen picture of Robert Schreiber"); 
                addScore(50); 
            }
            else {
                System.out.println("\nI don't know what that means"); 
                addScore(-5); 
            }
        } 
        else if(currentRoom.getName().equals("The Bathroom"))
        {
            if(i.equals("press button"))
            {
                buttonPress = true; 
                Room bathroom = m1.get("The Bathroom"); 
                bathroom.setDescription("To the north of you is a sink and toilet. The west side contains a bathtub and the south wall has a button seemed to have already been pressed"); 
            } 
            else 
            {
                System.out.println("\nI don't understand that command"); 
                addScore(-5); 
            }            
            if(buttonPress = true) {
                currentRoom = currentRoom.goDown(); 
                Room bathroom = m1.get("The Bathroom"); 
                bathroom.setDescription("To the north of you is a sink and toilet. The west side contains a bathtub and the south wall has a button seemed to have already been pressed"); 
            }
        }
        else if(currentRoom.getName().equals("The Batcave: Gadget Room"))
        {
            if(i.equals("take gadgets"))
            {
                System.out.println("You have taken a batarang, a grapling gun and a smokepellet"); 
                inventory.add(grapplingGun); 
                inventory.add(batarang); 
                inventory.add(smokePellet);
                Room gadgetRoom = m1.get("The Batcave: Gadget Room"); 
                gadgetRoom.setDescription("The room in the BatCave now only containing the Batsuit"); 
                gadgets = true; 
            } 
            else if(i.equals("take batsuit"))
            {
                System.out.println("Taken"); 
                inventory.add(batsuit); 
                Room gadgetRoom = m1.get("The Batcave: Gadget Room"); 
                gadgetRoom.setDescription("The room in the BatCave now only containing gadgets"); 
                batSuit = true; 
            } 
            else if(i.equals("wear batsuit")) 
            {
                if(batSuit == true) 
                {
                    batsuit.equip(batsuit); 
                    batSuitWorn = true; 
                } 
                else 
                {
                    System.out.println("You don't have that yet"); 
                }
            }
            else 
            {
                System.out.println("I don't understand what that means"); 
                addScore(-5); 
            }
            if(gadgets == true && batSuit == true)
            {
                Room gadgetRoom = m1.get("The Batcave: Gadget Room"); 
                gadgetRoom.setDescription("The room in the BatCave that now contains nothing"); 
            }
        }
        else if(i.equals("wear batsuit")) {
            if(batSuit == true) {
                batsuit.equip(batsuit); 
                batSuitWorn = true; 
            } else {
                System.out.println("You don't have that yet"); 
            }
        }
        else if(i.equals("i") || i.equals("inventory") || i.equals("open inventory") || i.equals("show inventory"))
        {
            for(Item item: inventory) {
                System.out.println(item); 
            }
        }
        else 
        {
            System.out.println("\nI don't understand what that means."); 
            addScore(-5); 
        }
    }

    public static void fightRobot() {
        addScore(100);
        System.out.println("\n" + "You are in " + currentRoom.getName() + "\n" + currentRoom.getDescription() + "\n"); 
        String msg = in.nextLine().toLowerCase(); 
        if(msg.equals("attack robot"))
        {
            System.out.println("\nWith what?\n"); 
            msg = in.nextLine().toLowerCase(); 
            if(msg.equals("grappling gun"))
            {
                System.out.println("The robot dodges the grappling gun and starts shooting at you. What do you use?");
                msg = in.nextLine().toLowerCase(); 
                if(msg.equals("use umbrella"))
                {
                    System.out.println("You deflected the bullets back to the robots killing it! Who knew Teriminators were easier to kill than we thought.\n"); 
                    addScore(500); 
                    endGame(); 
                } 
                else 
                {
                    System.out.println("\nYou are unsuccesful in deflecting the bullets killing you instantly\n"); 
                    addScore(-50); 
                    endGame(); 
                }
            }
            else if(msg.equals("batarang") )
            {
                System.out.println("Your batarang accidently hits the red button on the robot making it into a nuclear bomb and kind of blowing up everything"); 
                addScore(-50); 
                endGame(); 
            } 
            else if(msg.equals("smokepellet") || msg.equals("smoke pellet"))
            {
                System.out.println("If you think that smoke is going to beat a mysterious robot, you're wrong because the robot isn't going to die via smoke pellet. So happy...whatever you do in heaven...or hell"); 
                addScore(-50); 
                endGame(); 
            }
            else if(msg.equals("umbrella"))
            {
                System.out.println("You pop out your umbrella and it does suddenly start raining, but it just isn't regular rain. It is toxic acid rain which melts through your umbrella killing you"); 
                addScore(-50); 
                endGame(); 
            } 
            else 
            {
                System.out.println("You stand there like an idiotic fool and the robot pummels you to pieces."); 
                addScore(-50); 
                endGame(); 
            }
            
        }
    }

    /**
     * Method to end the game
     */
    public static void endGame() {
        System.out.println("Well thanks for playing Batman's last stand. Your final score was " + finalScore + ". I mean that isn't bad but my grandma could have beat that. Anyway hopefull you play again! Type exit to quit");
        String msg = in.nextLine().toLowerCase(); 
        if(msg.equals("exit")) {
            System.exit(0); 
        } else {
            System.out.println("Ok I'll just exit for you, you imbeicle"); 
            System.exit(0); 
        }
    }

    /**
     * Setups all the items, and room realtionships 
     */
    public static void setup() {
        Weapon knife = new Weapon("Knife", "Joker's knife that is so elegant as soon as you set it cuts you"); 
        Item pen = new Item("Pen", "The pen that can be used to write"); 
        Equippable batsuit = new Equippable("Batsuit", "The suit that Batman wears"); 
        Weapon grapplingGun = new Weapon("Grappling Gun", "Used to clap onto an object and make Batman more mobile"); 
        Weapon smokePellet = new Weapon("Smoke Pellet", "Used to evade enemies and it also looks so cool!"); 
        Weapon batarang = new Weapon("Batarang", "Can be thrown at enemies and scar them to death!"); 
        Item umbrella = new Item("Umbrella", "Penguin's umbrella to block objects"); 
        Weapon gun = new Weapon("Gun", "The gun that Two Face uses to attempt defeat batman!"); 
        Item cane = new Item("Cane", "A cane used by the elderly and The Riddler");
        Item key = new Item("Key", "The key to the bathroom"); 
        Item scotchBottle = new Item("Scotch Bottle", "A vodka bottle with a removable cap"); 
        Item button = new Item("Don't Press Me Button", "A button that says don't press me"); 
        Usable picture = new Usable("Picture", "A picture on the east wall", "There is a key behind the wall"); 
        Usable scotch = new Usable("Scotch Bottle", "A bottle full of scotch on the dining room table", "The picture falls to the floor");

        Character penguin = new Character("Penguin", "Really short, wears an eye glass on one eye, and has an umbrella", new Item[]{umbrella});
        Character batman = new Character("Batman", "Wears a batsuit that is all black", new Item[]{}); 
        Character joker = new Character("Joker", "Purple suit and pants, lot of face powder, and green hair", new Item[]{knife}); 
        Character twoFace = new Character("Two Face", "Has two faces, one burned and one normal, has also two persoanlities along side with his two faces", new Item[]{gun}); 
        Character riddler = new Character("Riddler", "Has some mental disorders but ultimately loves riddles for Batman's doom", new Item[]{cane}); 
        Character fan = new Character("Fan", "Really wants to get an autograph from batman", new Item[]{}); 

        Room bruceWayneRoom = new Room(new Item[]{pen}, new Character[]{},  "Bruce Wayne's Room",  "There are doors north and west of you. The door to the west seems to be the bathroom."); 
        Room livingRoom = new Room(new Item[]{scotchBottle, key}, new Character[]{},  "The Living Room", "The east wall contains a picture of Robert Schreiber with an abnormally long beard.\nThe west side of the room contains a dining table ");        
        Room pictureRoom = new Room(new Item[]{picture}, new Character[]{}, "The Picture Room", "The Picture of Robert Schreiber is on the east wall(he looks so young)"); 
        Room bathroom = new Room(new Item[]{button}, new Character[]{}, "The Bathroom", "To the north of you is a sink and toilet. The west side contains a bathtub and the south wall has a misplaced button on it that says \"Don’t Press Me.\"");
        Room centerPlatform = new Room(new Item[]{}, new Character[]{},  "The Batcave: Center Platform", "The platform in the middle of the Batcave. To west side of the Batcave is the gadgetRoom. The east side contains the Batcomputer but seems broken. And the north side has the batmobile.");
        Room batmobile = new Room(new Item[]{}, new Character[]{}, "The Batmobile", "The vehicle batman uses to get to locations");
        Room computerPlatform = new Room(new Item[]{}, new Character[]{}, "The Batcave: Computer Platform", "Where Batman does all of his work but the computer seems to be broken out of use right now."); 
        Room gadgetRoom = new Room(new Item[]{batsuit,grapplingGun, smokePellet, batarang}, new Character[]{}, "The Batcave: Gadget Room", "The room in the bat cave containing gadgets and the bat suit");
        Room cityCenter = new Room(new Item[]{}, new Character[]{},  "The City Center", "The middle for a city block with roads leading North, East, South, and West of you");
        Room northStreetEnd = new Room(new Item[]{}, new Character[]{}, "The North Street End", "The end of North Street. There are buildings to the East and West of you");
        Room southStreetEnd = new Room(new Item[]{}, new Character[]{}, "The South Street End", "The end of South Street. There are buildings to the East and West of you");
        Room eastStreetEnd = new Room(new Item[]{}, new Character[]{}, "The East Street End", "The end of East Street. There are buildings to the North and South of you");
        Room westStreetEnd = new Room(new Item[]{}, new Character[]{}, "The West Street End", "The end of West Street. There are buildings to the North and South of you");
        Room magicShop = new Room(new Item[]{}, new Character[]{riddler}, "The Magic Shop", "A magic shop with the Joker who has a pretty scary knife");
        Room iceCreamShop = new Room(new Item[]{}, new Character[]{penguin}, "The Ice Cream shop", "An Ice Cream shop with the penguin, who looks ready for a fight");
        Room bank = new Room(new Item[]{}, new Character[]{twoFace},  "The Bank", "Gotham City Bank, the best bank in Gotham, currently getting robbed by twoFace");
        Room toyStore = new Room(new Item[]{}, new Character[]{joker}, "The Toy Store", "A Toy Store with The Riddler standing in the back waiting for your move");
        Room diningRoom = new Room(new Item[]{scotchBottle}, new Character[]{}, "The Dining Room", "The room in which Batman eats, there is a scotch bottle on the table");

        currentRoom = bruceWayneRoom; 

        bruceWayneRoom.setNorth(livingRoom); 
        bruceWayneRoom.setSouth(null); 
        bruceWayneRoom.setWest(bathroom); 
        bruceWayneRoom.setEast(pictureRoom); 
        bruceWayneRoom.setUp(null); 
        bruceWayneRoom.setDown(null); 

        livingRoom.setNorth(null); 
        livingRoom.setSouth(bruceWayneRoom); 
        livingRoom.setEast(pictureRoom); 
        livingRoom.setWest(diningRoom);
        livingRoom.setUp(null);
        livingRoom.setDown(null);

        bathroom.setNorth(null);    
        bathroom.setWest(null);    
        bathroom.setSouth(null);    
        bathroom.setEast(bruceWayneRoom);
        bathroom.setUp(null);
        bathroom.setDown(centerPlatform);

        diningRoom.setNorth(null); 
        diningRoom.setSouth(null); 
        diningRoom.setWest(null);
        diningRoom.setEast(livingRoom);
        diningRoom.setUp(null);
        diningRoom.setDown(null);

        pictureRoom.setNorth(null);
        pictureRoom.setSouth(null);
        pictureRoom.setEast(null);
        pictureRoom.setWest(livingRoom);
        pictureRoom.setUp(null);
        pictureRoom.setDown(null);

        centerPlatform.setNorth(cityCenter);
        centerPlatform.setSouth(null);
        centerPlatform.setWest(gadgetRoom);
        centerPlatform.setEast(computerPlatform);
        centerPlatform.setUp(bathroom);
        centerPlatform.setDown(null);

        gadgetRoom.setNorth(null);
        gadgetRoom.setSouth(null);
        gadgetRoom.setWest(null);
        gadgetRoom.setEast(centerPlatform);
        gadgetRoom.setUp(null);
        gadgetRoom.setDown(null);

        computerPlatform.setNorth(null);
        computerPlatform.setSouth(null);
        computerPlatform.setEast(null);
        computerPlatform.setWest(centerPlatform);
        computerPlatform.setUp(null);
        computerPlatform.setDown(null);

        cityCenter.setNorth(northStreetEnd);
        cityCenter.setSouth(southStreetEnd);
        cityCenter.setWest(westStreetEnd);
        cityCenter.setEast(eastStreetEnd);
        cityCenter.setUp(null);
        cityCenter.setDown(null);

        northStreetEnd.setNorth(null);
        northStreetEnd.setSouth(cityCenter);
        northStreetEnd.setEast(bank);
        northStreetEnd.setWest(toyStore);
        northStreetEnd.setUp(null);
        northStreetEnd.setDown(null);

        southStreetEnd.setNorth(cityCenter);
        southStreetEnd.setSouth(null);
        southStreetEnd.setEast(iceCreamShop);
        southStreetEnd.setWest(magicShop);
        southStreetEnd.setUp(null);
        southStreetEnd.setDown(null);

        eastStreetEnd.setNorth(bank);
        eastStreetEnd.setSouth(iceCreamShop);
        eastStreetEnd.setEast(null);
        eastStreetEnd.setWest(cityCenter);
        eastStreetEnd.setUp(null);
        eastStreetEnd.setDown(null);

        westStreetEnd.setNorth(toyStore);
        westStreetEnd.setSouth(magicShop);
        westStreetEnd.setEast(cityCenter);
        westStreetEnd.setWest(null);
        westStreetEnd.setUp(null);
        westStreetEnd.setDown(null);

        toyStore.setNorth(null);
        toyStore.setSouth(westStreetEnd);
        toyStore.setEast(northStreetEnd);
        toyStore.setWest(null);
        toyStore.setUp(null);
        toyStore.setDown(null);

        bank.setNorth(null);
        bank.setSouth(eastStreetEnd);
        bank.setEast(null);
        bank.setWest(northStreetEnd);
        bank.setUp(null);
        bank.setDown(null);

        iceCreamShop.setNorth(eastStreetEnd);
        iceCreamShop.setSouth(null);
        iceCreamShop.setEast(null);
        iceCreamShop.setWest(southStreetEnd);
        iceCreamShop.setUp(null);
        iceCreamShop.setDown(null);

        magicShop.setNorth(westStreetEnd);
        magicShop.setSouth(null);
        magicShop.setEast(southStreetEnd);
        magicShop.setWest(null);
        magicShop.setUp(null);
        magicShop.setDown(null);

        m1.put("Bruce Wayne's Room", bruceWayneRoom); 
        m1.put("The Living Room", livingRoom);
        m1.put("The Dining Room", diningRoom);
        m1.put("The Bathroom", bathroom);
        m1.put("The Picture Room", pictureRoom);
        m1.put("The Batcave: Center Platform", centerPlatform);
        m1.put("The Batcave: Gadget Room", gadgetRoom);
        m1.put("The Batcave: Computer Platform", computerPlatform);
        m1.put("The Batcave: Batmobile", batmobile);
        m1.put("The City Center", cityCenter);
        m1.put("The North Street End", northStreetEnd);
        m1.put("The East Street End", eastStreetEnd);
        m1.put("The South Street End", southStreetEnd);
        m1.put("The West Street End", westStreetEnd);
        m1.put("The Bank", bank);
        m1.put("The Magic Shop", magicShop);
        m1.put("The Ice Cream Shop", iceCreamShop);
        m1.put("The Toy Store", toyStore);
    } 
}