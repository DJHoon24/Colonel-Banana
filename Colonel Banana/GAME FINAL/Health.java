import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    public int health;
    
    public Health(int health){
        this.health = health;
    }
    
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        setImage(new GreenfootImage("Health : " + health, 24, Color.RED, new Color(0,0,0,0)));
    }    
    
    public void loseHealth(int healthLost){
        health -= healthLost;
    }
}
