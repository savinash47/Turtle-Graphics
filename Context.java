import java.util.Hashtable;

public class Context {
	Hashtable<String, Integer> values = new Hashtable<String, Integer>();
	Turtle turtle;
	public Turtle getTurtle(){
		return turtle;
	}
	public void setTurtle(Turtle turtle){
		this.turtle = turtle;
	}
	public Integer getValue(String variableName){
		return values.get(variableName);
	}
	public void setValue(String variableName, Integer value){
		values.put(variableName, value);
	}
}
