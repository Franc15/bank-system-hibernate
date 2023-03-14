package com.codewithkiks.daos;

import com.codewithkiks.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer> {
    @Override
    public Optional<Customer> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public void update(Customer customer, String[] params) {

    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
