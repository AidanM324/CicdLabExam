package ie.atu.cicdlabexam;

public class DuplicateProductCodeException extends RuntimeException{
    public DuplicateProductCodeException(String message){
        super(message);
    }
}
