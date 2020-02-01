import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemBullet extends Bullet
{
    /**
     * Act - do whatever the EnemBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add 
        move(-8);
       

        if(getX()<=0)
        {
        getWorld().removeObject(this);
        }
    }    
}
