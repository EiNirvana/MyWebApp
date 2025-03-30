package com.iticbcn.MyWebApp.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iticbcn.MyWebApp.Model.Llibre;

import io.micrometer.common.lang.NonNull;

public interface RepoLlibre  extends JpaRepository<Llibre, Object>{
    
    @Override
    @NonNull
    List<Llibre> findAll();
    List<Llibre> findByEditorial();

    Optional<Llibre> findByTitol();


}
