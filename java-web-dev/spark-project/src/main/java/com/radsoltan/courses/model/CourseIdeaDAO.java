package com.radsoltan.courses.model;

import java.io.NotActiveException;
import java.util.List;

public interface CourseIdeaDAO {
    boolean add(CourseIdea idea);

    List<CourseIdea> findAll();

    CourseIdea findBySlug(String slug) throws NotActiveException;
}
