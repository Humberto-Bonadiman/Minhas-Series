package com.trybe.acc.java.minhasseries.exception;

@SuppressWarnings("serial")
public class EpisodioExistenteException extends RuntimeException {
  public EpisodioExistenteException() {
    super("Episódio Existente");
  }
}
