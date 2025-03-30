package com.iticbcn.MyWebApp.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "llibres")
public class Llibre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Llibre;
    @Column
    private String titol;
    @Column
    private String autor;
    @Column
    private String editorial;
    @Column(name = "datapublicacio", columnDefinition = "DATE")
    private LocalDate datapublicacio;
    @Column
    private String tematica;
    @Column(nullable = false, unique = true)
    private String ISBN;
 
}
