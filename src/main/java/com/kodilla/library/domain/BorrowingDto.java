package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class BorrowingDto {
    Long id;
    List<Volume> volumes;
    List<User> users;
    Date borrowed;
    Date returned;

}
