package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
  @Autowired
  private SerieRepository repository;

  /**
   * add serie.
   */
  public Serie addSerie(Serie serie) {
    String serieName = serie.getNome();

    if (repository.existsByNome(serieName)) {
      throw new SerieExistenteException();
    }

    return repository.save(serie);
  }

  public List<Serie> serieList() {
    return repository.findAll();
  }

  /**
   * delete serie.
   */
  public void deleteSerieById(Integer id) {
    Serie serie =
        repository.findById(id).orElseThrow(() -> new SerieNaoEncontradaException());
    repository.deleteById(serie.getId());
  }

  /**
   * add episodio.
   */
  public Serie addEpisodio(Integer id, Episodio episodio) {
    Serie serie =
        repository.findById(id).orElseThrow(() -> new SerieNaoEncontradaException());
    if (serie.episodioExiste(episodio)) {
      throw new EpisodioExistenteException();
    }
    serie.adicionarEpisodio(episodio);
    return repository.save(serie);
  }

  /**
   * lista episodios.
   */
  public List<Episodio> episodioList(Integer id) {
    Serie serie =
        repository.findById(id).orElseThrow(() -> new SerieNaoEncontradaException());
    return serie.getEpisodios();
  }

  /**
   * sum times.
   */
  public Integer sumTimes() {
    if (this.serieList().isEmpty()) {
      return 0;
    }
    Integer timeSpent = 0;
    return timeSpent;
  }
}
