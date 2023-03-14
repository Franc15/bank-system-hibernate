package com.codewithkiks.daos;

import com.codewithkiks.helpers.JpaHelper;
import com.codewithkiks.models.Account;
import com.codewithkiks.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AccountDao implements Dao<Account> {
    private final EntityManager entityManager;

    public AccountDao() {
        entityManager = EntityManagerUtil.getEntityManager();
    }
    @Override
    public Optional<Account> get(long id) {
        return Optional.ofNullable(entityManager.find(Account.class, (int) id));
    }

    @Override
    public List<Account> getAll() {
        Query query = entityManager.createQuery("select a from Account a");
        return query.getResultList();
    }

    @Override
    public void update(Account account, String[] params) {
        account.setBalance(Objects.requireNonNull(Double.parseDouble(params[0]), "Balance cannot be null"));
        JpaHelper.doInJpa(entityManager -> entityManager.merge(account), entityManager);
    }

    @Override
    public void save(Account account) {
        JpaHelper.doInJpa(entityManager -> entityManager.persist(account), entityManager);
    }

    @Override
    public void delete(Account account) {
        JpaHelper.doInJpa(entityManager -> entityManager.remove(account), entityManager);
    }
}
