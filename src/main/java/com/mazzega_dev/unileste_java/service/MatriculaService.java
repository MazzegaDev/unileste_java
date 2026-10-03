package com.mazzega_dev.unileste_java.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mazzega_dev.unileste_java.dto.MatriculaDTO;
import com.mazzega_dev.unileste_java.exception.BadRequestException;
import com.mazzega_dev.unileste_java.exception.NotFoundException;
import com.mazzega_dev.unileste_java.model.CursoModel;
import com.mazzega_dev.unileste_java.model.MatriculaModel;
import com.mazzega_dev.unileste_java.repository.ICursoRepository;
import com.mazzega_dev.unileste_java.repository.IMatriculaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatriculaService {
   private final IMatriculaRepository matriculaRepository;
   private final ICursoRepository cursoRepository;

   public void cadastrar(MatriculaDTO dados) throws BadRequestException, NotFoundException {
      CursoModel cursoEncontrado = cursoRepository.findById(dados.getCur_id()).orElse(null);
      if (cursoEncontrado == null) {
         throw new NotFoundException("Curso não encontrado");
      }

      if (dados.getMat_nome().isBlank() || dados.getMat_email().isBlank()) {
         throw new BadRequestException("Informe nome e e-mail valido a matricula");
      }
      if (dados.getMat_bairro().isBlank() || dados.getMat_cep().isBlank() || dados.getMat_cidade().isBlank()
            || dados.getMat_endereco().isBlank() || dados.getMat_uf().isBlank()) {
         throw new BadRequestException("Informe dados validos ao endereço da matricula");
      }

      LocalDate data = LocalDate.now();

      MatriculaModel matriculaModel = MatriculaModel.builder()
            .mat_bairro(dados.getMat_bairro())
            .mat_cep(dados.getMat_cep())
            .mat_endereco(dados.getMat_endereco())
            .mat_cidade(dados.getMat_cidade())
            .mat_email(dados.getMat_email())
            .mat_cursando(true)
            .mat_data(data)
            .mat_nome(dados.getMat_nome())
            .mat_uf(dados.getMat_uf())
            .curso(cursoEncontrado)
            .build();

      matriculaRepository.save(matriculaModel);
   }

   public List<MatriculaModel> obter() {
      return matriculaRepository.findAll();
   }

   public MatriculaModel obterPorId(Integer id) throws NotFoundException {
      MatriculaModel matriculaModel = matriculaRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Matricula não encontrada"));
      return matriculaModel;
   }

   public void atualizar(MatriculaDTO dados, Integer id) throws BadRequestException, NotFoundException {

      MatriculaModel matriculaModel = matriculaRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Matricula não encontrada"));

      CursoModel cursoEncontrado = cursoRepository.findById(dados.getCur_id()).orElse(null);
      if (cursoEncontrado == null) {
         throw new NotFoundException("Curso não encontrado");
      }

      if (dados.getMat_nome().isBlank() || dados.getMat_email().isBlank()) {
         throw new BadRequestException("Informe nome e e-mail valido a matricula");
      }
      if (dados.getMat_bairro().isBlank() || dados.getMat_cep().isBlank() || dados.getMat_cidade().isBlank()
            || dados.getMat_endereco().isBlank() || dados.getMat_uf().isBlank()) {
         throw new BadRequestException("Informe dados validos ao endereço da matricula");
      }

      matriculaModel.setCurso(cursoEncontrado);
      matriculaModel.setMat_bairro(dados.getMat_bairro());
      matriculaModel.setMat_cep(dados.getMat_cep());
      matriculaModel.setMat_cidade(dados.getMat_cidade());
      matriculaModel.setMat_email(dados.getMat_email());
      matriculaModel.setMat_endereco(dados.getMat_endereco());
      matriculaModel.setMat_nome(dados.getMat_nome());
      matriculaModel.setMat_uf(dados.getMat_uf());

      matriculaRepository.save(matriculaModel);

   }

   public void deletar(Integer id) throws BadRequestException, NotFoundException {
      MatriculaModel matriculaModel = obterPorId(id);
      if (matriculaModel == null) {
         throw new NotFoundException("Matricuola não encontrada");
      }

      matriculaRepository.delete(matriculaModel);
   }

}
