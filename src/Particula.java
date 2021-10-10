import processing.core.PApplet;

public class Particula implements Runnable {

		private int posX, posY;
		private final float tam = 30;
		private int vel;
		private PApplet app;

		public  Particula (int posX, int posY, PApplet app, int velocity) {
			this.posX = posX;
			this.posY = posY;
			this.app = app;

		}

		public void paint() {
			app.fill(255, 87, 51);
			app.noStroke();
			app.ellipse(posX, posY, tam, tam);
		}

		public void move() {
			posX += app.random(2, 1);
			posY += app.random(1, 2);

		}

		public void run() {
			move();
		}

		public int getPosX() {
			return posX;
		}

		public void setPosX(int posX) {
			this.posX = posX;
		}

		public int getPosY() {
			return posY;
		}

		public void setPosY(int posY) {
			this.posY = posY;
		}
	
	}
