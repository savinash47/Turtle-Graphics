
public class PenUp implements IntegerExpression{

	@Override
	public void interpret(Context values) {
		Turtle turtle = values.getTurtle();
		turtle.penUp();
		
	}
	

}
