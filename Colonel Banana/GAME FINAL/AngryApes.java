import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AngryApes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AngryApes extends Mobs
{
    int speed = getRandomNumber(10,15);
    int turn = getRandomNumber(0,360);
    int timer = 0;
    public Health health;
    /**
     * Act - do whatever the AngryApes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public AngryApes(int health){
        this.health = new Health(health);        
    }

    public void act(){
        walk();
        bounceAtEdge();
        timer--;
        hitByProjectile();
    }
    
    public void walk(){
        move(speed);
        if (timer == 0){
            turn = getRandomNumber(0,360);
            setRotation(turn);
            timer = 150;
        }
        health.setLocation(this.getX(),this.getY()-offset);
    }

    public void hitByProjectile(){
        Actor cherries = getOneIntersectingObject(Cherries.class);
        Actor oranges = getOneIntersectingObject(Oranges.class);
        Actor bananas = getOneIntersectingObject(Bananas.class);
        World myWorld = getWorld();
        if (cherries !=null){
            myWorld.removeObject(cherries);
            health.loseHealth(1);
        }
        else if (oranges !=null){
            myWorld.removeObject(oranges);
            health.loseHealth(2);
        }
        else if (bananas !=null){
            myWorld.removeObject(bananas);
            health.loseHealth(5);
        }
        if (health.health <= 0){
            myWorld.removeObject(this);
            myWorld.removeObject(health);
            Level level = (Level)myWorld;
            Score score = level.getScore();
            Gold gold = level.getGold();
            //Give Player 5 gold and score
            gold.killMob(5);
            score.killMob(5);
        }
    }
}