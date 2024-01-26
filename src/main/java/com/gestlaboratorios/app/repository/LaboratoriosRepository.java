package com.gestlaboratorios.app.repository;

import com.gestlaboratorios.app.model.Laboratorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoriosRepository extends JpaRepository<Laboratorios,Long> {
}
