package com.project.pet.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.project.pet.service.PDFGeneratorService;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class PDFExportController {

	

    private final PDFGeneratorService pdfGeneratorService;

    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }
    @GetMapping("/pdf/generate/{id}")
    public ResponseEntity<Map<String, String>> generatePDF(HttpServletResponse response, @PathVariable("id") Long id) {
        Map<String, String> jsonResponse = new HashMap<>();
        response.setContentType("application/json");  // Alterado para application/json
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
    

        try {
            ByteArrayOutputStream pdfStream = this.pdfGeneratorService.export(id);
            byte[] pdfData = pdfStream.toByteArray();
            String base64Encoded = Base64.getEncoder().encodeToString(pdfData);

  
            jsonResponse.put("content", base64Encoded);

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "Error generating PDF: " + e.getMessage());
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonResponse);
    }
}
