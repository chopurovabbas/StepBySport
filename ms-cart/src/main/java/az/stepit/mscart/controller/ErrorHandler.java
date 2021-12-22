package az.stepit.mscart.controller;

import az.stepit.mscart.model.error.ErrorDto;
import az.stepit.mscart.model.exception.CartNotFoundException;
import az.stepit.mscart.model.exception.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(ProductNotFoundException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                new ErrorDto( "productId.not-found", ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                webRequest);
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Object> handleAccountNotFoundException(CartNotFoundException ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                new ErrorDto( "product.not-found", ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                webRequest);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest webRequest) {
        return handleExceptionInternal(ex,
                new ErrorDto( "cart.unexpected-error", ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                webRequest);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return handleExceptionInternal(ex,
              ErrorDto.builder()
                      .error(ex.getMessage())
                      .message(errors.toString())
                      .build(),
                new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }


}