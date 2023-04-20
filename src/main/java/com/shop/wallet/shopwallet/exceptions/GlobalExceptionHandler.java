package com.shop.wallet.shopwallet.exceptions;

import com.shop.wallet.shopwallet.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {
           String message = e.getMessage();
           ApiResponse apiResponse = new ApiResponse(message,false);
           return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceFoundException e) {
        String message = e.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return  new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException e) {
        Map<String,String> responseMap = new HashMap<>();
          e.getBindingResult().getAllErrors().forEach((error) -> {
             String fieldName = ((FieldError)error).getField();
             String message = error.getDefaultMessage();
             responseMap.put(fieldName,message);
          });
        return new ResponseEntity<>(responseMap,HttpStatus.BAD_REQUEST);
    }

}
