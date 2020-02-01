import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss1 extends Enemy
{
  /**
   * Act - do whatever the Boss1 wants to do. This method is called whenever
   * the 'Act' or 'Run' button gets pressed in the environment.
   */
  private int health= 7;
  private int timer= 0;
  private int speed=1;
  public void act() 
  {
    // Add your action code here.
    if(health!=0)
    {
      collisionDetect();
      
      if(timer>30)
      {
        fire();
        timer=0;
      }
      timer++;
      
    }else{
      GreenfootSound diesound= new GreenfootSound("Explosion Effect.wav");
      diesound.play();  
      getWorld().removeObject(this);
      Player.addScore(3000);
    }
    move(5);
    turn(6);
  }
  
  
  
  
  public void fire()
  {
    getWorld().addObject(new EnemBullet(), getX(), getY());
    
  }
  public void collisionDetect(){
    Actor b=getOneIntersectingObject(PlayerBullet.class);
    if(b !=null)
    {
      getWorld().removeObject(b);
      health--;       
    }
    Actor c=getOneIntersectingObject(Player.class);
    if(c !=null)
    {
       Player.decreaseHealth();
       
    }
  }
  
  
  
  
}