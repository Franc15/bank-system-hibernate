package com.codewithkiks.daos;

import com.codewithkiks.models.Branch;

import java.util.List;
import java.util.Optional;

public class BranchDao implements Dao<Branch> {
    @Override
    public Optional<Branch> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Branch> getAll() {
        return null;
    }

    @Override
    public void update(Branch branch, String[] params) {

    }

    @Override
    public void save(Branch branch) {

    }

    @Override
    public void delete(Branch branch) {

    }
}
