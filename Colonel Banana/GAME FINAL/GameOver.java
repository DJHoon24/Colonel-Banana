import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private int timer = 30; //This timer stops the game from instantly switching to next World
    GreenfootSound sound = new GreenfootSound("gameover.mp3");

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public GameOver(){    
        super(1600, 900, 1); 
    }

    public void act(){
        timer--;
        sound.play();
        if(Greenfoot.isKeyDown("space")&& timer <= 0){
            Greenfoot.setWorld(new WelcomeScreen());
            sound.stop();
        }
    }
    
}
