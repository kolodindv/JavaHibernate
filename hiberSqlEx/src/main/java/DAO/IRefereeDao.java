package DAO;

import Entities.Referee;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IRefereeDao {
    void addReferee(Referee referee);
    List<Referee> getAllReferees();
    List <Referee> searchRefereeById(int id) throws JsonProcessingException;
    List <Referee> searchRefereeByFirstName(String firstName) throws JsonProcessingException;
    List <Referee> searchRefereeByLastName(String lastName) throws JsonProcessingException;
    void deleteRefereeById (int id);

}
