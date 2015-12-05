
public class TurnCommand implements Command{
	private Turtle turtle;
	private int degrees;
	public TurnCommand(Turtle turtle, int degrees){
		this.turtle = turtle;
		this.degrees = degrees;
	}
	@Override
	public void execute() {
		turtle.turn(degrees);
		
	}

	@Override
	public void undo() {
		turtle.turn(-degrees);
		
	}

}
