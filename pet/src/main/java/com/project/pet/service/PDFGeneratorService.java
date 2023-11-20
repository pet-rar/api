package com.project.pet.service;

import java.awt.Color;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.project.pet.dto.Vacinacao.CarterinhaDTO;
import com.project.pet.repository.VacinacaoRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PDFGeneratorService {

    @Autowired
    private VacinacaoRepository vacinacaoRepository;


    public void export(HttpServletResponse response, Long id) throws IOException, DocumentException {
        List<CarterinhaDTO> carterinhas = vacinacaoRepository.findCarterinhaVacinacao(id);

        if (carterinhas != null && !carterinhas.isEmpty()) {
            // Configuração do documento
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
            document.addTitle("Carterinha de Vacinação");
            document.open();

            for (CarterinhaDTO carterinha : carterinhas) {
                // Adiciona título centralizado para cada tabela
                Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitle.setSize(24);
                fontTitle.setColor(Color.BLACK);
                Paragraph title = new Paragraph("Carterinha de Vacinação", fontTitle);
                title.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(title);

                // Cria uma tabela para cada elemento
                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(80);
                table.setSpacingBefore(20f);
                table.setSpacingAfter(20f);

                float[] columnWidths = {1f, 2f};
                table.setWidths(columnWidths);

                // Adiciona células à tabela
                addCell(table, "Animal", carterinha.nome());
                addCell(table, "Tutor", carterinha.tutor_nome());
                String porteTexto;
                String porteValor = String.valueOf(carterinha.porte());

                if ("MEDIO".equals(porteValor)) {
                    porteTexto = "Médio";
                } else if ("GRANDE".equals(porteValor)) {
                    porteTexto = "Grande";
                } else  {
                    porteTexto = "Pequeno";
                } 

                addCell(table, "Porte", porteTexto);
                addCell(table, "Espécie", carterinha.especie());
                addCell(table, "Raça", carterinha.raca());
                addCell(table, "Vacinação", carterinha.descricao());
                addCell(table, "Data Vacinação", formatDate(carterinha.data_vacinacao()));

                document.add(table);
            }

            document.close();
        }
        
    }

    private String formatDate(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }

    private void addCell(PdfPTable table, String label, String value, int colspan) {
        Font fontLabel = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontLabel.setSize(12);
        fontLabel.setColor(Color.WHITE);

        Font fontValue = FontFactory.getFont(FontFactory.HELVETICA);
        fontValue.setSize(12);

        PdfPCell cellLabel = new PdfPCell(new Phrase(label, fontLabel));
        cellLabel.setBackgroundColor(new Color(70, 130, 180)); 
        cellLabel.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellLabel);

        PdfPCell cellValue = new PdfPCell(new Phrase(value, fontValue));
        cellValue.setBorder(Rectangle.NO_BORDER);
        cellValue.setBackgroundColor(new Color(173, 216, 230)); 
        cellValue.setColspan(colspan);
        cellValue.setHorizontalAlignment(Element.ALIGN_RIGHT); 
        table.addCell(cellValue);
    }

    private void addCell(PdfPTable table, String label, String value) {
        addCell(table, label, value, 1); 
    }
}