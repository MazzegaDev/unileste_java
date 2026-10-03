package com.mazzega_dev.unileste_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazzega_dev.unileste_java.model.CursoModel;

public interface ICursoRepository extends JpaRepository<CursoModel, Integer> {

}
