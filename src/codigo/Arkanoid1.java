package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid1 extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 520;

	Bola bola1 = new Bola(10, 10, Color.RED);

	Cursor miCursor = new Cursor(0, 400, 60, 10, this);
	GImage fondo = new GImage("imagenes/fondotw3.png");
	GImage fondoMarcador = new GImage("imagenes/triss.gif");
	Marcador miMarcador = new Marcador(30, 40);
	GImage fondoInicio =new GImage("imagenes/Intro1.gif");
	GImage derrota= new GImage("imagenes/sardinilla1.gif");
	GImage victoria= new GImage("imagenes/introgif.gif");
	

	public void init(){
		//Pongo el fondo de la intro lo primero
	
		setSize(600,386);
		add (fondoInicio);
		waitForClick();
		remove(fondoInicio);
		victoria.setBounds(0,0,800,600);
		add(fondoMarcador, ANCHO_PANTALLA- 30,0);
		add(fondo);
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);
		add(miCursor.cursor);

//		add(miCursor, 0 , 400);
		setSize(ANCHO_PANTALLA + 300 ,500);
	}

	public void run(){
		creaPiramide();
		miMarcador.addMarcador(this);
		while (true){
			bola1.muevete(this); //paso el objeto arkanoid que se está ejecutando
			pause(5);
//			miCursor.muevete(ANCHO_PANTALLA - 30, (int) bola1.getX());
			
			if(hasGanado()){
				removeAll();
				add (victoria);
				waitForClick();
				removeAll();
				init();
				run();
			}
			
			
			if (bola1.getY()>miCursor.getY()){
				removeAll();
				setSize(620,400);
				add(derrota);
				waitForClick();
				removeAll();
				init();
				run();
			}

		}
	}

	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}



	private void creaPiramide(){
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;

		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo3 miLadrillo = new Ladrillo3("imagenes/ghul1.png");

				add(miLadrillo
						,ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X
						,ALTO_LADRILLO*j + desplazamiento_inicial_Y );
			}
		}
	}
	private boolean hasGanado(){
		boolean a = false;
		if (Marcador.puntuacion==91){
			a=true;
			return a;
		}else{
			return a;
		}
	}


}