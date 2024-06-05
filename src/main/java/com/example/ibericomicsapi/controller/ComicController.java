package com.example.ibericomicsapi.controller;

import com.example.ibericomicsapi.model.Comic;
import com.example.ibericomicsapi.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comics")
public class ComicController {

    @Autowired
    private ComicRepository comicRepository;

    @GetMapping("/{userId}")
    public List<Comic> getComicsByUserId(@PathVariable int userId) {
        return comicRepository.findByUserId(userId);
    }


}
