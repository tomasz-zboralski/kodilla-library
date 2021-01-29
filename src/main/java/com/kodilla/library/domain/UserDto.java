package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private Date created;
}
