package clients;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import conf.HibernateConfiguration;

public class ClientCrudService {

    public long createClient(Client client) {
        if (client == null) {
            return -1;
        }

        try (Session session = HibernateConfiguration.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
            return client.getId();
        }
    }

    public Client getById(long id) {
        try (Session session = HibernateConfiguration.getInstance().getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery(
                    "from Client where id = :id",
                    Client.class
            );
            query.setParameter("id", id);
            return query.stream().findFirst().orElse(null);
        }
    }

    public long updateClient(Client client) {
        if (client == null) {
            return -1;
        }

        try (Session session = HibernateConfiguration.getInstance().getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
            return client.getId();
        }
    }

    public long deleteClient(Client client) {
        if (client == null) {
            return -1;
        }

        try (Session session = HibernateConfiguration.getInstance().getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
            return client.getId();
        }
    }
}
