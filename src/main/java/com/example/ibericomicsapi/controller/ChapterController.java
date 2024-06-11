package com.example.ibericomicsapi.controller;

import com.example.ibericomicsapi.model.Chapter;
import com.example.ibericomicsapi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("/comic/{comicId}")
    public List<String> getChaptersByComicId(@PathVariable int comicId) {
        return chapterService.findChaptersByComicId(comicId);
    }
}
