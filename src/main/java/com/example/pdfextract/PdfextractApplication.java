package com.example.pdfextract;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfextractApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(PdfextractApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello World!");
    }
}
