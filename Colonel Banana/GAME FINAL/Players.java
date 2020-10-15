import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceActors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Players extends Actor
{    
    protected int offset = 30; //This integer is used to put health above the Players
    /**
     * Act - do whatever the SpaceActors wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String hitTheEdge(){ //A method that tells if I hit the edge and what edge I hit    
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

    public void bounceAtEdge(){//A method that bounces players off the wall
        String edge = hitTheEdge();
        int x = getX();
        int y = getY();
        World myWorld = getWorld();
        int rightSide = myWorld.getWidth() - 1;
        int bottomSide = myWorld.getHeight() - 1;
        if(edge == "bottom"){
            setRotation(270);
            move(40);
        } 
        else if(edge == "top"){
            setRotation(90);
            move(40);
        } 
        else if(edge == "left"){
            setRotation(0);
            move(40);
        } 
        else if(edge == "right"){
            setRotation(180);
            move(40);
        }
    }
}
