package com.api.wallet.user;

import com.api.wallet.user.dto.UpdateUserRequest;
import com.api.wallet.user.dto.UpdateUserResponse;
import com.api.wallet.user.dto.UserRequest;
import com.api.wallet.user.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.LockSupport;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserRequest request
            ) {
        UserResponse userResponse = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        List<UserResponse> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<UpdateUserResponse> updateUser(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateUserRequest request
    ) {
        UpdateUserResponse updatedUser = userService.updateUser(id, request);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Integer id
    ) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
