package com.project.pet.model;

public enum AnimalTipo {	
    FEMININO("FEMININO"),
    MASCULINO("MASCULINO");

    private String tipo;

    private AnimalTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}