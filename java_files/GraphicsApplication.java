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
    private ControlInputListener controlInputListener;
    
    public GraphicsApplication() {}
    
    public void run() {
        setupDisplay();
        setupEngine();
        setupViewController();
    }
    
    private void setupDisplay() {
        graphicsDisplayWindow = GraphicsDisplayWindow.createNewGraphicsDisplayWindow();
    }
    
    private void setupEngine() {
        GraphicsDisplay graphicsDisplay = graphicsDisplayWindow.getGraphicsDisplay();
        EngineConfiguration initialEngineConfiguration = createEngineInitialConfigurationWithDisplay(graphicsDisplay);
        graphicsEngine = GraphicsEngine.startEngineWithConfiguration(initialEngineConfiguration);
    }
    
    private void setupViewController() {
        GraphicsViewportController graphicsViewportController = GraphicsViewportController.newViewportControllerWithEngine(this.graphicsEngine);
        controlInputListener = ControlInputListener.createControlInputListenerWithDelegate(graphicsViewportController);
        graphicsDisplayWindow.addKeyListener(this.controlInputListener);
        graphicsDisplayWindow.showWindow();
    }
    
    private EngineConfiguration createEngineInitialConfigurationWithDisplay(GraphicsDisplay graphicsDisplay) {
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        setEngineInitialConfigurationWithGraphicsDisplay(engineConfiguration, graphicsDisplay);
        return engineConfiguration;
    }
    
    private void setEngineInitialConfigurationWithGraphicsDisplay(EngineConfiguration engineConfiguration, GraphicsDisplay graphicsDisplay) {
        //engineConfiguration.setFramerateMaxFPS(60);
        engineConfiguration.setViewPosition(new Coordinate(-1,0,0));
        engineConfiguration.setViewPosition(new Coordinate(-1,0,2));
        engineConfiguration.setViewLookingTowardsDirection(new Direction(1,0,0));
        engineConfiguration.setGraphicsDisplay(graphicsDisplay);
        engineConfiguration.setScenePainter(new TestScenePainter());
    }
}
