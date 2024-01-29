package com.gestlaboratorios.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmacosLaboratorios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nombre;

    //@ManyToMany (fetch = FetchType.LAZY)
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "FarmacosLaboratorios_Lista",
            joinColumns = @JoinColumn(name = "farmaco_id"),
            inverseJoinColumns = @JoinColumn(name="laboratorio_id")
    )
    private List<Laboratorios> laboratoriosList;

}
