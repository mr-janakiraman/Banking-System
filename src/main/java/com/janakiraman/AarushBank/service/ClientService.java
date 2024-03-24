package com.janakiraman.AarushBank.service;

import com.janakiraman.AarushBank.dto.Client;
import com.janakiraman.AarushBank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client findClient(int id){

        return clientRepository.findById(id);
    }


}
