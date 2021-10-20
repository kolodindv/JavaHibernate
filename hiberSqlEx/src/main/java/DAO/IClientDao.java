package DAO;

import Entities.Client;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IClientDao {
    void addClient (Client client);
    List <Client> getAllClients();
    List <Client> searchClientById(int id) throws JsonProcessingException;
    List <Client> searchClientByFirstName(String firstName) throws JsonProcessingException;
    List <Client> searchClientByLastName(String lastName) throws JsonProcessingException;
    void deleteClientById(int id);
}