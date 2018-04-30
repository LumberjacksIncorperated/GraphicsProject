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
// <NONE>

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
public class GraphicsViewportController implements ControlInputListener
{
    private final GraphicsEngine graphicsEngine;
    
    /* Character Definitions for Keys That Will Be Pressed */
    private final char FORWARD_CHARACTER = 'w';
    private final char BACKWARD_CHARACTER = 's';
    private final char LEFT_CHARACTER = 'a';
    private final char RIGHT_CHARACTER = 'd';
    private final char ROTATE_UP_CHARACTER = 'l';
    private final char ROTATE_DOWN_CHARACTER = 'j';
    private final char ROTATE_LEFT_CHARACTER = 'k';
    private final char ROTATE_RIGHT_CHARACTER = 'i';
    
    /* Offset Definitions For Viewport Movement Amount When Keys Are Pressed */
    private final int MOVEMENT_OFFSET = 1;
    private final int MOVEMENT_RATATIONAL_OFFSET = 5;
    public void receivedControlInput(Input input) {
        if (input.isKeyCorrespondingToCharater(FORWARD_CHARACTER)) {
            this.moveViewportForwardByAmount(MOVEMENT_OFFSET);
        } else
        if (input.isKeyCorrespondingToCharater(BACKWARD_CHARACTER)) {
            this.moveViewportBackByAmount(MOVEMENT_OFFSET);
        } else
        if (input.isKeyCorrespondingToCharater(LEFT_CHARACTER)) {
            this.moveViewportLeftByAmount(MOVEMENT_OFFSET);
        } else
        if (input.isKeyCorrespondingToCharater(RIGHT_CHARACTER)) {
            this.moveViewportRightByAmount(MOVEMENT_OFFSET);
        } else
        if (input.isKeyCorrespondingToCharater(ROTATE_UP_CHARACTER)) {
            this.rotateViewportUpByAmount(MOVEMENT_RATATIONAL_OFFSET);
        } else
        if (input.isKeyCorrespondingToCharater(ROTATE_DOWN_CHARACTER)) {
            this.rotateViewportDownByAmount(MOVEMENT_RATATIONAL_OFFSET);
        } else
        if (input.isKeyCorrespondingToCharater(ROTATE_LEFT_CHARACTER)) {
            this.rotateViewportLeftByAmount(MOVEMENT_RATATIONAL_OFFSET);
        } else
        if (input.isKeyCorrespondingToCharater(ROTATE_RIGHT_CHARACTER)) {
            this.rotateViewportRightByAmount(MOVEMENT_RATATIONAL_OFFSET);
        }
        else {}
    }
    
    private GraphicsViewportController(GraphicsEngine graphicsEngine) {
        this.graphicsEngine = graphicsEngine;
    }
    
    public static GraphicsViewportController newViewportControllerWithEngine(GraphicsEngine graphicsEngine) {
        return new GraphicsViewportController(graphicsEngine);
    }
    
    /* Shifting Viewport Position In A Direction */
    private void moveViewportLeftByAmount(double moveLeftAmount) {
        this.moveViewportByXYZAmount(moveLeftAmount,0,0);
    }
    private void moveViewportRightByAmount(double moveRightAmount) {
        this.moveViewportByXYZAmount(-moveRightAmount,0,0);
    }
    private void moveViewportUpByAmount(double moveUpAmount) {
        this.moveViewportByXYZAmount(0,moveUpAmount,0);
    }
    private void moveViewportDownByAmount(double moveDownAmount) {
        this.moveViewportByXYZAmount(0,-moveDownAmount,0);
    }
    private void moveViewportForwardByAmount(double moveForwardAmount) {
        this.moveViewportByXYZAmount(0,0,moveForwardAmount);
    }
    private void moveViewportBackByAmount(double moveBackwardAmount) {
        this.moveViewportByXYZAmount(0,0,-moveBackwardAmount);
    }	
    private void moveViewportByXYZAmount(double xAmount, double yAmount, double zAmount) {
        Coordinate currentViewportPosition = graphicsEngine.getViewPosition();
        Coordinate newViewportPosition = new Coordinate(currentViewportPosition.x + xAmount , currentViewportPosition.y + yAmount, currentViewportPosition.z + zAmount);
        graphicsEngine.setViewPosition(newViewportPosition);
    }		
    
    /* Rotating Viewport In A Direction */
    private void rotateViewportLeftByAmount(double rotateLeftAmount) {
        this.rotateViewportXYByAmount(rotateLeftAmount,0);
    }
    private void rotateViewportRightByAmount(double rotateRightAmount) {
        this.rotateViewportXYByAmount(-rotateRightAmount,0);
    }
    private void rotateViewportUpByAmount(double rotateUpAmount) {
        this.rotateViewportXYByAmount(0,rotateUpAmount);
    }
    private void rotateViewportDownByAmount(double rotateDownAmount) {
        this.rotateViewportXYByAmount(0,-rotateDownAmount);
    }
    private void rotateViewportXYByAmount(double xAmount, double yAmount) {
        Direction currentViewportDirection = graphicsEngine.getViewDirection();
        Direction newViewportDirection = new Direction(currentViewportDirection.x + xAmount , currentViewportDirection.y + yAmount, currentViewportDirection.z);
        graphicsEngine.setViewDirection(newViewportDirection);
    }
}
