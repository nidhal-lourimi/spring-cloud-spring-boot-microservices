package com.nidhallourimi.app.ws.exceptions;

import com.nidhallourimi.app.ws.userService.UserService;
import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest request){
    String errorMessageDescription= exception.getLocalizedMessage();
    if(errorMessageDescription==null)errorMessageDescription=errorMessageDescription.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);
    return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @ExceptionHandler(value = {NullPointerException.class,UserServiceException.class})
    public ResponseEntity<Object> handleSpecificException(Exception exception, WebRequest request){
        String errorMessageDescription= exception.getLocalizedMessage();
        if(errorMessageDescription==null)errorMessageDescription=errorMessageDescription.toString();

        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);


    }
    @ExceptionHandler(value = ResponseStatusException.class )
    public ResponseEntity<Object> handleResponseException(Exception exception, WebRequest request){
        String errorMessageDescription= exception.getLocalizedMessage();
        if(errorMessageDescription==null)errorMessageDescription=errorMessageDescription.toString();
          String web= request.toString();
        HttpStatus status = ((ResponseStatusException) exception).getStatus();
        ErrorMessage errorMessage= new ErrorMessage(new Date(), errorMessageDescription);
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), status);


    }


}
