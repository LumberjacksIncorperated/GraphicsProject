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

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
public class GraphicsEngine implements GLEventListener
{
    private enum EngineRunningState {
        RUNNING,
        NOT_RUNNING
    }
    
    private final EngineConfiguration engineConfiguration;
    private final GLU graphicsLibraryUtility = new GLU();
    private EngineRunningState engineRunningState = EngineRunningState.NOT_RUNNING;
    
    public static GraphicsEngine startEngineWithConfiguration(EngineConfiguration initialEngineConfiguration) {
        GraphicsEngine newGraphicsEngine = new GraphicsEngine(initialEngineConfiguration);
        newGraphicsEngine.startEngine();
        return newGraphicsEngine;
    }
    
    public void moveViewportPosition(Coordinate newViewPosition, Direction newViewLookingTowardsDirection) {
        this.engineConfiguration.setViewPosition(newViewPosition);
        this.engineConfiguration.setViewLookingTowardsDirection(newViewLookingTowardsDirection);
    }
    
    private GraphicsEngine(EngineConfiguration initialEngineConfiguration) {
        this.engineConfiguration = initialEngineConfiguration;
        setupGlInternalConfiguration();
    }
    
    private void setupGlInternalConfiguration() {
        final GLProfile glProfile = GLProfile.get( GLProfile.GL2 );
        GLCapabilities glCapabilities = new GLCapabilities( glProfile );
        
        GraphicsDisplay graphicsDisplay = this.engineConfiguration.getGraphicsDisplay();
        
        graphicsDisplay.receiveGLCapabilitiesFromEngine(glCapabilities);
        graphicsDisplay.receiveGLEventListenerFromEngine(this);
    }
    
    private void startEngine() {
        assert(this.engineRunningState == EngineRunningState.NOT_RUNNING);
        this.engineRunningState = EngineRunningState.RUNNING;
    }
    
    private void paintScene(Scene scene) {
        ScenePainter scenePainter = this.engineConfiguration.getScenePainter();
        scenePainter.paintScene(scene);
    }
    
    public Coordinate getViewPosition() {
        return this.engineConfiguration.getViewPosition();
    }
    
    public void setViewPosition(Coordinate viewPosition) {
        this.engineConfiguration.setViewPosition(viewPosition);
    }
    
    public Direction getViewDirection() {
        return this.engineConfiguration.getViewLookingTowardsDirection();
    }
    
    public void setViewDirection(Direction viewDirection) {
        this.engineConfiguration.setViewLookingTowardsDirection(viewDirection);
    }
    
//----------------------------------------------------------------------------------------
// 									UNDER THE HOOD
//----------------------------------------------------------------------------------------
    
    @Override
    public void display( GLAutoDrawable drawable ) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
        gl.glLoadIdentity();
        OpenGLScene openGlScene = OpenGLScene.openGlSceneWithUtilityAndLibrary(graphicsLibraryUtility, gl);
        Coordinate viewPosition = engineConfiguration.getViewPosition();
        Direction viewLookingTowardsDirection = engineConfiguration.getViewLookingTowardsDirection();
        
        gl.glPushMatrix();
        gl.glRotated(viewLookingTowardsDirection.x-1, 1.0, 0, 0);
        gl.glRotated(viewLookingTowardsDirection.y, 0, 1.0, 0);
        gl.glRotated(viewLookingTowardsDirection.z, 0, 0, 1.0);
        gl.glTranslated(1 + viewPosition.x, viewPosition.y, -5.0 + viewPosition.z);
        
        this.paintScene(openGlScene);
        gl.glPopMatrix();
        gl.glFlush();
    }
    
    @Override
    public void dispose( GLAutoDrawable drawable ) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void init( GLAutoDrawable drawable ) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel( GL2.GL_SMOOTH );
        gl.glClearColor( 0f, 0f, 0f, 0f );
        gl.glClearDepth( 1.0f );
        gl.glEnable( GL2.GL_DEPTH_TEST );
        gl.glDepthFunc( GL2.GL_LEQUAL );
        gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
    }
    
    @Override
    public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
        
        // TODO Auto-generated method stub
        final GL2 gl = drawable.getGL().getGL2();
        if( height <= 0 )
            height = 1;
        
        final float h = ( float ) width / ( float ) height;
        gl.glViewport( 0, 0, width, height );
        gl.glMatrixMode( GL2.GL_PROJECTION );
        gl.glLoadIdentity();
        
        graphicsLibraryUtility.gluPerspective( 45.0f, h, 1.0, 20.0 );
        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();
    }
}

