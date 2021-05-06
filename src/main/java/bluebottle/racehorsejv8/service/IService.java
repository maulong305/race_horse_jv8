package bluebottle.racehorsejv8.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {
    List<T> findAll(Pageable pageable);
    T findById(Long id);
    T save(T t);
    Boolean remove(Long id);
}
