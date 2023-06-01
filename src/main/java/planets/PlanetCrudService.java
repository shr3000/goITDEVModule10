package planets;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import conf.HibernateConfiguration;

public class PlanetCrudService {

    public String create(Planet planet) {
        if (planet == null) {
            return "";
        }

        try (Session session = HibernateConfiguration.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
            return planet.getId();
        }
    }

    public Planet getPlanetById(String id) {
        try (Session session = HibernateConfiguration.getInstance().getSessionFactory().openSession()) {
            Query<Planet> query = session.createQuery(
                    "from Planet where id = :id",
                    Planet.class
            );
            query.setParameter("id", id);
            return query.stream().findFirst().orElse(null);
        }
    }

    public String updatePlanet(Planet planet) {
        if (planet == null) {
            return "";
        }

        try (Session session = HibernateConfiguration.getInstance().getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
            return planet.getId();
        }
    }

    public String deletePlanet(Planet planet) {
        if (planet == null) {
            return "";
        }

        try (Session session = HibernateConfiguration.getInstance().getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
            return planet.getId();
        }
    }
}