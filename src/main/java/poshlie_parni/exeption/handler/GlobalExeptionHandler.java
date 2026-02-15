package poshlie_parni.exeption.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import poshlie_parni.exeption.PersonAlreadyExistsExeption;
import poshlie_parni.exeption.PersonNotFoundExeption;

@ControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(PersonNotFoundExeption.class)
    public ResponseEntity<String> handlePersonNotFoundExeption(PersonNotFoundExeption e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonAlreadyExistsExeption.class)
    public ResponseEntity<String> handlePersonAlreadyExistsExeption(PersonAlreadyExistsExeption e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
