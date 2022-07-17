package com.trybe.acc.java.minhasseries.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String nome;

  @OneToMany(mappedBy = "episodio", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Episodio> episodio;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Episodio> getEpisodio() {
    return episodio;
  }

  public void setEpisodio(List<Episodio> episodio) {
    this.episodio = episodio;
  }
}
