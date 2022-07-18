package com.trybe.acc.java.minhasseries.exception;

@SuppressWarnings("serial")
public class ErroInesperadoException extends RuntimeException {
  public ErroInesperadoException() {
    super("Erro inesperado");
  }
}