package com.project.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
import org.springframework.http.HttpHeaders;
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
	    public ResponseEntity<ByteArrayResource> exportVacinacaoToExcel() {
	        List<VacinacaoFindAllDTO> vacinacoes = vacinacaoService.fetchVacinacaoList();
	        byte[] excelBytes = excelService.criarArquivoExcelVacinacoes("vacinacoes.xlsx", vacinacoes);

	        ByteArrayResource resource = new ByteArrayResource(excelBytes);
                String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));                
                String filename = "vacinacoes_" + currentDate + ".xlsx";

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename)
	                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	                .contentLength(excelBytes.length)
	                .body(resource);
	    }

	    @GetMapping("/export/animais")
	    public ResponseEntity<ByteArrayResource> exportAnimalToExcel() {
	        List<AnimalFindAllDTO> animais = animalService.fetchAnimalList();
	        byte[] excelBytes = excelService.criarArquivoExcelAnimal("animais.xlsx", animais);

	        ByteArrayResource resource = new ByteArrayResource(excelBytes);
                String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));                
                String filename = "animais_" + currentDate + ".xlsx";

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename)
	                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	                .contentLength(excelBytes.length)
	                .body(resource);
	    }

	    @GetMapping("/export/usuarios")
	    public ResponseEntity<byte[]> exportUsuarioToCsv() {
	        List<UsuarioFindAllDTO> usuarios = usuarioService.fetchUsuarioList();
                ByteArrayOutputStream stream = excelService.criarArquivoExcelUsuario("usuarios.xls", usuarios);          
	        
                String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));                
                String filename = "usuarios_" + currentDate + ".xlsx";

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename)
	                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
	                .body(stream.toByteArray());
	    }
	}
