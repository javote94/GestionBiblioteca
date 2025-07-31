package dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    void save(T t);
    void update(T t);
    void delete(Long id);
    Optional<T> findById(Long id);
    List<T> findAll();
}