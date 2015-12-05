import java.util.List;


public class Repeat implements IntegerExpression {
	private List<IntegerExpression> listOfExpression;
	private int repeatCount;
	public Repeat(List<IntegerExpression> expression, int repeatCount) {
		this.listOfExpression = expression;
		this.repeatCount = repeatCount;
	}


	@Override
	public void interpret(Context values) {
		Turtle turtle = values.getTurtle();
		
		}
	
	

}
