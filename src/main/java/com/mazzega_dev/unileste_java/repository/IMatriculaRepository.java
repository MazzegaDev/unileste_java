package com.mazzega_dev.unileste_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazzega_dev.unileste_java.model.MatriculaModel;

public interface IMatriculaRepository extends JpaRepository<MatriculaModel, Integer> {

}
