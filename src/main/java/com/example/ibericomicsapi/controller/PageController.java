package com.example.ibericomicsapi.controller;

import com.example.ibericomicsapi.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/chapter/{chapterId}")
    public List<String> getPagesByChapterId(@PathVariable int chapterId) {
        return pageService.findPagesByChapterId(chapterId);
    }
}
