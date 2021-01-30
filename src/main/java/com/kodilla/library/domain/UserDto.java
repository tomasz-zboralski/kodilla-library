package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private java.sql.Date created;
    private List<Borrowing> borrowingList = new ArrayList<>();
}
