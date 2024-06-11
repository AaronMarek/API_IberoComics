package com.example.ibericomicsapi.service;

import com.example.ibericomicsapi.model.Comic;
import com.example.ibericomicsapi.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComicService {

    @Autowired
    private ComicRepository comicRepository;

    public List<Comic> findAllComics() {
        return comicRepository.findAll();
    }

    public List<Comic> findComicsByUserId(Long userId) {
        return comicRepository.findByUserId(userId);
    }

    public void updateComicTitle(int comicId, String title) {
        Optional<Comic> comicOptional = comicRepository.findById(comicId);
        if (comicOptional.isPresent()) {
            Comic comic = comicOptional.get();
            comic.setTitle(title);
            comicRepository.save(comic);
        }
    }

    public Comic getComicDetails(int comicId) {
        Optional<Comic> comicOptional = comicRepository.findById(comicId);
        return comicOptional.orElse(null);
    }
}
