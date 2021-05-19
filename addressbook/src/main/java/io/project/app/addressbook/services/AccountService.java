package io.project.app.addressbook.services;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.repositories.AccountRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilith
 */
@Service
@Slf4j
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
    
    public Optional<Account> create(Account account){
        Account savedAccount = accountRepository.save(account);
        return Optional.ofNullable(savedAccount);
    }
}
