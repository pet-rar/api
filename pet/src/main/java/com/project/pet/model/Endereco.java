package com.project.pet.model;

import com.project.pet.dto.Endereco.EnderecoSaveDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEndereco;
	@Column(length = 255)
	private String logradouro;
	@Column(length = 255)
	private String cidade;
	@Column(length = 100)
	private String bairro;
	@Column(length = 2)
	private String estado;
	@Column(length = 9)
	private String cep;
	
	public Endereco(String logradouro, String cidade, String bairro, String estado, String cep) {
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.cep = cep;
	}
	 
	public Integer getIdEndereco() {
		return idEndereco;
	}
	
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	 
    public static Endereco convertToEntity(EnderecoSaveDTO enderecoSaveDTO) {
        return new Endereco(enderecoSaveDTO.logradouro(), enderecoSaveDTO.cidade(), enderecoSaveDTO.bairro(), enderecoSaveDTO.estado(), enderecoSaveDTO.cep());
    }	
}
