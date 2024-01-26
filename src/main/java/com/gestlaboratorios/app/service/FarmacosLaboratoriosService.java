package com.gestlaboratorios.app.service;

import com.gestlaboratorios.app.model.FarmacosLaboratorios;
import com.gestlaboratorios.app.model.Laboratorios;
import java.util.List;
import java.util.Optional;

public interface FarmacosLaboratoriosService {
    public List<FarmacosLaboratorios> listarTodos();

    public Optional<FarmacosLaboratorios> buscarFarmacosLaboratorios(Long id);

    public FarmacosLaboratorios guardarFarmacosLaboratorios(FarmacosLaboratorios farmacosLaboratorios);

    public void borrarFarmacosLaboratorios(FarmacosLaboratorios farmacosLaboratorios);

    public FarmacosLaboratorios guardaListaLaboratorios(Long id, Laboratorios laboratorio);
}
