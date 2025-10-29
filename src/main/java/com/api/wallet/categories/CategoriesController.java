package com.api.wallet.categories;

import com.api.wallet.categories.dto.CategoriesRequest;
import com.api.wallet.categories.dto.CategoriesResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;

    @PostMapping("/new/{userId}")
    public ResponseEntity<CategoriesResponse> createCategory(
            @Valid @RequestBody CategoriesRequest request,
            @PathVariable Integer userId
    ) {
        CategoriesResponse response = categoriesService.createCategory(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CategoriesResponse>> getCategoriesByUser(
            @PathVariable Integer userId
    ) {
        List<CategoriesResponse> response = categoriesService.getCategoriesByUser(userId);
        return ResponseEntity.ok(response);
    }
}
