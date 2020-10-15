import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bananas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Players
{
    GreenfootSound sound = new GreenfootSound("shop.mp3");
    GreenfootSound barrelHit = new GreenfootSound("barrel.mp3");
    private int timer = 0;
    private int shopTimer = 0;
    private int movingSpeed = 5;
    private int levelNum = 0;
    private String weapon = "Cherries";
    public Health health;
    private GreenfootImage left = new GreenfootImage("player1left.png");
    private GreenfootImage right = new GreenfootImage("player1.png");

    public Player1(int health){
        this.health = new Health(health);
    }

    /**
     * Act - do whatever the PieShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        hitTheEdge();
        bounceAtEdge();
        fireOnCommand();
        movement();
        hitByMob();
        timer -= 1;
        shopTimer -= 1;
        buyPowerUps();
    }    

    public void movement(){
        if(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("d")){
            setImage(right);
            setRotation(45);
            move(movingSpeed);
        }
        else if(Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a")){
            setImage(left);
            setRotation(135);
            move(movingSpeed);
        }
        else if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("a")){
            setImage(left);
            setRotation(225);
            move(movingSpeed);
        }
        else if(Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("d")){
            setImage(right);
            setRotation(315);
            move(movingSpeed);
        }
        else if(Greenfoot.isKeyDown("s")){            
            setRotation(90);
            move(movingSpeed);
        }
        else if(Greenfoot.isKeyDown("a")){
            setImage(left);
            setRotation(180);
            move(movingSpeed);
        }
        else if(Greenfoot.isKeyDown("w")){
            setRotation(270);
            move(movingSpeed);
        }
        else if(Greenfoot.isKeyDown("d")){
            setImage(right);
            setRotation(0);
            move(movingSpeed);
        }
        health.setLocation(this.getX(),this.getY()-offset);
    }

    public void hitByMob(){
        Actor mobs = getOneIntersectingObject(Mobs.class);
        Actor barrel = getOneIntersectingObject(Barrel.class);
        if(mobs!=null){
            move(-40);
            health.loseHealth(1);
        }
        if(barrel!=null){
            barrelHit.play();
            World myWorld = getWorld();
            myWorld.removeObject(barrel);
            health.loseHealth(2);
        }
        if(health.health <= 0){
            World myWorld = getWorld();
            myWorld.removeObject(this);
            myWorld.removeObject(health);
        }
    }

    private void fireOnCommand(){
        if(Greenfoot.isKeyDown("g") && timer <= 0){
            if(weapon.equals("Cherries")){
                World myWorld = getWorld();
                Cherries cherries = new Cherries();
                myWorld.addObject(cherries, getX(), getY());
                cherries.setRotation(getRotation());
                timer = 40;
            }
            else if(weapon.equals("Oranges")){
                World myWorld = getWorld();
                Oranges oranges = new Oranges();
                myWorld.addObject(oranges, getX(), getY());
                oranges.setRotation(getRotation());
                timer = 30;
            }
            else if(weapon.equals("Bananas")){
                World myWorld = getWorld();
                Bananas bananas = new Bananas();
                myWorld.addObject(bananas, getX(), getY());
                bananas.setRotation(getRotation());
                timer = 20;
            }
        }
    }

    private void buyPowerUps(){
        if(Greenfoot.isKeyDown("1") && shopTimer <= 0 && weapon.equals("Cherries")){
            World myWorld = getWorld();
            Level level = (Level)myWorld;
            Gold gold = level.getGold();
            if(gold.gold >= 30){
                gold.loseGold(30);
                weapon = "Oranges";
                shopTimer = 75;
                sound.play();
            }
        }
        else if(Greenfoot.isKeyDown("1") && shopTimer <= 0 && weapon.equals("Oranges")){
            World myWorld = getWorld();
            Level level = (Level)myWorld;
            Gold gold = level.getGold();
            if(gold.gold >= 50){
                gold.loseGold(50);
                weapon = "Bananas";
                shopTimer = 75;
                sound.play();
            }
        }
        else if(Greenfoot.isKeyDown("2") && shopTimer <= 0){
            World myWorld = getWorld();
            Level level = (Level)myWorld;
            Gold gold = level.getGold();
            if(gold.gold >= 5){
                gold.loseGold(5);
                movingSpeed += 1;
                shopTimer = 75;
                sound.play();
            }
        }        
        else if(Greenfoot.isKeyDown("3") && shopTimer <= 0){
            World myWorld = getWorld();
            Level level = (Level)myWorld;
            Gold gold = level.getGold();
            if(gold.gold >= 10){
                gold.loseGold(10);
                shopTimer = 75;
                health.health = 50;
                sound.play();
            }
        }
    }
}