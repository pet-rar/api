package com.project.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.service.AnimalService;
import com.project.pet.service.ExcelService;
import com.project.pet.service.UsuarioService;
import com.project.pet.service.VacinacaoService;

@RestController
@RequestMapping("/export")
public class ExcelController {
    @Autowired
    private ExcelService excelService;
    @Autowired
    private VacinacaoService vacinacaoService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/relatorioVacinacao")
    public ResponseEntity<String> exportVacinacaoToExcel() {
        List<VacinacaoFindAllDTO> vacinacoes = vacinacaoService.fetchVacinacaoList();

        excelService.criarArquivoExcelVacinacoes( "vacinacoes.xls",vacinacoes);
		return ResponseEntity.ok("Arquivo gerado com sucesso.");
    }
    
    @GetMapping("/relatorioAnimal")
    public ResponseEntity<String> exportAnimalToExcel() {
        List<AnimalFindAllDTO> animais = animalService.fetchAnimalList();

        excelService.criarArquivoExcelAnimal( "animais.xls",animais);
		return ResponseEntity.ok("Arquivo gerado com sucesso.");
    }
    
    @GetMapping("/relatorioUsuario")
    public ResponseEntity<String> exportUsuarioToCsv() {
    	
        List<UsuarioFindAllDTO> usuarios = usuarioService.fetchUsuarioList();

        excelService.criarArquivoExcelUsuario( "usuarios.xls",usuarios);
		return ResponseEntity.ok("Arquivo gerado com sucesso.");
    }
}