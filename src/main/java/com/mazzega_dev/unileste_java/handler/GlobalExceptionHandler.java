package com.mazzega_dev.unileste_java.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mazzega_dev.unileste_java.dto.ExceptionMessageDTO;
import com.mazzega_dev.unileste_java.exception.BadRequestException;
import com.mazzega_dev.unileste_java.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(NotFoundException.class)
   public ResponseEntity<ExceptionMessageDTO> NotFoundException(NotFoundException e) {
      ExceptionMessageDTO response = ExceptionMessageDTO.builder().message(e.getMessage())
            .status(HttpStatus.NOT_FOUND.value()).build();
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
   }

   @ExceptionHandler(BadRequestException.class)
   public ResponseEntity<ExceptionMessageDTO> BadRequestException(BadRequestException e) {

      ExceptionMessageDTO response = ExceptionMessageDTO.builder().message(e.getMessage())
            .status(HttpStatus.BAD_REQUEST.value()).build();

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

   }
}
