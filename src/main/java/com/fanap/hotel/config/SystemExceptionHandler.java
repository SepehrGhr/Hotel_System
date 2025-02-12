package com.fanap.hotel.config;

import com.fanap.hotel.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SystemExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<Map<String, String>>> handleMethodArgumentInvalidException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().stream().forEach(e -> {
            String field = ((FieldError) e).getField();
            String error = e.getDefaultMessage();
            errors.put(field, error);
        });

        BaseResponse<Map<String, String>> objectBaseResponse = BaseResponse.fail(errors);
        return ResponseEntity.ok(objectBaseResponse);
    }
}
