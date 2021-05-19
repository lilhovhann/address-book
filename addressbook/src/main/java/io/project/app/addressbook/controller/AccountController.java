package io.project.app.addressbook.controller;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.services.AccountService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author lilit
 */
@RestController
@RequestMapping("/api/v2/accounts")
@Slf4j
public class AccountController {
 
    @Autowired
    private AccountService accountService;
    @GetMapping(path = "/find/All", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        List<Account> savedAccounts = accountService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(savedAccounts);
    }
    
}
