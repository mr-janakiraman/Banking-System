package com.janakiraman.AarushBank.repository;

import com.janakiraman.AarushBank.dto.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Getter
@Setter
public class AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Account getAccount(int number){
        String sql = "Select * from account where number=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{number}, (rs,rownum)->{
            Account account = new Account();
            account.setNumber(rs.getInt("number"));
            account.setClientid(rs.getInt("clientid"));
            account.setBalance(rs.getFloat("balance"));
            return account;
        });
    }


    public String addAccount(Account account) {
        String sql = "INSERT INTO account (`number`, `balance`, `clientid`) VALUES (?,?,?)";

        int rows = jdbcTemplate.update(sql,account.getNumber(),account.getBalance(),account.getClientid());

        return "Account Added";

    }

    public String delAccount(int number) {
        String sql = "DELETE from account where number=?";

        int rows = jdbcTemplate.update(sql,number);

        return "Account deleted";
    }

    public String creditAccount(Account account) {

        String sql = "UPDATE account set balance=? where number=?";

        int rows = jdbcTemplate.update(sql,account.getBalance(),account.getNumber());

        return "Account Credited";

    }

    public String debitAccount(Account account) {
        String sql = "UPDATE account set balance=? where number=?";

        int rows = jdbcTemplate.update(sql,account.getBalance(),account.getNumber());

        return "Account Debited";
    }
}
