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
public class EngineConfiguration
{	
    //private int framerateMaxFPS = 60;
    private ScenePainter scenePainter;
    private GraphicsDisplay graphicsDisplay;
    private Coordinate viewPosition = new Coordinate(0,0,0);
    private Direction viewLookingTowardsDirection = new Direction(1,0,0);
    
    public EngineConfiguration() { /* Nothing */ }
    
    public void setScenePainter(ScenePainter newScenePainter) {
        this.scenePainter = newScenePainter;
    }
    public ScenePainter getScenePainter() {
        return this.scenePainter;
    }
    
    public void setViewPosition(Coordinate newViewPosition) {
        this.viewPosition = newViewPosition;
    }
    public Coordinate getViewPosition() {
        return this.viewPosition;
    }
    
    public void setViewLookingTowardsDirection(Direction newViewLookingTowardsDirection) {
        this.viewLookingTowardsDirection = newViewLookingTowardsDirection;
    }
    public Direction getViewLookingTowardsDirection() {
        return this.viewLookingTowardsDirection;
    }
    
    public void setGraphicsDisplay(GraphicsDisplay newGraphicsDisplay) {
        this.graphicsDisplay = newGraphicsDisplay;
    }
    public GraphicsDisplay getGraphicsDisplay() {
        return this.graphicsDisplay;
    }	
}



