package DAO;

import Entities.KindSport;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IKindSportDao {
    void addKindSport(KindSport kindSport);
    List <KindSport> getAllKinds ();
    List <KindSport> searchKindById (int id) throws JsonProcessingException;
    List <KindSport> searchKindByName(String name) throws JsonProcessingException;
    void deleteKindSportById (int id);
}
