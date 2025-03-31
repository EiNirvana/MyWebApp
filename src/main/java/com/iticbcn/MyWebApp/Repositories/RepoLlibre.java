package com.iticbcn.MyWebApp.Repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iticbcn.MyWebApp.Model.Llibre;

import io.micrometer.common.lang.NonNull;

@Repository
public interface RepoLlibre  extends JpaRepository<Llibre, Long>{

    @Override
    @NonNull
    ArrayList<Llibre> findAll();

    Llibre findByTitolAndEditorial(String titol, String editorial);

    Optional<Llibre> findByTitol(String titol);


}
