package com.codewithkiks.daos;

import com.codewithkiks.models.Account;

import java.util.List;
import java.util.Optional;

public class AccountDao implements Dao<Account> {
    @Override
    public Optional<Account> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public void update(Account account, String[] params) {

    }

    @Override
    public void save(Account account) {

    }

    @Override
    public void delete(Account account) {

    }
}
