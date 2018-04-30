public class TestScenePainter implements ScenePainter {

	public TestScenePainter(){}

	public void paintScene(Scene scene) {
		double sphereRadius = 0.4;
		Coordinate spherePosition = new Coordinate(0,0,0);
		scene.drawSphere(spherePosition, sphereRadius, Colour.redColour());
	}
}