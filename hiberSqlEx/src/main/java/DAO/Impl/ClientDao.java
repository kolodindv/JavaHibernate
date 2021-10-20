package DAO.Impl;

import DAO.HibernateUtil.HibernateUtil;
import DAO.IClientDao;
import Entities.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IClientDao {
    private static SessionFactory sessionFactory;
    public ClientDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void addClient(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }
    public List<Client> getAllClients() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List <Client> clientList = new ArrayList<Client>(
                session.createQuery("from Client").list());
        session.getTransaction().commit();
        return clientList;
    }
    public List <Client> searchClientById(int id) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Client.class).add(Restrictions.idEq(id));
        return criteria.list();
    }
    public List <Client> searchClientByFirstName(String firstName) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Client.class).add(Restrictions.like("firstName", firstName));
        return criteria.list();
    }
    public List <Client> searchClientByLastName (String lastName) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Client.class).add(Restrictions.like("lastName", lastName));
        return criteria.list();
    }
    public void deleteClientById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.delete(client);
        transaction.commit();
        session.close();
    }
}
