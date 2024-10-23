package com.kcedro.accounts.service;

import com.kcedro.accounts.dto.AccountBalanceDto;
import com.kcedro.accounts.dto.AccountDto;

public interface IAccountService {


    void createAccount(AccountDto accountDto);

    Long fetchAccountBalance(Long accountId);

    boolean updateAccountBalance(AccountBalanceDto accountBalanceDto);

    boolean deleteAccount(Long accountId);
}
