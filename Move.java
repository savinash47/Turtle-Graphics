public class Move implements IntegerExpression {
	private String distance;

	public Move(String distance) {
		this.distance = distance;

	}

	@Override
	public void interpret(Context values) {
		Turtle turtle = values.getTurtle();
		turtle.move(Integer.parseInt(distance));
		System.out.println(turtle.location().getX()+","+ turtle.location().getY());
		
	}

}
