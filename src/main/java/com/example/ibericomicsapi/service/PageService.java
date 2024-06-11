package com.example.ibericomicsapi.service;

import com.example.ibericomicsapi.model.Page;
import com.example.ibericomicsapi.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    public List<String> findPagesByChapterId(int chapterId) {
        List<Page> pages = pageRepository.findByChapterId(chapterId);
        return pages.stream()
                .map(Page::getImageUrl)
                .collect(Collectors.toList());
    }
}
