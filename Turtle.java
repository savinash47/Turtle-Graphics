import javafx.geometry.Point2D;
public class Turtle {
	private Point2D location;
	private int degrees;
	private boolean stateOfPen;

	public void penUp() {
		stateOfPen = true;
	}

	public void penDown() {
		stateOfPen = false;
	}

	public boolean isPenUp() {
		return stateOfPen;
	}

	public int direction() {
		return degrees;
	}
	
	public void turn(int degrees) {
		this.degrees = this.degrees + degrees;
	}
	public void move(int distance) {
		double radian = Math.PI * ((double) degrees / 180);
		double deltaX = Math.cos(radian) * distance;
		double deltaY = Math.sin(radian) * distance;
		location = location.add(deltaX, deltaY);
	}
	public Point2D location(){
		return location;
	}
}
