package main;

import clients.Client;
import clients.ClientCrudService;

import org.hibernate.cfg.Configuration;
import planets.Planet;
import planets.PlanetCrudService;

public class CrudServicesVerification {
    public static void main(String[] args) {
        //HibernateConfiguration.getInstance();
        //ClientCrudService
        new Configuration()
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();
        ClientCrudService clientService = new ClientCrudService();

        Client client = new Client();
        client.setName("User");
        clientService.createClient(client);

        client = clientService.getById(1);
        System.out.println("client = " + client);

        client = clientService.getById(2);
        client.setName("New User NAme");
        clientService.updateClient(client);
        Client getClient = clientService.getById(2);
        System.out.println("getClient = " + getClient);

        clientService.deleteClient(clientService.getById(2));

        // PlanetCrudService
        PlanetCrudService planetService = new PlanetCrudService();
        new Configuration()
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
        Planet planet = new Planet();
        planet.setId("EU");
        planet.setName("Europa");
        planetService.create(planet);
        planet = planetService.getPlanetById("EU");
        System.out.println("planet = " + planet);

        planet = planetService.getPlanetById("MAR");
        planet.setName("Mars terraform");
        planetService.updatePlanet(planet);
        Planet getPlanet = planetService.getPlanetById("MAR");
        System.out.println("getPlanet = " + getPlanet.getName());

        planetService.delete(planetService.getPlanetById("MAR"));


    }
}
