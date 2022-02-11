package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PrintAllHandleSax extends DefaultHandler {

    private StringBuilder currentValue = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(qName.equalsIgnoreCase("name")){
            System.out.printf("Name : %s%n", currentValue.toString());
        }
        if(qName.equalsIgnoreCase("url")){
            System.out.printf("Url : %s%n", currentValue.toString());
        }
        if(qName.equalsIgnoreCase("driver")){
            System.out.printf("Driver : %s%n", currentValue.toString());
        }
        if(qName.equalsIgnoreCase("username")){
            System.out.printf("Username : %s%n", currentValue.toString());
        }
        if(qName.equalsIgnoreCase("password")){
            System.out.printf("Password : %s%n", currentValue.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch,start,length);
    }
}
