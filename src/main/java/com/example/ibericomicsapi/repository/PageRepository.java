package com.example.ibericomicsapi.repository;

import com.example.ibericomicsapi.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {
    List<Page> findByChapterId(int chapterId);
}