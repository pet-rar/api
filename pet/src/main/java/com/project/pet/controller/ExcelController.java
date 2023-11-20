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
	public ResponseEntity<byte[]> exportVacinacaoToExcel() {
	    List<VacinacaoFindAllDTO> vacinacoes = vacinacaoService.fetchVacinacaoList();
	    byte[] excelBytes = excelService.criarArquivoExcelVacinacoes("vacinacoes.xlsx", vacinacoes);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=vacinacoes.xlsx");
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8"); // Use UTF-8 encoding

	  
	    headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
	    headers.add(HttpHeaders.PRAGMA, "no-cache");
	    headers.add(HttpHeaders.EXPIRES, "0");

	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(excelBytes.length)
	            .body(excelBytes);
	}

	@GetMapping("/export/relatorioAnimal")
	public ResponseEntity<byte[]> exportAnimalToExcel() {
	    List<AnimalFindAllDTO> animais = animalService.fetchAnimalList();
	    byte[] excelBytes = excelService.criarArquivoExcelAnimal("animais.xlsx", animais);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=animais.xlsx");
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8"); // Use UTF-8 encoding

	
	    headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
	    headers.add(HttpHeaders.PRAGMA, "no-cache");
	    headers.add(HttpHeaders.EXPIRES, "0");

	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(excelBytes.length)
	            .body(excelBytes);
	}

	@GetMapping("/export/usuarios")
	public ResponseEntity<byte[]> exportUsuarioToExcel() {
	    List<UsuarioFindAllDTO> usuarios = usuarioService.fetchUsuarioList();
	    byte[] excelBytes = excelService.criarArquivoExcelUsuario("usuarios.xlsx", usuarios);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=usuarios.xlsx");
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8"); // Use UTF-8 encoding

	   
	    headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
	    headers.add(HttpHeaders.PRAGMA, "no-cache");
	    headers.add(HttpHeaders.EXPIRES, "0");

	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(excelBytes.length)
	            .body(excelBytes);
	}
}
