package com.project.pet.model;

public enum VacinacaoStatus {
    APLICADA("APLICADA"),
    PENDENTE("PENDENTE");

    private String status;
    
    private VacinacaoStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}