package com.project.pet.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.project.pet.dto.Animal.AnimalFindAllDTO;
import com.project.pet.dto.Usuario.UsuarioFindAllDTO;
import com.project.pet.dto.Vacinacao.VacinacaoFindAllDTO;

@Service
public class CsvService {

	public void exportToCsvVacinacao(List<VacinacaoFindAllDTO> vacinacoes, String csvFilePath) throws IOException {
		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {
			String[] header = { "ID", "Nome animal", "Data Vacinacao", "Descrição", "Status" };
			csvWriter.writeNext(header);

			for (VacinacaoFindAllDTO vacinacao : vacinacoes) {
				String[] data = { String.valueOf(vacinacao.id()), vacinacao.animal_nome(),
						String.valueOf(vacinacao.data_vacinacao()), vacinacao.descricao(),
						String.valueOf(vacinacao.status()) };
				csvWriter.writeNext(data);
			}
		}
	}

	public void exportToCsvAnimal(List<AnimalFindAllDTO> animais, String csvFilePath) throws IOException {

		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {
			String[] header = { "ID", "Nome animal", "Raça", "Nome tutor" };
			csvWriter.writeNext(header);

			for (AnimalFindAllDTO animal : animais) {
				String[] data = { String.valueOf(animal.id()), animal.nome(), animal.raca(), animal.tutor_nome() };
				csvWriter.writeNext(data);
			}
		}

	}

	public void exportToCsvUsuarios(List<UsuarioFindAllDTO> usuarios, String csvFilePath) throws IOException {

		try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFilePath))) {
			String[] header = { "ID", "Nome", "CPF", "Tipo" };
			csvWriter.writeNext(header);

			for (UsuarioFindAllDTO usuario : usuarios) {
				String[] data = { String.valueOf(usuario.id()), usuario.nome(), usuario.cpf(),
						String.valueOf(usuario.tipo()) };
				csvWriter.writeNext(data);
			}
		}

	}
}