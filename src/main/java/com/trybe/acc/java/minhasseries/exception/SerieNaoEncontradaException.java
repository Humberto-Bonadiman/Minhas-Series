package com.trybe.acc.java.minhasseries.exception;

@SuppressWarnings("serial")
public class SerieNaoEncontradaException extends RuntimeException {
  public SerieNaoEncontradaException() {
    super("{\"error\": \"Série não encontrada\"}");
  }
}
