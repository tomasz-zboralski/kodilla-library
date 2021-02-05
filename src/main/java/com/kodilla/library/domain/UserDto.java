package com.kodilla.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class UserDto {
    private final Long id;
    private final String name;
    private final String surname;
    private final java.sql.Date created;
    private final List<Borrowing> borrowingList = new ArrayList<>();
}
