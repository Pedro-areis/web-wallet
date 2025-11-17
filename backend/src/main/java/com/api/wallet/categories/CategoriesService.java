package com.api.wallet.categories;

import com.api.wallet.categories.dto.CategoriesRequest;
import com.api.wallet.categories.dto.CategoriesResponse;
import com.api.wallet.categories.dto.UpdateCategoryRequest;
import com.api.wallet.categories.dto.UpdateCategoryResponse;
import com.api.wallet.user.User;
import com.api.wallet.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;
    private final UserRepository userRepository;

    public CategoriesResponse createCategory(Integer userId, CategoriesRequest request) {
        User onwerUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não foi encontrado!"));

        Categories newCategory = new Categories();

        newCategory.setName(request.name());
        newCategory.setUser(onwerUser);
        newCategory.setDescription(request.description());

        Categories savedCategory = categoriesRepository.save(newCategory);

        return new CategoriesResponse(
                savedCategory.getId(),
                savedCategory.getName(),
                savedCategory.getDescription(),
                savedCategory.getUser().getId(),
                savedCategory.getCreatedAt()
        );
    }

    public List<CategoriesResponse> getCategoriesByUser(Integer userId) {
        List<Categories> categories = categoriesRepository.findByUserId(userId);

        return categories.stream()
                .map(this::toCategoriesResponse)
                .collect(Collectors.toList());
    }

    private CategoriesResponse toCategoriesResponse(Categories category) {
        return new CategoriesResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getUser().getId(),
                category.getCreatedAt()
        );
    }

    public UpdateCategoryResponse updateCategory(Integer id, Integer userId, UpdateCategoryRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não foi encontrado!"));
        Categories category = categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não foi encontrada!"));

        if(!category.getUser().getId().equals(user.getId())){
            throw new RuntimeException("A categoria não pertence ao usuário!");
        }

        if(request.name() != null && !request.name().isBlank()){
            category.setName(request.name());
        }
        if(request.description() != null && !request.description().isBlank()){
            category.setDescription(request.description());
        }

        Categories savedCategory = categoriesRepository.save(category);

        return new UpdateCategoryResponse(
                savedCategory.getId(),
                savedCategory.getName(),
                savedCategory.getDescription(),
                savedCategory.getUser().getId()
        );
    }

    public void deleteCategory(Integer id, Integer userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não foi encontrado!"));
        Categories category = categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não foi encontrada!"));

        if(!category.getUser().getId().equals(user.getId())){
            throw new RuntimeException("A categoria não pertence ao usuário!");
        }

        categoriesRepository.delete(category);

    }
}
