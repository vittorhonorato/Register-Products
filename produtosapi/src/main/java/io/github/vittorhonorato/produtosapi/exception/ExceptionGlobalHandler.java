package io.github.vittorhonorato.produtosapi.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionGlobalHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationFieldsCreate(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                erros.put(error.getField(), error.getDefaultMessage()));

       return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ApiResponse> productNotFound(ProductNotFound ex) {
        ApiResponse response = new ApiResponse(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ProductConflit.class)
    public ResponseEntity<ApiResponse> productExisted(ProductConflit ex) {
        ApiResponse response = new ApiResponse(
                HttpStatus.CONFLICT,
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String,InvalidFormatException>> validationFieldsCreate(HttpMessageNotReadableException ex) {
        Map<String, InvalidFormatException> erros = new HashMap<>();

        if (ex.getCause() instanceof InvalidFormatException) {
            var cause = (InvalidFormatException) ex.getCause();
            String field = cause.getPath().get(0).getFieldName();

            erros.put(field, cause);

        }


       return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);

    }


}
