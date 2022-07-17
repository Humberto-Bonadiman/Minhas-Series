package com.trybe.acc.java.minhasseries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Episodio {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private int numero;
  private int duracaoEmMinutos;

  @ManyToOne
  @JoinColumn(name = "serie_id")
  private Serie serie;

  /**
   * Episodio.
   */
  public Episodio() {}

  /**
   * Episodio.
   */
  public Episodio(int id, int numero, int duracaoEmMinutos, Serie serie) {
    this.id = id;
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
    this.serie = serie;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public void setDuracaoEmMinutos(int duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  public Serie getSerie() {
    return serie;
  }

  public void setSerie(Serie serie) {
    this.serie = serie;
  }
}
