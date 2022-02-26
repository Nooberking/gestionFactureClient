package fr.hebdoProgChall.gestionFactureClient.Generator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.BorderStyle;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.*;
import static org.apache.pdfbox.pdmodel.font.PDType1Font.*;
import static org.vandeseer.easytable.settings.HorizontalAlignment.*;
import static org.vandeseer.easytable.settings.VerticalAlignment.TOP;

public class TemplatePerso {
    int n;
    Integer total = 0;
    Integer price;
    String CustName;
    String CustPh;
    List<String> ProductName = new ArrayList<String>();
    List<Integer> ProductPrice = new ArrayList<Integer>();
    List<Integer> ProductQty = new ArrayList<Integer>();
    int numPage = 0;
    int totalPage = 1;
    int tailleBasPage = 85;
    final Color BLUE_DARK = new Color(76, 129, 190);
    final Color BLUE_LIGHT_1 = new Color(186, 206, 230);
    final Color BLUE_LIGHT_2 = new Color(218, 230, 242);

    private final static Object[][] DATA = new Object[][]{
            {"Whisky", 134.0, 145.0},
            {"Beer",   768.0, 677.0},
            {"Gin",    456.2, 612.0},
            {"Vodka",  302.3, 467.0},
            {"Whisky", 134.0, 145.0},
            {"Beer",   768.0, 677.0},
            {"Gin",    456.2, 612.0},
            {"Vodka",  302.3, 467.0},
            {"Whisky", 134.0, 145.0},
            {"Beer",   768.0, 677.0},
            {"Gin",    456.2, 612.0},
            {"Vodka",  302.3, 467.0},
            {"Whisky", 134.0, 145.0},
            {"Beer",   768.0, 677.0},
            {"Gin",    456.2, 612.0},
            {"Vodka",  302.3, 467.0},
            {"Whisky", 134.0, 145.0},
            {"Beer",   768.0, 677.0},
            {"Gin",    456.2, 612.0},
            {"Vodka",  302.3, 467.0}



    };





    public void generate() {
        // ajout de la première page
        PDDocument facture = new PDDocument();
        PDPage newpage = new PDPage(PDRectangle.A4);
        facture.addPage(newpage);

        PDPage page = facture.getPage(numPage) ;

        try {

            //placement du logo
            PDImageXObject pdImage = PDImageXObject.createFromFile("./HPC_transparent.png",facture);
            PDPageContentStream cs = new PDPageContentStream(facture,page, PDPageContentStream.AppendMode.APPEND, true, true );
            float scale = 0.5f;
            cs.drawImage(pdImage, 420,620 + tailleBasPage ,pdImage.getWidth() * scale, pdImage.getHeight() * scale);


            //Ajout du nom de la facture
            cs.beginText();
            cs.setNonStrokingColor(15, 176, 253);
            cs.setFont(PDType1Font.TIMES_ROMAN, 32);
            cs.newLineAtOffset(50,720 + tailleBasPage);
            cs.showText("Facture n° ");
            cs.endText();

            //nom de l'entreprise
            cs.beginText();
            cs.setNonStrokingColor(88, 91, 92);
            cs.setFont(PDType1Font.TIMES_ROMAN, 21);
            cs.newLineAtOffset(50,690 + tailleBasPage);
            cs.showText("Hebdo Prog Challenge");
            cs.endText();

            //Coordonnées de l'entreprise
            cs.beginText();
            cs.setNonStrokingColor(138, 138, 138);
            cs.setFont(PDType1Font.TIMES_ROMAN, 15);
            cs.newLineAtOffset(50,660 + tailleBasPage);
            cs.setLeading(20f);
            cs.showText("50 Rue des tiercelins, 54000 Nancy");
            cs.newLine();
            cs.showText("06 58 80 38 81");
            cs.newLine();
            cs.showText("Date : ");
            cs.endText();

            //Titre "destinataire"
            cs.beginText();
            cs.setNonStrokingColor(15, 176, 253);
            cs.setFont(PDType1Font.TIMES_ROMAN, 21);
            cs.newLineAtOffset(50,560 + tailleBasPage);
            cs.showText("Destinataire");
            cs.endText();

            //Coordonnées destinataire
            cs.beginText();
            cs.setNonStrokingColor(138, 138, 138);
            cs.setFont(PDType1Font.TIMES_ROMAN, 15);
            cs.newLineAtOffset(50,530 + tailleBasPage);
            cs.setLeading(20f);
            cs.showText("Nom du client");
            cs.newLine();
            cs.showText("50 Rue des tiercelins, 54000 Nancy");
            cs.newLine();
            cs.showText("numéro de tel:");
            cs.endText();


            // Génération tableau de listing des produits
            Table myTable = this.createSimpleExampleTable();

            TableDrawer tableDrawer = TableDrawer.builder()
                    .contentStream(cs)
                            .startX(50f)
                            .startY(550f)
                            .table(myTable).build();

            tableDrawer.draw();

            //Ajout nombre de pages
            cs.beginText();

            cs.setFont(PDType1Font.TIMES_ROMAN, 18);
            cs.newLineAtOffset(480,30);
            cs.showText("page 1 / 1");
            cs.endText();

            //Génération du tableau du total

            Table.TableBuilder tableBuilder = Table.builder()
                    .addColumnsOfWidth(100,100)
                            .fontSize(12)
                            .font(HELVETICA);

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("Sous-total").borderWidth(1).build())
                    .add(TextCell.builder().text(total + " €").borderWidth(1).build())
                    .build());

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("TVA").borderWidth(1).build())
                    .add(TextCell.builder().text(20 + " %").borderWidth(1).build())
                    .build());

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("Coût total TTC").borderWidth(1).build())
                    .add(TextCell.builder().text(total + " €").borderWidth(1).build())
                    .textColor(WHITE)
                    .backgroundColor(BLUE_DARK)
                    .build());

            Table totalTable = tableBuilder.build();
            TableDrawer tDrawer = TableDrawer.builder()
                    .contentStream(cs)
                    .startX(350f)
                    .startY(150f)
                    .table(totalTable).build();

            tDrawer.draw();







            cs.close();
            //sauvegarde du fichier
            facture.save("./testPerso.pdf");
        } catch (IOException e) {
            e.printStackTrace();

        }










    }
    public Table createSimpleExampleTable() {

        final Table.TableBuilder tableBuilder = Table.builder()
                .addColumnsOfWidth(200, 100, 100, 100)
                .fontSize(12)
                .font(HELVETICA)
                .borderColor(WHITE);

        //Pour les titres des colonnes
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Description de l'élément").borderWidth(1).build())
                .add(TextCell.builder().text("Prix Unitaire").borderWidth(1).build())
                .add(TextCell.builder().text("Quantité").borderWidth(1).build())
                .add(TextCell.builder().text("Montant Total").borderWidth(1).build())
                .backgroundColor(BLUE_DARK)
                .textColor(WHITE)
                .font(HELVETICA_BOLD)
                .fontSize(12)
                .horizontalAlignment(CENTER)
                .build());

        // Ajout des lignes
        double grandTotal = 0;
        for (int i = 0; i < DATA.length; i++) {
            final Object[] dataRow = DATA[i];
            final double total = (double) dataRow[1] + (double) dataRow[2];
            grandTotal += total;

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text(String.valueOf(dataRow[0])).horizontalAlignment(LEFT).borderWidth(1).build())
                    .add(TextCell.builder().text(dataRow[1] + " €").borderWidth(1).build())
                    .add(TextCell.builder().text(dataRow[2] + " €").borderWidth(1).build())
                    .add(TextCell.builder().text(total + " €").borderWidth(1).build())
                    .backgroundColor(i % 2 == 0 ? BLUE_LIGHT_1 : BLUE_LIGHT_2)
                    .horizontalAlignment(RIGHT)
                    .build());
        }

        // Add a final row
        /* tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("This spans over 3 cells, is right aligned and its text is so long that it even breaks. " +
                                "Also it shows the grand total in the next cell and furthermore vertical alignment is shown:")
                        .colSpan(3)
                        .lineSpacing(1f)
                        .borderWidthTop(1)
                        .textColor(WHITE)
                        .backgroundColor(BLUE_DARK)
                        .fontSize(6)
                        .font(HELVETICA_OBLIQUE)
                        .borderWidth(1)
                        .build())
                .add(TextCell.builder().text(grandTotal + " €").backgroundColor(LIGHT_GRAY)
                        .font(HELVETICA_BOLD_OBLIQUE)
                        .verticalAlignment(TOP)
                        .borderWidth(1)
                        .build())
                .horizontalAlignment(RIGHT)
                .build());
            */
        return tableBuilder.build();
    }

    public static void main( String[] args )
    {
        TemplatePerso test = new TemplatePerso();
        test.generate();
    }
}
