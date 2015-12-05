
public class Variable implements IntegerExpression {
		 
		 private String name;
		 private int value;
		 private Variable( String name, int value ) {
		 this.name = name;
		 this.value = value;
		 }
		 
		@Override
		public void interpret(Context values) {
			values.setValue(name,value);
			
		}
}
