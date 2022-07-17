package com.trybe.acc.java.minhasseries.exception;

public class DataError {
  private String error;

  public DataError(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}