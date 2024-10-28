package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Produto {
	   
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Long id;
	   
	   @NotNull(message="Nome é obrigatorio")
	   @Size(min = 1, max = 100, message = "O nome deve ter entre 1 e 100 caracteres")
	   private String nome;

	   
	   @NotNull
	   private int idFornecedor;

	   @NotNull(message="Bula é obrigatorio")
	   @Size(min=10, message="bula deve ter no minimo 10 caracteres")
	   private String bula;
	   
	   @NotNull(message="data é obrigatorio")
	   @Size(min=10, message="A data deve ter no minimo 10 caracteres")
	   private String dataValidade;
	   
	   
	   //Metodos getts e setts
	   public String getNome() {
	       return nome;
	   }
	   
	   public void setNome(String nome) {
	       this.nome = nome;
	   }
	   
	   public Long getId() {
	       return id;
	   }
	   
	   public void setId(Long id) {
	       this.id = id;
	   }
	   
	   public int getIdFornecedor() {
		   return idFornecedor;
	   }
	   
	   public void setIdFornecedor(int idFornecedor) {
	       this.idFornecedor = idFornecedor;
	   }
	   
	   public String getBula() {
	       return bula;
	   }
	   
	   public void setBula(String bula) {
	       this.bula = bula;
	   }
	   
	   public String getDataValidade() {
	       return dataValidade;
	   }
	   
	   public void setDataValidade(String dataValidade) {
	       this.dataValidade = dataValidade;
	   }
	}

