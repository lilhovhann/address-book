package io.project.app.addressbook.services;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.domainDTO.AccountDTO;
import io.project.app.addressbook.repositories.AccountRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
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

    public Optional<Account> create(AccountDTO accountDTO) {

        Account convertedData = convertEntityToDto(accountDTO);
        final Account savedAccount = accountRepository.save(convertedData);
        return Optional.ofNullable(savedAccount);

    }

    public static AccountDTO convertEntityToDto(Account account) {
        AccountDTO accountDTOResponse = new AccountDTO();
        try {
            BeanUtils.copyProperties(account, accountDTOResponse);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating doctorDTO response from Doctor", e);
        }
        return accountDTOResponse;
    }

    public static Account convertEntityToDto(AccountDTO accountDTO) {
        Account doctorResponse = new Account();
        try {
            BeanUtils.copyProperties(accountDTO, doctorResponse);
        } catch (BeansException e) {
            throw new RuntimeException("Error creating doctor from DoctorDto", e);
        }
        return doctorResponse;
    }
}
