package com.kcedro.accounts.mapper;

import com.kcedro.accounts.dto.AccountDto;
import com.kcedro.accounts.entity.Account;

public class AccountMapper {

    public static Account mapToAccounts(AccountDto accountDto, Account account) {
        account.setEmail(accountDto.getEmail());
        account.setName(accountDto.getName());
        account.setSurname(accountDto.getSurname());
        account.setMobileNumber(accountDto.getMobileNumber());
        return account;
    }
}
