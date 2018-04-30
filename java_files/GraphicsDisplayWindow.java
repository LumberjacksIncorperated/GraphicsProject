///-----------------------------------------------------------------------------------------------------------------------
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
import java.awt.DisplayMode;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
public class GraphicsDisplayWindow implements GraphicsDisplay
{
    private JFrame frameWithinWindow;
    private GLCapabilities glCapabilities;
    private GLEventListener glEventListener;
    
    private final String WINDOW_NAME = "Dave Is Dave";
    private GraphicsDisplayWindow() {
        frameWithinWindow = new JFrame ( WINDOW_NAME );
    }
    
    public static GraphicsDisplayWindow createNewGraphicsDisplayWindow() {
        return new GraphicsDisplayWindow();
    }
    
    public GraphicsDisplay getGraphicsDisplay() {
        return this;
    }
    
    public void addKeyListener(KeyListener keyListener) {
        this.frameWithinWindow.addKeyListener(keyListener);
    }
    
    public void receiveGLCapabilitiesFromEngine(GLCapabilities glCapabilities) {
        this.glCapabilities = glCapabilities;
    }
    public void receiveGLEventListenerFromEngine(GLEventListener glEventListener) {
        this.glEventListener = glEventListener;
    }
    
    private int WINDOW_WIDTH = 400;
    private int WINDOW_HEIGHT = 400;
    private int FRAMES_PER_SECOND = 300;
    public void showWindow() {
        final GLCanvas glcanvas = new GLCanvas( this.glCapabilities );
        
        glcanvas.addGLEventListener( this.glEventListener );
        glcanvas.setSize( WINDOW_WIDTH, WINDOW_HEIGHT );
        
        frameWithinWindow.getContentPane().add( glcanvas );
        frameWithinWindow.setSize( frameWithinWindow.getContentPane().getPreferredSize() );
        frameWithinWindow.setVisible( true );
        
        final FPSAnimator animator = new FPSAnimator(glcanvas, FRAMES_PER_SECOND, true);
        
        animator.start();
    }
}
