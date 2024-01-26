package com.gestlaboratorios.app.repository;

import com.gestlaboratorios.app.model.FarmacosLaboratorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FarmacosLaboratoriosRepository extends JpaRepository<FarmacosLaboratorios,Long> {

}
