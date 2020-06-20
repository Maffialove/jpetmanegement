package com.example.jpetmanegement.service;

import com.example.jpetmanegement.domain.Account;
import com.example.jpetmanegement.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;



//    public Account getAccount(String username, String password) {
//        Account account = new Account();
//        account.setUsername(username);
//        account.setPassword(password);
//        return accountMapper.getAccountByUsernameAndPassword(account);
//    }

    @Transactional
    public void insertAccount(Account account){
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertLogin(account);
    }

    public void updateAccount(String userId,String email,String firstName,String lastName,String status,String addr1,String addr2,String city,String state,
                              String zip,String country,String phone,String password){
        accountMapper.updateAccount(userId,email,firstName,lastName,status,addr1,addr2,city,state,zip,country,phone,password);
    }


    public List<Account> getAccountList(){
        return accountMapper.getAccountList();
    }
    public void updateAccountPassword(String userId){accountMapper.updateAccountPassword(userId);}
    public Account getAccount(String userId) {
        return accountMapper.getAccountByUsername(userId);
    }


}
