import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Winner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Winner extends World
{
    private int timer = 30; //This timer stops the game from instantly switching to next World
    /**
     * Constructor for objects of class Winner.
     * 
     */
    public Winner(){    
        super(1600, 900, 1); 
    }
    
    public void act(){
        timer--;
        if(Greenfoot.isKeyDown("space")&& timer <= 0){
            Greenfoot.setWorld(new WelcomeScreen());
        }
    }
}
