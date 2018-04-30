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
import com.jogamp.opengl.util.gl2.GLUT;
//com.jogamp.opengl.util.gl2.GLUT


public class OpenGLScene implements Scene {
	private final GL2 gl;
	private final GLU glUtility;
	private final GLUT glut = new GLUT();

	private OpenGLScene(GL2 gl, GLU glUtility) {
		this.gl = gl;
		this.glUtility = glUtility;
	}

	public static OpenGLScene openGlSceneWithUtilityAndLibrary(GLU glUtility, GL2 gl) {
		return new OpenGLScene(gl, glUtility); 
	}

	private final static int POLYGON_COUNT_FACTOR = 47;
	public void drawSphere(Coordinate position, double radius, Colour colour) {
		gl.glPushMatrix();
		gl.glTranslated(position.x, position.y, position.z);
		//gl.glRotated(1.0, 1.0f, 1.0f, 1.0f);
		this.glSetColour(colour);
		//gl.glColor3f( 0f,1f, 1f );
		//glut.glutSolidSphere(1, 20, 20);
		//glut.glutSolidSphere(radius, POLYGON_COUNT_FACTOR, POLYGON_COUNT_FACTOR);
		glut.glutSolidSphere(1, POLYGON_COUNT_FACTOR, POLYGON_COUNT_FACTOR);
    	gl.glPopMatrix();
    	

/*

    	gl.glTranslatef( 0f, 0f, -5.0f ); 

      // Rotate The Cube On X, Y & Z
      gl.glRotatef(0, 1.0f, 1.0f, 1.0f); 
 
      //giving different colors to different sides
      gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
      gl.glColor3f(1f,0f,0f); //red color
      gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)
		
      gl.glColor3f( 0f,1f,0f ); //green color
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,0f,1f ); //blue color
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Back)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Back)

      gl.glColor3f( 1f,0f,1f ); //purple (red + green)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Left)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Left)
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 

      gl.glColor3f( 0f,1f, 1f ); // blue (blue +green)
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Right)
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
      gl.glEnd(); // Done Drawing The Quad
      */
	}

	private void glSetColour(Colour colour) {
		gl.glColor4d(colour.getRedComponent(), colour.getGreenComponent(), colour.getBlueComponent(), colour.getAlphaComponent());
	}
}

