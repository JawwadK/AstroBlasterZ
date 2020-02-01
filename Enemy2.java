import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class Enemy2 extends Enemy
{
  private int health= 5;
  private int timer= 0;
  private int speed=1;
  /**
   * Act - do whatever the Enemy2 wants to do. This method is called whenever
   * the 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() 
  {
    move(-1);
    
    if(health!=0)
    {
      collisionDetect();
      
      if(timer>70)
      {
        fire();
        timer=0;
      }else if(getX()==0)
      {
        Player.minusScore(1200);
        getWorld().removeObject(this);
        
      }
      timer++;
      
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
    }else if( c!=null)
    {
      Player.decreaseHealth();
    }
  }
  public void fire()
  {
    getWorld().addObject(new EnemBullet() ,getX(),getY());
  }
}
