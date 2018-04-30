//-----------------------------------------------------------------------------------------------------------------------
//
// PROJECT
// -------
// "Graphics Project"
//
// AUTHOR
// ------
// Lumberjacks Incorperated (2018)
//
//-----------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
public class ControlInput implements KeyListener
{
    private ControlInputListener controlInputListener;
    
    private ControlInput(ControlInputListener controlInputListener) {
        this.controlInputListener = controlInputListener;
    }
    
    public static ControlInput startListeningToInputWithWindowAndListener(GraphicsDisplayWindow graphicsDisplayWindow, ControlInputListener controlInputListener) {
        ControlInput newControlInput = new ControlInput(controlInputListener);
        graphicsDisplayWindow.addKeyListener(newControlInput);
        return newControlInput;
    }
    
    public void keyPressed(KeyEvent keyEvent) {
        Input receivedInput = Input.inputWithKeyPressedKeyEvent(keyEvent);
        this.controlInputListener.receivedControlInput(receivedInput);
    }
    
    public void keyReleased(KeyEvent keyEvent) {}
    public void keyTyped(KeyEvent keyEvent) {}
}
