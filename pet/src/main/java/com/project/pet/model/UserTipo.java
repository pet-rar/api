package com.project.pet.model;

public enum UserTipo {
    CLIENTE("CLIENTE"),
    FUNCIONARIO("FUNCIONARIO");

    private String tipo;

    private UserTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }	
}
