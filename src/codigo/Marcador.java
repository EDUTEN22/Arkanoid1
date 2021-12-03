package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{

	GLabel texto = new GLabel("");
	static int puntuacion = 0;
	
	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		texto.setLabel("Ghouls machacados=0");
		texto.setColor(Color.WHITE);
		texto.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
	}

	//suma el nº de puntos que se indica en la variable puntos 
	//a la puntuacion actual
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos; // puntuacion += puntos;
		texto.setLabel("Ghouls machacados " + puntuacion);
	}
	
	public void addMarcador(Arkanoid1 arkanoid){
		arkanoid.add(this, arkanoid.getWidth() - 100, 20);
		arkanoid.add(texto, arkanoid.getWidth() - 300, 40);
	}
}
