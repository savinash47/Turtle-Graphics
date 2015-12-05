
public class Turn implements IntegerExpression{
	private String degrees;
	public Turn(String degrees){
		this.degrees = degrees;
	}
	

	@Override
	public void interpret(Context values) {
		Turtle turtle = values.getTurtle();
		turtle.turn(Integer.parseInt(degrees));
		
	}
	

}
