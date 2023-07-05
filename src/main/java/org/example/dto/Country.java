package org.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Country {
    POLAND("Poland"),
    GERMANY("Germany"),
    FRANCE("France"),
    GREAT_BRITAIN("Great Britain");

    private final String name;
}
