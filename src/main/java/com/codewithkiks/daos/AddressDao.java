package com.codewithkiks.daos;

import com.codewithkiks.helpers.JpaHelper;
import com.codewithkiks.models.Address;
import com.codewithkiks.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AddressDao implements Dao<Address> {
    private final EntityManager entityManager;

    public AddressDao() {
        entityManager = EntityManagerUtil.getEntityManager();
    }
    @Override
    public Optional<Address> get(long id) {
        return Optional.ofNullable(entityManager.find(Address.class, (int) id));
    }

    @Override
    public List<Address> getAll() {
        Query query = entityManager.createQuery("select a from Address a");
        return query.getResultList();
    }

    @Override
    public void update(Address address, String[] params) {
        address.setStreetName(Objects.requireNonNull(params[0], "Street name cannot be null"));
        address.setCityName(Objects.requireNonNull(params[1], "City cannot be null"));
        address.setCountryName(Objects.requireNonNull(params[2], "Country cannot be null"));
        JpaHelper.doInJpa(entityManager -> entityManager.merge(address), entityManager);
    }

    @Override
    public void save(Address address) {
        JpaHelper.doInJpa(entityManager -> entityManager.persist(address), entityManager);
    }

    @Override
    public void delete(Address address) {
        JpaHelper.doInJpa((entityManager -> entityManager.remove(address)), entityManager);
    }
}
