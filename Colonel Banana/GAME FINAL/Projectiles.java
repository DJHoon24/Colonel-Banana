import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectiles extends Actor
{
    /**
     * Act - do whatever the Projectiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public void movement(){
        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        int rightSideOfScreen = myWorld.getWidth()-1;
        int bottomOfScreen = myWorld.getHeight()-1;
        if (x <= 0 || x >= rightSideOfScreen || y <= 0 || y>= bottomOfScreen){
            myWorld.removeObject(this);
        }
    }    
}
