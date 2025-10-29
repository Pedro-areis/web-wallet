package com.api.wallet.special_categories;

import com.api.wallet.special_categories.dto.SpecialCategoriesRequest;
import com.api.wallet.special_categories.dto.SpecialCategoriesResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/special-categories")
@RequiredArgsConstructor
public class SpecialCategoriesController {
    private final SpecialCategoriesService specialCategoriesService;

    @PostMapping("/new/{userId}")
    public ResponseEntity<SpecialCategoriesResponse> createSpecialCategories(
            @Valid @RequestBody SpecialCategoriesRequest request,
            @PathVariable Integer userId
    ) {
        SpecialCategoriesResponse response = specialCategoriesService.createSpecialCategories(userId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<SpecialCategoriesResponse>> getSpecialCategoriesByUser(
            @PathVariable Integer userId
    ) {
        List<SpecialCategoriesResponse> response = specialCategoriesService.getSpecialCategoriesByUser(userId);

        return ResponseEntity.ok(response);
    }
}
