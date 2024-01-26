package com.gestlaboratorios.app.service;

import com.gestlaboratorios.app.model.FarmacosLaboratorios;
import com.gestlaboratorios.app.model.Laboratorios;
import java.util.List;
import java.util.Optional;

public interface LaboratoriosService {
    public List<Laboratorios> listarTodos();

    public Optional<Laboratorios> buscarLaboratorios(Long id);

    public Laboratorios guardarLaboratorios(Laboratorios laboratorio);

    public void borrarLaboratorios(Laboratorios laboratorio);

    public Laboratorios asignarValores (Long id, Laboratorios laboratorio);
    public Laboratorios guardaListaFarmacos(Long id, FarmacosLaboratorios farmacosLaboratorio);
}
