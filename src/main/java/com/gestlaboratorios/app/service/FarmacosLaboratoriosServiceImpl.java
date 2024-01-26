package com.gestlaboratorios.app.service;

import com.gestlaboratorios.app.model.FarmacosLaboratorios;
import com.gestlaboratorios.app.model.Laboratorios;
import com.gestlaboratorios.app.repository.FarmacosLaboratoriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FarmacosLaboratoriosServiceImpl implements FarmacosLaboratoriosService {
    @Autowired
    private FarmacosLaboratoriosRepository farmacosLaboratoriosRepository;

    public List<FarmacosLaboratorios> listarTodos(){return farmacosLaboratoriosRepository.findAll();}

    public Optional<FarmacosLaboratorios> buscarFarmacosLaboratorios(Long id){return farmacosLaboratoriosRepository.findById(id);}

    public FarmacosLaboratorios guardarFarmacosLaboratorios(FarmacosLaboratorios farmacosLaboratorios){return farmacosLaboratoriosRepository.save(farmacosLaboratorios);}

    public void borrarFarmacosLaboratorios(FarmacosLaboratorios farmacosLaboratorios){farmacosLaboratoriosRepository.delete(farmacosLaboratorios);}

    public FarmacosLaboratorios guardaListaLaboratorios(Long id, Laboratorios laboratorio) {
        FarmacosLaboratorios farmacoLaboratorioBD = farmacosLaboratoriosRepository.findById(id).orElse(null);
        List<Laboratorios> LaboratoriosList = new ArrayList<Laboratorios>();
        //List<Laboratorios> LaboratoriosList;

        if (farmacoLaboratorioBD !=null) {
            //LaboratoriosList = farmacoLaboratorioBD.getLaboratoriosList();
            LaboratoriosList.add(laboratorio);
            farmacoLaboratorioBD.setLaboratoriosList(LaboratoriosList);
        }

        farmacoLaboratorioBD = farmacosLaboratoriosRepository.save(farmacoLaboratorioBD);
        return  farmacoLaboratorioBD;
    }
}
