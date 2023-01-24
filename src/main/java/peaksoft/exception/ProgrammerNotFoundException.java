package peaksoft.exception;

public class ProgrammerNotFoundException extends RuntimeException{
    public ProgrammerNotFoundException(){
        super();
    }
    public ProgrammerNotFoundException(String message){
        super(message);
    }
}
