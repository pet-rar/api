package com.project.pet.model;

import com.project.pet.dto.Vacinacao.VacinacaoSaveDTO;
import com.project.pet.dto.Vacinacao.VacinacaoUpdateDTO;
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
import java.time.LocalDateTime;

@Entity
@Table(name = "vacinacao")
public class Vacinacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 255)
    private String descricao;

    @Column
    private LocalDateTime data_vacinacao;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

    @Column(columnDefinition = "ENUM('aplicada', 'pendente')")
    @Enumerated(EnumType.STRING)
    private VacinacaoStatus status;
    
    public Vacinacao() {
        super();
    }
    
    public Vacinacao(VacinacaoSaveDTO vacinacao) {
        this.descricao = vacinacao.descricao();
        this.data_vacinacao = vacinacao.data_vacinacao();
        this.status = VacinacaoStatus.PENDENTE;
    }
    
    public Vacinacao(VacinacaoUpdateDTO vacinacao, Animal animal) {
        this.id = vacinacao.id();
        this.descricao = vacinacao.descricao();
        this.data_vacinacao = vacinacao.data_vacinacao();
        this.status = vacinacao.status();
        this.animal = animal;
    }

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

    public LocalDateTime getDataVacinacao() {
        return data_vacinacao;
    }

    public void setDataVacinacao(LocalDateTime data_vacinacao) {
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
