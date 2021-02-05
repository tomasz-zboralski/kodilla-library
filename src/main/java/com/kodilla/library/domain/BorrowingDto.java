package com.kodilla.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class BorrowingDto {
    private final Long id;
    private final Volume volume;
    private final User user;
    private final Date borrowed;
    private final Date returned;

}
