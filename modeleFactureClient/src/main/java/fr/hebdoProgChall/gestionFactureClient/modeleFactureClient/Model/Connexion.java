package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String FILENAME = "BDDConfig.xml";
    SAXParserFactory factory = SAXParserFactory.newInstance();

    public Connection on() {
        try {
            SAXParser saxParser = factory.newSAXParser();
            SaxHandlerPerso handler = new SaxHandlerPerso();
            saxParser.parse(FILENAME,handler);

            Class.forName(handler.getDriver());
            return DriverManager.getConnection(handler.getUrl(), handler.getUsername(), handler.getPassword());

        } catch (ParserConfigurationException |
                SAXException |
                IOException |
                ClassNotFoundException |
                SQLException e){

            e.printStackTrace();
            return null;
        }

    }

}
