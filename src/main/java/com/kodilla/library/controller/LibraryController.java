package com.kodilla.library.controller;

import com.kodilla.library.domain.BookDto;
import com.kodilla.library.mapper.LibraryMapper;
import com.kodilla.library.service.DbService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    DbService dbService;
    LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(Long bookId) {
        return new BookDto(1L, "Title Test", "Author Test", 1970);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(Long bookId) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook")
    public void createBook(BookDto bookDto) {

    }
}
