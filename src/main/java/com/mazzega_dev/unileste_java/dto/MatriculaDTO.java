package com.mazzega_dev.unileste_java.dto;


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
public class MatriculaDTO {

   private String mat_nome;

   private String mat_email;

   private String mat_cep;

   private String mat_endereco;

   private String mat_bairro;

   private String mat_cidade;

   private String mat_uf;

   private Integer cur_id;
}
