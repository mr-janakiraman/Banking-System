package com.janakiraman.AarushBank.repository;

import com.janakiraman.AarushBank.dto.Client;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
@Getter
@Setter
public class ClientRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public Client findById(int id){
        System.out.println(id);
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


}