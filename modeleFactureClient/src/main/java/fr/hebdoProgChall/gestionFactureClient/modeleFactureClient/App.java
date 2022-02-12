package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient;

import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.DAO.ClientDAO;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Impl.ClientDAOImpl;
import fr.hebdoProgChall.gestionFactureClient.modeleFactureClient.Model.Client;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Client> allClients = null;
        List<Client> allClientsId = null;
        List<Client> allClientsNom = null;
        ClientDAO ClientAccess = new ClientDAOImpl();

        try {
            allClients = ClientAccess.findAll("CLI_CODE");
            allClientsId = ClientAccess.findBy("CLI_CODE",1);
            allClientsNom = ClientAccess.findBy("CLI_NOM","Le Testeur");

        }catch (Exception e) {
            e.printStackTrace();
        }

        for (Client currentC : allClients)
        {
            System.out.println(currentC.getCli_nom()+ " " +currentC.getCli_prenom() );
        }
        for (Client currentC2 : allClientsId)
        {
            System.out.println("Test id : " + currentC2.getCli_nom()+ " " +currentC2.getCli_prenom() );
        }
        for (Client currentC3 : allClientsNom){
            System.out.print("TestNom : " + currentC3.getCli_nom()+ " " +currentC3.getCli_prenom());
        }

    }
}
