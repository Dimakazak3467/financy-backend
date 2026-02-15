package poshlie_parni.exeption;

public class PersonAlreadyExistsExeption extends RuntimeException{
    public PersonAlreadyExistsExeption(String message) {
        super(message);
    }
}
