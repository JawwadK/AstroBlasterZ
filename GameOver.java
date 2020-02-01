import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    GreenfootSound bgm= new GreenfootSound("Lose.mp3");
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        bgm.play();
        setBackground("StartScreen.png");
        showText("You lost, play again? ", 300, 200);
        addObject(new PlayAgainButton(), 300, 250); 
    }
}
