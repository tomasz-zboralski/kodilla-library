package com.kodilla.library.controller;

import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.LibraryMapper;
import com.kodilla.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/library")
public class LibraryController {

    @Autowired
    private final DbService dbService;
    @Autowired
    private final LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBorrowings")
    public List<BorrowingDto> getBorrowings() {
        List<Borrowing> borrowings = dbService.getAllBorrowings();
        return libraryMapper.mapToBorrowingDtoList(borrowings);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        List<Book> books = dbService.getAllBooks();
        return libraryMapper.mapToBookDtoList(books);
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

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(@RequestBody UserDto userDto) {
        User user = libraryMapper.mapToUser(userDto);
        dbService.saveUser(user);

    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook")
    public void createBook(@RequestBody BookDto bookDto) {
        Book book = libraryMapper.mapToBook(bookDto);
        dbService.saveBook(book);

    }

    @RequestMapping(method = RequestMethod.POST, value = "createVolume")
    public void createVolume(@RequestBody VolumeDto volumeDto) {
        Volume volume = libraryMapper.mapToVolume(volumeDto);
        dbService.saveVolume(volume);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeVolumeStatus")
    public VolumeDto changeVolumeStatus(@RequestBody VolumeDto volumeDto) {
        Long volumeId = volumeDto.getId();
        Volume volume = dbService.getVolume(volumeId).get();
        volume.setStatus(volumeDto.getStatus());


        //Volume volume = libraryMapper.mapToVolume(volumeDto);
        Volume savedVolume = dbService.saveVolume(volume);
        return libraryMapper.mapToVolumeDto(savedVolume);

    }

    @RequestMapping(method = RequestMethod.GET, value = "volumeQuantityAvailable")
    public List<VolumeDto> volumeQuantityAvailable(@RequestParam Long bookId) throws LibraryNotFoundException {
        Book book = dbService.getBook(bookId).orElseThrow(LibraryNotFoundException::new);
        List<Volume> availableVolumes = book.getVolumeList();
        return libraryMapper.mapToVolumeDtoList(availableVolumes);

    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrowing")
    public void createBorrowing(Long bookId, User user) throws LibraryNotFoundException {
        Book book = dbService.getBook(bookId).orElseThrow(LibraryNotFoundException::new);
        List<Volume> availableVolumes = book.getVolumeList();

        Volume volume = availableVolumes.get(0);

        if (volume != null) {
            Borrowing borrowing = new Borrowing(null, volume, user, new Date(), null);
            Borrowing savedBorrowing = dbService.saveBorrowing(borrowing);

            libraryMapper.mapToBorrowingDto(savedBorrowing);
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(Long bookId) {
        return new BookDto(1L, "Title Test", "Author Test", 1970);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(Long bookId) {

    }


}
