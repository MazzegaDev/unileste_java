package com.mazzega_dev.unileste_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mazzega_dev.unileste_java.dto.CursoDTO;
import com.mazzega_dev.unileste_java.exception.BadRequestException;
import com.mazzega_dev.unileste_java.exception.NotFoundException;
import com.mazzega_dev.unileste_java.model.CursoModel;
import com.mazzega_dev.unileste_java.repository.ICursoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoService {
   private final ICursoRepository cursoRepository;

   public void cadastrar(CursoDTO dados) throws BadRequestException {
      if (dados.getCur_nome().isBlank()) {
         throw new BadRequestException("Informe um nome valido ao curso");
      }
      if (dados.getCur_valor().isNaN() || dados.getCur_valor() < 0) {
         throw new BadRequestException("Informe um valor valido ao curso");
      }

      CursoModel cursoModel = CursoModel.builder()
            .cur_nome(dados.getCur_nome())
            .cur_valor(dados.getCur_valor())
            .build();

      cursoRepository.save(cursoModel);

   }

   public List<CursoModel> obter() {
      return cursoRepository.findAll();
   }

   public CursoModel obterPorId(Integer id) throws NotFoundException {
      CursoModel curso = cursoRepository.findById(id).orElseThrow(() -> new NotFoundException("Curso não encontrado"));

      return curso;
   }

   public void atualizar(CursoDTO dados, Integer id) throws BadRequestException, NotFoundException {
      CursoModel cursoEncontrado = obterPorId(id);

      if (dados.getCur_nome().isBlank()) {
         throw new BadRequestException("Informe um nome valido ao curso");
      }
      if (dados.getCur_valor().isNaN() || dados.getCur_valor() < 0) {
         throw new BadRequestException("Informe um valor valido ao curso");
      }

      cursoEncontrado.setCur_nome(dados.getCur_nome());
      cursoEncontrado.setCur_valor(dados.getCur_valor());

      cursoRepository.save(cursoEncontrado);

   }

   public void deletar(Integer id) throws NotFoundException, BadRequestException {
      CursoModel cursoEncontrado = obterPorId(id);

      if (!cursoEncontrado.getMatriculas().isEmpty()) {
         throw new BadRequestException("Não foi possivel deletar o curso, tem matriculas vinculadas a ele");
      }

      cursoRepository.delete(cursoEncontrado);

   }

}
