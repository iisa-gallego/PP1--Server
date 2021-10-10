import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet {

	private Socket socket;
	private ArrayList<Particula> Particulas;
	public int vel;

	public static void main(String[] args) {
		PApplet.main("Main");

	}

	public void settings() {
		size(1080, 700);
	}

	public void setup() {
		initServer();
		Particulas = new ArrayList<Particula>();
		for (int i = 0; i < 20; i++) {
			int posX = (int) random(30, 470);
			int posY = (int) random(30, 470);

			Particulas.add(new Particula(posX, posY, this, vel));

		}
	}

	public void draw() {
		background(0);
		for (Particula Particulas : Particulas) {
			Particulas.paint();
			new Thread(Particulas).start(); // llamada al método run de Particulas
		}
	}

	public void initServer() {
		new Thread(() -> {
			try {
				ServerSocket server = new ServerSocket(5000);
				System.out.println("esperando la conexión");
				socket = server.accept();
				System.out.println("Cliente conectado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
