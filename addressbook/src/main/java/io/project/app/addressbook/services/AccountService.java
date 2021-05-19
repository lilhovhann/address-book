package io.project.app.addressbook.services;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.repositories.AccountRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
