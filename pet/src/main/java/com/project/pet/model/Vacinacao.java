package com.project.pet.model;

import java.sql.Date;

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
@Table(name = "vacinacao")
public class Vacinacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 255)
	private String descricao;

	@Column
	private Date dataVacinacao;

	// Usando @ManyToOne para representar o relacionamento com Animal
	@ManyToOne
	@JoinColumn(name = "idAnimal") // Isso cria uma coluna idAnimal na tabela Vacinacao para mapear o
									// relacionamento
	private Animal animal;

	@Column(columnDefinition = "ENUM('aplicado', 'pendente')")
	@Enumerated(EnumType.STRING)
	private VaccinationStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public VaccinationStatus getStatus() {
		return status;
	}

	public void setStatus(VaccinationStatus status) {
		this.status = status;
	}

}
