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
            allClientsNom = ClientAccess.findBy("CLI_NOM","MANNNA");
            ClientAccess.add("MANUEL","David","50 rue des tiercelins", "porte en haut", 54000,"Nancy","0658803881");
            ClientAccess.delete(4);
            ClientAccess.update(3,"MBULUKU","David","50 rue des tiercelins", "porte en haut", 54000,"Nancy","0658803881");

        }catch (Exception e) {
            e.printStackTrace();
        }

        assert allClients != null;
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
