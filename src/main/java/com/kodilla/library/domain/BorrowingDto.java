package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class BorrowingDto {
    Long id;
    Volume volume;
    User user;
    Date borrowed;
    Date returned;

}
