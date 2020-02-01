import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
/**
 * Write a description of class Gamewin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWin extends World
{
    private int playerScore=Player.getScore();
    private int playerPos;
    private String name;
    GreenfootSound bgm= new GreenfootSound("Victory.mp3");
    /**
     * Constructor for objects of class Gamewin.
     * 
     */
    public GameWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        bgm.play();
        setBackground("StartScreen.png");
        addObject(new PlayAgainButton(), 300, 250);
        showText("Congratulations, you beat the game!", 300, 50);
        name= Greenfoot.ask("Please enter your name to get into leaderboards");
      
        
        //array is initialized from text file
        ArrayList<PlayerInfo> leaderboard= new ArrayList<PlayerInfo>();
        InputStream input = getClass().getClassLoader().getResourceAsStream("ScoreInfo.txt");
        Scanner reader= new Scanner(input);
        
        while(reader.hasNextLine())
        {
        String a= reader.nextLine();
        int b= reader.nextInt();
        PlayerInfo c= new PlayerInfo(a,b);
        leaderboard.add(c);
        }
        leaderboard.add(new PlayerInfo(name, playerScore));//adds players score into array
        PlayerInfo[] scorearray;//initializes scorearray
        scorearray=new PlayerInfo[leaderboard.size()];
        scorearray=leaderboard.toArray(scorearray);
        sortByScore(scorearray);
        int d= scorearray.length-1;
        showText("You placed "+ (scorearray.length-playerPos) + " on the leaderboards", 200,100);
        showText("1." + scorearray[d].toString(), 200, 150);
        showText("2." + scorearray[d-1].toString(), 200, 200);
        showText("3." + scorearray[d-2].toString(), 200, 250);
        showText("4." + scorearray[d-3].toString(), 200, 250);
        //PrintWriter output= new PrintWriter
        reader.close();
    }

    public void readFile()
    {
        ArrayList<PlayerInfo> leaderboard= new ArrayList<PlayerInfo>();
        InputStream input = getClass().getClassLoader().getResourceAsStream("ScoreInfo.txt");
        Scanner reader= new Scanner(input);
        
        while(reader.hasNext())
        {
        String a= reader.nextLine();
        int b= reader.nextInt();
        PlayerInfo c= new PlayerInfo(a,b);
        leaderboard.add(c);
        }
        leaderboard.add(new PlayerInfo(name, playerScore));//adds players score into array
        PlayerInfo[] scorearray;//initializes scorearray
        scorearray=new PlayerInfo[leaderboard.size()];
        scorearray=leaderboard.toArray(scorearray);
        
    }
  public static void sortByScore(PlayerInfo[] a)
  {
    int iPos=0;
    int iMin;
    for(iPos=0; iPos < a.length; iPos++)
    {
      iMin=iPos;
      for(int i=iPos+1; i< a.length;i++)
      {
        if(a[i].getScore()<a[iMin].getScore())
        {
          iMin=i;
        }
      }
      if(iMin!=iPos){
        PlayerInfo tmp;
        tmp= a[iPos];
        a[iPos]=a[iMin];
        a[iMin]=tmp;
      }
    }
  }
  
  public static int binarySearch(PlayerInfo[] a, int low, int high, int number) 
  {
    int middle;
    middle=(low+high)/2;
    if(number <  a[middle].getScore())
    {
      System.out.println("a");
      return binarySearch(a , low, middle, number);
    }
    if(number > a[middle].getScore())
    {
      System.out.println("b");
      return binarySearch(a, middle+1, high, number);
    }
    if(number==a[middle].getScore())
    {
      return middle;
    }else
    {
      return -1;
    }
    
  }  
}
