package com.kcedro.accounts.service;

import com.kcedro.accounts.dto.AccountDto;

public interface IAccountService {


    void createAccount(AccountDto accountDto);

    AccountDto fetchAccount(String mobileNumber);

    boolean updateAccount(AccountDto accountDto);

    boolean deleteAccount(String mobileNumber);
}
