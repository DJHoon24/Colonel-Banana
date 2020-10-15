import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Level4S here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4S extends Level
{
    GreenfootSound background = new GreenfootSound("level4.mp3");
    GreenfootSound victory = new GreenfootSound("victory.mp3");
    public Level4S(Score score, Gold gold){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(score, gold); 
        prepare();
    }

    private void prepare(){
        //Spawn Gold and Score
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
        //Spawn Apes Health
        addObject(apes.health, apes.getX(), apes.getY()- offset);
        addObject(apes2.health, apes2.getX(), apes2.getY()- offset);
        addObject(apes3.health, apes3.getX(), apes3.getY()- offset);
        addObject(apes4.health, apes4.getX(), apes4.getY()- offset);
        //Spawn Monkeys
        Monkeys monkeys = new Monkeys(1);
        addObject(monkeys, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Monkeys monkeys2 = new Monkeys(1);
        addObject(monkeys2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Monkeys monkeys3 = new Monkeys(1);
        addObject(monkeys3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        Monkeys monkeys4 = new Monkeys(1);
        addObject(monkeys4, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        //Spawm Monkeys health
        addObject(monkeys.health, monkeys.getX(), monkeys.getY()- offset);
        addObject(monkeys2.health, monkeys2.getX(), monkeys2.getY()- offset);
        addObject(monkeys3.health, monkeys3.getX(), monkeys3.getY()- offset);
        addObject(monkeys4.health, monkeys4.getX(), monkeys4.getY()- offset);
        //Spawn AngryMonkeys
        AngryMonkeys angrymonkeys = new AngryMonkeys(2);
        addObject(angrymonkeys, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryMonkeys angrymonkeys2 = new AngryMonkeys(2);
        addObject(angrymonkeys2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryMonkeys angrymonkeys3 = new AngryMonkeys(2);
        addObject(angrymonkeys3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryMonkeys angrymonkeys4 = new AngryMonkeys(2);
        addObject(angrymonkeys4, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        //Spawm AngryMonkeys health
        addObject(angrymonkeys.health, angrymonkeys.getX(), angrymonkeys.getY()- offset);
        addObject(angrymonkeys2.health,angrymonkeys2.getX(), angrymonkeys2.getY()- offset);
        addObject(angrymonkeys3.health, angrymonkeys3.getX(), angrymonkeys3.getY()- offset);
        addObject(angrymonkeys4.health, angrymonkeys4.getX(), angrymonkeys4.getY()- offset);
    }

    public void act(){
        if(getObjects(Players.class).isEmpty()){
            background.stop();
            Greenfoot.setWorld(new GameOver());
        }
        else{
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
                else if(Greenfoot.isKeyDown("Space")){
                    Level5S level5S = new Level5S(score, gold);
                    Greenfoot.setWorld(level5S);
                    level5S.advancePlayer1(player1, getWidth()/2, getHeight()/2);
                    victory.stop();
                }
            }
        }
    }
}