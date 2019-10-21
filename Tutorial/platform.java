import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class platform extends Actor
{
    /**
     * Act - do whatever the platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public platform(){
       this(100, 25);
    }
    public platform(int width, int height){
      GreenfootImage image = getImage();
      image.scale(width, height);
      setImage(image);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
