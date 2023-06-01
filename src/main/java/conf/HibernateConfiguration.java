package conf;

import clients.Client;
import planets.Planet;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    private static final HibernateConfiguration INSTANCE;

    static {
        INSTANCE = new HibernateConfiguration();
    }

    @Getter
    private SessionFactory sessionFactory;

    private HibernateConfiguration() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();

        FlywayConfiguration.migrate((String) sessionFactory.getProperties().get("hibernate.connection.url"));
    }

    public static HibernateConfiguration getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
