package br.edu.ifsp.arq.ads.petpar.resources.exception.handler;

import br.edu.ifsp.arq.ads.petpar.resources.exception.BadRequestException;
import br.edu.ifsp.arq.ads.petpar.resources.exception.NotFoundException;
import br.edu.ifsp.arq.ads.petpar.resources.exception.dto.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ResponseBody
    @ExceptionHandler(value = {NotFoundException.class})
    protected final ResponseEntity<ApiError> handleNotFoundException(Exception ex) {

        ApiError apiError = new ApiError(NOT_FOUND, ex.getLocalizedMessage(), ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ResponseBody
    @ExceptionHandler(value = {BadRequestException.class})
    protected final ResponseEntity<ApiError> handleBadRequestException(BadRequestException ex) {

        ApiError apiError = new ApiError(BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());

        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//
//        List<String> errors = new ArrayList<>();
//
//        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//            errors.add(toSnakeCase(error.getField()) + " " + error.getDefaultMessage());
//        }
//
//        ApiError apiError = new ApiError(
//            UNPROCESSABLE_ENTITY,
//            INVALID_VALUE_FIELD_MESSAGE,
//            errors
//        );
//
//        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
//    }
}
