package com.project.pet.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario implements UserDetails {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer idUsuario;

	    @Column(length = 255)
	    private String nome;

	    @Column(length = 300)
	    private String senha;

	    @Column
	    private Date dataNascimento;

	    @Column(name = "tipo")
	    @Enumerated(EnumType.STRING)
	    private UserTipo tipo;

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


	    public Usuario() {
			super();
		}
	    
		public Usuario(String nome, String senha, UserTipo tipo) {
			super();
			this.nome = nome;
			this.senha = senha;
			this.tipo = tipo;
		}
		@Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        if(this.tipo == UserTipo.FUNCIONARIO) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
	        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	    }
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

		public UserTipo getTipo() {
			return tipo;
		}

		public void setTipo(UserTipo tipo) {
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

		@Override
		public String getPassword() {

			return this.senha;
		}

		@Override
		public String getUsername() {

			return this.nome;
		}
		@Override
		public boolean isAccountNonExpired() {

			return true;
		}

		@Override
		public boolean isAccountNonLocked() {

			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {

			return true;
		}

		@Override
		public boolean isEnabled() {

			return true;
		}
	 
	    
}
