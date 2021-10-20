package DAO.Impl;

import DAO.ISportGroupDao;
import DAO.HibernateUtil.HibernateUtil;
import Entities.SportGroup;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class SportGroupDao implements ISportGroupDao {
    private static SessionFactory sessionFactory;
    public SportGroupDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void addSportGroup (SportGroup sportGroup) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sportGroup);
        transaction.commit();
        session.close();
    }
    public List <SportGroup> getAllSportGroups() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List <SportGroup> sportGroupList = new ArrayList<SportGroup>(
                session.createQuery("from SportGroup").list());
        session.getTransaction().commit();
        return sportGroupList;
    }
    public List <SportGroup> searchGroupById(int id) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(SportGroup.class).add(Restrictions.idEq(id));
        return  criteria.list();
    }
    public List <SportGroup> searchGroupByName (String name) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(SportGroup.class).add(Restrictions.like("nameGroup", name));
        return criteria.list();
    }
    public void deleteSportGroupById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        SportGroup sportGroup = session.get(SportGroup.class, id);
        session.delete(sportGroup);
        transaction.commit();
        session.close();
    }

}
