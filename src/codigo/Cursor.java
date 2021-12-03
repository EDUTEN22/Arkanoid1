package codigo;

import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GRect;

public class Cursor extends GRect{
	GImage cursor;
	

public Cursor(double x, double y, double width, double height, Arkanoid1 ark) {
super(x, y,width,height);
	cursor= new GImage("imagenes/espadaArkanoid1.png");
	
	cursor.setBounds(x, y, width, height-35);
	}

	

	

	public void muevete(int anchoPantalla, int posX){
		if (posX + getWidth() < anchoPantalla){
			setLocation(posX, getY());
			cursor.setLocation(posX,getY());
		}
	}

}