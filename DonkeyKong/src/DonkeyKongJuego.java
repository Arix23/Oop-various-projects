/*
 * PROYECTO FINAL DE POO
 * 
 * DONKEY KONG
 * 
 * CREADORES:
 * Alan Ezequiel Savoy A01351362
 * Ari  Valenzuela A01635584
 * 
 * MAYO 6 2019
 * 
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class DonkeyKongJuego extends JPanel implements Runnable, KeyListener, MouseListener {
	private Barrel[] barrel;//Objeto barrel
	private Player player;//Objeto player
	
	private Image donkeyKong,//sprites
					barra,
					escalera,
					marioDerecha,
					marioIzquierda,
					marioEscalera,
					barrilPixel,
					marioJumpSpriteLeft,
					marioJumpSpriteRight,
					barriles,
					marioMuerto,
					marioMuertoRight,
					corazonRoto,
					corazon,
					gameOverImage,
					Reiniciarbtn,
					pauline;
	
	//0 para izquierda, 1 para derecha, 2 para arriba/abajo
	private int marioPosition,
				movizq,
				movder;
				 
	//booleans para validar una accion
	private boolean marioJump,
					gameOn,
					ladder,
					movement,
					fallen,
					gameOver,
					gameWin;
	
	
	//constructor
	
	public DonkeyKongJuego() {
		super();
		this.setPreferredSize(new Dimension(610,695));
		this.setOpaque(true);
		this.setBackground(Color.BLACK);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.addMouseListener(this);
		
		//Inicializar atributos
		
		this.donkeyKong = new ImageIcon("donkeykong.png").getImage();
		this.pauline = new ImageIcon("pauline.png").getImage();
		this.barra = new ImageIcon("barra.png").getImage();
		this.escalera = new ImageIcon("escalera.png").getImage();
		this.barrilPixel = new ImageIcon("barril.png").getImage();
		this.marioDerecha = new ImageIcon("marioright.png").getImage();
		this.marioIzquierda = new ImageIcon("marioleft.png").getImage();
		this.marioEscalera = new ImageIcon("marioescalera.png").getImage();
		this.marioJumpSpriteLeft = new ImageIcon("mariojumpleft.png").getImage();
		this.marioJumpSpriteRight = new ImageIcon("mariojumpright.png").getImage();
		this.barriles = new ImageIcon("barriles.png").getImage();
		this.corazonRoto = new ImageIcon("corazonroto.png").getImage();
		this.corazon = new ImageIcon("corazon.png").getImage();
		this.marioMuerto = new ImageIcon("mariomuerto.png").getImage();
		this.marioMuertoRight = new ImageIcon("mariomuertoright.png").getImage();
		this.gameOverImage = new ImageIcon("gameover.png").getImage();
		this.Reiniciarbtn = new ImageIcon("reiniciar.png").getImage();
		
		this.barrel = new Barrel[13];
		for (int i = 0;i<13;i++) {
			this.barrel[i]= new Barrel();
		}
		this.player = new Player();
		this.marioPosition = 1;
		this.movizq=0;
		this.movder=0;
		this.marioJump = false;
		this.gameOn = true;
		this.ladder = false;
		this.movement = false;
		this.fallen = false;
		this.gameOver = false;
		this.gameWin = false;
		
		
		//Initialize Thread
		
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	//M�todo con el que se pinta
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		this.pintaLineas(g);
		this.pintaEscaleras(g);
		this.pintaBarriles(g);
		this.pintaJugador(g);
		this.pintaChango(g);
		this.pintaCorazones(g);
	}
	public void pintaLineas(Graphics g) {
		
		//Primera linea
		
		for(int i = 0; i<15;i++) {
			g.drawImage(this.barra, 0+i*24,175,24,20,this);
		}
		for (int i = 0; i<2;i++) {
			g.drawImage(this.barra, 360+i*24,178,24,20,this);
			g.drawImage(this.barra, 408+i*24,181,24,20,this);
			g.drawImage(this.barra, 456+i*24,184,24,20,this);
			g.drawImage(this.barra, 504+i*24,187,24,20,this);
		}
		for(int i = 0; i<3;i++) {
			
			//Segunda linea
			
			g.drawImage(this.barra, 554+i*24,275,24,20,this);
			g.drawImage(this.barra, 482+i*24,278,24,20,this);
			g.drawImage(this.barra, 410+i*24,281,24,20,this);
			g.drawImage(this.barra, 338+i*24,284,24,20,this);
			g.drawImage(this.barra, 266+i*24,287,24,20,this);
			g.drawImage(this.barra, 194+i*24,290,24,20,this);
			g.drawImage(this.barra, 122+i*24,293,24,20,this);
			g.drawImage(this.barra, 50+i*24,296,24,20,this);
			
			//Tercera linea
			
			g.drawImage(this.barra, 0+i*24,375,24,20,this);
			g.drawImage(this.barra, 72+i*24,378,24,20,this);
			g.drawImage(this.barra, 144+i*24,381,24,20,this);
			g.drawImage(this.barra, 216+i*24,384,24,20,this);
			g.drawImage(this.barra, 288+i*24,387,24,20,this);
			g.drawImage(this.barra, 360+i*24,390,24,20,this);
			g.drawImage(this.barra, 432+i*24,393,24,20,this);
			g.drawImage(this.barra, 504+i*24,396,24,20,this);
			
			//Cuarta linea
			
			g.drawImage(this.barra, 554+i*24,475,24,20,this);
			g.drawImage(this.barra, 482+i*24,478,24,20,this);
			g.drawImage(this.barra, 410+i*24,481,24,20,this);
			g.drawImage(this.barra, 338+i*24,484,24,20,this);
			g.drawImage(this.barra, 266+i*24,487,24,20,this);
			g.drawImage(this.barra, 194+i*24,490,24,20,this);
			g.drawImage(this.barra, 122+i*24,493,24,20,this);
			g.drawImage(this.barra, 50+i*24,496,24,20,this);
			
			//Quinta linea
			
			g.drawImage(this.barra, 0+i*24,575,24,20,this);
			g.drawImage(this.barra, 72+i*24,578,24,20,this);
			g.drawImage(this.barra, 144+i*24,581,24,20,this);
			g.drawImage(this.barra, 216+i*24,584,24,20,this);
			g.drawImage(this.barra, 288+i*24,587,24,20,this);
			g.drawImage(this.barra, 360+i*24,590,24,20,this);
			g.drawImage(this.barra, 432+i*24,593,24,20,this);
			g.drawImage(this.barra, 504+i*24,596,24,20,this);
		}
		
		//Sexta linea
		
		for (int i =0;i<4;i++) {
			g.drawImage(this.barra, 306+i*19,672,19,20,this);
			g.drawImage(this.barra, 382+i*19,669,19,20,this);
			g.drawImage(this.barra, 458+i*19,666,19,20,this);
			g.drawImage(this.barra, 534+i*19,663,19,20,this);
		}
		for (int i =0;i<17;i++) {
			g.drawImage(this.barra, 0+i*18,675,18,20,this);
		}
		
		//Linea princesa
		
		for(int i = 0;i<5;i++) {
			g.drawImage(this.barra, 200+i*24,80,24,20,this);
		}
		g.drawImage(this.pauline, 210, 40, 30, 45, this);
		g.setColor(Color.WHITE);
		g.drawString("Vidas: 1", 10, 20);
		g.drawString("Presiona SPACE para saltar.", 10, 40);
		g.drawString("Ari Valenzuela (A01635584)", 420, 20);
		g.drawString("Alan Ezequiel (A01351362)", 420, 40);
		g.setColor(Color.CYAN);
				
	}
	
	public void pintaEscaleras(Graphics g) {
		//Escaleras completas
		
		for(int i = 0;i<3;i++) {
			g.drawImage(this.escalera,490,615+i*17,20,17,this);
		}
		for (int i = 0; i<4;i++) {
			g.drawImage(this.escalera,75,316+i*15,20,15,this);
			g.drawImage(this.escalera,490,416+i*15,20,15,this);
			g.drawImage(this.escalera,100,515+i*15,20,15,this);
		}
		for (int i = 0;i<5;i++) {
			g.drawImage(this.escalera,295,100+i*15,20,15,this);
			g.drawImage(this.escalera,190,310+i*15,20,15,this);
			g.drawImage(this.escalera,330,407+i*15,20,15,this);
			g.drawImage(this.escalera,225,510+i*15,20,15,this);
			g.drawImage(this.escalera,504,202+i*15,20,15,this);
		}
		for (int i = 0; i<9;i++) {
			g.drawImage(this.escalera, 130,40+i*15,20,15,this);
			g.drawImage(this.escalera, 180,40+i*15,20,15,this);
		}
		
		//Escaleras rotas
		
		g.drawImage(this.escalera, 210,603,20,20,this);
		g.drawImage(this.escalera, 210,655,20,20,this);
		
		//Set1
		
		g.drawImage(this.escalera, 190,464,20,25,this);
		g.drawImage(this.escalera, 190,401,20,25,this);
		
		//Set2
		
		g.drawImage(this.escalera, 430,364,20,29,this);
		g.drawImage(this.escalera, 430,301,20,25,this);
		
		//Set3
		
		g.drawImage(this.escalera, 260,257,20,29,this);
		g.drawImage(this.escalera, 260,194,20,28,this);
		
	}
	
	public void pintaBarriles(Graphics g) {
		//barrel x and y
		for (int i = 0; i<13;i++) {
			g.drawImage(this.barrilPixel, this.barrel[i].getCoorX(),this.barrel[i].getCoorY(), 20, 20,this);
		}
	}
	
	public void pintaJugador(Graphics g) {
		
		//player x and y
		if(!gameOver) {
			if(this.marioPosition == 0) {
				g.drawImage(this.marioIzquierda,this.player.getCoorX(),this.player.getCoorY(),25,28,this);
			} else if (this.marioPosition == 1) {
				g.drawImage(this.marioDerecha,this.player.getCoorX(),this.player.getCoorY(),25,28,this);
			} else if (this.marioPosition == 2) {
				g.drawImage(this.marioEscalera,this.player.getCoorX(),this.player.getCoorY(),25,28,this);
			}
			if(this.marioJump && this.marioPosition==0) {
				g.drawImage(this.marioJumpSpriteLeft,this.player.getCoorX(),this.player.getCoorY(),25,28,this);
			} else if (this.marioJump && this.marioPosition==1) {
				g.drawImage(this.marioJumpSpriteRight,this.player.getCoorX(),this.player.getCoorY(),25,28,this);
			}
		}
	}
	
	public void pintaChango(Graphics g) {
		//DonkeyKong
		g.drawImage(this.barriles,0,105,40,70, this);
		g.drawImage(this.donkeyKong, 15,90,100,100,this);
		
	}
	
	public void pintaCorazones(Graphics g) {
		//Corazon
		if(this.gameWin) {
			g.drawImage(this.corazon,260,40,20,20,this);
			g.drawImage(this.Reiniciarbtn,250,450,100,100, this);
		} else if(this.gameOver) {
			if(this.marioPosition==0) {
				g.drawImage(this.marioMuerto,this.player.getCoorX(),this.player.getCoorY(),28,25, this);
			} else {
				g.drawImage(this.marioMuertoRight,this.player.getCoorX(),this.player.getCoorY(),28,25, this);
			}
		
			g.drawImage(this.gameOverImage,150,350,300,100, this);
			g.drawImage(this.Reiniciarbtn,250,450,100,100, this);
			g.drawImage(this.corazonRoto,260,40,40,40,this);
		}
	}
	
	public void movement() {
		
		if (this.movement) {
			if(this.marioPosition==1) {
				if(this.ladder == true || this.gameOver == true || this.gameWin==true) {
					this.player.addRightCoorX(0);
				}else {
					this.player.addRightCoorX(3);
				}
			}else if (this.marioPosition == 0) {
				if(this.ladder == true || this.gameOver == true || this.gameWin==true) {
					this.player.addLeftCoorX(0);
				}else {
					this.player.addLeftCoorX(-3);
				}
			}
		}
		
		//if para validar piso y escaleras cuando se presiona el boton derecha
		
		
		if(this.marioJump==false) {
			//primer piso
			
			//movimiento primer piso
			if(this.player.getCoorY()<680 && this.player.getCoorY()>576) {
				if((this.player.getCoorX()>0) && (this.player.getCoorX()<297) ) {
					this.player.setCoorY(648);
					
				}
				else if((this.player.getCoorX()>297) && (this.player.getCoorX()<372) ) {
					this.player.setCoorY(645);
				
				}
				else if((this.player.getCoorX()>372) && (this.player.getCoorX()<454) ) {
					this.player.setCoorY(640);
				
				}
				else if((this.player.getCoorX()>454) && (this.player.getCoorX()<480) || (this.player.getCoorX()>511 && this.player.getCoorX()<526)) {
					this.player.setCoorY(638);
					
				}
				else if(this.player.getCoorX()>526) {
					if(this.fallen==false) {
						this.player.setCoorY(634);
					}
				}
				this.LaddersMove();

			/*
			 * segundo piso 
			 */
				
				
			}else if(this.player.getCoorY()<590 && this.player.getCoorY()>469) {
				if(this.player.getCoorX()<60){
					if(this.fallen==false) {
						this.player.setCoorY(550);
					}
				}
				else if((this.player.getCoorX()>60) && (this.player.getCoorX()<88) || (this.player.getCoorX()>114 && this.player.getCoorX()<132)) {
					this.player.setCoorY(552);
					
				}
				else if((this.player.getCoorX()>132) && (this.player.getCoorX()<204) ) {
					this.player.setCoorY(554);
				
				}
				else if((this.player.getCoorX()>204) && (this.player.getCoorX()<219) || (this.player.getCoorX()>241 && this.player.getCoorX()<277)) {
					this.player.setCoorY(558);
				}
				else if(((this.player.getCoorX()>277) && (this.player.getCoorX()<349))) {
					this.player.setCoorY(560);
					
				}else if(((this.player.getCoorX()>349) && (this.player.getCoorX()<427))) {
					this.player.setCoorY(563);
					
				}else if(((this.player.getCoorX()>427) && (this.player.getCoorX()<497))) {
					this.player.setCoorY(566);
					
				}else if(((this.player.getCoorX()>497) && (this.player.getCoorX()<570))) {
					this.player.setCoorY(570);
					
					//salto del segundo piso
					
				}else if(this.player.getCoorX()>570) {
						this.fallen=true;
						for(int i=0; i<8;i++) {
							this.player.addCoorY(4);
							this.player.addRightCoorX(2);
						}
						this.fallen=false;
				}
				this.LaddersMove();
			}
			
			
			/*
			 * 
			 * tercer piso 
			 * 
			 */
			
			
				else if(this.player.getCoorY()<492 && this.player.getCoorY()>398) {
					
					//salto tercer piso
					
					if(this.player.getCoorX()<33){
						this.fallen=true;
						for(int i=0; i<8;i++) {
							this.player.addCoorY(4);
							this.player.addLeftCoorX(-2);
						}
						this.fallen=false;
						
					}
					else if((this.player.getCoorX()>51) && (this.player.getCoorX()<115) ) {
						this.player.setCoorY(467);
					
					}
					else if((this.player.getCoorX()>115) && (this.player.getCoorX()<187) ) {
						this.player.setCoorY(462);
					
					}
					else if(((this.player.getCoorX()>187) && (this.player.getCoorX()<257))) {
						this.player.setCoorY(462);
						
					}else if((this.player.getCoorX()>257) && (this.player.getCoorX()<315)) {
						this.player.setCoorY(460);
						
					}else if((this.player.getCoorX()>315) && (this.player.getCoorX()<323) || (this.player.getCoorX()>353 && this.player.getCoorX()<404)) {
						this.player.setCoorY(458);
						
					}else if((this.player.getCoorX()>404) && (this.player.getCoorX()<458)) {
						this.player.setCoorY(454);
						
					}else if((this.player.getCoorX()>458) && (this.player.getCoorX()<481) || (this.player.getCoorX()>514 && this.player.getCoorX()<548)) {
						this.player.setCoorY(452);
						
					}else if(this.player.getCoorX()>548) {
						if(this.fallen==false) {
							this.player.setCoorY(449);
						}
					}
					this.LaddersMove();
				}
				
			
			//cuarto piso
			
			
			else if(this.player.getCoorY()<380 && this.player.getCoorY()>280) {
				if(this.player.getCoorX()<48){
					if(this.fallen==false) {
						this.player.setCoorY(348);
					}
				}
				else if((this.player.getCoorX()>48) && (this.player.getCoorX()<66) || (this.player.getCoorX()>96 && this.player.getCoorX()<132)) {
					this.player.setCoorY(350);
					
				}
				else if((this.player.getCoorX()>132) && (this.player.getCoorX()<163) ) {
					this.player.setCoorY(352);
				
				}
				else if((this.player.getCoorX()>205) && (this.player.getCoorX()<277)) {
					this.player.setCoorY(354);
				}
				else if(((this.player.getCoorX()>277) && (this.player.getCoorX()<349))) {
					this.player.setCoorY(356);
					
				}else if(((this.player.getCoorX()>349) && (this.player.getCoorX()<427))) {
					this.player.setCoorY(359);
					
				}else if(((this.player.getCoorX()>427) && (this.player.getCoorX()<497))) {
					this.player.setCoorY(362);
					
				}else if(((this.player.getCoorX()>497) && (this.player.getCoorX()<570))) {
					this.player.setCoorY(366);
					
					//salto del cuarto piso
					
				}else if(this.player.getCoorX()>570) {
					this.player.setCoorY(449);
				}
				this.LaddersMove();
			}
			
			//quinto piso
				
				
			else if(this.player.getCoorY()<=283 && this.player.getCoorY()>160){
				//salto quinto piso
				
				if(this.player.getCoorX()<33){
					this.fallen=true;
					for(int i=0; i<8;i++) {
						this.player.addCoorY(4);
						this.player.addLeftCoorX(-2);
					}
					this.fallen=false;
					
				}
				else if((this.player.getCoorX()>51) && (this.player.getCoorX()<115) ) {
					this.player.setCoorY(266);
				
				}
				else if((this.player.getCoorX()>115) && (this.player.getCoorX()<194) ) {
					this.player.setCoorY(262);
				
				}
				else if(((this.player.getCoorX()>194) && (this.player.getCoorX()<257))) {
					this.player.setCoorY(259);
					
				}else if((this.player.getCoorX()>257) && (this.player.getCoorX()<315)) {
					this.player.setCoorY(258);
					
				}else if((this.player.getCoorX()>315) && (this.player.getCoorX()<404)) {
					this.player.setCoorY(256);
					
				}else if((this.player.getCoorX()>404) && (this.player.getCoorX()<458)) {
					this.player.setCoorY(254);
					
				}else if((this.player.getCoorX()>458) && (this.player.getCoorX()<488) || (this.player.getCoorX()>526 && this.player.getCoorX()<548)) {
					this.player.setCoorY(249);
					
				}else if(this.player.getCoorX()>548) {
					if(this.fallen==false) {
						this.player.setCoorY(247);
					}
				this.LaddersMove();
				}
				
				
			//sexto piso
				
			
			}else if(this.player.getCoorY()<189) {
				if((this.player.getCoorX()>=497 && this.player.getCoorX()<=517) && (this.player.getCoorY()<245 && this.player.getCoorY()>163)) { 
					this.ladder = true;
				}else {
					this.ladder = false;
				}
				//movimiento sexto piso
				
				//salto sexto piso
				if(this.player.getCoorX()>548){
					this.fallen=true;
					for(int i=0; i<8;i++) {
						this.player.addCoorY(4);
						this.player.addRightCoorX(2);
					}
					this.fallen=false;
				}
				else if((this.player.getCoorX()<547) && (this.player.getCoorX()>495) ) {
					this.player.setCoorY(158);
				
				}
				else if((this.player.getCoorX()<495) && (this.player.getCoorX()>440) ) {
					this.player.setCoorY(154);
				
				}else if((this.player.getCoorX()<440) && (this.player.getCoorX()>399) ) {
					this.player.setCoorY(151);
				}
				else if((this.player.getCoorX()<399) && (this.player.getCoorX()>347) ) {
					this.player.setCoorY(147);
				}else if((this.player.getCoorX()<347) && (this.player.getCoorX()>315)) {
					this.player.setCoorY(144);
				}
				this.LaddersMove();
			}
		}
	}
	public void LaddersMove() {
		if(this.marioJump==false) {
			//piso 1
			//escalera piso 1
			
			if((this.player.getCoorX()>484&&this.player.getCoorX()<514) && (this.player.getCoorY()<634 && this.player.getCoorY()>568)) {
				this.ladder = true;
			}else {
				this.ladder = false;
			}
			//piso 2
			//escalera 1 segundo piso
			
			if((this.player.getCoorX()>=218&&this.player.getCoorX()<=238) && (this.player.getCoorY()<554 && this.player.getCoorY()>463)) {
				this.ladder = true;
				
			//escalera 2 segundo piso
				
			}else if((this.player.getCoorX()>=95&&this.player.getCoorX()<=113) && (this.player.getCoorY()<545 && this.player.getCoorY()>465)) {
				this.ladder = true;
			}else {
				this.ladder = false;
			}
			//piso 3
			//escaleras tercer piso
			//escalera 1 tercer piso
			
			
			if((this.player.getCoorX()>=322&&this.player.getCoorX()<=344) && (this.player.getCoorY()<450 && this.player.getCoorY()>364)) { 
				this.ladder = true;

			//escalera 2 tercer piso
				
			}else if((this.player.getCoorX()>=485&&this.player.getCoorX()<=502) && (this.player.getCoorY()<446 && this.player.getCoorY()>367)) {
				this.ladder = true;
			}else {
				this.ladder = false;
			}
			//piso 4
			//escalera 1 cuarto piso
			
			if((this.player.getCoorX()>=68&&this.player.getCoorX()<=84) && (this.player.getCoorY()<342 && this.player.getCoorY()>271)) {
				this.ladder = true;
				
			//escalera 2 cuarto piso
				
			}else if((this.player.getCoorX()>=183&&this.player.getCoorX()<=202) && (this.player.getCoorY()<348 && this.player.getCoorY()>267)){
				this.ladder = true;
			
			}else {
				this.ladder = false;
			}
			//piso 5

			if((this.player.getCoorX()>=497 && this.player.getCoorX()<=517) && (this.player.getCoorY()<245 && this.player.getCoorY()>163)) { 
				this.ladder = true;
			}else {
				this.ladder = false;
			}
			//piso 6
			if((this.player.getCoorX()>=290 && this.player.getCoorX()<=295) && (this.player.getCoorY()<=150 && this.player.getCoorY()>10)) { 
				this.ladder = true;
			}else {
				this.ladder = false;
			}
			
		}
		
	}
	public void moveBarrel(int number) {
		boolean goingDown = false;
		// IF's de Y para controlar el movimiento en y
		//Primera linea
		if(this.barrel[number].getOptionsDirection()[0]==0) {
			if(this.barrel[number].getCoorX() < 265 && this.barrel[number].getCoorX() > 260 && (this.barrel[number].getCoorY()<270&&this.barrel[number].getCoorY()>=155)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		} else if (this.barrel[number].getOptionsDirection()[0]==1) {
			if(this.barrel[number].getCoorX() < 510 && this.barrel[number].getCoorX() > 504 && (this.barrel[number].getCoorY()<256&&this.barrel[number].getCoorY()>=155)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			} 
		} else if (this.barrel[number].getOptionsDirection()[0]==2) {
			if(this.barrel[number].getCoorX() < 556 && this.barrel[number].getCoorX() > 550 && (this.barrel[number].getCoorY()<256&&this.barrel[number].getCoorY()>=155)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			} 
		}
		
		//Segunda linea
		if(this.barrel[number].getOptionsDirection()[1]==0) {
			if(this.barrel[number].getCoorX() < 434 && this.barrel[number].getCoorX() > 428 && (this.barrel[number].getCoorY()<372&&this.barrel[number].getCoorY()>250)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		} else if (this.barrel[number].getOptionsDirection()[1]==1) {
			if(this.barrel[number].getCoorX() < 191 && this.barrel[number].getCoorX() > 187 && (this.barrel[number].getCoorY()<363&&this.barrel[number].getCoorY()>261)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			} 
		} else if (this.barrel[number].getOptionsDirection()[1]==2) {
			if(this.barrel[number].getCoorX() < 75 && this.barrel[number].getCoorX() > 71 && (this.barrel[number].getCoorY()<355&&this.barrel[number].getCoorY()>268)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		} else if (this.barrel[number].getOptionsDirection()[1]==3) {
			if(this.barrel[number].getCoorX() < 31 && this.barrel[number].getCoorX() > 27 && (this.barrel[number].getCoorY()<356&&this.barrel[number].getCoorY()>267)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		}
		//Comprobaci�n de la segunda l�nea
		if (this.barrel[number].getCoorX()<30 && this.barrel[number].getCoorX()>26 && (this.barrel[number].getCoorY()<354&&this.barrel[number].getCoorY()>267)) {
			this.barrel[number].addCoorY(4);
			goingDown = true;
		}
		
		//Tercera linea
		if(this.barrel[number].getOptionsDirection()[2]==0) {
			if(this.barrel[number].getCoorX() < 194 && this.barrel[number].getCoorX() > 190 && (this.barrel[number].getCoorY()<471&&this.barrel[number].getCoorY()>352)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		} else if (this.barrel[number].getOptionsDirection()[2]==1) {
			if(this.barrel[number].getCoorX() < 335 && this.barrel[number].getCoorX() > 331 && (this.barrel[number].getCoorY()<460&&this.barrel[number].getCoorY()>358)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			} 
		} else if (this.barrel[number].getOptionsDirection()[2]==2) {
			if(this.barrel[number].getCoorX() < 495 && this.barrel[number].getCoorX() > 491 && (this.barrel[number].getCoorY()<455&&this.barrel[number].getCoorY()>353)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		} else if (this.barrel[number].getOptionsDirection()[2]==3) {
			if(this.barrel[number].getCoorX() < 580 && this.barrel[number].getCoorX() > 575 && (this.barrel[number].getCoorY()<455&&this.barrel[number].getCoorY()>358)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		}
		//Comprobaci�n tercera l�nea
		if(this.barrel[number].getCoorX() < 579 && this.barrel[number].getCoorX() > 575 && (this.barrel[number].getCoorY()<455&&this.barrel[number].getCoorY()>358)) {
			this.barrel[number].addCoorY(4);
			goingDown = true;
		}
		
		
		//Cuarta linea
		if(this.barrel[number].getOptionsDirection()[3]==0) {
			if(this.barrel[number].getCoorX() < 224 && this.barrel[number].getCoorX() > 220 && (this.barrel[number].getCoorY()<562&&this.barrel[number].getCoorY()>466)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		} else if (this.barrel[number].getOptionsDirection()[3]==1) {
			if(this.barrel[number].getCoorX() < 111 && this.barrel[number].getCoorX() > 107 && (this.barrel[number].getCoorY()<556&&this.barrel[number].getCoorY()>468)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			} 
		} else if (this.barrel[number].getOptionsDirection()[3]==2) {
			if(this.barrel[number].getCoorX() < 31 && this.barrel[number].getCoorX() > 27 && (this.barrel[number].getCoorY()<556&&this.barrel[number].getCoorY()>468)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		}
		//Comprobaci�n cuarta l�nea
		if(this.barrel[number].getCoorX() < 30 && this.barrel[number].getCoorX() > 26 && (this.barrel[number].getCoorY()<556&&this.barrel[number].getCoorY()>468)) {
				this.barrel[number].addCoorY(2);
				goingDown = true;
			}
		
		//Quinta linea
		if(this.barrel[number].getOptionsDirection()[4]==0) {
			if(this.barrel[number].getCoorX() < 214 && this.barrel[number].getCoorX() > 210 && (this.barrel[number].getCoorY()<654&&this.barrel[number].getCoorY()>552)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		} else if (this.barrel[number].getOptionsDirection()[4]==1) {
			if(this.barrel[number].getCoorX() < 492 && this.barrel[number].getCoorX() > 487 && (this.barrel[number].getCoorY()<646&&this.barrel[number].getCoorY()>564)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			} 
		} else if (this.barrel[number].getOptionsDirection()[4]==2) {
			if(this.barrel[number].getCoorX() < 578 && this.barrel[number].getCoorX() > 574 && (this.barrel[number].getCoorY()<644&&this.barrel[number].getCoorY()>568)) {
				this.barrel[number].addCoorY(4);
				goingDown = true;
			}
		}
		//Comprobaci�n quinta linea
		if(this.barrel[number].getCoorX() < 578 && this.barrel[number].getCoorX() > 574 && (this.barrel[number].getCoorY()<644&&this.barrel[number].getCoorY()>568)) {
			this.barrel[number].addCoorY(4);
			goingDown = true;
		}
		
		//IF's de X para controlar el movimiento en X
		//Primer linea
		if((this.barrel[number].getCoorY()>150&&this.barrel[number].getCoorY()<189)&&this.barrel[number].getCoorX()<580&& goingDown==false) {
			this.barrel[number].addCoorX(3);
			if(this.barrel[number].getCoorX()<=409 && this.barrel[number].getCoorX()>=358) {
				this.barrel[number].setCoorY(158);
			} else if (this.barrel[number].getCoorX()<=452 && this.barrel[number].getCoorX()>=409) {
				this.barrel[number].setCoorY(161);
			} else if(this.barrel[number].getCoorX()<=501 && this.barrel[number].getCoorX()>=452) {
				this.barrel[number].setCoorY(164);
			} else if(this.barrel[number].getCoorX()<=550 && this.barrel[number].getCoorX()>=501) {
				this.barrel[number].setCoorY(167);
			}
		}
		
		//Segunda linea
		if((this.barrel[number].getCoorY()>243&&this.barrel[number].getCoorY()<296)&&this.barrel[number].getCoorX()>0&& goingDown==false) {
			this.barrel[number].addCoorX(-3);
			if(this.barrel[number].getCoorX()<=531 && this.barrel[number].getCoorX()>=464) {
				this.barrel[number].setCoorY(259);
			} else if (this.barrel[number].getCoorX()<=464 && this.barrel[number].getCoorX()>=391) {
				this.barrel[number].setCoorY(261);
			} else if(this.barrel[number].getCoorX()<=391 && this.barrel[number].getCoorX()>=320) {
				this.barrel[number].setCoorY(264);
			} else if(this.barrel[number].getCoorX()<=320 && this.barrel[number].getCoorX()>=246) {
				this.barrel[number].setCoorY(267);
			} else if(this.barrel[number].getCoorX()<=246 && this.barrel[number].getCoorX()>=176) {
				this.barrel[number].setCoorY(270);
			} else if(this.barrel[number].getCoorX()<=176 && this.barrel[number].getCoorX()>=103) {
				this.barrel[number].setCoorY(273);
			} else if(this.barrel[number].getCoorX()<=103 && this.barrel[number].getCoorX()>=50) {
				this.barrel[number].setCoorY(276);
			}
			
		}
		//Tercera linea
		if((this.barrel[number].getCoorY()>350&&this.barrel[number].getCoorY()<397)&&this.barrel[number].getCoorX()<580&& goingDown==false) {
			this.barrel[number].addCoorX(3);
			if(this.barrel[number].getCoorX()<=142 && this.barrel[number].getCoorX()>=74) {
				this.barrel[number].setCoorY(359);
			} else if (this.barrel[number].getCoorX()<=220 && this.barrel[number].getCoorX()>=142) {
				this.barrel[number].setCoorY(361);
			} else if(this.barrel[number].getCoorX()<=287 && this.barrel[number].getCoorX()>=220) {
				this.barrel[number].setCoorY(364);
			} else if(this.barrel[number].getCoorX()<=361 && this.barrel[number].getCoorX()>=287) {
				this.barrel[number].setCoorY(367);
			} else if(this.barrel[number].getCoorX()<=433 && this.barrel[number].getCoorX()>=361) {
				this.barrel[number].setCoorY(370);
			} else if(this.barrel[number].getCoorX()<=503 && this.barrel[number].getCoorX()>=433) {
				this.barrel[number].setCoorY(373);
			} else if(this.barrel[number].getCoorX()<=575 && this.barrel[number].getCoorX()>=503) {
				this.barrel[number].setCoorY(376);
			}
		}
		//Cuarta linea
		if((this.barrel[number].getCoorY()>448 && this.barrel[number].getCoorY()<497)&&this.barrel[number].getCoorX()>0&& goingDown==false) {
			this.barrel[number].addCoorX(-3);
			if(this.barrel[number].getCoorX()<=555 && this.barrel[number].getCoorX()>=483) {
				this.barrel[number].setCoorY(460);
			} else if (this.barrel[number].getCoorX()<=463 && this.barrel[number].getCoorX()>=390) {
				this.barrel[number].setCoorY(463);
			} else if(this.barrel[number].getCoorX()<=390 && this.barrel[number].getCoorX()>=319) {
				this.barrel[number].setCoorY(466);
			} else if(this.barrel[number].getCoorX()<=319 && this.barrel[number].getCoorX()>=248) {
				this.barrel[number].setCoorY(469);
			} else if(this.barrel[number].getCoorX()<=248 && this.barrel[number].getCoorX()>=173) {
				this.barrel[number].setCoorY(472);
			} else if(this.barrel[number].getCoorX()<=173 && this.barrel[number].getCoorX()>=100) {
				this.barrel[number].setCoorY(475);
			} else if(this.barrel[number].getCoorX()<=100 && this.barrel[number].getCoorX()>=33) {
				this.barrel[number].setCoorY(478);
			}
		}
		//Quinta linea
		if((this.barrel[number].getCoorY()>548 && this.barrel[number].getCoorY()<598)&&this.barrel[number].getCoorX()<580&& goingDown==false) {
			this.barrel[number].addCoorX(3);
			if(this.barrel[number].getCoorX()<=142 && this.barrel[number].getCoorX()>=73) {
				this.barrel[number].setCoorY(557);
			} else if (this.barrel[number].getCoorX()<=216 && this.barrel[number].getCoorX()>=142) {
				this.barrel[number].setCoorY(560);
			} else if(this.barrel[number].getCoorX()<=287 && this.barrel[number].getCoorX()>=216) {
				this.barrel[number].setCoorY(563);
			} else if(this.barrel[number].getCoorX()<=361 && this.barrel[number].getCoorX()>=287) {
				this.barrel[number].setCoorY(566);
			} else if(this.barrel[number].getCoorX()<=431 && this.barrel[number].getCoorX()>=361) {
				this.barrel[number].setCoorY(569);
			} else if(this.barrel[number].getCoorX()<=503 && this.barrel[number].getCoorX()>=431) {
				this.barrel[number].setCoorY(572);
			} else if(this.barrel[number].getCoorX()<=575 && this.barrel[number].getCoorX()>=503) {
				this.barrel[number].setCoorY(575);
			}
		}
		
		
		//Sexta linea
		
		if((this.barrel[number].getCoorY()>633 && this.barrel[number].getCoorY()<676)&&this.barrel[number].getCoorX()>=0&& goingDown==false) {
			this.barrel[number].addCoorX(-3);
			if(this.barrel[number].getCoorX()<=511 && this.barrel[number].getCoorX()>=440) {
				this.barrel[number].setCoorY(646);
			} else if (this.barrel[number].getCoorX()<=440 && this.barrel[number].getCoorX()>=382) {
				this.barrel[number].setCoorY(649);
			} else if(this.barrel[number].getCoorX()<=382 && this.barrel[number].getCoorX()>=307) {
				this.barrel[number].setCoorY(652);
			} else if(this.barrel[number].getCoorX()<=307 && this.barrel[number].getCoorX()>=0) {
				this.barrel[number].setCoorY(655);
			}
		}
		
		//IF para ver si debe regresarse
		
		if(this.barrel[number].getCoorX() <20  && (this.barrel[number].getCoorY()<680&&this.barrel[number].getCoorY()>645)){
			this.barrel[number].setCoorX(120);
			this.barrel[number].setCoorY(155);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//Left
		
		if (e.getKeyCode() == 65 || e.getKeyCode() == 37) { 
			this.movizq=1;
			this.movement = true;
			this.marioPosition = 0;
			this.repaint();
		}
		
		
		//Right
		
		else if (e.getKeyCode() == 68 || e.getKeyCode() == 39) { 
			this.movder=1;
			this.movement = true;
			this.marioPosition = 1;
			if(e.getKeyCode()== 65 || e.getKeyCode() == 37) {
				this.movement = true;
				this.marioPosition = 0;
			}
			this.repaint();
		
		/*
		 * 
		 * Up
		 * 
		 */
			
		}else if (e.getKeyCode() == 87 || e.getKeyCode() == 38) { 
			this.marioPosition = 2;
			
			//primer piso
			
			if(this.player.getCoorY()<670 && this.player.getCoorY()>568) {
				if (this.player.getCoorX()>=478 && this.player.getCoorX()<500) {
					this.player.addCoorY(-4);
				}
				
			//segundo piso
				
				//primera escalera
				
			}else if(this.player.getCoorY()<564 && this.player.getCoorY()>460) {
				if(this.player.getCoorX()>=218&&this.player.getCoorX()<=238) {
					this.player.addCoorY(-4);
					
				//segunda escalera
					
				}else if(this.player.getCoorY()<554&& this.player.getCoorY()>469){
					if(this.player.getCoorX()>=95&&this.player.getCoorX()<=113) {
						this.player.addCoorY(-4);
					}
				}
				
			//tercer piso
				
				
				//primera escalera
				
			}else if(this.player.getCoorY()<470 && this.player.getCoorY()>360){
				if(this.player.getCoorX()>=324&&this.player.getCoorX()<=344) {
					this.player.addCoorY(-4);
					
				//segunda escalera
					
					
				}else if(this.player.getCoorY()<455 && this.player.getCoorY()>365){
					if(this.player.getCoorX()>=483&&this.player.getCoorX()<=502) {
						this.player.addCoorY(-4);
					}
				}
				
			//cuarto piso
				
				
				//primera escalera
				
			}else if(this.player.getCoorY()<355 && this.player.getCoorY()>250){
				if(this.player.getCoorX()>=68&&this.player.getCoorX()<=84) {
					if(this.player.getCoorY()<355 && this.player.getCoorY()>268) {
						this.player.addCoorY(-4);
					}
					
				//segunda escalera
					
				}else if(this.player.getCoorY()<357 && this.player.getCoorY()>260){
					if(this.player.getCoorX()>=183&&this.player.getCoorX()<=202) {
						this.player.addCoorY(-4);
					}
				}
				
			//quinto piso
				
				
				//escalera
				
			}else if(this.player.getCoorY()<263 && this.player.getCoorY()>159) {
				if (this.player.getCoorX()>=497 && this.player.getCoorX()<=517) {
					this.player.addCoorY(-4);
				}
				
				
			//sexto piso
				
				//escalera pauline
				
			}else if(this.player.getCoorY()<152 && this.player.getCoorY()>53) {
				if (this.player.getCoorX()>=290 && this.player.getCoorX()<=305) {
					this.player.addCoorY(-4);
				}
			}
			this.repaint();	 
			
		}else if (e.getKeyCode() == 32) { //Jump
			if(this.ladder == true || this.gameOver == true || this.gameWin==true) {
				this.marioJump=false;
			}else {
				this.marioJump = true;
			}
		}
		
		
		/*
		 * 
		 * Down
		 * 
		 */
		
		else if (e.getKeyCode() == 83 || e.getKeyCode() == 40) {
			this.marioPosition = 2;
			
			//primer piso
			
			
			if(this.player.getCoorY()<638 && this.player.getCoorY()>568) {
				if (this.player.getCoorX()>=478 && this.player.getCoorX()<500) {
					this.player.addCoorY(3);
				}
				
			//segundo piso
				
				
			}else if(this.player.getCoorY()<556&& this.player.getCoorY()>460) {
				
					//segunda escalera
				
				if(this.player.getCoorX()>=218&&this.player.getCoorX()<=238) {
					this.player.addCoorY(3);
					
					//primera escalera
					
				}else if(this.player.getCoorY()<550&& this.player.getCoorY()>469){
					if(this.player.getCoorX()>=95&&this.player.getCoorX()<=113) {
						this.player.addCoorY(3);
					}
				}
				
			//tercer piso
				
				
			}else if(this.player.getCoorY()<456 && this.player.getCoorY()>360){
				
				//primer escalera
				
				if(this.player.getCoorX()>=324&&this.player.getCoorX()<=344) {
					this.player.addCoorY(3);
					
				//segunda escalera
					
				}else if(this.player.getCoorY()<450 && this.player.getCoorY()>365){
					if(this.player.getCoorX()>=483&&this.player.getCoorX()<=502) {
						this.player.addCoorY(3);
					}
				}
				
			//cuarto piso
				
				
				//primera escalera
				
			}else if(this.player.getCoorY()<349 && this.player.getCoorY()>296){
				if(this.player.getCoorX()>=68&&this.player.getCoorX()<=84) {
					this.player.addCoorY(3);
					
				//segunda escalera
					
				}else if(this.player.getCoorY()<368 && this.player.getCoorY()>284){
					if(this.player.getCoorX()>=183&&this.player.getCoorX()<=202) {
						this.player.addCoorY(3);
					}
				}
				
				
			//quinto piso
				
				//escalera
				
			}else if(this.player.getCoorY()<248 && this.player.getCoorY()>156) {
				if (this.player.getCoorX()>=497 && this.player.getCoorX()<517) {
					this.player.addCoorY(3);
				}
				
			//sexto piso
				
				//escalera pauline
				
			}else if(this.player.getCoorY()<146 && this.player.getCoorY()>81) {
				if (this.player.getCoorX()>=290 && this.player.getCoorX()<=305) {
					this.player.addCoorY(3);
				}
			}
			this.repaint();	
		}
	}
	
	public void playAudio(String file) {
		try {
		    File yourFile = new File(file);
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    stream = AudioSystem.getAudioInputStream(yourFile);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
		    System.out.println("Terrible");
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//left
		if(e.getKeyCode() == 65 || e.getKeyCode() == 37) {
			this.movizq=0;
		
		//right
		}else if (e.getKeyCode() == 68 || e.getKeyCode() == 39) { 
			this.movder=0;
		}
		if(this.movizq==0 && this.movder==0) {
			this.movement=false;
			
		}
	}

	@Override
	public void run() {
		int cont = 0;
		int contBarriles = 0;
		int audiocont = 0;
		while(this.gameOn) {
			try {
				contBarriles++;
				if (contBarriles>=0) {
					this.moveBarrel(0);
				}
				if (contBarriles >= 1*80) {
					this.moveBarrel(1);
				}
				if (contBarriles >= 2*80) {
					this.moveBarrel(3);
				}
				if (contBarriles >= 3*80) {
					this.moveBarrel(4);
				}
				if (contBarriles >= 4*80) {
					this.moveBarrel(5);
				}
				if (contBarriles >= 5*80) {
					this.moveBarrel(6);
				}
				if (contBarriles >= 6*80) {
					this.moveBarrel(7);
				}
				if (contBarriles >= 7*80) {
					this.moveBarrel(8);
				}
				if (contBarriles >= 8*80) {
					this.moveBarrel(9);
				}
				if (contBarriles >= 9*80) {
					this.moveBarrel(10);
				}
				if (contBarriles >= 10*80) {
					this.moveBarrel(11);
				}
				if (contBarriles >= 11*80) {
					this.moveBarrel(12);
				}
				
				this.movement();
				this.repaint();
				if(this.marioJump) {
					if(cont <1) {
						this.playAudio("mariojump.wav");
					}
					cont++;
					this.player.addCoorY(-6);
					if (cont>8 && cont < 16){
						this.player.addCoorY(12);
				} else if (cont>=16) {
						this.player.addCoorY(12);
						this.marioJump = false;
						cont = 0;
					}
					this.repaint();
					
				}
				if(Math.abs((this.barrel[0].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[0].getCoorY()-this.player.getCoorY()))<26 || 
						Math.abs((this.barrel[1].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[1].getCoorY()-this.player.getCoorY()))<26 || 
						Math.abs((this.barrel[2].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[2].getCoorY()-this.player.getCoorY()))<26 ||
						Math.abs((this.barrel[3].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[3].getCoorY()-this.player.getCoorY()))<26 ||
						Math.abs((this.barrel[4].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[4].getCoorY()-this.player.getCoorY()))<26 ||
						Math.abs((this.barrel[5].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[5].getCoorY()-this.player.getCoorY()))<26 ||
						Math.abs((this.barrel[6].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[6].getCoorY()-this.player.getCoorY()))<26 || 
						Math.abs((this.barrel[7].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[7].getCoorY()-this.player.getCoorY()))<26 || 
						Math.abs((this.barrel[8].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[8].getCoorY()-this.player.getCoorY()))<26 || 
						Math.abs((this.barrel[9].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[9].getCoorY()-this.player.getCoorY()))<26 || 
						Math.abs((this.barrel[10].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[10].getCoorY()-this.player.getCoorY()))<26 || 
						Math.abs((this.barrel[11].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[11].getCoorY()-this.player.getCoorY()))<26 || 
						Math.abs((this.barrel[12].getCoorX()-this.player.getCoorX())) < 20 && Math.abs((this.barrel[12].getCoorY()-this.player.getCoorY()))<26 ) {
					gameOver = true;
					contBarriles=0;
				}
				if((this.player.getCoorX()>290&&this.player.getCoorX()<=314) && this.player.getCoorY()<=54) {
					this.gameWin = true;
					contBarriles=0;
				}
				audiocont++;
				boolean audio = false;
				if(!audio) {
					if(audiocont <2 || (audiocont> 1202 &&audiocont<1204)||(audiocont> 2404 &&audiocont<2406)) {
						this.playAudio("25m.wav");
						audio = true;
					}
				}
				Thread.sleep(40);
			} catch(InterruptedException ex) {
				System.out.println("Terrible");
			}
			
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(gameOver || gameWin) {
			this.barrel = new Barrel[13];
			for (int i = 0;i<13;i++) {
				this.barrel[i]= new Barrel();
			}
			this.player = new Player();
			this.marioPosition = 1;
			this.marioJump = false;
			this.gameOn = true;
			this.ladder = false;
			this.movement = false;
			this.fallen = false;
			this.gameOver = false;
			this.gameWin = false;
			this.repaint();
			Thread hilo = new Thread();
			hilo.start();
			try {
				hilo.join();
			} catch(Exception ex) {
				System.out.println("terrible");
			}
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
