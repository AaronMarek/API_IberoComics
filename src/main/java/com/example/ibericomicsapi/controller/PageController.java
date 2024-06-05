package com.example.ibericomicsapi.controller;

import com.example.ibericomicsapi.model.Page;
import com.example.ibericomicsapi.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    @Autowired
    private PageRepository pageRepository;

    @GetMapping("/{chapterId}")
    public List<Page> getPagesByChapterId(@PathVariable int chapterId) {
        return pageRepository.findByChapterId(chapterId);
    }
}
