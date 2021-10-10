package Logic;

import DAO.*;
import DAO.Impl.*;
import DAO.HibernateUtil.HibernateUtil;
import Entities.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MySystem {
    private SessionFactory sessionFactory;
    private Scanner in;
    private IUserDao userDao;

    public MySystem() {
        sessionFactory = HibernateUtil.getSessionFactory();
        in = new Scanner(java.lang.System.in);
        userDao = new UserDao();
    }

    public void registerUser() /*throws JsonProcessingException*/ {
        in.nextLine();
        java.lang.System.out.println("Придумайте логин:");
        String login = in.nextLine();
        java.lang.System.out.println("Придумайте пароль:");
        int passwordHashCode = in.nextLine().hashCode();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new User(login, passwordHashCode));
        transaction.commit();
        session.close();
    }
    public void logIn() throws JsonProcessingException {
        in.nextLine();
        //System.out.println("Ваш логин:");
        String login = in.nextLine();
        //System.out.println("Ваш пароль:");
        int passwordHashCode = in.nextLine().hashCode();
        List<User> userList = (List<User>) userDao.getNeedUsers(login, passwordHashCode);
        if (userList.size() > 0) {
            //System.out.println("ПРАВИЛЬНЫЕ параметры авторизации!");
            for (User el : userList) {
                System.out.println(el.getLogin() + "  _______");
            }
            //menu();
        } else {
            //System.out.println("Неправильные параметры авторизации! Давайте попробуем еще раз!");
            logIn();
        }
    }
}
