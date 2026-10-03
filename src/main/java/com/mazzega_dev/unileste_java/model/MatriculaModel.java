package com.mazzega_dev.unileste_java.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Matricula")
public class MatriculaModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer mat_id;

   @Column(nullable = false)
   private String mat_nome;

   private LocalDate mat_data;

   private LocalDate mat_dataEncerramento;

   @Column(nullable = false)
   private String mat_email;

   @Column(nullable = false)
   private String mat_cep;

   @Column(nullable = false)
   private String mat_endereco;

   @Column(nullable = false)
   private String mat_bairro;

   @Column(nullable = false)
   private String mat_cidade;

   @Column(nullable = false)
   private String mat_uf;

   @Builder.Default
   private Boolean mat_cursando = true;

   @ManyToOne
   @JoinColumn(name = "cur_id", nullable = false)
   @JsonIgnore
   private CursoModel curso;
}
