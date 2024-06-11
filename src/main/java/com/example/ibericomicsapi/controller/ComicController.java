package com.example.ibericomicsapi.controller;

import com.example.ibericomicsapi.model.Comic;
import com.example.ibericomicsapi.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @GetMapping("/")
    public List<Comic> getAllComics() {
        return comicService.findAllComics();
    }

    @GetMapping("/user/{userId}")
    public List<Comic> getComicsByUserId(@PathVariable Long userId) {
        return comicService.findComicsByUserId(userId);
    }

    @PutMapping("/{comicId}/title")
    public void updateComicTitle(@PathVariable int comicId, @RequestParam String title) {
        comicService.updateComicTitle(comicId, title);
    }

    @GetMapping("/{comicId}")
    public Comic getComicDetails(@PathVariable int comicId) {
        return comicService.getComicDetails(comicId);
    }
}
