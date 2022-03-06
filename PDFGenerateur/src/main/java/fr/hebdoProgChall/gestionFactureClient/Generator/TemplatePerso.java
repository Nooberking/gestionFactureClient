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
import java.util.Arrays;
import java.util.Date;
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
    int totalPage = 2;
    int maxArticleParPage = 25;
    int tailleBasPage = 85;
    final Color BLUE_DARK = new Color(76, 129, 190);
    final Color BLUE_LIGHT_1 = new Color(186, 206, 230);
    final Color BLUE_LIGHT_2 = new Color(218, 230, 242);

    Object[][] DATA = new Object[][]{
            {"A", 134.0, 145.0},
            {"B",   768.0, 677.0},
            {"C",    456.2, 612.0},
            {"D",  302.3, 467.0},
            {"E", 134.0, 145.0},
            {"F",   768.0, 677.0},
            {"G",    456.2, 612.0},
            {"H",  302.3, 467.0},
            {"I", 134.0, 145.0},
            {"J",   768.0, 677.0},
            {"K",    456.2, 612.0},
            {"L",  302.3, 467.0},
            {"M", 134.0, 145.0},
            {"N",   768.0, 677.0},
            {"O",    456.2, 612.0},
            {"P",  302.3, 467.0},
            {"Q", 134.0, 145.0},
            {"R",   768.0, 677.0},
            {"S",    456.2, 612.0},
            {"T",  302.3, 467.0},
            {"U", 134.0, 145.0},
            {"V",   768.0, 677.0},
            {"W",    456.2, 612.0},
            {"X",  302.3, 467.0},
            {"Y", 134.0, 145.0},
            {"Z",   768.0, 677.0},
            {"a",    456.2, 612.0},
            {"b",  302.3, 467.0},
            {"c", 134.0, 145.0},
            {"d",   768.0, 677.0},
            {"e",    456.2, 612.0},
            {"f",  302.3, 467.0},
            {"g", 134.0, 145.0},
            {"h",   768.0, 677.0},
            {"i",    456.2, 612.0},
            {"j",  302.3, 467.0},
            {"k", 134.0, 145.0},
            {"l",   768.0, 677.0},
            {"m",   768.0, 677.0},
            {"n",   768.0, 677.0},
            {"o",   768.0, 677.0},
            {"p",   768.0, 677.0},
            {"q",   768.0, 677.0},
            {"r",   768.0, 677.0},
            {"s",   768.0, 677.0},
            {"t",   768.0, 677.0},
            {"u",   768.0, 677.0},
            {"v",   768.0, 677.0},
            {"w",   768.0, 677.0},
            {"x",   768.0, 677.0},
            {"y",   768.0, 677.0},
            {"z",   768.0, 677.0}






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


            if (DATA.length > 20){
                //séparation des produits en produits par pages
                ArrayList<Object[][]> lignesPages = new ArrayList<>();
                lignesPages.add(Arrays.copyOfRange(DATA,0,20));
                for (int i=0; i<((DATA.length - 20) / maxArticleParPage) ;i++){
                    lignesPages.add(Arrays.copyOfRange(DATA,20 + maxArticleParPage * i, 20 + maxArticleParPage * (i + 1) ));
            }
                lignesPages.add(Arrays.copyOfRange(DATA,((DATA.length - 20) / maxArticleParPage) * maxArticleParPage + 20, DATA.length));
                totalPage = lignesPages.size();

                //première page
                Table firstTable = this.createSimpleExampleTable(lignesPages.get(0));
                TableDrawer tableDrawer = TableDrawer.builder()
                        .contentStream(cs)
                        .startX(50f)
                        .startY(550f)
                        .table(firstTable).build();

                tableDrawer.draw();
                //Ajout nombre de pages
                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 18);
                cs.newLineAtOffset(480, 30);
                cs.showText("page "+ (numPage + 1) + " / " + totalPage );
                numPage ++;
                cs.endText();
                cs.close();

                //si pages intermédiaires
                if (lignesPages.size() > 2 )
                {
                    for(int i = 1; i<lignesPages.size() - 1 ; i++ )
                    {
                        //Ajout de pages
                        newpage = new PDPage(PDRectangle.A4);
                        facture.addPage(newpage);
                        page = facture.getPage(numPage);

                        //logo
                         cs = new PDPageContentStream(facture,page, PDPageContentStream.AppendMode.APPEND, true, true );
                         scale = 0.5f;
                         cs.drawImage(pdImage, 420,620 + tailleBasPage ,pdImage.getWidth() * scale, pdImage.getHeight() * scale);

                         //Titre
                        cs.beginText();
                        cs.setNonStrokingColor(15, 176, 253);
                        cs.setFont(PDType1Font.TIMES_ROMAN, 32);
                        cs.newLineAtOffset(50,720 + tailleBasPage);
                        cs.showText("Facture n° ");
                        cs.endText();

                         firstTable = this.createSimpleExampleTable(lignesPages.get(i));
                         tableDrawer = TableDrawer.builder()
                                .contentStream(cs)
                                .startX(50f)
                                .startY(625f)
                                .table(firstTable).build();

                        tableDrawer.draw();


                        //Ajout nombre de pages
                        cs.beginText();
                        cs.setFont(PDType1Font.TIMES_ROMAN, 18);
                        cs.newLineAtOffset(480, 30);
                        cs.showText("page "+ (numPage + 1) + " / " + totalPage );
                        numPage ++;
                        cs.endText();
                        cs.close();
                    }
                }

                //ajout de la dernière page
                newpage = new PDPage(PDRectangle.A4);
                facture.addPage(newpage);
                page = facture.getPage(numPage);

                //logo
                cs = new PDPageContentStream(facture,page, PDPageContentStream.AppendMode.APPEND, true, true );
                scale = 0.5f;
                cs.drawImage(pdImage, 420,620 + tailleBasPage ,pdImage.getWidth() * scale, pdImage.getHeight() * scale);

                //Titre
                cs.beginText();
                cs.setNonStrokingColor(15, 176, 253);
                cs.setFont(PDType1Font.TIMES_ROMAN, 32);
                cs.newLineAtOffset(50,720 + tailleBasPage);
                cs.showText("Facture n° ");
                cs.endText();
                cs.beginText();
                cs.setNonStrokingColor(15, 176, 253);
                cs.setFont(PDType1Font.TIMES_ROMAN, 32);
                cs.newLineAtOffset(50,720 + tailleBasPage);
                cs.showText("Facture n° ");
                cs.endText();

                firstTable = this.createSimpleExampleTable(lignesPages.get(lignesPages.size() - 1) );
                tableDrawer = TableDrawer.builder()
                        .contentStream(cs)
                        .startX(50f)
                        .startY(625f)
                        .table(firstTable).build();

                tableDrawer.draw();


                //Ajout nombre de pages
                cs.beginText();
                cs.setFont(PDType1Font.TIMES_ROMAN, 18);
                cs.newLineAtOffset(480, 30);
                cs.showText("page "+ ( numPage + 1) + " / " + totalPage );
                numPage ++;
                cs.endText();



            }
            else {
                // Génération tableau de listing des produits
                Table myTable = this.createSimpleExampleTable(DATA);

                TableDrawer tableDrawer = TableDrawer.builder()
                        .contentStream(cs)
                        .startX(50f)
                        .startY(550f)
                        .table(myTable).build();

                tableDrawer.draw();

                //Ajout nombre de pages
                cs.beginText();

                cs.setFont(PDType1Font.TIMES_ROMAN, 18);
                cs.newLineAtOffset(480, 30);
                cs.showText("page 1 / 1");
                cs.endText();
            }
            //Génération du tableau du total

            Table.TableBuilder tableBuilder = Table.builder()
                    .addColumnsOfWidth(100, 100)
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
    public Table createSimpleExampleTable(Object[][] data) {

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
        for (int i = 0; i < data.length; i++) {
            final Object[] dataRow = data[i];
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
