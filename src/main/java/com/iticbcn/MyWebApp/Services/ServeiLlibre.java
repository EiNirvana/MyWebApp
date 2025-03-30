package com.iticbcn.MyWebApp.Services;

import java.util.Optional;

import com.iticbcn.MyWebApp.Model.Llibre;
import com.iticbcn.MyWebApp.Repositories.RepoLlibre;

public class ServeiLlibre {

    private final RepoLlibre repoLlibre;
    
    public ServeiLlibre(RepoLlibre repoLlibre){
        this.repoLlibre = repoLlibre;
    }

    public Optional<Llibre> findByIdLlibre(int id_Llibre) {
        return repoLlibre.findById(id_Llibre);
    }
}
