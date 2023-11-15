package com.project.pet.controller;

import com.project.pet.dto.Vacinacao.VacinacaoDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllByCpfDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoSaveDTO;
import com.project.pet.dto.Vacinacao.VacinacaoUpdateDTO;
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
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

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
    public Map<String, Object> listVacinacao(@RequestParam("page") Integer page) {
        return vacinacaoService.fetchVacinacaoListPaginated(page);
    }
    
    @GetMapping("/vacinacao/{id}")
    public VacinacaoDTO findVacinacao(@PathVariable("id") Long id) {
        return vacinacaoService.fetchVacinacao(id);
    }
    
    @PostMapping("/vacinacao/cpf")
    public Map<String, Object> listVacinacaoByCPF(@Valid @RequestBody VacinacaoFindAllByCpfDTO dto) {
        return vacinacaoService.fetchVacinacaoListByCPF(dto);
    }

    @PostMapping("/vacinacao/update")
    public Vacinacao updateVacinacao(@Valid @RequestBody VacinacaoUpdateDTO vacinacao) {
        return vacinacaoService.updateVacinacao(vacinacao);
    }

    @DeleteMapping("/vacinacao/delete/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long Id) {
        vacinacaoService.deleteVacinacaoById(Id);
        return "Deleted Successfully";
    }
}
