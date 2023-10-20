package com.project.pet.model;

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
import java.time.LocalDate;

@Entity
@Table
public class Animal {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer idAnimal;
	 
	 @Column(length = 255)
	 private String nome;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_usuario")
	 private Usuario usuario;
	 
	 @Column
	 private LocalDate dataNascimento;
	 
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
         
        public Animal() {
            super();
        }
        
        public Animal(Integer id, String nome, LocalDate dataNascimento, String especie, String raça, AnimalTipo tipo, String porte, String pelagem, String cor, Double peso) {
            super();
            this.idAnimal = id;
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.especie = especie;
            this.raça = raça;
            this.tipo = tipo;
            this.porte = porte;
            this.pelagem = pelagem;
            this.cor = cor;
            this.peso = peso;
        }

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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
