package com.api.wallet.special_categories;

import com.api.wallet.special_categories.dto.SpecialCategoriesRequest;
import com.api.wallet.special_categories.dto.SpecialCategoriesResponse;
import com.api.wallet.special_categories.dto.UpdateSpecialCategoriesRequest;
import com.api.wallet.special_categories.dto.UpdateSpecialCategoriesResponse;
import com.api.wallet.user.User;
import com.api.wallet.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        newSpecialCategory.setDescription(request.description());
        newSpecialCategory.setLimitValue(request.limitValue());
        newSpecialCategory.setCurrentValue(request.currentValue());
        newSpecialCategory.setType(request.type());
        newSpecialCategory.setUser(ownerUser);

        SpecialCategories savedSpecialCategory = specialCategoriesRepository.save(newSpecialCategory);

        return new SpecialCategoriesResponse(
                savedSpecialCategory.getId(),
                savedSpecialCategory.getName(),
                savedSpecialCategory.getDescription(),
                savedSpecialCategory.getLimitValue(),
                savedSpecialCategory.getCurrentValue(),
                savedSpecialCategory.getType(),
                savedSpecialCategory.getCreatedAt(),
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
                specialCategories.getDescription(),
                specialCategories.getLimitValue(),
                specialCategories.getCurrentValue(),
                specialCategories.getType(),
                specialCategories.getCreatedAt(),
                specialCategories.getUser().getId()
        );
    }

    public UpdateSpecialCategoriesResponse updateSpecialCategories(
            Integer id, Integer userId, UpdateSpecialCategoriesRequest request
    ){
        User userOwner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        SpecialCategories specialCategory = specialCategoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria especial não foi encontrada!"));

        if(!userOwner.getId().equals(specialCategory.getUser().getId())) {
            throw new RuntimeException("A categoria não pertence a esse usuário!");
        }

        if(request.name() != null && !request.name().isBlank()){
            specialCategory.setName(request.name());
        }
        if(request.description() != null && !request.description().isBlank()){
            specialCategory.setDescription(request.description());
        }
        if(request.type() != null){
            specialCategory.setType(request.type());
        }
        if(request.limitValue() != null){
            specialCategory.setLimitValue(request.limitValue());
        }

        SpecialCategories savedSpecialCategory = specialCategoriesRepository.save(specialCategory);

        return new UpdateSpecialCategoriesResponse(
                savedSpecialCategory.getId(),
                savedSpecialCategory.getName(),
                savedSpecialCategory.getDescription(),
                savedSpecialCategory.getLimitValue(),
                savedSpecialCategory.getType()
        );

    }

    public void deleteSepecialCategory (Integer id, Integer userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        SpecialCategories specialCategory = specialCategoriesRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        if (!user.getId().equals(specialCategory.getUser().getId())){
            throw new RuntimeException("A categoria não pertence a esse usuário!");
        }
        specialCategoriesRepository.delete(specialCategory);

    }
}
