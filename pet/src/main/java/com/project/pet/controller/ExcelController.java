package com.project.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;
import com.project.pet.service.AnimalService;
import com.project.pet.service.ExcelService;
import com.project.pet.service.UsuarioService;
import com.project.pet.service.VacinacaoService;
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
	 @GetMapping("/export/relatorioVacinacao")
	    public ResponseEntity<ByteArrayResource> exportVacinacaoToExcel() {
	        List<VacinacaoFindAllDTO> vacinacoes = vacinacaoService.fetchVacinacaoList();
	        byte[] excelBytes = excelService.criarArquivoExcelVacinacoes("vacinacoes.xls", vacinacoes);

	        ByteArrayResource resource = new ByteArrayResource(excelBytes);

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=vacinacoes.xls")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .contentLength(excelBytes.length)
	                .body(resource);
	    }

	    @GetMapping("/export/relatorioAnimal")
	    public ResponseEntity<ByteArrayResource> exportAnimalToExcel() {
	        List<AnimalFindAllDTO> animais = animalService.fetchAnimalList();
	        byte[] excelBytes = excelService.criarArquivoExcelAnimal("animais.xls", animais);

	        ByteArrayResource resource = new ByteArrayResource(excelBytes);

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=animais.xls")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .contentLength(excelBytes.length)
	                .body(resource);
	    }

	    @GetMapping("/export/relatorioUsuario")
	    public ResponseEntity<ByteArrayResource> exportUsuarioToCsv() {
	        List<UsuarioFindAllDTO> usuarios = usuarioService.fetchUsuarioList();
	        byte[] excelBytes = excelService.criarArquivoExcelUsuario("usuarios.xls", usuarios);

	        ByteArrayResource resource = new ByteArrayResource(excelBytes);

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=usuarios.xls")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .contentLength(excelBytes.length)
	                .body(resource);
	    }
	}
