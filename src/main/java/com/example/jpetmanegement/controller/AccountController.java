package com.example.jpetmanegement.controller;

import com.example.jpetmanegement.domain.Account;
import com.example.jpetmanegement.domain.Product;
import com.example.jpetmanegement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Collections;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account/")
@SessionAttributes({"account", "myList", "authenticated"})
public class AccountController {
    @Autowired
    private AccountService accountService;


    @GetMapping("viewAccount")
    public String viewAccount(Model model){
        List<Account> accountList = accountService.getAccountList();
        model.addAttribute("accountList",accountList);
        return "account/account";
    }
    @GetMapping("updateAccount")
    public String updateAccount(String userId,Model model){
        Account account = accountService.getAccount(userId);
        model.addAttribute("account",account);
        return "account/updateAccount";
    }
    @GetMapping("updateAccountInfo")
    public String updateAccountInfo(String userId,String email,String firstName,String lastName,String status,String address1,String address2,String city,String state,
            String zip,String country,String phone,String password,Model model){
        if(accountService.getAccount(userId) !=null){
            accountService.updateAccount(userId,email,firstName,lastName,status,address1,address2,city,state,zip,country,phone,password);
        }else{
            String msg = "Please enter a  right user id , then press the update button.";
            model.addAttribute("msg", msg);
            return "common/error";}
        List<Account> accountList = accountService.getAccountList();
        model.addAttribute("accountList",accountList);
        return "account/account";
    }
    @GetMapping("resetAccount")
    public String resetAccount(String userId, Model model){
//        if(accountService.getProductGround(productId).equals("grounding")){
            accountService.updateAccountPassword(userId);
//        }else {
//            catalogService.updateProductGround(productId,"grounding");
//        }
        List<Account> accountList = accountService.getAccountList();
        model.addAttribute("accountList",accountList);
        return "account/account";
    }
}
