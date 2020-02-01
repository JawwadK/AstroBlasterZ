import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World 
{
  private int time=0;
  private GreenfootSound bgm = new GreenfootSound("BackgroundTrack2.mp3");
  /**
   * Constructor for objects of class MyWorld.
   * 
   */
  private int timer=0;
  private int numEnemies=0;
  private int numBoss=0;
  private int numMinBoss=0;
  private int elitetimer=0;
  private int buffNum=0;
  private int spawntimer=0;
  public Level2()
  {    
    // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    
    super(600, 400, 1);
    started();
    setBackground("Spacebackground2.png");
    addObject(new Player(), 300, 300);
    showText("Health: "+ Player.getHealth(), 50, 10);
    showText("Score:"+ Player.getScore(), 50, 25);
    showText("Level: 2", 50, 40);
    showText("H buffs:"+Player.getHealthbuffnum(), 50, 55);
    showText("S buffs:"+Player.getSpeedbuffnum(), 50, 70);
    showText("F buffs:"+Player.getFirebuffnum(), 50, 85);    
    
    
    
  }
  public void act()
  {
    if(getObjects(Player.class).isEmpty())
    {
      Greenfoot.setWorld(new GameOver());
    }
    showText("Health: "+ Player.getHealth(), 50, 10);
    showText("Score:"+ Player.getScore(), 50, 25);
    showText("Level: 2", 50, 40);
    showText("H buffs:"+Player.getHealthbuffnum(), 50, 55);
    showText("S buffs:"+Player.getSpeedbuffnum(), 50, 70);
    showText("F buffs:"+Player.getFirebuffnum(), 50, 85);    
    checkPause();
    runSpawnTimer();
    runEliteSpawnTimer();
    runBuffSpawnTimer();
    if(numEnemies>35&& numBoss<1)
    {
      addObject(new Boss2(), 600, 200);
      numBoss++;
    }        
    if(numEnemies>30 && numMinBoss<1)
    {
      addObject(new Boss1(), 470, Greenfoot.getRandomNumber(400));
      numMinBoss++;
    }
    
    if(numBoss>0 && getObjects(Boss2.class).isEmpty())
    {
      bgm.stop();  
      Greenfoot.setWorld(new Level3());
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
    if(timer>50&& numEnemies<40)
    {
      
      spawnEnemy();
      timer=0;  
    }
    timer++;
    
  }
  public void runEliteSpawnTimer()
  {
    if(elitetimer>120 && numEnemies < 40)
    {
      spawnEliteEnemy();
      elitetimer=0;
    }
    elitetimer++;
  }
  public void runBuffSpawnTimer()
  {
    if(spawntimer>600&& buffNum<2)
    {
      spawnPowerup();
      spawntimer=0;
    }
    spawntimer++;
    
    
  }  
  public void spawnEnemy()
  {
    
    addObject(new Enemy1(), 590, Greenfoot.getRandomNumber(400));
    numEnemies++;
  }
  public void spawnEliteEnemy(){
    addObject(new Enemy3(), 590, Greenfoot.getRandomNumber(400));
    numEnemies++;
  }
  public void spawnPowerup()
  {
    addObject(new Powerup(), 590, Greenfoot.getRandomNumber(400));
    buffNum++;
  }
  public void started()
  {
    bgm.playLoop();
  }
  
}
