
public class Constant implements IntegerExpression{

	private int constant;
	
	public Constant(int constant)
	{
		this.constant = constant;
	}
	
	@Override
	public void interpret(Context value) {
		value.setValue(""+constant,constant);
	}

}



