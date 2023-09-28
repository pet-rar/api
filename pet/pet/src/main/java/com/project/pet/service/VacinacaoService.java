package com.project.pet.service;

import java.util.List;

import com.project.pet.model.Vacinacao;

public interface VacinacaoService {
	// Save operation
	Vacinacao saveVacinacao(Vacinacao vacinacao);

	// Read operation
	List<Vacinacao> fetchVacinacaoList();

	// Update operation
	Vacinacao updateVacinacao(Vacinacao vacinacao);

	// Delete operation
	void deleteVacinacaoById(Long Id);
}
