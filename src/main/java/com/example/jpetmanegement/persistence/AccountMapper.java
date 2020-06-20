package com.example.jpetmanegement.persistence;

import com.example.jpetmanegement.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {



    //用于验证登陆信息
    Account getAccountByUsernameAndPassword(Account account);

    void insertAccount(Account account);

    void insertProfile(Account account);

    void insertLogin(Account account);



    void updateProfile(Account account);

    void updateLogin(Account account);

    List<Account> getAccountList();
    void updateAccountPassword(String userId);
    Account getAccountByUsername(String username);
    void updateAccount(String userId,String email,String firstName,String lastName,String status,String addr1,String addr2,String city,String state,
                       String zip,String country,String phone,String password);
}
