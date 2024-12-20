package com.app.springsecurity.repositories;

import com.app.springsecurity.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
