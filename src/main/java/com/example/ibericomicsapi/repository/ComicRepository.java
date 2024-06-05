package com.example.ibericomicsapi.repository;

import com.example.ibericomicsapi.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Integer> {
    List<Comic> findByUserId(int userId);
}