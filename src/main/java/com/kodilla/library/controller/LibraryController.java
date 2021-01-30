package com.kodilla.library.controller;

import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.LibraryMapper;
import com.kodilla.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/library")
public class LibraryController {

    DbService dbService;
    LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBorrowings")
    public List<BorrowingDto> getBorrowings() {
        List<Borrowing> borrowings = dbService.getAllBorrowings();
        return libraryMapper.mapToBorrowingDtoList(borrowings);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        List<Book> books = dbService.getAllBooks();
        return libraryMapper.mapToBookDtoList(books);
        //return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getVolumes")
    public List<VolumeDto> getVolumes() {
        List<Volume> volumes = dbService.getAllVolumes();
        return libraryMapper.mapToVolumeDtoList(volumes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        List<User> users = dbService.getAllUsers();
        return libraryMapper.mapToUserDtoList(users);
    }



//    @RequestMapping(method = RequestMethod.GET, value = "getBook")
//    public BookDto getBook(Long bookId) {
//        return new BookDto(1L, "Title Test", "Author Test", 1970);
//
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(Long bookId) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook")
    public void createBook(BookDto bookDto) {

    }
}
