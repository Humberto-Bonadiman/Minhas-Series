package com.trybe.acc.java.minhasseries.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Episodio {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private Integer numero;
  private Integer duracaoEmMinutos;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "serie_id")
  private Serie serie;

  /**
   * Episodio.
   */
  public Episodio() {}

  /**
   * Episodio.
   */
  public Episodio(Integer id, Integer numero, Integer duracaoEmMinutos, Serie serie) {
    this.id = id;
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
    this.serie = serie;
  }

  public Episodio(Integer numero, Integer duracaoEmMinutos) {
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  public int getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public int getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  @JsonIgnore
  public Serie getSerie() {
    return serie;
  }

  public void setSerie(Serie serie) {
    this.serie = serie;
  }
}
