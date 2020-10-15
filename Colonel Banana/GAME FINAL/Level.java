import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    protected Score score;
    protected Gold gold;
    protected int offset = 30;
    protected int playerOffset = 100;
    public Level(Score score, Gold gold){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
        
        this.score = score;
        this.gold = gold;
    }
    
    public void advancePlayer1(Player1 player1, int x, int y){ //Method advances player1 to next lvl
        addObject(player1, x, y);
        addObject(player1.health, 50, 25);
    }
    
    public void advancePlayer2(Player2 player2, int x, int y){//Method advances player2 to next lvl
        addObject(player2, x, y);
        addObject(player2.health, 50, 25);
    }
    
    public Score getScore(){
        return score;
    }
    
    public Gold getGold(){
        return gold;
    }
    
}
