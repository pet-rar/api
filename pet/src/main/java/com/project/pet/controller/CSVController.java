package com.project.pet.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.service.AnimalService;
import com.project.pet.service.CsvService;
import com.project.pet.service.UsuarioService;
import com.project.pet.service.VacinacaoService;

@RestController
@RequestMapping("/export")
public class CSVController {
    @Autowired
    private CsvService csvService;
    @Autowired
    private VacinacaoService vacinacaoService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/relatorioVacinacao")
    public ResponseEntity<String> exportVacinacaoToCsv() {
        List<VacinacaoFindAllDTO> vacinacoes = vacinacaoService.fetchVacinacaoList();

        try {
            csvService.exportToCsvVacinacao(vacinacoes, "vacinacoes.csv");
            return ResponseEntity.ok("Arquivo CSV gerado com sucesso.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao gerar o arquivo CSV.");
        }
    }
    
    @GetMapping("/relatorioAnimal")
    public ResponseEntity<String> exportAnimalToCsv() {
        List<AnimalFindAllDTO> animais = animalService.fetchAnimalList();

        try {
            csvService.exportToCsvAnimal(animais, "animais.csv");
            return ResponseEntity.ok("Arquivo CSV gerado com sucesso.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao gerar o arquivo CSV.");
        }
    }
    
    @GetMapping("/relatorioUsuario")
    public ResponseEntity<String> exportUsuarioToCsv() {
    	
        List<UsuarioFindAllDTO> usuarios = usuarioService.fetchUsuarioList();

        try {
            csvService.exportToCsvUsuarios(usuarios, "usuarios.csv");
            return ResponseEntity.ok("Arquivo CSV gerado com sucesso.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao gerar o arquivo CSV.");
        }
    }
}