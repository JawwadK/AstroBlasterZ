import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
  /**
   * Act - do whatever the Enemy1 wants to do. This method is called whenever
   * the 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() 
  {
    move(-1);
    collisionDetect();
    
  }
  public void collisionDetect(){
    Actor b=getOneIntersectingObject(PlayerBullet.class);
    Actor c=getOneIntersectingObject(Player.class);
    if(b !=null)
    {
      World world= getWorld();
      Player.addScore(400);
      getWorld().removeObject(b);
      getWorld().removeObject(this);
      
      
    }else if(c !=null)
    {
      Player.decreaseHealth();
      
    }else if(getX()==0)
    {
      getWorld().removeObject(this);
      Player.minusScore(300);
    }
    
  }
}
