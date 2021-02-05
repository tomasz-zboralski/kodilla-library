package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Borrowing;
import com.kodilla.library.domain.User;
import com.kodilla.library.domain.Volume;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.BorrowingRepository;
import com.kodilla.library.repository.UserRepository;
import com.kodilla.library.repository.VolumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    @Autowired
    private final BorrowingRepository borrowingRepository;

    @Autowired
    private final VolumeRepository volumeRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BookRepository bookRepository;

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public List<Volume> getAllVolumes() {
        return volumeRepository.findAll();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public Volume saveVolume(final Volume volume) {
        return volumeRepository.save(volume);
    }

    public Borrowing saveBorrowing(final Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    public User saveUser(final User user){
        return userRepository.save(user);
    }

    public Optional<Volume> getVolume(final Long id) {
        return volumeRepository.findById(id);
    }

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }

}
