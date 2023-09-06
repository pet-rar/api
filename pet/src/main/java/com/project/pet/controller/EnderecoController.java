package com.project.pet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.pet.model.Endereco;
import com.project.pet.service.EnderecoService;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoService EnderecoService;

	@PostMapping("/endereco")
	public Endereco saveEndereco(@Valid @RequestBody Endereco Endereco) {

		return EnderecoService.saveEndereco(Endereco);
	}

	@GetMapping("/endereco")
	public List<Endereco> listEndereco() {
		return EnderecoService.fetchEnderecoList();
	}

	@PostMapping("/enderecoUpdate")
	public Endereco updateEndereco(Endereco Endereco) {
		return EnderecoService.updateEndereco(Endereco);
	}

	@DeleteMapping("/endereco/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long Id) {
		EnderecoService.deleteEnderecoById(Id);
		return "Deleted Successfully";
	}
}
