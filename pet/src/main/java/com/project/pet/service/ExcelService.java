package com.project.pet.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;


@Service
public class ExcelService {
	
	  public byte[] criarArquivoExcelVacinacoes(final String nomeArquivo, List<VacinacaoFindAllDTO> vacinacoes) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");

	        try (var workbook = new XSSFWorkbook(); var outputStream = new ByteArrayOutputStream()) {
	            var planilha = workbook.createSheet("Lista de Vacinações");
	            int numeroDaLinha = 0;

	            adicionarCabecalhoVacinacao(planilha, numeroDaLinha++);

	            for (VacinacaoFindAllDTO vacinacao : vacinacoes) {
	                var linha = planilha.createRow(numeroDaLinha++);
	                adicionarCelula(linha, 0, vacinacao.id());
	                adicionarCelula(linha, 1, vacinacao.animal_nome());
	                adicionarCelula(linha, 2, vacinacao.descricao());
	                adicionarCelula(linha, 3, String.valueOf(vacinacao.status()));
	                adicionarCelula(linha, 4, vacinacao.data_vacinacao().format(formatter));
	            }

	            workbook.write(outputStream);
	            return outputStream.toByteArray();
	        } catch (IOException e) {
	            System.err.println("Erro ao processar o arquivo: " + nomeArquivo);
	            return new byte[0];
	        }
	    }

	
	    public byte[] criarArquivoExcelAnimal(final String nomeArquivo, List<AnimalFindAllDTO> animais) {
	        try (var workbook = new XSSFWorkbook(); var outputStream = new ByteArrayOutputStream()) {
	            var planilha = workbook.createSheet("Lista de Animais");
	            int numeroDaLinha = 0;

	            adicionarCabecalhoAnimal(planilha, numeroDaLinha++);

	            for (AnimalFindAllDTO animal : animais) {
	                var linha = planilha.createRow(numeroDaLinha++);
	                adicionarCelula(linha, 0, animal.id());
	                adicionarCelula(linha, 1, animal.nome());
	                adicionarCelula(linha, 2, animal.especie());
	                adicionarCelula(linha, 3, animal.raca());
	                adicionarCelula(linha, 4, animal.tutor_nome());
	            }

	            workbook.write(outputStream);
	            return outputStream.toByteArray();
	        } catch (IOException e) {
	            System.err.println("Erro ao processar o arquivo: " + nomeArquivo);
	            return new byte[0];
	        }
	    }

	
	
	    public byte[] criarArquivoExcelUsuario(final String nomeArquivo, List<UsuarioFindAllDTO> usuarios) {
	        try (var workbook = new XSSFWorkbook(); var outputStream = new ByteArrayOutputStream()) {
	            var planilha = workbook.createSheet("Lista de Usuarios");
	            int numeroDaLinha = 0;

	            adicionarCabecalhoUsuario(planilha, numeroDaLinha++);

	            for (UsuarioFindAllDTO usuario : usuarios) {
	                var linha = planilha.createRow(numeroDaLinha++);
	                adicionarCelula(linha, 0, usuario.id());
	                adicionarCelula(linha, 1, usuario.nome());
	                adicionarCelula(linha, 2, usuario.email());
	                adicionarCelula(linha, 3, usuario.cpf());
	                adicionarCelula(linha, 4, String.valueOf(usuario.tipo()));
	            }

	            workbook.write(outputStream);
	            return outputStream.toByteArray();
	        } catch (IOException e) {
	            System.err.println("Erro ao processar o arquivo: " + nomeArquivo);
	            return new byte[0];
	        }
	    }

	private void adicionarCabecalhoVacinacao(XSSFSheet planilha, int numeroLinha) {
		var linha = planilha.createRow(numeroLinha);
		adicionarCelula(linha, 0, "Id");
		adicionarCelula(linha, 1, "Nome animal");
		adicionarCelula(linha, 2, "Descrição");
		adicionarCelula(linha, 3, "Status");
		adicionarCelula(linha, 4, "DataVacinacao");
	}
	private void adicionarCabecalhoAnimal(XSSFSheet planilha, int numeroLinha) {
		var linha = planilha.createRow(numeroLinha);
		adicionarCelula(linha, 0, "Id");
		adicionarCelula(linha, 1, "Nome animal");
		adicionarCelula(linha, 2, "Espécie");
		adicionarCelula(linha, 3, "Raca");
		adicionarCelula(linha, 4, "Nome tutor");
	}
	
	private void adicionarCabecalhoUsuario(XSSFSheet planilha, int numeroLinha) {
		var linha = planilha.createRow(numeroLinha);
		adicionarCelula(linha, 0, "Id");
		adicionarCelula(linha, 1, "Nome");
		adicionarCelula(linha, 2, "Email");
		adicionarCelula(linha, 3, "cpf");
		adicionarCelula(linha, 4, "Tipo");
	}

	private void adicionarCelula(Row linha, int coluna, String valor) {
		Cell cell = linha.createCell(coluna);
		cell.setCellValue(valor);
	}

	private void adicionarCelula(Row linha, int coluna, int valor) {
		Cell cell = linha.createCell(coluna);
		cell.setCellValue(valor);
	}
}
