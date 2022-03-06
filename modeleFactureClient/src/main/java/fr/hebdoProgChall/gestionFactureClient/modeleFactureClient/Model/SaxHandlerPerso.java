package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandlerPerso extends DefaultHandler {
    private String name;
    private String url;
    private String driver;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    private StringBuilder currentValue = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {


        if(qName.equalsIgnoreCase("name")){
            name = currentValue.toString();

        }
        if(qName.equalsIgnoreCase("url")){
            url = currentValue.toString();

        }
        if(qName.equalsIgnoreCase("driver")){
            driver = currentValue.toString();

        }
        if(qName.equalsIgnoreCase("username")){
            username = currentValue.toString();

        }
        if(qName.equalsIgnoreCase("password")){
            password = currentValue.toString();

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch,start,length);
    }
}
