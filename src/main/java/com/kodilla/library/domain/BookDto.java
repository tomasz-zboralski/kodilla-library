package com.kodilla.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class BookDto {
    private final Long id;
    private final String title;
    private final String author;
    private final int published;
    private final List<Volume> volumeList = new ArrayList<>();
}
