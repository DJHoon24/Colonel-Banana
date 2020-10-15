import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mobs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mobs extends Actor
{   
    protected int offset = 30; //This integer is used to put health above the Mobs
    /**
     * Act - do whatever the Mobs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String hitTheEdge(){//This method tells if I hit the edge of map
        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth() - 1;
        int bottomSide = myWorld.getHeight() - 1;
        if(y == 0){
            return "top";
        } 
        else if (x == 0){
            return "left";
        } 
        else if(x == rightSide){
            return "right";
        } 
        else if(y == bottomSide){
            return "bottom";
        } 
        else{
            return null;
        }
    }

    public void bounceAtEdge(){//This method allows mobs to bounce off the wall
        String edge = hitTheEdge();
        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth() - 1;
        int bottomSide = myWorld.getHeight() - 1;
        if(edge == "bottom"){
            setRotation(270);
        } 
        else if(edge == "top"){
            setRotation(90);
        } 
        else if(edge == "left"){
            setRotation(0);
        } 
        else if(edge == "right"){
            setRotation(180);
        }
    }

    public int getRandomNumber(int start, int end){//RandomNumber Method
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }
}
