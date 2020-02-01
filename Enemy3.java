import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Enemy
{
  /**
   * Act - do whatever the Enemy3 wants to do. This method is called whenever
   * the 'Act' or 'Run' button gets pressed in the environment.
   */
  
  private int health=3;
  public void act() 
  {
    // Add your action code here.
    move(-3);
    if(health!=0)
    {
      collisionDetect();
      
      if(getX()==0)
      {
        getWorld().removeObject(this);
        Player.minusScore(800);
      }
      
      
    }else{
      getWorld().removeObject(this);
    }
    
  } 
  public void collisionDetect(){
    Actor b=getOneIntersectingObject(PlayerBullet.class);
    Actor c=getOneIntersectingObject(Player.class);
    if(b !=null)
    {
      getWorld().removeObject(b);
      health--;       
    }
    else if(c !=null)
    {
      Player.decreaseHealth();
    }
  }
}



