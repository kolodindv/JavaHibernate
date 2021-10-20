package DAO.Impl;

import DAO.ISportsmanDao;
import DAO.HibernateUtil.HibernateUtil;
import Entities.Sportsman;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class SportsmanDao implements ISportsmanDao {
    private static SessionFactory sessionFactory;
    public SportsmanDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void addSportsman (Sportsman sportsman) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sportsman);
        transaction.commit();
        session.close();
    }
    public List<Sportsman> getAllSportsmans() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List <Sportsman> sportsmanList = new ArrayList<Sportsman>(
                session.createQuery("from Sportsman").list());
        session.getTransaction().commit();
        session.close();
        return sportsmanList;
    }
    public void printAllSportsmans() throws JsonProcessingException {
        Session session = sessionFactory.openSession();

    }
    public List<Sportsman> searchSportsmanById(int id) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Sportsman.class).add(Restrictions.idEq(id));
        return criteria.list();
    }
    public List <Sportsman> searchSportsmanByFirstName(String firstName) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Sportsman.class).add(Restrictions.like("firstName", firstName));
        return criteria.list();
    }
    public List <Sportsman> searchSportsmanByLastName(String lastName) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Sportsman.class).add(Restrictions.like("lastName", lastName));
        return criteria.list();
    }
    public void deleteSportsmanById (int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Sportsman sportsman = session.get(Sportsman.class, id);
        session.delete(sportsman);
        transaction.commit();
        session.close();
    }
}
