package com.project.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pet.model.Vacinacao;
import com.project.pet.repository.VacinacaoRepository;

@Service
public class VacinacaoServiceImpl implements VacinacaoService{


	@Autowired
	private VacinacaoRepository vacinacaoRepository;
	
	
	
	@Override
	public Vacinacao saveVacinacao(Vacinacao vacinacao) {
		// TODO Auto-generated method stub
		return vacinacaoRepository.save(vacinacao);
	}

	@Override
	public List<Vacinacao> fetchVacinacaoList() {
		// TODO Auto-generated method stub
		return vacinacaoRepository.findAll();
	}

	@Override
	public Vacinacao updateVacinacao(Vacinacao vacinacao) {
		// TODO Auto-generated method stub
		return vacinacaoRepository.save(vacinacao);
	}

	@Override
	public void deleteVacinacaoById(Long Id) {
		// TODO Auto-generated method stub
		vacinacaoRepository.deleteById(Id);
	}

}
