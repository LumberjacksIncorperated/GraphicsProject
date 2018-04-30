
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
// APPLICATION
//-----------------------------------------------------------------------------------------------------------------------
public class GraphicsApplication
{
    public static void main(String[] args) {
        GraphicsApplication graphicsApplication = new GraphicsApplication();
        graphicsApplication.run();
    }
    
    private GraphicsDisplayWindow graphicsDisplayWindow;
    private GraphicsEngine graphicsEngine;
    private ControlInput controlInput;
    
    public GraphicsApplication() {}
    
    public void run() {
        graphicsDisplayWindow = GraphicsDisplayWindow.createNewGraphicsDisplayWindow();
        GraphicsDisplay graphicsDisplay = graphicsDisplayWindow.getGraphicsDisplay();
        
        EngineConfiguration initialEngineConfiguration = GraphicsApplication.engineInitialConfigurationWithDisplay(graphicsDisplay);
        graphicsEngine = GraphicsEngine.startEngineWithConfiguration(initialEngineConfiguration);
        
        GraphicsViewportController graphicsViewportController = GraphicsViewportController.newViewportControllerWithEngine(graphicsEngine);
        controlInput = ControlInput.startListeningToInputWithWindowAndListener(graphicsDisplayWindow, graphicsViewportController);
        
        graphicsDisplayWindow.showWindow();
    }
    
    private static EngineConfiguration engineInitialConfigurationWithDisplay(GraphicsDisplay graphicsDisplay) {
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        
        //engineConfiguration.setFramerateMaxFPS(60);
        engineConfiguration.setViewPosition(new Coordinate(-1,0,0));
        engineConfiguration.setViewPosition(new Coordinate(-1,0,2));
        engineConfiguration.setViewLookingTowardsDirection(new Direction(1,0,0));
        engineConfiguration.setGraphicsDisplay(graphicsDisplay);
        engineConfiguration.setScenePainter(new TestScenePainter());
        
        return engineConfiguration;
    }
}
