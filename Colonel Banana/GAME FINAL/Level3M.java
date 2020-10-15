import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Jungle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3M extends Level
{
    GreenfootSound background = new GreenfootSound("level3.mp3");
    GreenfootSound victory = new GreenfootSound("victory.mp3");
    public Level3M(Score score, Gold gold){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(score, gold); 
        prepare();
    }

    private void prepare(){
        //Spawn Score and Gold
        addObject(score, 1525, 25);
        addObject(gold, 1525, 50);
        //Spawn AngryMonkeys
        AngryMonkeys angrymonkeys = new AngryMonkeys(2);
        addObject(angrymonkeys, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryMonkeys angrymonkeys2 = new AngryMonkeys(2);
        addObject(angrymonkeys2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryMonkeys angrymonkeys3 = new AngryMonkeys(2);
        addObject(angrymonkeys3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        //Spawm AngryMonkeys health
        addObject(angrymonkeys.health, angrymonkeys.getX(), angrymonkeys.getY()- offset);
        addObject(angrymonkeys2.health,angrymonkeys2.getX(), angrymonkeys2.getY()- offset);
        addObject(angrymonkeys3.health, angrymonkeys3.getX(), angrymonkeys3.getY()- offset);
        //Spawn Apes
        Apes apes = new Apes(3);
        addObject(apes, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes2 = new Apes(3);
        addObject(apes2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Apes apes3 = new Apes(3);
        addObject(apes3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        //Spawn Apes Health
        addObject(apes.health, apes.getX(), apes.getY()- offset);
        addObject(apes2.health, apes2.getX(), apes2.getY()- offset);
        addObject(apes3.health, apes3.getX(), apes3.getY()- offset);
    }
    
    public void act(){
        if(getObjects(Players.class).isEmpty()){//If both players dead
            background.stop();
            Greenfoot.setWorld(new GameOver());
        }
        else if(getObjects(Player1.class).isEmpty()){//If player1 is dead
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
                    Level4M level4M = new Level4M(score, gold);
                    Greenfoot.setWorld(level4M);
                    level4M.advancePlayer2(player2, (getWidth()/2), getHeight()/2);
                    victory.stop();
                }
            }
        }
        else if(getObjects(Player2.class).isEmpty()){//If player2 is dead
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
                    Level4M level4M = new Level4M(score, gold);
                    Greenfoot.setWorld(level4M);
                    level4M.advancePlayer1(player1, (getWidth()/2), getHeight()/2);
                    victory.stop();
                }
            }
        }
        else{//If both players dead
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
                    Level4M level4M = new Level4M(score, gold);
                    Greenfoot.setWorld(level4M);
                    level4M.advancePlayer1(player1, (getWidth()/2)-playerOffset, getHeight()/2);
                    level4M.advancePlayer2(player2, (getWidth()/2)+playerOffset, getHeight()/2);
                    victory.stop();
                }
            }
        }      
    }
}