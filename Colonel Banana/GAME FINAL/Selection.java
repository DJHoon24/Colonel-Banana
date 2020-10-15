import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selection extends World
{
    private int timer = 30; //This timer stops the game from instantly switching to next World
    GreenfootSound theme = new GreenfootSound("theme.mp3");
    
    public Selection(){    
        super(1600, 900, 1); 
    }

    public void act(){
        theme.play();
        timer--;
        if(Greenfoot.isKeyDown("2")&& timer <= 0){//This transitions into multiplayer mode
            Greenfoot.setWorld(new Level1M());
            theme.stop();
        }
        else if(Greenfoot.isKeyDown("1")&& timer <= 0){//This transitions to solo mode
            Greenfoot.setWorld(new Level1S());
            theme.stop();
        }
    }
}
