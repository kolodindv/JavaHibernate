package DAO;

import Entities.SportGroup;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ISportGroupDao {
    void addSportGroup(SportGroup sportGroup);
    List <SportGroup> getAllSportGroups();
    List <SportGroup>searchGroupById(int id) throws JsonProcessingException;
    List <SportGroup> searchGroupByName(String name) throws JsonProcessingException;
    void deleteSportGroupById(int id);
}
