package conf;

import clients.Client;
import lombok.Getter;
import org.hibernate.SessionFactory;
import planets.Planet;


public class Configuration {
    private static final Configuration INSTANCE;

    static {
        INSTANCE = new Configuration();
    }

    @Getter
    private SessionFactory sessionFactory;

    private Configuration() {
        sessionFactory = new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();

        FlywayConfiguration.migrate((String) sessionFactory.getProperties().get("hibernate.connection.url"));
    }

    public static Configuration getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
