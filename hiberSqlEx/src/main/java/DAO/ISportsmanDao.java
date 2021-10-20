package DAO;

import Entities.Sportsman;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ISportsmanDao {
    void addSportsman(Sportsman sportsman);
    List <Sportsman> getAllSportsmans();
    List <Sportsman> searchSportsmanById(int id) throws JsonProcessingException;
    List <Sportsman> searchSportsmanByFirstName(String firstName) throws JsonProcessingException;
    List <Sportsman> searchSportsmanByLastName(String lastName) throws JsonProcessingException;
    void deleteSportsmanById(int id);
}
