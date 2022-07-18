package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.DataError;
import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.ErroInesperadoException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.exception.ServicoIndisponivelException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorAdvice {

  @ExceptionHandler({SerieExistenteException.class, EpisodioExistenteException.class})
  public ResponseEntity<Object> handlerConflictError(RuntimeException exception) {
    return new ResponseEntity<>(new DataError(exception.getMessage()), HttpStatus.CONFLICT);
  }

  @ExceptionHandler({SerieNaoEncontradaException.class})
  public ResponseEntity<Object> handlerNotFoundError(RuntimeException exception) {
    return new ResponseEntity<>(new DataError(exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({ErroInesperadoException.class})
  public ResponseEntity<Object> handlerInternalServerError(RuntimeException exception) {
    return new ResponseEntity<>(new DataError(exception.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler({ServicoIndisponivelException.class})
  public ResponseEntity<Object> handlerUnavailable(RuntimeException exception) {
    return new ResponseEntity<>(new DataError(exception.getMessage()),
        HttpStatus.SERVICE_UNAVAILABLE);
  }
}
