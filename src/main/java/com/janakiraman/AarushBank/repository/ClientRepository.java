package com.janakiraman.AarushBank.repository;

import com.janakiraman.AarushBank.dto.Client;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Getter
@Setter
public class ClientRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public Client findById(int id){

        String sql = "select * from client where id=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs,rowNum)->{
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("name"));
            client.setAddress(rs.getString("address"));
            System.out.println(client);
            return client;
        });

    }


    public List<Client> findAllClients() {
        String sql = "select * from client";

        return jdbcTemplate.query(sql, (rs,rowNum)->{
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("name"));
            client.setAddress(rs.getString("address"));
            System.out.println(client);
            return client;
        });
    }

    public String addClient(Client client) {
        String sql = "INSERT INTO client (`name`, `address`, `id`) VALUES (?,?,?)";

        int rows = jdbcTemplate.update(sql, client.getName(),client.getAddress(),client.getId());

        return "Successfully inserted";

    }

    public String delClient(int id) {
        String sql = "DELETE from client where id=?";

        int rows = jdbcTemplate.update(sql,id);

        return "Account deleted";
    }
}
