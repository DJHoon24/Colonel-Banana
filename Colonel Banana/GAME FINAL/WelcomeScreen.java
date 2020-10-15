import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WelcomeScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WelcomeScreen extends World
{
    private int timer = 30; //This timer stops the game from instantly switching to next World
    GreenfootSound theme = new GreenfootSound("theme.mp3");
    /**
     * Constructor for objects of class WelcomeScreen.
     * 
     */
    public WelcomeScreen(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
    }

    public void act(){
        theme.play();
        timer--;
        if(Greenfoot.isKeyDown("space") && timer <= 0){
            Greenfoot.setWorld(new Instructions());
            theme.stop();
        }
    }
    
}
