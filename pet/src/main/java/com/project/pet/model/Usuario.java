package com.project.pet.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer idUsuario;

	    @Column(length = 255)
	    private String nome;

	    @Column(length = 30)
	    private String senha;

	    @Column
	    private Date dataNascimento;

	    @Column(columnDefinition = "ENUM('Funcionario', 'Cliente')")
	    private String tipo;

	    @Column(length = 14)
	    private String telefone;

	    @Column(length = 11)
	    private String cpf;

	    // Usando @OneToOne para representar o relacionamento com Endereco
	    @OneToOne(cascade = CascadeType.ALL) 
	    @JoinColumn(name = "idEndereco")
	    private Endereco endereco;

	    @Column(length = 255)
	    private String email;

		public Integer getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	 
	    
}
