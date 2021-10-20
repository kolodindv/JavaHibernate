package DAO.Impl;

import DAO.IHallDao;
import DAO.HibernateUtil.HibernateUtil;
import Entities.Hall;
import Entities.User;
import antlr.debug.TraceListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HallDao implements IHallDao {
    private static SessionFactory sessionFactory;
    public HallDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void addHall(Hall hall) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(hall);
        transaction.commit();
        session.close();
    }

    public List<Hall> getAllHalls() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List <Hall> hallList = new ArrayList<Hall>(
                session.createQuery("from Hall").list());
        session.getTransaction().commit();
        return hallList;
    }
    public List <Hall> searchHallById(int id) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Hall> criteriaQuery = criteriaBuilder.createQuery(Hall.class);
        Root<Hall> HallRoot = criteriaQuery.from(Hall.class);

        Predicate idPredicate = criteriaBuilder.equal(HallRoot.get("idHall"), id);
        criteriaQuery.where(idPredicate);

        List<Hall> HallList = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();

        session.close();
        return HallList;
//        Criteria criteria = session.createCriteria(Hall.class).add(Restrictions.idEq(id));
//        return criteria.list();
    }
    public List <Hall> searchHallByName(String name) throws JsonProcessingException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Hall.class).add(Restrictions.like("nameOfHall", name));
        return criteria.list();
    }
    public void deleteHallById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Hall hall = session.get(Hall.class, id);
        session.delete(hall);
        transaction.commit();
        session.close();
    }
}
