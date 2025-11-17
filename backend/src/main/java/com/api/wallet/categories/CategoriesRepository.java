package com.api.wallet.categories;

import com.api.wallet.categories.dto.CategoriesResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository <Categories, Integer> {
    List<Categories> findByUserId(Integer userId);
}
