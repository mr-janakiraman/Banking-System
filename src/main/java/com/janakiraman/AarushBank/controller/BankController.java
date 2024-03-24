package com.janakiraman.AarushBank.controller;

import com.janakiraman.AarushBank.dto.Client;
import com.janakiraman.AarushBank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    ClientService clientService;

    @GetMapping("client/{id}")
    public Client getClient(@PathVariable("id") int id){
        return clientService.findClient(id);
    }

    @GetMapping("client/all")
    public List<Client> getAllClients(){
        return clientService.findAllClient();
    }

}
