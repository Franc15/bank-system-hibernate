package com.codewithkiks.daos;

import com.codewithkiks.models.AccountType;

import java.util.List;
import java.util.Optional;

public class AccountTypeDao implements Dao<AccountType> {
    @Override
    public Optional<AccountType> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<AccountType> getAll() {
        return null;
    }

    @Override
    public void update(AccountType accountType, String[] params) {

    }

    @Override
    public void save(AccountType accountType) {

    }

    @Override
    public void delete(AccountType accountType) {

    }
}
