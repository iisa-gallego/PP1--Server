import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import processing.core.PApplet;

public class Inicial extends PApplet {

	private Socket socket;
	private ArrayList<Particula> Particulas;

	public static void main(String[] args) {
		PApplet.main("Inicial");

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

			Particulas.add(new Particula());

		}
	}

	public void draw() {
		for (Particula Particulas : Particulas) {
			Particulas.paint();
			new Thread(Particulas).start(); // llamada al método run de Polo
		}
	}

	public void initServer() {
		new Thread(() -> {
			try {
				ServerSocket server = new ServerSocket(5000);
				System.out.println("esperanda la conexión");
				socket = server.accept();
				System.out.println("Cliente conectado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
