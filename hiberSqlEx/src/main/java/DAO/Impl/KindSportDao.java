package DAO.Impl;

import DAO.IKindSportDao;
import DAO.HibernateUtil.HibernateUtil;
import Entities.KindSport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class KindSportDao implements IKindSportDao {
    private static SessionFactory sessionFactory;
    public KindSportDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public void addKindSport (KindSport kindSport) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(kindSport);
        transaction.commit();
        session.close();
    }
    public List <KindSport> getAllKinds() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List <KindSport> kindSportList = new ArrayList<KindSport> (
                session.createQuery("from KindSport").list());
        session.getTransaction().commit();
        return kindSportList;
    }
    public List <KindSport> searchKindById(int id) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(KindSport.class).add(Restrictions.idEq(id));
        return criteria.list();
    }
    public List <KindSport> searchKindByName(String name) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(KindSport.class).add(Restrictions.like("nameKind", name));
        return criteria.list();
    }
    public void deleteKindSportById (int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        KindSport kindSport = session.get(KindSport.class, id);
        session.delete(kindSport);
        transaction.commit();
        session.close();
    }

}

