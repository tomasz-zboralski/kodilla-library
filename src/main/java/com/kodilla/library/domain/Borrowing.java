package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Borrowing {
    Long id;
    List<Volume> volumes;
    List<User> users;
    Date borrowed;
    Date returned;

}
