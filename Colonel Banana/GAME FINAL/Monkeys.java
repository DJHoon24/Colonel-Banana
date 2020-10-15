import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bananas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monkeys extends Mobs
{
    private int speed = getRandomNumber(3,8);
    private int turn = getRandomNumber(0,360);
    private int timer = 0;
    public Health health;
    /**
     * Act - do whatever the Bananas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Monkeys(int health){
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
            //Give Player 1 gold an score
            gold.killMob(1);
            score.killMob(1);
        }
    }
}