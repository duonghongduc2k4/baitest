package com.example.socdo.service;

import com.example.socdo.model.Account;

import java.util.Optional;

public interface IAccountService {
    Account register(Account account);

    Account login(Account account);

    Optional<Account> findById(Long id);

    Iterable<Account> findAll();
}
