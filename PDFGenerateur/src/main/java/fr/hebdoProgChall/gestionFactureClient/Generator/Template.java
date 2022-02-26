package fr.hebdoProgChall.gestionFactureClient.Generator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class Template {

    public void generate() {
        // Creating the PDF
        PDDocument templatePDF = new PDDocument();

        //Creating a Blank Page
        PDPage newpage = new PDPage();
        //Adding the blank page to our PDF
        templatePDF.addPage(newpage);

        //getting the required page
        //0 index for the fisrt page
        PDPage mypage = templatePDF.getPage(0);
        try {
            PDPageContentStream contentStream = new PDPageContentStream(templatePDF, mypage);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 18);
            contentStream.newLineAtOffset(150,750);
            //Setting the leading line
            contentStream.setLeading(15f);

            contentStream.showText("Text Line 1");
            contentStream.newLine();
            contentStream.showText("Text Line 2");

            //Ending the text
            contentStream.endText();
            //Closing the content stream
            contentStream.close();

            //Saving the PDF
            templatePDF.save("./test.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
