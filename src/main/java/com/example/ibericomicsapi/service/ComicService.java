package com.example.ibericomicsapi.service;

import com.example.ibericomicsapi.repository.ComicRepository;

public class ComicService {
    private final ComicRepository comicRepository;

    public ComicService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }
}
