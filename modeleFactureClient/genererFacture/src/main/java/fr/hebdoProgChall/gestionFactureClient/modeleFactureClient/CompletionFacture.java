package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient;


import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;

public class CompletionFacture {

    public void generate(Facture facture, Client client, ArrayList<Ligne> lignes, ArrayList<Produit> produits) throws IOException {

        int id = facture.getId();

        // copie de la facture type et attribution du num de la facture
        File src = new File("D:\\HebdoProgChallenge\\gestionFactureClient\\modeleFactureClient\\genererFacture\\src\\main\\resources\\Facture Template.xlsx");
        File dest = new File("D:\\HebdoProgChallenge\\gestionFactureClient\\modeleFactureClient\\genererFacture\\src\\main\\resources\\factures\\Facture n°" + id + ".xlsx");
        Files.copy(src.toPath(),dest.toPath());

        // ouverture de la modification de l'excel de destination
        FileInputStream inputStream = new FileInputStream(dest);
        XSSFWorkbook wk  = new XSSFWorkbook(inputStream);
        XSSFSheet sheet =  wk.getSheetAt(0);

        //numéro de facture
        XSSFCell cell = sheet.getRow(1).getCell(1);
        cell.setCellValue("Facture n°"+id);

        //Date
        cell = sheet.getRow(2).getCell(1);
        cell.setCellValue(facture.getDate_creation());

        //Nom, Prénom
        cell = sheet.getRow(4).getCell(1);
        cell.setCellValue(client.getCli_nom().toUpperCase(Locale.ROOT) + client.getCli_prenom());

        //Adresse
        cell = sheet.getRow(5).getCell(1);
        String value = client.getCli_adr()+",";
        value += client.getCli_comp().equals("") ? "" : client.getCli_comp() + ",";

        //Téléphone
        cell = sheet.getRow(6).getCell(1);
        cell.setCellValue("Téléphone : " + client.getTel());

        //Ajout d'éléments dans la liste des produits
        int row = 8 ;
        int actualProduit = 0;
        double totalHT = 0;
        for (Ligne ligne:lignes)
        {
            XSSFRow actualRow = sheet.getRow(row);
            //nom du produit
            cell = actualRow.getCell(1);
            cell.setCellValue(produits.get(actualProduit).getPro_lib());

            //Prix unitaire
            cell = actualRow.getCell(2);
            cell.setCellValue(produits.get(actualProduit).getPro_prix());

            //Quantité
            cell = actualRow.getCell(3);
            cell.setCellValue(ligne.getLig_qte());

            //sous-total
            cell = actualRow.getCell(4);
            cell.setCellValue(produits.get(actualProduit).getPro_prix() * ligne.getLig_qte());
            totalHT += produits.get(actualProduit).getPro_prix() * ligne.getLig_qte();
            actualProduit ++;
            row ++;
        }

        //total HT
        cell = sheet.getRow(29).getCell(4);
        cell.setCellValue(totalHT);

        // TVA
        cell = sheet.getRow(30).getCell(4);
        cell.setCellValue(facture.getTva());

        // Total TTC
        cell = sheet.getRow(32).getCell(4);
        cell.setCellValue(facture.getTva() * totalHT);
        inputStream.close();

        FileOutputStream out = new FileOutputStream(dest);
        wk.write(out);
        out.close();





    }


}
