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
public class Colour
{
    private final double redComponent;
    private final double greenComponent;
    private final double blueComponent;
    private final double alphaComponent;
    
    private Colour(double redComponent, double greenComponent, double blueComponent, double alphaComponent) {
        this.redComponent = redComponent;
        this.greenComponent = greenComponent;
        this.blueComponent = blueComponent;
        this.alphaComponent = alphaComponent;
    }
    
    public static Colour createRedColour() {
        return new Colour(1.0, 0, 0, 1.0);
    }
    
    public static Colour createRedColor() {
        return new Colour(0, 1.0, 0, 1.0);
    }
    
    public static Colour createBlueColour() {
        return new Colour(0, 0, 1.0, 1.0);
    }
    
    public double getRedComponent() {
        return this.redComponent;
    }
    
    public double getGreenComponent() {
        return this.greenComponent;
    }
    
    public double getBlueComponent() {
        return this.blueComponent;
    }
    
    public double getAlphaComponent() {
        return this.alphaComponent;
    }
}
