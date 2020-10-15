import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Level3S here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3S extends Level
{
    GreenfootSound background = new GreenfootSound("level3.mp3");
    GreenfootSound victory = new GreenfootSound("victory.mp3");
    public Level3S(Score score, Gold gold){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(score, gold); 
        prepare();
    }

    private void prepare()
    {
        //Spawn Gold and Score
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
                    Level4S level4S = new Level4S(score, gold);
                    Greenfoot.setWorld(level4S);
                    level4S.advancePlayer1(player1, getWidth()/2, getHeight()/2);
                    victory.stop();
                }
            }
        }
    }
}
