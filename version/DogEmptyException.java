package code.java.project.version;

public class DogEmptyException extends RuntimeException{
    public DogEmptyException(){}

    public DogEmptyException(String message){
        super(message);
    }
}
