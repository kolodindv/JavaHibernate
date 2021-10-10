package DAO;

import Entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Collection;
import java.util.List;

public interface IUserDao {
    Collection<User> getNeedUsers(String login, int passwordHashCode);
}