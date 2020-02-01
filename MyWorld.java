import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World 
{
  private int time=0;
  private GreenfootSound backgroundMusic = new GreenfootSound("BGM.mp3");
  /**
   * Constructor for objects of class MyWorld.
   * 
   */
  private int timer=0;
  private int numEnemies=0;
  private int numBoss=0;
  public MyWorld()
  {    
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    
    super(600, 400, 1);
    started();
    setBackground("spacebackground.jpg");
    addObject(new Player(), 300, 300);
    showText("Health: "+ Player.getHealth(), 50, 10);
    showText("Score:"+ Player.getScore(), 50, 25);
    showText("Level: 1", 50, 40);
    //music.setVolume(4);
    
    
  }
  public void act()
  {
    showText("Health: "+ Player.getHealth(), 50, 10);
    showText("Score:"+ Player.getScore(), 50, 25);
    showText("Level: 1", 50, 40);  
    checkPause();  
    runSpawnTimer();
    if(numEnemies>40&& numBoss<1)
    {
      addObject(new Boss1(), 600, 200);
      numBoss++;
    }        
    
    if(numBoss>0 && getObjects(Boss1.class).isEmpty())
    {
      Greenfoot.setWorld(new Level2());
    }
  }
  public void checkPause()
  {
    if(Greenfoot.isKeyDown("p"))
    {
    Greenfoot.stop();
    }
    if(Greenfoot.isKeyDown("r"))
    {
    Greenfoot.start();
    }
    }
  public void runSpawnTimer()
  {
    if(timer>50&& numEnemies<50)
    {
      
      spawnEnemy();
      timer=0;  
    }
    timer++;
    
  }
  public void spawnEnemy()
  {
    
    addObject(new Enemy1(), 590, Greenfoot.getRandomNumber(400));
    numEnemies++;
  }
  
  public void started()
  {
    //backgroundMusic.playLoop();
  }
  
}
