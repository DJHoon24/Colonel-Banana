import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gold extends Actor
{
    public int gold;
    
    public Gold(int gold){
        this.gold = gold;
    }
    
    /**
     * Act - do whatever the Gold wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        setImage(new GreenfootImage("Gold : " + gold, 24, Color.YELLOW, new Color(0,0,0,0)));
    }
    
    public void killMob(int goldWon){
        gold += goldWon;
    }
    
    public void loseGold(int goldLost){
        gold -= goldLost;
    }
}
