package com.example.jpetmanegement;

import com.example.jpetmanegement.domain.Account;
import com.example.jpetmanegement.domain.Item;
import com.example.jpetmanegement.persistence.AccountMapper;
import com.example.jpetmanegement.persistence.CategoryMapper;
import com.example.jpetmanegement.persistence.ItemMapper;
import com.example.jpetmanegement.service.CatalogService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.example.jpetmanegement.persistence")
class JpetmanegementApplicationTests {


    @Autowired
    CatalogService catalogService;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    AccountMapper accountMapper;

    @Test
    void contextLoads() {
//        catalogService.addItem("EST-1",	"FI-SW-01",	"16.5",	"10","1","P	","Large");
        Item item = itemMapper.getItem("EST-1");
        System.out.println(item.getItemId());
        // itemMapper.addItem("asd","123321");
    }
    @Test
    void test(){
//        itemMapper.addItem("123","K9-DL-01","12","123",1,"P","123");
        Item item = itemMapper.getItem("EST-1");
        System.out.println(item.getItemId());
    }

    @Test
    void test2(){
        Account account;
        account = accountMapper.getAccountByUsername("a");
        System.out.println(account.getUsername());
    }

}
