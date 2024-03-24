package com.janakiraman.AarushBank.controller;

import com.janakiraman.AarushBank.dto.Account;
import com.janakiraman.AarushBank.dto.Client;
import com.janakiraman.AarushBank.service.AccountService;
import com.janakiraman.AarushBank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    ClientService clientService;
    @Autowired
    AccountService accountService;

    @GetMapping("account/{number}")
    public Account getAccount(@PathVariable("number") int number){
        return accountService.findAccount(number);
    }

    //Add account
    @PostMapping("account/add")
    public String addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }
    //Remove Account
    @DeleteMapping("account/del")
    public String deleteAccount(@PathVariable("number") int number){
        return accountService.deleteAccount(number);
    }

    @GetMapping("client/all")
    public List<Client> getAllClients(){
        return clientService.findAllClient();
    }

    @GetMapping("client/{id}")
    public Client getClient(@PathVariable("id") int id){
        return clientService.findClient(id);
    }

    //AddClient
    @PostMapping("client/add")
    public String addClient(@RequestBody Client client){
        System.out.println(client);
        return clientService.addClient(client);
    }

    //RemoveClient
    @PostMapping("client/remove")
    public String removeClient(@PathVariable("id") int id){
        return clientService.removeClient(id);
    }

    //Credit
    @PostMapping("account/credit")
    public String creditAccount(@RequestBody Account account){
        return accountService.creditAccount(account);
    }
    //Debit
    @PostMapping("account/debit")
    public String debitAccount(@RequestBody Account account){
        return accountService.debitAccount(account);
    }


}
