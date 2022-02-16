package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient;


import java.io.IOException;

public class Tester
{
    public static void main( String[] args ) throws IOException
    {
        CompletionFacture nc = new CompletionFacture();
        nc.generate(01);
        /*File file = new File("C:\\Users\\david\\IdeaProjects\\gestionFactureClient\\generationFacture\\src\\main\\resources\\Facture Template.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Double subTot = 0.0 ;

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);

        //numéro de Facture
        XSSFCell cell = sheet.getRow(1).getCell(1);
        cell.setCellValue("Facture n° " + "000");

        // Date
        cell = sheet.getRow(2).getCell(1);
        cell.setCellValue("Date : " + " 13/02/2022");

        //Nom, Prénom
        cell = sheet.getRow(4).getCell(1);
        cell.setCellValue("Manuel".toUpperCase(Locale.ROOT) + " " + "David");

        //Adresse, complément adresse, code postal, ville
        cell = sheet.getRow(5).getCell(1);
        cell.setCellValue("50 Rue de Tiercelins" + ", " + "50 B" + ", 54000" + " " + "NANCY");

        // Téléphone
        cell = sheet.getRow(6).getCell(1);
        cell.setCellValue("Téléphone : " + " 06 58 80 38 81");






        // Ajout éléments dans la liste
        cell = sheet.getRow(8).getCell(1);
        cell.setCellValue( "A");
        XSSFCell cellA = sheet.getRow(8).getCell(2);
        cellA.setCellValue(20);
        XSSFCell cellB = sheet.getRow(8).getCell(3);
        cellB.setCellValue(2);
        cell = sheet.getRow(8).getCell(4);
        subTot += cellA.getNumericCellValue() * cellB.getNumericCellValue();
        cell.setCellValue( cellA.getNumericCellValue() * cellB.getNumericCellValue());

        cell = sheet.getRow(9).getCell(1);
        cell.setCellValue("End");
        cellA = sheet.getRow(9).getCell(2);
        cellA.setCellValue(10);
        cellB = sheet.getRow(9).getCell(3);
        cellB.setCellValue(3);
        cell = sheet.getRow(9).getCell(4);
        subTot += cellA.getNumericCellValue() * cellB.getNumericCellValue();
        cell.setCellValue( cellA.getNumericCellValue() * cellB.getNumericCellValue());


        //Sous-Total
        cell = sheet.getRow(29).getCell(4);
        cell.setCellValue(subTot);
        //TVA
        cell = sheet.getRow(30).getCell(4);
        cell.setCellValue(0.20);

        cell = sheet.getRow(32).getCell(4);
        cell.setCellValue(subTot * (1 + 0.20));

        inputStream.close();

        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();*/

        CompletionFacture cpFacture = new CompletionFacture();
        cpFacture.generate(2);


    }
}
