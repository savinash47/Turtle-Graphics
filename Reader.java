import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;



public class Reader {
	private String fileName, statement;
	private String[] statementArray;
	private List<IntegerExpression> expressionList = new ArrayList<IntegerExpression>();
	private List<IntegerExpression> repeatBlock = new ArrayList<IntegerExpression>();
	private Context values = new Context();
	private boolean isRepeatFound = false;
	private Turtle turtle = new Turtle();
	private int repeatCount;
	public Reader(String fileName) {
		this.fileName = fileName;
	}
    
	public void abstractSyntaxTree() throws FileNotFoundException {
		int output = 0;
		
		Scanner inputFile = new Scanner(new FileInputStream(fileName));
		while (inputFile.hasNext()) {
			statement = inputFile.nextLine();
			statementArray = statement.trim().split(" ");
			if (statementArray.length == 2) {
				if (statementArray[0].equalsIgnoreCase("move")) {
				IntegerExpression 	expressionList.add(statementArray[0]);
					output = expression("move");
					if(output != 1)
						break;
				} else if (statementArray[0].equalsIgnoreCase("turn")) {
					output = expression("turn");
					if(output != 1)
						break;
				} else if (statementArray[0].equalsIgnoreCase("repeat")) {
					output = repeatExpression();
					if(output != 1)
						break;
				}else {
					output = stateExpression();
					if(output != 1)
						break;
				}
				
			}
			if(statementArray.length == 3){
				output = equalsExpression();
				if(output != 1)
					break;
			}
		}

	}
	
	private int expression(String operation) {
		String currentOperation = statementArray[1].trim();
		if (currentOperation.startsWith("$")) {
			return variableExpression(operation);
		} else
			return constantExpression(operation);
	}

	private int variableExpression(String operation) {
		String variable = statementArray[1].trim();
		try {
			int value = values.getValue(variable);
			if (value != 0) {
				IntegerExpression expression = null;
				if (operation == "move")
					expression = new Move(variable);
				else
					expression = new Turn(variable);
				if (!isRepeatFound)
					expressionList.add(expression);
				else
					repeatBlock.add(expression);
				return 1;
			} else
				return 0;
		}

		catch (Exception e) {
			return 0;
		}

	}

	private int constantExpression(String operation) {
		String constant = statementArray[1].trim();
		try {
			int value = values.getValue(constant);
			if (value == 0)
				values.setValue(constant, Integer.parseInt(constant));
			IntegerExpression expression;
			if (operation == "move")
				expression = new Move(constant);
			else
				expression = new Turn(constant);
			if (!isRepeatFound)
				expressionList.add(expression);
			else
				repeatBlock.add(expression);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	private int repeatExpression() {
		String repeat = statementArray[1].trim();
		try {
			isRepeatFound = true;
			if (repeat.startsWith("$")) {
				int value = values.getValue(repeat);
				if (value != 0) {
					repeatCount = value;
					return 1;
				} else
					return 0;
			} else {
				int value = values.getValue(repeat);
				if (value == 0)
					values.setValue(repeat, Integer.parseInt(repeat));
				repeatCount = Integer.parseInt(repeat);
				return 1;
			}
		}
		catch(Exception e) {
			return 0;
		}

	}
private int equalsExpression() {
		
		if(!statementArray[1].trim().equals("="))
			return 0;
		try {
			if (statementArray[0].trim().startsWith("$")) {
				values.setValue(statementArray[0].trim(),
						Integer.parseInt(statementArray[2].trim()));
				return 1;
			} else
				return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	private int stateExpression(){
	int result = 0;
		
		if(statement.equalsIgnoreCase("pendown"))
		{
			result = 1;
			IntegerExpression abstractExpression = new PenDown();
			if(!isRepeatFound)
				expressionList.add(abstractExpression);
			else
				repeatBlock.add(abstractExpression);
		}
		else if(statement.equalsIgnoreCase("penup")) {
			result = 1;
			IntegerExpression abstractExpression = new PenUp();
			if(!isRepeatFound)
				expressionList.add(abstractExpression);
			else
				repeatBlock.add(abstractExpression);
		}
		else if(statement.equalsIgnoreCase("end")) {
			if(!isRepeatFound)
				return 0;
			result = 1;
			IntegerExpression endOfFile = new Repeat(repeatBlock,repeatCount);
			isRepeatFound = false;
			expressionList.add(endOfFile);
		}
		else {
			result = 0;
		}
		return result;
	}
		
	}
	

