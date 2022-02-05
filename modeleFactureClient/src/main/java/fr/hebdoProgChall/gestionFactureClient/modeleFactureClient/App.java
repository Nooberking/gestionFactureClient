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
        ClientDAO ClientAccess = new ClientDAOImpl();

        try {
            allClients = ClientAccess.findAll();
        }catch (Exception e) {
            e.printStackTrace();
        }

        for (Client currentC : allClients)
        {
            System.out.println(currentC.getCli_nom()+ " " +currentC.getCli_prenom() );
        }
    }
}
