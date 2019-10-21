import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dolphin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dolphin extends Actor
{
    /**
     * Act - do whatever the dolphin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int GRAVITY = 1; 
    private int velocity;
    public void act() 
    {  
       fall();
       if(Greenfoot.isKeyDown("space")&& isOnSolidGround()){
           jump(); 
       }
       move();
    }    
    public dolphin(){
       velocity = 0;
    }
    
    public void fall(){
       setLocation(getX(), getY() + velocity);
       if (isOnSolidGround()){
           velocity = 0;
        while(isOnSolidGround()){ 
            setLocation(getX(), getY() - 1); 
        } 
        setLocation(getX(), getY() + 1);
        }
       else if (velocity < 0 && didBumpHead()) velocity = 0;
       else velocity += GRAVITY;
    }
    
    public boolean isOnSolidGround(){ 
       boolean isOnGround = false;
       if (getY() > getWorld().getHeight() - 70) isOnGround = true;
         int imageWidth = getImage().getWidth();
         int imageHeight = getImage().getHeight();
      if (getOneObjectAtOffset(imageWidth / -2, imageHeight / 2, platform.class) != null ||getOneObjectAtOffset(imageWidth / 2, imageHeight / 2, platform.class) != null) isOnGround = true;
      return isOnGround;
    }
    
    public boolean didBumpHead(){
       boolean bumpedHead = false;
       int imageWidth = getImage().getWidth();
       int imageHeight = getImage().getHeight(); if (getOneObjectAtOffset(imageWidth / -2, imageHeight / -2, platform.class) != null || getOneObjectAtOffset(imageWidth / 2, imageHeight / -2, platform.class) != null) bumpedHead = true;
       return bumpedHead;
    }
    
    public void jump(){
        velocity = -20;
    }
    
    public void move(){
       int x = getX(), y = getY();
       if(Greenfoot.isKeyDown("left") && canMoveLeft()) x-=3;
       if(Greenfoot.isKeyDown("right") && canMoveRight()) x+=3;
       setLocation(x, y);
    }
    
    public boolean canMoveLeft(){ 
        boolean moveLeft = true; 
        int imageWidth = getImage().getWidth(); 
        int imageHeight = getImage().getHeight(); 
        if (getOneObjectAtOffset((imageWidth / -2) - 3, imageHeight / -2, platform.class) != null || getOneObjectAtOffset((imageWidth / -2) - 3, (imageHeight / 2) - 1, platform.class) != null) 
        moveLeft = false; 
        return moveLeft; 
    } 
    
    public boolean canMoveRight(){ 
        boolean moveRight = true; 
        int imageWidth = getImage().getWidth(); 
        int imageHeight = getImage().getHeight(); 
        if (getOneObjectAtOffset((imageWidth / 2) + 3, imageHeight / -2, platform.class) != null || getOneObjectAtOffset((imageWidth / 2) + 3, (imageHeight / 2) - 1, platform.class) != null) 
        moveRight = false; 
        return moveRight; 
    }
}
