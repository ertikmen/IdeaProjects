package com.ertikmen.utility;


import com.ertikmen.repository.entity.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class ServiceManager<T extends BaseEntity, ID> implements IService<T, ID>{

    private final JpaRepository<T, ID> repository;

    @Override
    public T save(T t) {
        t.setCreateDate(System.currentTimeMillis());
        t.setUpdateDate(System.currentTimeMillis());
        return repository.save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> t) {
        t.forEach(x -> {
            x.setCreateDate(System.currentTimeMillis());
            x.setUpdateDate(System.currentTimeMillis());

        });
        return repository.saveAll(t);
    }

    @Override
    public T update(T t) {
        t.setUpdateDate(System.currentTimeMillis());
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }
}
