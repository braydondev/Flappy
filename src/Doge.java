package flappy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Doge {
	int y = 0, x = 0;
	int speed = 0, acceleration = 1;
	
	BufferedImage dog = null;
	{
		try {
			dog = ImageIO.read(new File("doge.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public Doge()
	{
		
	}
	
	public void updatePosition() {
		speed += acceleration;
		y += speed;
	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void jump()
	{
		speed = -12;
	}
	
	public boolean outOfBounds()
	{
		return y < 0;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public BufferedImage getImage()
	{
		return dog;
	}
	
	public void paint(Graphics g){	
		g.drawImage(dog, this.x, this.y, null);							
	}
	
	public Rectangle getBounds(){
		 return new Rectangle(x, y, dog.getWidth(), dog.getHeight());		//Gives a rectangle used to detect collisions in the Wall class
	}
	
}
