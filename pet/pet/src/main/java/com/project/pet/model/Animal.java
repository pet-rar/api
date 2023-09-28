package com.project.pet.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Animal {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer idAnimal;
	 
	 @Column(length = 255)
	 private String nome;
	 
	 @ManyToOne
	 @JoinColumn(name = "idUsuario")
	 private Usuario idUsuario;
	 
	 @Column
	 private Date dataNascimento;
	 
	 @Column(length = 255)
	 private String especie;
	 
	 @Column(length = 255)
	 private String raça;
	 
	 @Column(columnDefinition = "ENUM('Feminino', 'Masculino')")
	 @Enumerated(EnumType.STRING)
	 private AnimalTipo tipo;
	 
	 @Column(length = 100)
	 private String porte;
	 
	 @Column(length = 250)
	 private String pelagem;
	 
	 @Column(length = 100)
	 private String cor;
	 
	 @Column
	 private Double peso;

	public Integer getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Integer idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public AnimalTipo getTipo() {
		return tipo;
	}

	public void setTipo(AnimalTipo tipo) {
		this.tipo = tipo;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	 
	 
	 
}
