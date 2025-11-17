package com.api.wallet.special_categories;

import com.api.wallet.special_categories.dto.SpecialCategoriesRequest;
import com.api.wallet.special_categories.dto.SpecialCategoriesResponse;
import com.api.wallet.special_categories.dto.UpdateSpecialCategoriesRequest;
import com.api.wallet.special_categories.dto.UpdateSpecialCategoriesResponse;
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

    @PatchMapping("/update{id}/{userId}")
    public ResponseEntity<UpdateSpecialCategoriesResponse> updateSpecialCategory (
            @PathVariable Integer id,
            @PathVariable Integer userId,
            @Valid @RequestBody UpdateSpecialCategoriesRequest request
            ){
        UpdateSpecialCategoriesResponse response = specialCategoriesService.updateSpecialCategories(id, userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete{id}/{userId}")
    public ResponseEntity<String> deleteSepecialCategory (
            @PathVariable Integer id,
            @PathVariable Integer userId
    ){
        specialCategoriesService.deleteSepecialCategory(id, userId);

        return ResponseEntity.ok().body("Categoria deletada com sucesso!");
    }
}
