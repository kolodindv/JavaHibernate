package DAO.Impl;


        import DAO.IUserDao;
        import DAO.HibernateUtil.HibernateUtil;
        import Entities.*;
        import org.hibernate.Criteria;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.criterion.Restrictions;

        import java.util.Collection;
        import java.util.List;

        import javax.persistence.criteria.CriteriaBuilder;
        import javax.persistence.criteria.CriteriaQuery;
        import javax.persistence.criteria.Root;
        import javax.persistence.criteria.Predicate;

public class UserDao implements IUserDao {
    private SessionFactory sessionFactory;

    public UserDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }



    // Create CriteriaBuilder


    // Create CriteriaQuery


    public Collection<User> getNeedUsers(String login, int passwordHashCode) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        Root<User> UserRoot = criteriaQuery.from(User.class);
        Predicate loginPredicate =  criteriaBuilder.equal(UserRoot.get("login"), login);
        Predicate passPredicate =  criteriaBuilder.equal(UserRoot.get("passwordHashCode"), passwordHashCode);
        criteriaQuery.where(criteriaBuilder.and(loginPredicate, passPredicate));

        List<User> userList = session.createQuery(criteriaQuery).getResultList();
        return userList;
    }
}