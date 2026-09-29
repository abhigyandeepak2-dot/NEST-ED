package com.edunet.backend.controller;

import com.edunet.backend.dto.UserProfileDto;
import com.edunet.backend.entity.User;
import com.edunet.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserProfileDto>> getUsersByRole(@PathVariable User.Role role) {
        return ResponseEntity.ok(userService.getUsersByRole(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDto> updateProfile(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {

        String name = request.get("name");
        String bio = request.get("bio");
        String profilePicture = request.get("profilePicture");

        return ResponseEntity.ok(userService.updateUserProfile(id, name, bio, profilePicture));
    }
}
