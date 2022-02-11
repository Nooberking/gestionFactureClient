package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ReadXmlSaxParser {

    private static final String FILENAME = "BDDConfig.xml";

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();

            PrintAllHandleSax handler = new PrintAllHandleSax();
            saxParser.parse(FILENAME,handler);
        } catch (ParserConfigurationException | SAXException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
