package com.codewithkiks.daos;

import com.codewithkiks.helpers.JpaHelper;
import com.codewithkiks.models.AccountType;
import com.codewithkiks.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AccountTypeDao implements Dao<AccountType> {
    private final EntityManager entityManager;

    public AccountTypeDao() {
        entityManager = EntityManagerUtil.getEntityManager();
    }
    @Override
    public Optional<AccountType> get(long id) {
        return Optional.ofNullable(entityManager.find(AccountType.class, (int) id));
    }

    @Override
    public List<AccountType> getAll() {
        Query query = entityManager.createQuery("select a from AccountType a");
        return query.getResultList();
    }

    @Override
    public void update(AccountType accountType, String[] params) {
        accountType.setType(Objects.requireNonNull(params[0], "Account type cannot be null"));
        accountType.setInterestRate(Objects.requireNonNull(Double.parseDouble(params[1]), "Interest rate cannot be null"));
        accountType.setDescription(Objects.requireNonNull(params[2], "Description cannot be null"));
        JpaHelper.doInJpa(entityManager -> entityManager.merge(accountType), entityManager);
    }

    @Override
    public void save(AccountType accountType) {
        JpaHelper.doInJpa(entityManager -> entityManager.persist(accountType), entityManager);
    }

    @Override
    public void delete(AccountType accountType) {
        JpaHelper.doInJpa(entityManager -> entityManager.remove(accountType), entityManager);
    }
}
