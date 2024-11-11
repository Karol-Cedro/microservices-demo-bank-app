package com.kcedro.accounts.service.impl;

import com.kcedro.accounts.configuration.ServiceProperties;
import com.kcedro.accounts.dto.AccountBalanceDto;
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

    private ServiceProperties serviceProperties;

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
        newAccount.setBalance(0L);
        return newAccount;
    }

    @Override
    public Long fetchAccountBalance(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "accountId", accountId)
        );
        return account.getBalance();
    }

    @Override
    public boolean updateAccountBalance(AccountBalanceDto accountBalanceDto) {
        Account account = accountRepository.findById(accountBalanceDto.getAccountId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "accountId", accountBalanceDto.getAccountId())
        );
        account.setBalance(accountBalanceDto.getBalance());
        accountRepository.save(account);
        return true;
    }

    @Override
    public boolean deleteAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "accountId", accountId)
        );
        accountRepository.deleteByAccountId(account.getAccountId());
        return true;
    }

}
