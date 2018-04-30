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
public class ControlInputListener implements KeyListener
{
    private ControlInputDelegate controlInputDelegate;
    
    private ControlInputListener(ControlInputDelegate controlInputDelegate) {
        this.controlInputDelegate = controlInputDelegate;
    }
    
    public static ControlInputListener createControlInputListenerWithDelegate(ControlInputDelegate controlInputDelegate) {
        ControlInputListener newControlInputListener = new ControlInputListener(controlInputDelegate);
        return newControlInputListener;
    }
    
    /* Key Event Functions */
    public void keyPressed(KeyEvent keyEvent) {
        Input receivedInput = Input.inputWithKeyPressedKeyEvent(keyEvent);
        this.controlInputDelegate.receivedControlInput(receivedInput);
    }
    public void keyReleased(KeyEvent keyEvent) { /* Nothing */ }
    public void keyTyped(KeyEvent keyEvent) { /* Nothing */ }
}
