package code.java.project.version;

public class CatEmptyException extends RuntimeException{
    public CatEmptyException(){}

    public CatEmptyException(String message){
        super(message);
    }
}
