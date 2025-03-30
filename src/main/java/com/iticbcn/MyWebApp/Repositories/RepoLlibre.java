package com.iticbcn.MyWebApp.Repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iticbcn.MyWebApp.Model.Llibre;

public interface RepoLlibre  extends JpaRepository<Llibre, Long>{

    Set<Llibre> findByTitolAndEditorial(String titol, String editorial);

    Optional<Llibre> findByTitol(String titol);


}
