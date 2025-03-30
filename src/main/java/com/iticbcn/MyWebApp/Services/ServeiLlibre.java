package com.iticbcn.MyWebApp.Services;

import java.util.Optional;
import java.util.List;
import java.util.Set;

import com.iticbcn.MyWebApp.Model.Llibre;

public interface ServeiLlibre {

    List<Llibre> findAll();
    
    Optional<Llibre> findById(Long id);
    
    Optional<Llibre> findByTitol(String titol);
    
    Set<Llibre> findByTitolAndEditorial(String titol, String editorial);
    
    Llibre save(Llibre llibre);
    
    void deleteById(Long id);

    boolean validarISBN(String isbn);
}