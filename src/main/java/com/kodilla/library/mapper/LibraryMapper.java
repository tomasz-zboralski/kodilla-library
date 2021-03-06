package com.kodilla.library.mapper;

import com.kodilla.library.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublished()
        );
    }
    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublished());
    }

    public Borrowing mapToBorrowing(final BorrowingDto borrowingDto) {
        return new Borrowing(
                borrowingDto.getId(),
                borrowingDto.getVolume(),
                borrowingDto.getUser(),
                borrowingDto.getBorrowed(),
                borrowingDto.getReturned()
        );
    }

    public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(
                borrowing.getId(),
                borrowing.getVolume(),
                borrowing.getUser(),
                borrowing.getBorrowed(),
                borrowing.getReturned()
        );
    }

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getCreated()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getCreated()
        );
    }

    public Volume mapToVolume(final VolumeDto volumeDto) {
        return new Volume(
                volumeDto.getId(),
                volumeDto.getBook(),
                volumeDto.getStatus()
        );
    }

    public VolumeDto mapToVolumeDto(final Volume volume) {
        return new VolumeDto(
                volume.getId(),
                volume.getBook(),
                volume.getStatus()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    public List<VolumeDto> mapToVolumeDtoList(final List<Volume> volumeList) {
        return volumeList.stream()
                .map(this::mapToVolumeDto)
                .collect(Collectors.toList());
    }

    public List<BorrowingDto> mapToBorrowingDtoList(final List<Borrowing> borrowingList) {
        return borrowingList.stream()
                .map(this::mapToBorrowingDto)
                .collect(Collectors.toList());
    }

}
