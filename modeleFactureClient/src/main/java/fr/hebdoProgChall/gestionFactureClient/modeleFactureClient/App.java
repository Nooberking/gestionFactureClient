package fr.hebdoProgChall.gestionFactureClient.modeleFactureClient;

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
