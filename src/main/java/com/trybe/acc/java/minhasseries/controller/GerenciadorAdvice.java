package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.ErroInesperadoException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorAdvice {

  @ExceptionHandler({SerieExistenteException.class, EpisodioExistenteException.class})
  public ResponseEntity<String> handlerConflictError(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
  }

  @ExceptionHandler({SerieNaoEncontradaException.class})
  public ResponseEntity<String> handlerNotFoundError(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  @ExceptionHandler({ErroInesperadoException.class})
  public ResponseEntity<String> handlerInternalServerError(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
  }
}
