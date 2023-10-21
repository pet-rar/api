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
@Table(name = "vacinacao")
public class Vacinacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 255)
    private String descricao;

    @Column
    private LocalDate data_vacinacao;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

    @Column(columnDefinition = "ENUM('aplicado', 'pendente')")
    @Enumerated(EnumType.STRING)
    private VacinacaoStatus status;

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

    public LocalDate getDataVacinacao() {
        return data_vacinacao;
    }

    public void setDataVacinacao(LocalDate data_vacinacao) {
            this.data_vacinacao = data_vacinacao;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public VacinacaoStatus getStatus() {
        return status;
    }

    public void setStatus(VacinacaoStatus status) {
        this.status = status;
    }
}
