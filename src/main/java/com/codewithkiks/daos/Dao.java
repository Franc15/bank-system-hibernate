package com.codewithkiks.daos;

import java.util.List;
import java.util.Optional;

public interface Dao<E> {
    Optional<E> get(long id);
    List<E> getAll();
    void update(E e, String[] params);
    void save(E e);
    void delete(E e);
}
