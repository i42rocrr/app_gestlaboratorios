package com.gestlaboratorios.app.controller;

import com.gestlaboratorios.app.model.FarmacosLaboratorios;
import com.gestlaboratorios.app.model.Laboratorios;
import com.gestlaboratorios.app.service.FarmacosLaboratoriosService;
import com.gestlaboratorios.app.service.LaboratoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LaboratoriosController {

    @Autowired
    private LaboratoriosService laboratoriosService;
    @Autowired
    private FarmacosLaboratoriosService farmacosLaboratoriosService;

    private Laboratorios laboratorio;

    /////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/laboratorios/alta")
    public String mostrarFormularioDeNuevoLaboratorio(Model model){

        laboratorio= new Laboratorios();

        model.addAttribute("laboratorio",laboratorio);

        return "NuevoLaboratorioForm";
    }

    @PostMapping("/laboratorios/alta/guardar")
    public String guardarNuevoLaboratorio(@ModelAttribute Laboratorios labpratorioModel) {

        labpratorioModel.setNombre(labpratorioModel.getNombre().toUpperCase().trim());
        labpratorioModel.setEmail (labpratorioModel.getEmail().toUpperCase().trim());


        laboratoriosService.guardarLaboratorios(labpratorioModel);
        laboratorio = laboratoriosService.asignarValores(labpratorioModel.getId(),labpratorioModel);


        return "redirect:/laboratorios/farmacos";
    }
///////////////////////////////////////////////////////////////////////////////////



    @GetMapping("/laboratorios/farmacos")
    public String mostrarFormularioDeNuevosFarmacos(Model model){



        model.addAttribute("laboratorio",laboratorio);
        model.addAttribute("farmacosList", laboratorio.getFarmacosLaboratoriosList());
        model.addAttribute("nuevoFarmaco",new FarmacosLaboratorios());


        return "AdherirFarmacosLaboratoriosForm";
    }

    @PostMapping("/laboratorios/farmacos/guardar")
    public String guardarNuevoFarmaco(@ModelAttribute FarmacosLaboratorios farmacosLaboratoriosModel) {
        FarmacosLaboratorios farmacosLaboratorio;
        List<FarmacosLaboratorios> farmacosLaboratoriosList = new ArrayList<FarmacosLaboratorios>();

        farmacosLaboratoriosModel.setNombre (farmacosLaboratoriosModel.getNombre().toUpperCase().trim());

        farmacosLaboratorio  = farmacosLaboratoriosService.guardarFarmacosLaboratorios(farmacosLaboratoriosModel);
        farmacosLaboratoriosService.guardaListaLaboratorios(farmacosLaboratorio.getId(), laboratorio);
        laboratoriosService.guardaListaFarmacos(laboratorio.getId(), farmacosLaboratorio);


        if (laboratorio.getFarmacosLaboratoriosList() != null) {
            farmacosLaboratoriosList = laboratorio.getFarmacosLaboratoriosList();
        }
        farmacosLaboratoriosList.add(farmacosLaboratorio);

        laboratorio.setFarmacosLaboratoriosList(farmacosLaboratoriosList);


        return "redirect:/laboratorios/farmacos";
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/laboratorios/listartodos")
    public String listarLaboratorios(Model model){
        List<Laboratorios> laboratoriosList = laboratoriosService.listarTodos();

        model.addAttribute("laboratoriosList",laboratoriosList);


        return "ListadoCompletoLaboratorios";
    }


    @GetMapping("/laboratorios/borrar/{id}")
    public String borrarLaboratorio(@PathVariable Long id){
        Optional<Laboratorios> buscarLaboratorioBD = laboratoriosService.buscarLaboratorios(id);
        if (buscarLaboratorioBD.isPresent()) {
            Laboratorios laboratorioBD = buscarLaboratorioBD.get();

            List<FarmacosLaboratorios> farmacosLaboratorioList = laboratorioBD.getFarmacosLaboratoriosList();
            if (farmacosLaboratorioList.isEmpty()==false) {
                for (int i = 0; i < farmacosLaboratorioList.size(); i++) {
                    farmacosLaboratoriosService.borrarFarmacosLaboratorios(farmacosLaboratorioList.get(i));
                }
            }
            laboratoriosService.borrarLaboratorios(laboratorioBD);
        }

        return "redirect:/laboratorios/listartodos";
    }
}
