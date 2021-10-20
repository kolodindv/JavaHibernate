package DAO;

import Entities.User;
import java.util.Collection;

public interface IUserDao {
    Collection<User> getNeedUsers(String login, int passwordHashCode);
}