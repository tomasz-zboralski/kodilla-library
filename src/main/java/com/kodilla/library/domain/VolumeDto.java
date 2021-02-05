package com.kodilla.library.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class VolumeDto {
    private final Long id;
    private final Book book;
    private final VolumeStatus status;
    private final List<Borrowing> borrowingList = new ArrayList<>();


}
