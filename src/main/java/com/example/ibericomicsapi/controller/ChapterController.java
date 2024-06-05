package com.example.ibericomicsapi.controller;

import com.example.ibericomicsapi.model.Chapter;
import com.example.ibericomicsapi.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    @Autowired
    private ChapterRepository chapterRepository;

    @GetMapping("/{comicId}")
    public List<Chapter> getChaptersByComicId(@PathVariable int comicId) {
        return chapterRepository.findByComicId(comicId);
    }

}