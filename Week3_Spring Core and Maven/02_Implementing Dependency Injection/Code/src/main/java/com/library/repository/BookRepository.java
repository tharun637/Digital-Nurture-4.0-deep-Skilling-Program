package com.library.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {
    public List<String> findAll() {
        return Arrays.asList("Java Basics", "Spring in Action", "Hibernate Essentials");
    }
}
