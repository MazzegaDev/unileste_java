package com.mazzega_dev.unileste_java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mazzega_dev.unileste_java.dto.MatriculaDTO;
import com.mazzega_dev.unileste_java.exception.BadRequestException;
import com.mazzega_dev.unileste_java.exception.NotFoundException;
import com.mazzega_dev.unileste_java.model.MatriculaModel;
import com.mazzega_dev.unileste_java.service.MatriculaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1/matricula")
@RequiredArgsConstructor
public class MatriculaController {
   private final MatriculaService matriculaService;

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public void cadastrar(@RequestBody MatriculaDTO dados) throws BadRequestException, NotFoundException {
      matriculaService.cadastrar(dados);
   }

   @GetMapping
   @ResponseStatus(HttpStatus.OK)
   public List<MatriculaModel> obter() throws BadRequestException, NotFoundException {
      return matriculaService.obter();
   }

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.CREATED)
   public void atualizar(@RequestBody MatriculaDTO dados, @PathVariable Integer id)
         throws BadRequestException, NotFoundException {
      matriculaService.atualizar(dados, id);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public void deletar(@PathVariable Integer id) throws BadRequestException, NotFoundException {
      matriculaService.deletar(id);
   }
}
