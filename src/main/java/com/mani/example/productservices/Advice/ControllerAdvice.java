package com.mani.example.productservices.Advice;

import com.mani.example.productservices.DTO.ErrorDto;
import com.mani.example.productservices.Exception.InvalidProductIDException;
import com.mani.example.productservices.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(InvalidProductIDException.class)
    public ResponseEntity<ErrorDto> handleInvalidProductIDException(InvalidProductIDException e)
    {
        ErrorDto dto = new ErrorDto();
        dto.setCode("Some status code");
        dto.setMessage(e.getMessage());

        return new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception)
    {
        ErrorDto dto = new ErrorDto();
        dto.setCode("Some status code");
        dto.setMessage("Product not found");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
