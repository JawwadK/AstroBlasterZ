import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgainButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgainButton extends Button
{
    /**
     * Act - do whatever the PlayAgainButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {   
            Player.setHealth(20);
            Player.setScore(0);
            Player.setFiretimer(15);
            Player.setHealthbuffnum(0);
            Player.setSpeedbuffnum(0);
            Player.setFirebuffnum(0);
            Greenfoot.setWorld(new Level1());
            Greenfoot.stop();
        }
    }    
}
