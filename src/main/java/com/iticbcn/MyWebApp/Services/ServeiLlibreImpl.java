package com.iticbcn.MyWebApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import com.iticbcn.MyWebApp.Model.Llibre;
import java.util.Set;
import com.iticbcn.MyWebApp.Repositories.RepoLlibre;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class ServeiLlibreImpl implements ServeiLlibre {

    private final RepoLlibre repoLlibre;

    public ServeiLlibreImpl(RepoLlibre repoLlibre){
        this.repoLlibre = repoLlibre;
    }

    @Override
    public List<Llibre> findAll() {
        return repoLlibre.findAll();
    }

    @Override
    public Optional<Llibre> findByIdLlibre(Long id) {
        return repoLlibre.findById(id);
    }

    @Override
    public Optional<Llibre> findByTitol(String titol) {
        return repoLlibre.findByTitol(titol);
    }

    @Override
    public Set<Llibre> findByTitolAndEditorial(String titol, String editorial) {
        return repoLlibre.findByTitolAndEditorial(titol, editorial);
    }

    @Override
    public Llibre save(Llibre llibre) {
        if (!validarISBN(llibre.getISBN())) {
            throw new IllegalArgumentException("Format ISBN incorrecte");
        }
        return repoLlibre.save(llibre);
    }

    @Override
    public void deleteById(Long id) {
        repoLlibre.deleteById(id);
    }

    @Override
    public boolean validarISBN(String isbn) {
        String regex = "^(97(8|9))?\\d{9}(\\d|X)$";
        return Pattern.matches(regex, isbn);
    }
    
}
