package com.api.wallet.user;

import com.api.wallet.user.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse getCurrentUser(Integer id) {
        User currentUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        return new UserResponse(
                currentUser.getId(),
                currentUser.getName(),
                currentUser.getEmail(),
                currentUser.getDateBirth(),
                currentUser.getNote(),
                currentUser.getCreatedAt()
        );
    }

    public UserResponse createUser(UserRequest request) {
        // Lógica para criar um usuário

        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Email já cadastrado.");
        }

        String hashedPassword = passwordEncoder.encode(request.password());

        User newUser = new User();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setDateBirth(request.dateBirth());
        newUser.setNote(request.note());
        newUser.setPassword(hashedPassword);

        User savedUser = userRepository.save(newUser);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getDateBirth(),
                savedUser.getNote(),
                savedUser.getCreatedAt()
        );
    }

    public UpdateUserResponse updateUser(Integer id, UpdateUserRequest request) {
        // Lógica para atualizar um usuário
        User userOwner = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (request.email() != null && !request.email().equals(userOwner.getEmail())) {
            if (userRepository.findByEmail(request.email()).isPresent()) {
                throw new RuntimeException("Email já cadastrado.");
            }
            userOwner.setEmail(request.email());
        }

        if (request.password() != null && !request.password().isBlank()){
            String newHashedPassword = passwordEncoder.encode(request.password());
            userOwner.setPassword(newHashedPassword);
        }

        if (request.note() != null && !request.note().isBlank()){
            userOwner.setNote(request.note());
        }

        User updatedUser = userRepository.save(userOwner);

        return new UpdateUserResponse(
                updatedUser.getId(),
                updatedUser.getEmail(),
                updatedUser.getNote()
        );
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::toUserResponse)
                .collect(Collectors.toList());
    }

    private UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getDateBirth(),
                user.getNote(),
                user.getCreatedAt()
        );
    }

    public String deleteUser(Integer id) {
        User userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        userRepository.delete(userToDelete);

        return "Usuário deletado com sucesso.";
    }
}
