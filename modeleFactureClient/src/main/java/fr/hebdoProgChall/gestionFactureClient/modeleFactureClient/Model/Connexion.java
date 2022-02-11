package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Connexion {
    public void on() {
        try {
            File file = new File("BDDConfig.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(BDDConfig.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BDDConfig bdd =(BDDConfig) jaxbUnmarshaller.unmarshal(file);


        } catch(JAXBException e){
            e.printStackTrace();

        }

    }
}
