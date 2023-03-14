package com.codewithkiks.daos;

import com.codewithkiks.helpers.JpaHelper;
import com.codewithkiks.models.Branch;
import com.codewithkiks.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BranchDao implements Dao<Branch> {
    private final EntityManager entityManager;

    public BranchDao() {
        entityManager = EntityManagerUtil.getEntityManager();
    }
    @Override
    public Optional<Branch> get(long id) {
        return Optional.ofNullable(entityManager.find(Branch.class, (int) id));
    }

    @Override
    public List<Branch> getAll() {
        Query query = entityManager.createQuery("select b from Branch b");
        return query.getResultList();
    }

    @Override
    public void update(Branch branch, String[] params) {
        branch.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        JpaHelper.doInJpa(entityManager -> entityManager.merge(branch), entityManager);
    }

    @Override
    public void save(Branch branch) {
        JpaHelper.doInJpa(entityManager -> entityManager.persist(branch), entityManager);
    }

    @Override
    public void delete(Branch branch) {
        JpaHelper.doInJpa(entityManager -> entityManager.remove(branch), entityManager);
    }
}
