package com.project.pet.model;

import com.project.pet.dto.Animal.AnimalDTO;
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
import java.util.Optional;

@Entity
@Table
public class Animal {	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 255)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    private LocalDate data_nascimento;

    @Column(length = 255)
    private String especie;

    @Column(length = 255)
    private String raca;

    @Column(columnDefinition = "ENUM('Feminino', 'Masculino')")
    @Enumerated(EnumType.STRING)
    private AnimalTipo tipo;

    @Column(length = 100)
    private String porte;

    @Column(length = 100)
    private String cor;

    @Column
    private Double peso;

   public Animal() {
    super();
   }
   
   public Animal(Optional<Animal> animal) {
    super();
    this.id = animal.get().getId();
    this.nome = animal.get().getNome();
    this.data_nascimento = animal.get().getDataNascimento();
    this.especie = animal.get().getEspecie();
    this.raca = animal.get().getRaca();
    this.tipo = animal.get().getTipo();
    this.porte = animal.get().getPorte();
    this.cor = animal.get().getCor();
    this.peso = animal.get().getPeso();
   }

   public Animal(Integer id, String nome, LocalDate dataNascimento, String especie, String raca, AnimalTipo tipo, String porte, String cor, Double peso, Usuario usuario) {
    super();
    this.id = id;
    this.nome = nome;
    this.data_nascimento = dataNascimento;
    this.especie = especie;
    this.raca = raca;
    this.tipo = tipo;
    this.porte = porte;
    this.cor = cor;
    this.peso = peso;
    this.usuario = usuario;
   }
   
    public Animal(String nome, LocalDate dataNascimento, String especie, String raca, AnimalTipo tipo, String porte, String cor, Double peso, Usuario usuario) {
    super();
    this.nome = nome;
    this.data_nascimento = dataNascimento;
    this.especie = especie;
    this.raca = raca;
    this.tipo = tipo;
    this.porte = porte;
    this.cor = cor;
    this.peso = peso;
    this.usuario = usuario;
   }
   
   public Animal(AnimalDTO animal) {
    super();
    this.id = animal.id();
    this.nome = animal.nome();
    this.data_nascimento = animal.data_nascimento();
    this.especie = animal.especie();
    this.raca = animal.raca();
    this.tipo = animal.tipo();
    this.porte = animal.porte();
    this.cor = animal.cor();
    this.peso = animal.peso();
   }

   public Integer getId() {
    return id;
   }

   public void setId(Integer id) {
    this.id = id;
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
    return data_nascimento;
   }

   public void setDataNascimento(LocalDate data_nascimento) {
    this.data_nascimento = data_nascimento;
   }

   public String getEspecie() {
    return especie;
   }

   public void setEspecie(String especie) {
    this.especie = especie;
   }

   public String getRaca() {
    return raca;
   }

   public void setRaca(String raca) {
    this.raca = raca;
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
