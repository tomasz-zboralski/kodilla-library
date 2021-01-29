package com.kodilla.library.service;

import com.kodilla.library.domain.Volume;
import com.kodilla.library.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final LibraryRepository repository;

    public List<Volume> getAllVolumes() {
        return repository.findAll();
    }

    public Volume saveVolume(final Volume volume) {
        return repository.save(volume);
    }

    public Optional<Volume> getVolume(final Long id) {
        return repository.findById(id);
    }
}
