package DAO;

import Entities.Coach;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ICoachDao {
    void addCoach (Coach coach);
    void addKindByCoach(int idCoach, int idKind);
    List <Coach> getAllCoaches();
    List <Coach> searchCoachById(int id) throws JsonProcessingException;
    List <Coach> searchCoachByFirstName(String firstName) throws JsonProcessingException;
    List <Coach> searchCoachByLastName(String lastName) throws JsonProcessingException;
    void deleteCoachById(int id);
}
