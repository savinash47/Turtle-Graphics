public class MoveCommand implements Command {
	private Turtle turtle;
	private int distance;

	public MoveCommand(Turtle turtle, int distance) {
		this.turtle = turtle;
		this.distance = distance;
	}

	@Override
	public void execute() {
		turtle.move(distance);

	}

	@Override
	public void undo() {
		turtle.move(-distance);

	}

}
