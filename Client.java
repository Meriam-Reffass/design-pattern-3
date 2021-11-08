package casestudy;

import java.util.Observer;

public class Client {
public static void main(String[] args) {
	Subject subject = new Subject(0);
	Observer octal = new OctalObserver(subject);
	Observer binary = new BinaryObserver(subject);
	Observer hexa = new HexaObserver(subject);
	Thread thread = new Thread(subject);
	thread.start();
}
}
