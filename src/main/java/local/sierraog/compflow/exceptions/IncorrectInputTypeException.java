package local.sierraog.compflow.exceptions;

public class IncorrectInputTypeException extends RuntimeException {
    public IncorrectInputTypeException(){
        super("Input type not valid");
    }
}
