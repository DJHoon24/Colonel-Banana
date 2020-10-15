import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int score;
    
    public Score(int score){
        this.score = score;
    }
            
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        setImage(new GreenfootImage("Score : " + score, 24, Color.GREEN, new Color(0,0,0,0)));
    }
    
    public void killMob(int scoreWon){
        score += scoreWon;
    }
}
