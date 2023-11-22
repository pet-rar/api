package com.project.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.service.AnimalService;
import com.project.pet.service.ExcelService;
import com.project.pet.service.UsuarioService;
import com.project.pet.service.VacinacaoService;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;

@RestController
public class ExcelController {
    @Autowired
    private ExcelService excelService;
    @Autowired
    private VacinacaoService vacinacaoService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/export/vacinacoes")
    public ResponseEntity<Map<String, String>> exportVacinacaoToExcel() {
        List<VacinacaoFindAllDTO> vacinacoes = vacinacaoService.fetchVacinacaoList();
        ByteArrayOutputStream stream = excelService.criarArquivoExcelVacinacoes("vacinacoes.xls", vacinacoes);

        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String filename = "vacinacoes_" + currentDate + ".xlsx";

        byte[] excelData = stream.toByteArray();
        String base64Encoded = Base64.getEncoder().encodeToString(excelData);


        Map<String, String> response = new HashMap<>();
        response.put("filename", filename);
        response.put("content", base64Encoded);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/export/animais")
    public ResponseEntity<Map<String, String>> exportAnimalToExcel() {
        List<AnimalFindAllDTO> animais = animalService.fetchAnimalList();
        ByteArrayOutputStream stream = excelService.criarArquivoExcelAnimal("animais.xls", animais);

        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String filename = "animais_" + currentDate + ".xlsx";

        byte[] excelData = stream.toByteArray();
        String base64Encoded = Base64.getEncoder().encodeToString(excelData);

        Map<String, String> response = new HashMap<>();
        response.put("filename", filename);
        response.put("content", base64Encoded);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/export/usuarios")
    public ResponseEntity<Map<String, String>> exportUsuarioToCsv() {
        List<UsuarioFindAllDTO> usuarios = usuarioService.fetchUsuarioList();
        ByteArrayOutputStream stream = excelService.criarArquivoExcelUsuario("usuarios.xls", usuarios);

        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String filename = "usuarios_" + currentDate + ".xlsx";

        byte[] excelData = stream.toByteArray();
        String base64Encoded = Base64.getEncoder().encodeToString(excelData);

        // Create a JSON payload containing the Base64 data
        Map<String, String> response = new HashMap<>();
        response.put("filename", filename);
        response.put("content", base64Encoded);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
