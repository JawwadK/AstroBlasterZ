import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss2 extends Enemy
{
  /**
   * Act - do whatever the Boss1 wants to do. This method is called whenever
   * the 'Act' or 'Run' button gets pressed in the environment.
   */
  private int health= 9;
  private int timer= 0;
  private int teletimer=0;
  public void act() 
  {
    // Add your action code here.
    if(health!=0)
    {
      collisionDetect();
      
      if(timer>20)
      {
        fire();
        timer=0;
      }
      timer++;
      
    }else{
      GreenfootSound diesound= new GreenfootSound("Explosion Effect.wav");
      diesound.play();  
      getWorld().removeObject(this);
      Player.addScore(4000);
    }
    teleportation();
  }
  public void teleportation()
  {
    if(teletimer>200)
    {
        setLocation(Greenfoot.getRandomNumber(400), Greenfoot.getRandomNumber(600));
        teletimer=0;
    }
    teletimer++;
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