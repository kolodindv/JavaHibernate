package DAO;

import Entities.Hall;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IHallDao {
    void addHall(Hall hall);
    List <Hall> getAllHalls();
    List <Hall> searchHallById(int id) throws JsonProcessingException;
    List <Hall> searchHallByName(String name) throws JsonProcessingException;
    void deleteHallById(int id);
}