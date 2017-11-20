package com.shaulskiy.netfluxexample.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Movie {

    private String id;

    @NonNull
    private String title;


    public Movie(String title, String id) {
        this.title = title;
        this.id = id;
    }
}
