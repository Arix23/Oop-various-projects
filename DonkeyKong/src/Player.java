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



public class Player {
	private int coorX,
				coorY;
	
	public Player() {
		this.coorX = 54;
		this.coorY = 646;
	}
	
	public void setCoorY(int coord) {
		this.coorY = coord;
	}
	
	public int getCoorX() {
		return this.coorX;
	}
	public int getCoorY() {
		return this.coorY;
	}
	public void addRightCoorX(int coord) {
		if(this.coorX < 578) {
			this.coorX+=coord;
		}	
	}
	public void addLeftCoorX(int coord) {
		if(this.coorX > 0) {
			this.coorX+=coord;
		}
	}
	public void addCoorY(int coord) {
		this.coorY+=coord;
	}
}