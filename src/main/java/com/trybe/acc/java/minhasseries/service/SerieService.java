package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
  @Autowired
  private SerieRepository repository;
}
