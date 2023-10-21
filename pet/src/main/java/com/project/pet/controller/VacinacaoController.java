package com.project.pet.controller;

import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
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

@RestController
public class VacinacaoController {
    @Autowired
    private VacinacaoService vacinacaoService;

    @PostMapping("/vacinacao")
    public Vacinacao saveVacinacao(@Valid @RequestBody Vacinacao vacinacao) {
        return vacinacaoService.saveVacinacao(vacinacao);
    }

    @GetMapping("/vacinacao")
    public List<VacinacaoFindAllDTO> listVacinacao() {
        return vacinacaoService.fetchVacinacaoList();
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
