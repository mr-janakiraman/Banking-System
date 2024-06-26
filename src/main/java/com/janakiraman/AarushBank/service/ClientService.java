package com.janakiraman.AarushBank.service;

import com.janakiraman.AarushBank.dto.Client;
import com.janakiraman.AarushBank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client findClient(int id){

        return clientRepository.findById(id);
    }

    public List<Client> findAllClient(){

        return clientRepository.findAllClients();
    }

    public String addClient(Client client){

        return clientRepository.addClient(client);
    }

    public String removeClient(int id) {
        return clientRepository.delClient(id);
    }
}
