package com.dwbe.hotelaria.repositories;

import com.dwbe.hotelaria.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
