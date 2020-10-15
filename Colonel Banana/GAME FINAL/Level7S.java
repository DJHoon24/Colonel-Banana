import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Level7S here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level7S extends Level
{
    GreenfootSound background = new GreenfootSound("level7.mp3");
    GreenfootSound victory = new GreenfootSound("victory.mp3");
    public Level7S(Score score, Gold gold){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(score, gold); 
        prepare();
    }

    private void prepare(){
        //Spawn Gold and Score
        addObject(score, 1525, 25);
        addObject(gold, 1525, 50);
        //Spawn Angry Apes
        AngryApes angryapes = new AngryApes(6);
        addObject(angryapes, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryApes angryapes2 = new AngryApes(6);
        addObject(angryapes2, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryApes angryapes3 = new AngryApes(6);
        addObject(angryapes3, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryApes angryapes4 = new AngryApes(6);
        addObject(angryapes4, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryApes angryapes5 = new AngryApes(6);
        addObject(angryapes5, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryApes angryapes6 = new AngryApes(6);
        addObject(angryapes6, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        AngryApes angryapes7 = new AngryApes(6);
        addObject(angryapes7, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        //Spawn Apes Health
        addObject(angryapes.health, angryapes.getX(), angryapes.getY()- offset);
        addObject(angryapes2.health, angryapes2.getX(), angryapes2.getY()- offset);
        addObject(angryapes3.health, angryapes3.getX(), angryapes3.getY()- offset);
        addObject(angryapes4.health, angryapes4.getX(), angryapes4.getY()- offset);
        addObject(angryapes5.health, angryapes5.getX(), angryapes5.getY()- offset);
        addObject(angryapes6.health, angryapes6.getX(), angryapes6.getY()- offset);
        addObject(angryapes7.health, angryapes7.getX(), angryapes7.getY()- offset);
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
                    Level8S level8S = new Level8S(score, gold);
                    Greenfoot.setWorld(level8S);
                    level8S.advancePlayer1(player1, getWidth()/2, getHeight()/2);
                    victory.stop();
                }
            }
        }
    }
}
