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

public class GraphicsDisplayWindow implements GraphicsDisplay {

	private JFrame frameWithinWindow;

	private GraphicsDisplayWindow() {

		frameWithinWindow = new JFrame ( "ðDave is Daveð" );
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

	private GLCapabilities glCapabilities;
	private GLEventListener glEventListener;
	public void receiveGLCapabilitiesFromEngine(GLCapabilities glCapabilities) {
		this.glCapabilities = glCapabilities;
	}
	public void receiveGLEventListenerFromEngine(GLEventListener glEventListener) {
		this.glEventListener = glEventListener;
	}

	public void showWindow() {
	  	final GLCanvas glcanvas = new GLCanvas( this.glCapabilities );
		
      glcanvas.addGLEventListener( this.glEventListener );
      glcanvas.setSize( 400, 400 );
		
      frameWithinWindow.getContentPane().add( glcanvas );
      frameWithinWindow.setSize( frameWithinWindow.getContentPane().getPreferredSize() );
      frameWithinWindow.setVisible( true );


      final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true);
		
      animator.start();
	}



}