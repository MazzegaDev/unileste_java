package com.mazzega_dev.unileste_java.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mazzega_dev.unileste_java.dto.CursoDTO;
import com.mazzega_dev.unileste_java.exception.BadRequestException;
import com.mazzega_dev.unileste_java.exception.NotFoundException;
import com.mazzega_dev.unileste_java.model.CursoModel;
import com.mazzega_dev.unileste_java.service.CursoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/v1/curso")
@RequiredArgsConstructor
public class CursoController {
   private final CursoService cursoService;

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public void cadastrar(@RequestBody CursoDTO data) throws BadRequestException {
      cursoService.cadastrar(data);
   }

   @GetMapping
   @ResponseStatus(HttpStatus.OK)
   public List<CursoModel> obter() {
      return cursoService.obter();
   }

   @GetMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public CursoModel obterPorId(@PathVariable Integer id) throws NotFoundException {
      return cursoService.obterPorId(id);
   }

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.OK)
   public void atualizar(@PathVariable Integer id, @RequestBody CursoDTO dados) throws NotFoundException,
         BadRequestException {
      cursoService.atualizar(dados, id);
   }

   @DeleteMapping("/{id}")
   public void deletar(@PathVariable Integer id) throws NotFoundException, BadRequestException {
      cursoService.deletar(id);
   }

}
