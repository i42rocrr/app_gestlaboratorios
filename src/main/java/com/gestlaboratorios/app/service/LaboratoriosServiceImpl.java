package com.gestlaboratorios.app.service;

import com.gestlaboratorios.app.model.FarmacosLaboratorios;
import com.gestlaboratorios.app.model.Laboratorios;
import com.gestlaboratorios.app.repository.LaboratoriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LaboratoriosServiceImpl implements LaboratoriosService {
    @Autowired
    private LaboratoriosRepository laboratoriosRepository;

    @Override
    public List<Laboratorios> listarTodos() {
        return laboratoriosRepository.findAll();
    }

    @Override
    public Optional<Laboratorios> buscarLaboratorios(Long id) {
        return laboratoriosRepository.findById(id);
    }

    @Override
    public Laboratorios guardarLaboratorios(Laboratorios laboratorio) {return laboratoriosRepository.save(laboratorio);}

    @Override
    public void borrarLaboratorios(Laboratorios laboratorio) {
        laboratoriosRepository.delete(laboratorio);
    }



    public Laboratorios asignarValores (Long id, Laboratorios laboratorio) {
        Laboratorios laboratorioBD = laboratoriosRepository.findById(id).orElse(null);

        if (laboratorioBD !=null) {
            laboratorioBD.setNombre(laboratorio.getNombre());
            laboratorioBD.setEmail(laboratorio.getEmail());


            laboratorioBD.setFarmacosLaboratoriosList(laboratorio.getFarmacosLaboratoriosList());
        }

        return laboratorioBD;
    }

    public Laboratorios guardaListaFarmacos(Long id, FarmacosLaboratorios farmacosLaboratorio) {
        Laboratorios laboratorioBD = laboratoriosRepository.findById(id).orElse(null);
        List<FarmacosLaboratorios> farmacosLaboratoriosList = new ArrayList<FarmacosLaboratorios>();

        if (laboratorioBD !=null) {
            farmacosLaboratoriosList = laboratorioBD.getFarmacosLaboratoriosList();
            farmacosLaboratoriosList.add(farmacosLaboratorio);

            laboratorioBD.setFarmacosLaboratoriosList(farmacosLaboratoriosList);
        }
        return laboratoriosRepository.save(laboratorioBD);
    }
}
