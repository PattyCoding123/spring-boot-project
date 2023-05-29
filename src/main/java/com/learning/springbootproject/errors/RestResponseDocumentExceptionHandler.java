package com.learning.springbootproject.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/* With the @ControllerAdvice annotation, whenever there is an
 * exception thrown in our controllers, it will create a particular
 * response based on that exception. It will then return that as the Response object.
 *
 * The @ResponseStatus will mark this class with the HTTP code
 * and status that should be returned.
 *
 * We want to create different methods for different Exception classes.
 * */
@ControllerAdvice
@ResponseStatus
public class RestResponseDocumentExceptionHandler
        extends ResponseEntityExceptionHandler {

    /* This method will handle the DepartmentNotFoundException
     * class, so whenever an error of this type is thrown,
     * then this method will be invoked and will return
     * an appropriate Response entity.
     *
     * Functions with @ExceptionHandler will take the exception
     * object as the first parameter, and a WebRequest object.
     * */
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception,
                                                                    WebRequest request) {
        /* All errors of departmentNotFoundException should have a 404
         * status code */
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        /* Finally, we must return a ResponseEntity that is sent
         * as a Response for our API */
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
