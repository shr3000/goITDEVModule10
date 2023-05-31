package clients;


import conf.FlywayConfiguration;
import org.hibernate.SessionFactory;


import org.hibernate.cfg.Configuration;
import java.util.List;


public class CrudServicesVerification {
    public static void main(String[] args) {
        FlywayConfiguration.migrate("D:/GOITDev/goITDevModule10/src/main/dbSource/planetscruiser");
        // Тестування ClientCrudService
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
        ClientCrudService clientService = new ClientCrudService(sessionFactory);

        Client client = new Client();
        client.setName("User");
        clientService.addClient(client);

        client = clientService.getAllClients().get(2);
        System.out.println("client = " + client);

        client = clientService.getAllClients().get(2);
        client.setName("New User NAme");
        clientService.updateClient(client, client.getId());
        Client getClient = clientService.getAllClients().get(2);
        System.out.println("getClient = " + getClient);

        clientService.deleteClient(11);

        List<Client> clients = clientService.getAllClients();
        for (Client clnt : clients) {
            System.out.println(clnt);
        }

    }
}
