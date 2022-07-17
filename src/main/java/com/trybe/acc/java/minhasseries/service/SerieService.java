package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.exception.ServicoIndisponivelException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
  @Autowired
  private SerieRepository repository;

  /**
   * add serie.
   */
  public Serie create(Serie serie) {
    String serieName = serie.getNome();

    if (repository.existsByNome(serieName)) {
      throw new SerieExistenteException();
    }

    Serie addSerie = repository.save(serie);
    return addSerie;
  }

  public List<Serie> serieList() {
    return repository.findAll();
  }

  /**
   * delete serie.
   */
  public Serie delete(Integer id) {
    Optional<Serie> serie = repository.findById(id);
    if (serie.isEmpty()) {
      throw new SerieNaoEncontradaException();
    }
    Serie serieToBeDeleted = serie.get();
    repository.delete(serieToBeDeleted);
    return serieToBeDeleted;
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
    List<Serie> series = repository.findAll();
    if (series.isEmpty()) {
      return 0;
    }
    int timeSpent = series.stream().reduce(0,
        (subtotal,
            serie) -> subtotal + serie.getEpisodios().stream().reduce(0,
                (total, episodio) -> total + episodio.getDuracaoEmMinutos(), Integer::sum),
        Integer::sum);
    return timeSpent;
  }

  /**
   * find by id.
   */
  @CircuitBreaker(name = "serie", fallbackMethod = "fallback")
  public Serie findById(Integer id) {
    Optional<Serie> serie = repository.findById(id);
    if (serie.isEmpty()) {
      throw new SerieNaoEncontradaException();
    }
    Serie serieFound = serie.get();
    return serieFound;
  }

  public Serie fallback(Integer id, ServicoIndisponivelException e)
      throws ServicoIndisponivelException {
    throw new ServicoIndisponivelException();
  }
}
