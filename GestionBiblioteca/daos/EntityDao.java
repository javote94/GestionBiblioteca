package daos;

import java.util.Optional;

public interface EntityDao <T> {
    Optional<T> findById(Long id);
    void Save(T newEntity);
}