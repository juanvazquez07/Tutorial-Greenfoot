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
       if(Greenfoot.isKeyDown("space")){
           jump(); 
       }
    }    
    public dolphin(){
       velocity = 0;
    }
    
    public void fall(){
       setLocation(getX(), getY() + velocity);
       if (getY() > getWorld().getHeight() - 70) velocity = 0;
       else velocity += GRAVITY;
    }
    
    public void jump(){
        velocity = -20;
    }
}
