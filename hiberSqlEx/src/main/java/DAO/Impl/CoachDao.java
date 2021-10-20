package DAO.Impl;

import DAO.ICoachDao;
import DAO.HibernateUtil.HibernateUtil;
import Entities.Client;
import Entities.Coach;
import Entities.Hall;
import Entities.KindSport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoachDao implements ICoachDao {
    private static SessionFactory sessionFactory;
    public CoachDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void addCoach (Coach coach) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(coach);
        transaction.commit();
        session.close();
    }
    public List <Coach> getAllCoaches() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List <Coach> coachList = new ArrayList<Coach>(
                session.createQuery("from Coach").list());
        session.getTransaction().commit();
        return coachList;
    }
    public List <Coach> searchCoachById(int id) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Coach.class).add(Restrictions.idEq(id));
        return criteria.list();
    }
    public List <Coach> searchCoachByFirstName(String firstName) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Coach.class).add(Restrictions.like("firstName", firstName));
        return criteria.list();
    }
    public List <Coach> searchCoachByLastName(String lastName) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Coach.class).add(Restrictions.like("lastName", lastName));
        return criteria.list();
    }
    public void deleteCoachById (int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Coach coach = session.get(Coach.class, id);
        session.delete(coach);
        transaction.commit();
        session.close();
    }
    public void addKindByCoach (int idCoach, int idKind) {
        Session firstSession = sessionFactory.openSession();
        Transaction transaction = firstSession.beginTransaction();
        Coach coach = firstSession.get(Coach.class, idCoach);
        coach.getKindsSport().add(firstSession.get(KindSport.class, idKind));
        transaction.commit();
        firstSession.close();
        Session secondSession = sessionFactory.openSession();
        Transaction transaction1 = secondSession.beginTransaction();
        KindSport kindSport = secondSession.get(KindSport.class, idKind);
        kindSport.getCoaches().add(secondSession.get(Coach.class, idCoach));
        transaction1.commit();
        secondSession.close();
    }
}
