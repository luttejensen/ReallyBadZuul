
import java.util.HashMap;
import java.util.Set;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
//    private Room northExit;
//    private Room southExit;
//    private Room eastExit;
//    private Room westExit;
    

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * 
     * @param direction
     * @param neighbor
     */
    public void setExits(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Witch Room  we reach if we go from this room in direction "direction" if no room return null
     * @param direction
     * @return 
     */
    
    public Room getExit(String direction)
    {
        return exits.get(direction);
            
     }
    
    /**
     * Return a description of the rooms available exits
     * @return 
     */
    public String getExitString()
    {        
        String exitString = "Exits: ";
        String returnString = " ";
        
        Set<String> keys = exits.keySet();
            for(String exit : keys)
            {
                returnString += " " + exit;
            }
            return returnString;
       
  }
    
    /**
     * return a long description of the room
     * @return
     */
     public String getLongDescription()
        {
            return "Your are " + description + ".\n" + getExitString(); 
        }

}
