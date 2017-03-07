package io.github.albraga;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import io.github.albraga.PDFLayoutTextStripper;

import org.apache.commons.io.FileUtils;

public class PdfTxt {

    public static void main(String[] args) {
        String string = null;
        
        try {
            PDFParser pdfParser = new PDFParser(new FileInputStream("sample.pdf"));
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
            string = pdfTextStripper.getText(pdDocument);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
        try {
            FileUtils.writeStringToFile(new File("test.txt"), string, "UTF-8");
        } catch(Exception e) {}
    }

}