package com.example.socdo.controller;

import com.example.socdo.model.Account;
import com.example.socdo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> register(@RequestBody Account account){
        return new ResponseEntity<>(accountService.register(account), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account account){
        return new ResponseEntity<>(accountService.login(account),HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<Account> findById() {
        List<Account> accounts = (List<Account>) accountService.findAll();
        Account account = accounts.get(accounts.size() - 1);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }}
