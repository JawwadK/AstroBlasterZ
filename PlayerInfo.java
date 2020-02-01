/**
 * Write a description of class PlayerData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerInfo  
{
    // instance variables - replace the example below with your own
    private String name;
    private int score;

    /**
     * Constructor for objects of class PlayerData
     */
    public PlayerInfo(String n, int sc)
    {
        name=n;
        score=sc;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public  String returnName()
    {
        return name;
    }
    public  int getScore()
    {
        return score;
    }
    public String getName()
    {
        return name;
    }
    public String toString()
    {
        return name + " " + score;
    }
}
