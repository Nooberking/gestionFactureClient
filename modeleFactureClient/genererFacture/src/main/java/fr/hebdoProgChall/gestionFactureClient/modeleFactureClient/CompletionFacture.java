package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CompletionFacture {

    public void generate(int id) throws IOException {
        File src = new File("C:\\Users\\david\\IdeaProjects\\gestionFactureClient\\modeleFactureClient\\genererFacture\\src\\main\\resources\\Facture Template.xlsx");
        File dest = new File("C:\\Users\\david\\IdeaProjects\\gestionFactureClient\\modeleFactureClient\\genererFacture\\src\\main\\resources\\factures\\Facture n°" + id + ".xlsx");
        Files.copy(src.toPath(),dest.toPath());
        XSSFWorkbook wk  = new XSSFWorkbook();
    }


}
