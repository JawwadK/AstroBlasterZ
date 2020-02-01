import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
  private int firedelay=0;
  private int speed=4;
  private int lives=3;
  private static int health=20;
  private static int firetimer=15;
  private static int score=0;
  private static int healthbuffnum=0;
  private static int speedbuffnum=0;
  private static int firebuffnum=0;
  /**
   * Act - do whatever the Player wants to do. This method is called whenever
   * the 'Act' or 'Run' button gets pressed in the environment.
   */
  public void act() 
  {
    if(health!=0)
    {
      collisionDetect();  
      Move(speed);
      Fire(1);
      firedelay++;
    }else{
      getWorld().removeObject(this);
    }
  }
  public void Fire(int times)
  {
    for(int i=0;i<times;i++)
    {
      if(Greenfoot.isKeyDown("f")&& firedelay>firetimer){
        GreenfootSound shooteffect= new GreenfootSound("Gun.mp3");
        PlayerBullet bullet = new PlayerBullet(); // creates the bullet object
        shooteffect.play();
        bullet.setRotation(getRotation()); // sets the direction of the bullet
        getWorld().addObject(bullet, getX(), getY()); // adds the bullet into the world
        firedelay=0;
      }
    }
  }
  public void Move(int fast){
    {
      
      if(Greenfoot.isKeyDown("down"))
      {
        setLocation(getX(),getY()+speed); 
      }
      if(Greenfoot.isKeyDown("up"))
      {
        setLocation(getX(),getY()-speed); 
      }
      if(Greenfoot.isKeyDown("right"))
      {
        
        setLocation(getX()+speed,getY()); 
      }
      if(Greenfoot.isKeyDown("left"))
      {
        setLocation(getX()-speed,getY()); 
      }
    }
  }
  public void collisionDetect(){
    Actor b=getOneIntersectingObject(EnemBullet.class);
    Actor c=getOneIntersectingObject(Powerup.class);
    if(b !=null)
    {
      World world= getWorld();
      
      
      
      getWorld().removeObject(b);
      health--;
      
      
    }
    if(c!=null)
    {
      int rng= Greenfoot.getRandomNumber(2);
      switch(rng)
      {    
        case 1:
          health+=2;
          healthbuffnum++;
          break;
        case 2:
          speed++;
          speedbuffnum++;
          break;
        default:
          firetimer--;
          firebuffnum++;
          break;
          
          
      }
      getWorld().removeObject(c);
      
      
      
    }
  }
  public static int getHealth()
  {
    return health;
  }
  public static int getScore()
  {
    return score;
  }
  public static void addScore(int points)
  {
    score+=points;
  }
  public static void minusScore(int points)
  {
    score-=points;
  }
  public static void decreaseHealth()
  {
    health--;
  }
  public static void setScore(int points)
  {
    score=points;
  }
  public static void setHealth(int points)  
  {
    health=points;
  }
  public static void setFiretimer(int points)
  {
    firetimer=points;
  }
  public static int getHealthbuffnum()
  {
    return healthbuffnum;
  }
  public static int getSpeedbuffnum()
  {
    return speedbuffnum;
  }
  public static int getFirebuffnum()
  {
    return firebuffnum;
  }
  public static void setHealthbuffnum(int points)  
  {
    healthbuffnum=points;
  }
  public static void setSpeedbuffnum(int points)  
  {
    speedbuffnum=points;
  }
  public static void setFirebuffnum(int points)  
  {
    firebuffnum=points;
  }
}

