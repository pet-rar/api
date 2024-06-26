package com.project.pet.model;

import com.project.pet.dto.Usuario.UsuarioDTO;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.pet.dto.Usuario.UsuarioSaveDTO;
import com.project.pet.dto.Usuario.UsuarioSaveWithIdDTO;

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
    @Column(name = "id")
    private Integer id;

    @Column(length = 255)
    private String nome;

    @Column(length = 300)
    private String senha;

    @Column(name = "data_nascimento")
    private LocalDate data_nascimento;

    @Column()
    @Enumerated(EnumType.STRING)
    private UserTipo tipo;

    @Column(length = 15)
    private String telefone;

    @Column(length = 14)
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) 
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(length = 255)
    private String email;

    public Usuario() {
        super();
    }

    public Usuario(String email, String senha, UserTipo tipo) {
        super();
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(UsuarioSaveDTO usuarioSaveDTO) {
        super();
        this.nome = usuarioSaveDTO.nome();
        this.senha = usuarioSaveDTO.senha();
        this.data_nascimento = usuarioSaveDTO.data_nascimento();
        this.tipo = usuarioSaveDTO.tipo();
        this.telefone = usuarioSaveDTO.telefone();
        this.cpf = usuarioSaveDTO.cpf();
        this.email = usuarioSaveDTO.email();
    }

    public Usuario(UsuarioSaveWithIdDTO usuario) {
        super();
        this.id = usuario.id();
        this.nome = usuario.nome();
        this.senha = usuario.senha();
        this.data_nascimento = usuario.data_nascimento();
        this.tipo = usuario.tipo();
        this.telefone = usuario.telefone();
        this.cpf = usuario.cpf();
        this.email = usuario.email();
    }
    
    public Usuario(UsuarioDTO usuario) {
        super();
        this.id = usuario.id();
        this.nome = usuario.nome();        
        this.data_nascimento = usuario.data_nascimento();
        this.tipo = usuario.tipo();
        this.telefone = usuario.telefone();
        this.cpf = usuario.cpf();
        this.email = usuario.email();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.tipo == UserTipo.FUNCIONARIO) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
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
