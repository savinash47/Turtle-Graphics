import java.util.List;


public interface Visitor {
	public Command visit(Move moveExpression);
	public Command visit(Turn turnExpression);
	public Command visit(PenDown penDown);
	public Command visit(PenUp penUp);
	public List<Command> visit();
}
