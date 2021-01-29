package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class VolumeDto {
    private Long id;
    private Book book;
    private String status;


}
