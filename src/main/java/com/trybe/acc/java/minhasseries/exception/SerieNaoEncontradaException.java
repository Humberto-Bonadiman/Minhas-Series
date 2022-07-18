package com.trybe.acc.java.minhasseries.exception;

@SuppressWarnings("serial")
public class SerieNaoEncontradaException extends RuntimeException {
  public SerieNaoEncontradaException() {
    super("Série não encontrada");
  }
}
