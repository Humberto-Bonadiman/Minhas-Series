package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
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
}
