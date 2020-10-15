import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Jungle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level5M extends Level
{
    GreenfootSound background = new GreenfootSound("level5.mp3");
    GreenfootSound victory = new GreenfootSound("victory.mp3");
    public Level5M(Score score, Gold gold){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(score, gold); 
        prepare();
    }

    private void prepare(){
        //Spawn Score and Gold
        addObject(score, 1525, 25);
        addObject(gold, 1525, 50);
        //Spawn Apes
        Apes apes = new Apes(3);
        addObject(apes, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes2 = new Apes(3);
        addObject(apes2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes3 = new Apes(3);
        addObject(apes3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes4 = new Apes(3);
        addObject(apes4, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes5 = new Apes(3);
        addObject(apes5, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes6 = new Apes(3);
        addObject(apes6, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes7 = new Apes(3);
        addObject(apes7, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes8 = new Apes(3);
        addObject(apes8, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes9 = new Apes(3);
        addObject(apes9, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        //Spawn Apes Health
        addObject(apes.health, apes.getX(), apes.getY()- offset);
        addObject(apes2.health, apes2.getX(), apes2.getY()- offset);
        addObject(apes3.health, apes3.getX(), apes3.getY()- offset);
        addObject(apes4.health, apes4.getX(), apes4.getY()- offset);
        addObject(apes5.health, apes5.getX(), apes5.getY()- offset);
        addObject(apes6.health, apes6.getX(), apes6.getY()- offset);
        addObject(apes7.health, apes7.getX(), apes7.getY()- offset);
        addObject(apes8.health, apes8.getX(), apes8.getY()- offset);
        addObject(apes9.health, apes9.getX(), apes9.getY()- offset);
    }
    
    public void act(){
        if(getObjects(Players.class).isEmpty()){//If both players dead
            background.stop();
            Greenfoot.setWorld(new GameOver());
        }
        else if(getObjects(Player1.class).isEmpty()){//If player1 dead
            List<Player2> player2s = getObjects(Player2.class);
            Player2 player2 = player2s.get(0);
            background.play();
            if(getObjects(Mobs.class).isEmpty()){
                background.stop();
                victory.play();
                if(Greenfoot.isKeyDown("m")){
                    Shop shop = new Shop();
                    addObject(shop, getWidth()/2, getHeight()/2);
                }
                if(Greenfoot.isKeyDown("Space")){
                    Level6M level6M = new Level6M(score, gold);
                    Greenfoot.setWorld(level6M);
                    level6M.advancePlayer2(player2, (getWidth()/2), getHeight()/2);
                    victory.stop();
                }
            }
        }
        else if(getObjects(Player2.class).isEmpty()){//If player2 dead
            List<Player1> player1s = getObjects(Player1.class);
            Player1 player1 = player1s.get(0);
            background.play();
            if(getObjects(Mobs.class).isEmpty()){
                background.stop();
                victory.play();
                if(Greenfoot.isKeyDown("m")){
                    Shop shop = new Shop();
                    addObject(shop, getWidth()/2, getHeight()/2);
                }
                if(Greenfoot.isKeyDown("Space")){
                    Level6M level6M = new Level6M(score, gold);
                    Greenfoot.setWorld(level6M);
                    level6M.advancePlayer1(player1, (getWidth()/2), getHeight()/2);
                    victory.stop();
                }
            }
        }
        else{//If both players alive
            List<Player1> player1s = getObjects(Player1.class);
            Player1 player1 = player1s.get(0);
            List<Player2> player2s = getObjects(Player2.class);
            Player2 player2 = player2s.get(0);
            background.play();
            if(getObjects(Mobs.class).isEmpty()){
                background.stop();
                victory.play();
                if(Greenfoot.isKeyDown("m")){
                    Shop shop = new Shop();
                    addObject(shop, getWidth()/2, getHeight()/2);
                }
                if(Greenfoot.isKeyDown("Space")){
                    Level6M level6M = new Level6M(score, gold);
                    Greenfoot.setWorld(level6M);
                    level6M.advancePlayer1(player1, (getWidth()/2)-playerOffset, getHeight()/2);
                    level6M.advancePlayer2(player2, (getWidth()/2)+playerOffset, getHeight()/2);
                    victory.stop();
                }
            }
        }
    }
}
