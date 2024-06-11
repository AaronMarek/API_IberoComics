package com.example.ibericomicsapi.service;

import com.example.ibericomicsapi.model.Chapter;
import com.example.ibericomicsapi.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    public List<String> findChaptersByComicId(int comicId) {
        List<Chapter> chapters = chapterRepository.findByComicId(comicId);
        return chapters.stream()
                .map(Chapter::getTitle)
                .collect(Collectors.toList());
    }
}
