package code.java.project.version;

public class ShelterEmptyException extends RuntimeException{
    public ShelterEmptyException(){}

    public ShelterEmptyException(String message){
        super(message);
    }
}
