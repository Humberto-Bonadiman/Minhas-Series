package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.SerieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {

  @Autowired
  private SerieService serieService;

  @PostMapping(value = "/series")
  public ResponseEntity<Object> create(@RequestBody Serie serie) {
    Serie serieCreate = serieService.addSerie(serie);
    return new ResponseEntity<>(serieCreate, HttpStatus.OK);
  }

  @GetMapping(value = "/series")
  public ResponseEntity<Object> findAll() {
    List<Serie> serieList = serieService.serieList();
    return new ResponseEntity<>(serieList, HttpStatus.OK);
  }

  @DeleteMapping(value = "/series/{serie_id}")
  public ResponseEntity<Object> delete(@PathVariable Integer id) {
    serieService.deleteSerieById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
