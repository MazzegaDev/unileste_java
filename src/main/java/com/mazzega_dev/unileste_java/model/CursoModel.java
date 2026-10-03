package com.mazzega_dev.unileste_java.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Curso")
public class CursoModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer cur_id;

   @Column(nullable = false)
   private String cur_nome;

   @NotNull
   private Double cur_valor;

   @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
   @Builder.Default
   private List<MatriculaModel> matriculas = new ArrayList<>();
}
