package com.kcedro.accounts.service.impl;

import com.kcedro.accounts.dto.AccountDto;
import com.kcedro.accounts.entity.Account;
import com.kcedro.accounts.exception.AccountAlreadyExistsException;
import com.kcedro.accounts.exception.ResourceNotFoundException;
import com.kcedro.accounts.mapper.AccountMapper;
import com.kcedro.accounts.repository.AccountRepository;
import com.kcedro.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;

    @Override
    public void createAccount(AccountDto accountDto) {
        Optional<Account> optionalAccount = accountRepository.findByMobileNumber(accountDto.getMobileNumber());
        if (optionalAccount.isPresent()) {
            throw new AccountAlreadyExistsException("Account already exists with given mobile number " + accountDto.getMobileNumber());
        }
        accountRepository.save(createNewAccount(accountDto));
    }

    private Account createNewAccount(AccountDto accountDto) {
        Account newAccount = AccountMapper.mapToAccounts(accountDto, new Account());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        return newAccount;
    }

    @Override
    public AccountDto fetchAccount(String mobileNumber) {
        Account account = accountRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Account", "mobileNumber", mobileNumber)
        );
        AccountDto accountDto = AccountMapper.mapToAccountsDto(account, new AccountDto());
        return accountDto;
    }

    @Override
    public boolean updateAccount(AccountDto accountDto) {
        Account account = accountRepository.findByMobileNumber(accountDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "MobileNumber", accountDto.getMobileNumber())
        );
        Account updatedAccount = AccountMapper.mapToAccounts(accountDto, account);
        accountRepository.save(updatedAccount);
        return true;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Account account = accountRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Account", "mobileNumber", mobileNumber)
        );
        accountRepository.deleteByAccountId(account.getAccountId());
        return true;
    }

}
