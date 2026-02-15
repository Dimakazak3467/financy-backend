package poshlie_parni.exeption;

public class PersonNotFoundExeption extends RuntimeException {
    public PersonNotFoundExeption(String message) {
        super(message);
    }
}
