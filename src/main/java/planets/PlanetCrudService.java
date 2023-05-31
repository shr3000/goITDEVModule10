package planets;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;

public class PlanetCrudService {
    private SessionFactory sessionFactory;

    public PlanetCrudService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void savePlanet(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Optional<Planet> getPlanetById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Optional<Planet> optionalPlanet = Optional.empty();

        try {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            transaction.commit();
            optionalPlanet = Optional.ofNullable(planet);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return optionalPlanet;
    }

    public List<Planet> getAllPlanets() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Planet> planets = null;

        try {
            transaction = session.beginTransaction();
            planets = session.createQuery("FROM Planet").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return planets;
    }

    public void deletePlanet(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.delete(planet);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void closeSessionFactory() {
        sessionFactory.close();
    }
}
