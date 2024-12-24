package com.example.socdo.service;

import com.example.socdo.model.Account;
import com.example.socdo.repo.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepo iAccountRepo;
    @Override
    public Account register(Account account) {
        return iAccountRepo.save(account);
    }
    public Account login(Account account){
        List<Account> accountList = iAccountRepo.findAll();
        for (Account acc : accountList){
            if (account.getEmail().equals(acc.getEmail()) && account.getPassword().equals(acc.getPassword())){
                return acc;
            }
        }
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return iAccountRepo.findById(id);
    }

    @Override
    public Iterable<Account> findAll() {
        return iAccountRepo.findAll();
    }

}
