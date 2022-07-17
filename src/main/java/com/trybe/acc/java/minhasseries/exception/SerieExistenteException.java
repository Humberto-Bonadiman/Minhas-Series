package com.trybe.acc.java.minhasseries.exception;

@SuppressWarnings("serial")
public class SerieExistenteException extends RuntimeException {
  public SerieExistenteException() {
    super("{\"error\": \"Série Existente\"}");
  }
}
