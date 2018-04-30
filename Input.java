import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class Input {
	private KeyEvent keyEvent;

	private Input() {

	}

	public boolean isKeyCorrespondingToCharater(char character) {
		return (this.keyEvent.getKeyChar() == character);
	}


	public static Input inputWithKeyPressedKeyEvent(KeyEvent keyEvent) {
		Input input = new Input();
		input.keyEvent = keyEvent;
		return input;
	}
}