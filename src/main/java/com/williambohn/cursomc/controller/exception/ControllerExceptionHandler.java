package com.williambohn.cursomc.controller.exception;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.williambohn.cursomc.service.exceptions.DataIntegrityException;
import com.williambohn.cursomc.service.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler { // Classe auxiliar que vai interceptar as excpetions, MANIPULADOR DE ERROR

    @ExceptionHandler(ObjectNotFoundException.class)//.Metodo padrao dentro do frameWork e ela precisa ter essa assinatura
    // @ExceptionHandler(ObjectNotFoundException.class) Indica que é um tratador de exception do ObjectNotFoundException;
    public ResponseEntity<StandarteError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandarteError erro =  new StandarteError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    //Exception personalizada para nao excluir uma categoria que tenha produto
    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandarteError> DataIntegrity(DataIntegrityException e, HttpServletRequest request){
        StandarteError erro =  new StandarteError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}