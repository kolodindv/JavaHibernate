package DAO.Impl;

import DAO.IRefereeDao;
import DAO.HibernateUtil.HibernateUtil;
import Entities.Referee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class RefereeDao implements IRefereeDao {
    private static SessionFactory sessionFactory;
    public RefereeDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void addReferee (Referee referee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(referee);
        transaction.commit();
        session.close();
    }
    public List <Referee> getAllReferees() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List <Referee> refereeList = new ArrayList<Referee>(
                session.createQuery("from Referee").list());
        session.getTransaction().commit();
        return refereeList;
    }
    public List <Referee> searchRefereeById(int id) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Referee.class).add(Restrictions.idEq(id));
        return criteria.list();
    }
    public List <Referee>  searchRefereeByFirstName(String firstName) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Referee.class).add(Restrictions.like("firstName", firstName));
        return criteria.list();
    }
    public List <Referee> searchRefereeByLastName(String lastName) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Referee.class).add(Restrictions.like("lastName", lastName));
        return criteria.list();
    }
    public void deleteRefereeById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Referee referee = session.get(Referee.class, id);
        session.delete(referee);
        transaction.commit();
        session.close();
    }

}
