package com.project.pet.controller;

import com.project.pet.dto.Vacinacao.VacinacaoFindAllByCpfDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoSaveDTO;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.pet.model.Vacinacao;
import com.project.pet.service.VacinacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class VacinacaoController {
    @Autowired
    private VacinacaoService vacinacaoService;

    @PostMapping("/vacinacao/save")
    public ResponseEntity saveVacinacao(@Valid @RequestBody VacinacaoSaveDTO vacinacao) {
        vacinacaoService.saveVacinacao(vacinacao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/vacinacao")
    public List<VacinacaoFindAllDTO> listVacinacao() {
        return vacinacaoService.fetchVacinacaoList();
    }
    
    @PostMapping("/vacinacao/cpf")
    public List<VacinacaoFindAllDTO> listVacinacaoByCPF(@Valid @RequestBody VacinacaoFindAllByCpfDTO cpf) {
        return vacinacaoService.fetchVacinacaoListByCPF(cpf);
    }

    @PostMapping("/vacinacaoUpdate")
    public Vacinacao updateVacinacao(Vacinacao vacinacao) {
        return vacinacaoService.updateVacinacao(vacinacao);
    }

    @DeleteMapping("/vacinacao/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long Id) {
        vacinacaoService.deleteVacinacaoById(Id);
        return "Deleted Successfully";
    }
}
