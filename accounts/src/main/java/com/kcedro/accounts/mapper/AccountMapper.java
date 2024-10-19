package com.kcedro.accounts.mapper;

import com.kcedro.accounts.dto.AccountDto;
import com.kcedro.accounts.entity.Account;

public class AccountMapper {

    public static AccountDto mapToAccountsDto(Account account, AccountDto accountDto) {
        accountDto.setName(account.getName());
        accountDto.setEmail(account.getEmail());
        accountDto.setMobileNumber(account.getMobileNumber());
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        return accountDto;
    }

    public static Account mapToAccounts(AccountDto accountDto, Account account) {
        account.setAccountType(accountDto.getAccountType());
        account.setEmail(accountDto.getEmail());
        account.setName(accountDto.getName());
        account.setMobileNumber(accountDto.getMobileNumber());
        return account;
    }
}
