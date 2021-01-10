package com.example.yakuba.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.yakuba.entity.Account;
import com.example.yakuba.model.CreateAccountForm;
import com.example.yakuba.service.AccountService;

@Controller
@RequestMapping("/signup")
public class CreateAccountController {
    @Autowired
    AccountService accountService;

    /** ユーザー新規登録画面表示 */
    @GetMapping
    public String getSignUp(Model model, CreateAccountForm createAccountForm) {
        return "signup";
    }

    /** ユーザー新規登録 */
    @PostMapping
    public String postSignUp(@Valid @ModelAttribute CreateAccountForm createAccountForm, BindingResult bindingResult) {
        Account account = new Account();
        account = accountService.convertCreateAccountFormToModel(createAccountForm, new Account());
        accountService.save(account);
        //処理
        return "redirect:/login";
    }
}
