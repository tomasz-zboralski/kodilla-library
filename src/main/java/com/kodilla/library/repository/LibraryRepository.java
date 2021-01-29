package com.kodilla.library.repository;

import com.kodilla.library.domain.Volume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends CrudRepository<Volume, Long> {

    @Override
    List<Volume> findAll();
}
