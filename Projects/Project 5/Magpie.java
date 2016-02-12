/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White and Jai Bansal 
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        } else if(statement.indexOf("dog") >= 0
                || statement.indexOf("cat") >= 0)
        {
            response = "Tell me more about your pets."; 
        } else if(statement.indexOf("Schreiber") >= 0)
        {
            response = "I thought his name was Scrubber."; 
        } else if(statement.trim().length() == 0)
        {
            response = "You typed nothing, who do you think I am?"; 
        } else if (statement.indexOf("batman") >= 0)
        {
            response = "Jai is the one and only Batman."; 
        } else if (statement.indexOf("cheese") >= 0)
        {
            response = "I like cheese."; 
        } else if (statement.indexOf("Fifa") >= 0)
        {
            response = "I'll wreck you in FIFA anyday."; 
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        } 
        else if (whichResponse == 4)
        {
            response = "Huh sounds important."; 
        }
        else if (whichResponse == 5)
        {
            response = "Man that is so......cool?"; 
        }
        return response;
    }
}
