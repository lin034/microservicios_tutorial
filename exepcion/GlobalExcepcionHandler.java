package com.pildoraslin.aurrera.exepcion;

import com.pildoraslin.aurrera.dto.ErrorDetalles;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExcepcionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecursoNotFounException.class)
    public ResponseEntity<ErrorDetalles> manejarRecursoNotFounException(RecursoNotFounException exception , WebRequest webRequest){
        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SugerenciaEditaException.class)
    public ResponseEntity<ErrorDetalles> sugerenciaEditaException(SugerenciaEditaException exception , WebRequest webRequest){
        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetalles> manejarGlobalException(Exception exception , WebRequest webRequest){
        ErrorDetalles errorDetalles = new ErrorDetalles(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        /*Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());*/


        Map<String, String> errores = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach( (error) ->{

            String nombreCampo = ((FieldError)error).getField();
            String mensaje = error.getDefaultMessage();


            //errores.put("fecha", new Date().toString());
            errores.put("fecha", String.valueOf(new Date()));

            errores.put(nombreCampo, mensaje);

        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);


    }
}
