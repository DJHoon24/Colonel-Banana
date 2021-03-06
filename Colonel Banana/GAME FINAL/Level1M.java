import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1M extends Level
{
    GreenfootSound background = new GreenfootSound("level1.mp3");
    GreenfootSound victory = new GreenfootSound("victory.mp3");
    public Level1M(){   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(new Score(0), new Gold(1000));         
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare(){
        //Spawn Gold and Score
        score = new Score(0);
        gold = new Gold(0);
        addObject(gold, 1525, 50);
        addObject(score, 1525, 25);
        //Spawn Players
        Player1 player1 = new Player1(50);
        addObject(player1, (getWidth()/2)-playerOffset, getHeight()/2);
        addObject(player1.health, player1.getX(), player1.getY()- offset);
        Player2 player2 = new Player2(50);
        addObject(player2, (getWidth()/2)+playerOffset, getHeight()/2);
        addObject(player2.health, player2.getX(), player2.getY()- offset);
        //Spawn Monkeys
        Monkeys monkeys = new Monkeys(1);
        addObject(monkeys, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Monkeys monkeys2 = new Monkeys(1);
        addObject(monkeys2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Monkeys monkeys3 = new Monkeys(1);
        addObject(monkeys3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Monkeys monkeys4 = new Monkeys(1);
        addObject(monkeys4, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Monkeys monkeys5 = new Monkeys(1);
        addObject(monkeys5, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Monkeys monkeys6 = new Monkeys(1);
        addObject(monkeys6, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        //Spawm Monkeys health
        addObject(monkeys.health, monkeys.getX(), monkeys.getY()- offset);
        addObject(monkeys2.health, monkeys2.getX(), monkeys2.getY()- offset);
        addObject(monkeys3.health, monkeys3.getX(), monkeys3.getY()- offset);
        addObject(monkeys4.health, monkeys4.getX(), monkeys4.getY()- offset);
        addObject(monkeys5.health, monkeys5.getX(), monkeys5.getY()- offset);
        addObject(monkeys6.health, monkeys6.getX(), monkeys6.getY()- offset);
    }

    public void act(){
        if(getObjects(Players.class).isEmpty()){ //If both players dead
            background.stop();
            Greenfoot.setWorld(new GameOver());
        }
        else if(getObjects(Player1.class).isEmpty()){ //If player1 dead
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
                    Level2M level2M = new Level2M(score, gold);
                    Greenfoot.setWorld(level2M);
                    level2M.advancePlayer2(player2, (getWidth()/2), getHeight()/2);
                    victory.stop();
                }
            }
        }
        else if(getObjects(Player2.class).isEmpty()){ //If player2 dead
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
                    Level2M level2M = new Level2M(score, gold);
                    Greenfoot.setWorld(level2M);
                    level2M.advancePlayer1(player1, (getWidth()/2), getHeight()/2);
                    victory.stop();
                }
            }
        }
        else{ //If both players alive
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
                    Level2M level2M = new Level2M(score, gold);
                    Greenfoot.setWorld(level2M);
                    level2M.advancePlayer1(player1, (getWidth()/2)-playerOffset, getHeight()/2);
                    level2M.advancePlayer2(player2, (getWidth()/2)+playerOffset, getHeight()/2);
                    victory.stop();
                }
            }
        }
    }
}
