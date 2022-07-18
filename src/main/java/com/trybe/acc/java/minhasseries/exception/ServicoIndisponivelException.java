package com.trybe.acc.java.minhasseries.exception;

@SuppressWarnings("serial")
public class ServicoIndisponivelException extends RuntimeException {
  public ServicoIndisponivelException() {
    super("Serviço temporariamente indisponível");
  }
}
