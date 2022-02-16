package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;

public class CompletionFacture {

    public void generate(int id){
        File src = new File("C:\\Users\\david\\IdeaProjects\\gestionFactureClient\\generationFacture\\src\\main\\resources\\Facture Template.xlsx");
        File dest = new File("C:\\Users\\david\\IdeaProjects\\gestionFactureClient\\generationFacture\\src\\main\\resources\\factures\\Facture n°" + id + ".xlsx");

        XSSFWorkbook wk  = new XSSFWorkbook();
    }


}
