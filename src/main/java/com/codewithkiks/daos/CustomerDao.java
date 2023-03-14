package com.codewithkiks.daos;

import com.codewithkiks.helpers.JpaHelper;
import com.codewithkiks.models.Customer;
import com.codewithkiks.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class CustomerDao implements Dao<Customer> {
    private final EntityManager entityManager;

    public CustomerDao() {
        entityManager = EntityManagerUtil.getEntityManager();
    }

    @Override
    public Optional<Customer> get(long id) {
        return Optional.ofNullable(entityManager.find(Customer.class, (int) id));
    }

    @Override
    public List<Customer> getAll() {
        Query query = entityManager.createQuery("select c from Customer c");
        return query.getResultList();
    }

    @Override
    public void update(Customer customer, String[] params) {
        customer.setFirstName(Objects.requireNonNull(params[0], "First name cannot be null"));
        customer.setLastName(Objects.requireNonNull(params[1], "Last name cannot be null"));
        customer.setEmail(Objects.requireNonNull(params[2], "Email cannot be null"));
        JpaHelper.doInJpa(entityManager -> entityManager.merge(customer), entityManager);
    }

    @Override
    public void save(Customer customer) {
        JpaHelper.doInJpa(entityManager -> entityManager.persist(customer), entityManager);
    }

    @Override
    public void delete(Customer customer) {
        JpaHelper.doInJpa(entityManager -> entityManager.remove(customer), entityManager);
    }

}
