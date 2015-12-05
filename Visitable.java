import java.util.List;


public interface Visitable {
	public List<Command> accept(Visitor visitor);

}
