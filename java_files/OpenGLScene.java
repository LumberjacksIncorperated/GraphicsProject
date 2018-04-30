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

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
public class OpenGLScene implements Scene
{
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
    }
    
    private void glSetColour(Colour colour) {
        gl.glColor4d(colour.getRedComponent(), colour.getGreenComponent(), colour.getBlueComponent(), colour.getAlphaComponent());
    }
}

