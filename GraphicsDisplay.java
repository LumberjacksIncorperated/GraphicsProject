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

public interface GraphicsDisplay {
	public void receiveGLCapabilitiesFromEngine(GLCapabilities capabilities);
	public void receiveGLEventListenerFromEngine(GLEventListener glEventListener);
}