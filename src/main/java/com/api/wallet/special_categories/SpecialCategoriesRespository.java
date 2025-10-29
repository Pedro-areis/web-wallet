package com.api.wallet.special_categories;

import com.api.wallet.special_categories.dto.SpecialCategoriesResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialCategoriesRespository extends JpaRepository<SpecialCategories, Integer> {
    List<SpecialCategories> findByUserId(Integer userId);
}
