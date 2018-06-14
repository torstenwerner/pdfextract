package com.example.pdfextract;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;

@SpringBootApplication
public class PdfextractApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(PdfextractApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        File input = new File("samples/befruchtung.pdf");
        RandomAccessFile randomAccessFile = new RandomAccessFile(input, "r");
        PDFParser parser = new PDFParser(randomAccessFile);
        parser.parse();
        COSDocument cosDoc = parser.getDocument();
        PDDocument pdDoc = new PDDocument(cosDoc);
        PDFTextStripper pdfStripper = new PDFTextStripper();
//        pdfStripper.setStartPage(1);
//        pdfStripper.setEndPage(5);
        String parsedText = pdfStripper.getText(pdDoc);
        try (FileWriter writer = new FileWriter("samples/befruchtung-pdfbox.txt")) {
            writer.write(parsedText);
        }
    }
}
