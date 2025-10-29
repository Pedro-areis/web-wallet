package com.api.wallet.special_categories;

import com.api.wallet.special_categories.dto.SpecialCategoriesRequest;
import com.api.wallet.special_categories.dto.SpecialCategoriesResponse;
import com.api.wallet.user.User;
import com.api.wallet.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecialCategoriesService {
    private final SpecialCategoriesRespository specialCategoriesRepository;
    private final UserRepository userRepository;

    public SpecialCategoriesResponse createSpecialCategories(Integer userId, SpecialCategoriesRequest request) {
        User ownerUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não foi encontrado!"));

        SpecialCategories newSpecialCategory = new SpecialCategories();

        newSpecialCategory.setName(request.name());
        newSpecialCategory.setLimitValue(request.limitValue());
        newSpecialCategory.setCurrentValue(request.currentValue());
        newSpecialCategory.setType(request.type());
        newSpecialCategory.setUser(ownerUser);

        SpecialCategories savedSpecialCategory = specialCategoriesRepository.save(newSpecialCategory);

        return new SpecialCategoriesResponse(
                savedSpecialCategory.getId(),
                savedSpecialCategory.getName(),
                savedSpecialCategory.getLimitValue(),
                savedSpecialCategory.getCurrentValue(),
                savedSpecialCategory.getType(),
                savedSpecialCategory.getUser().getId()
        );
    }

    public List<SpecialCategoriesResponse> getSpecialCategoriesByUser(Integer userId) {
        List<SpecialCategories> specialCategories = specialCategoriesRepository.findByUserId(userId);

        return specialCategories.stream()
                .map(this::toSpecialCategoriesResponse)
                .collect(Collectors.toList());
    }

    private SpecialCategoriesResponse toSpecialCategoriesResponse(SpecialCategories specialCategories) {
        return new SpecialCategoriesResponse(
                specialCategories.getId(),
                specialCategories.getName(),
                specialCategories.getLimitValue(),
                specialCategories.getCurrentValue(),
                specialCategories.getType(),
                specialCategories.getUser().getId()
        );
    }

}
