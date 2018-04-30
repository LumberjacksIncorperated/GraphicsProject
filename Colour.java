public class Colour {
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

	public static Colour redColour() {
		return new Colour(1.0, 0, 0, 1.0);
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