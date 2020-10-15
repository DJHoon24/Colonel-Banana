import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KingKong here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KingKong extends Mobs
{
    GreenfootSound sound = new GreenfootSound("roar.mp3");
    private int speed = getRandomNumber(15,20);
    private int turn = getRandomNumber(0,360);
    private int timer = 0;
    private int shootTimer = 40;
    public Health health;
    /**
     * Act - do whatever the KingKong wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public KingKong(int health){
        this.health = new Health(health);        
    }

    public void act(){
        fireMode();
        runMode();
        bounceAtEdge();
        timer--;
        hitByProjectile();
    }

    public void fireMode(){//This is the first stage of KingKong
        if (health.health <= 50 && health.health >25){
            shootTimer--;
            if(shootTimer == 0){
                World myWorld = getWorld();
                Barrel barrel = new Barrel();
                myWorld.addObject(barrel, getX(), getY());
                barrel.setRotation(getRotation());
                shootTimer = 20;
            }
            else if (timer == 0){
                turn = getRandomNumber(0,360);
                setRotation(turn);
                timer = 40;
            }
        }
    }

    public void runMode(){//This is the second stage of KingKong
        if(health.health == 25){
            sound.play();
        }
        if(health.health <= 25){
            move(speed);
            if (timer == 0){
                turn = getRandomNumber(0,360);
                setRotation(turn);
                timer = 75;
            }
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
        }
    }
}
