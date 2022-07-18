package com.trybe.acc.java.minhasseries.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String nome;

  @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.LAZY)
  private List<Episodio> episodios = new ArrayList<Episodio>();

  public Serie(String nome) {
    this.nome = nome;
  }

  public Serie() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Episodio> getEpisodios() {
    return episodios;
  }

  public void setEpisodios(List<Episodio> episodios) {
    this.episodios = episodios;
  }

  public void adicionarEpisodio(Episodio episodio) {
    episodio.setSerie(this);
    this.episodios.add(episodio);
  }

  /**
   * episodio existente.
   */
  public boolean episodioExiste(Episodio episodio) {
    Integer numero = episodio.getNumero();
    boolean exist =
        this.episodios.stream().filter(e -> e.getNumero() == numero).findFirst().isPresent();
    return exist;
  }
}
