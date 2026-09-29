package com.edunet.backend.service;

import com.edunet.backend.dto.UserProfileDto;
import com.edunet.backend.entity.User;
import com.edunet.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 1. User profile ID se fetch karna
    public UserProfileDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        return new UserProfileDto(user);
    }

    // 2. Role ke according list lana (e.g. TEACHER ya STUDENT)
    public List<UserProfileDto> getUsersByRole(User.Role role) {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole() == role)
                .map(UserProfileDto::new)
                .collect(Collectors.toList());
    }

    // 3. Profile update karna (Name, Bio, Profile Picture)
    public UserProfileDto updateUserProfile(Long id, String name, String bio, String profilePicture) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        if (name != null && !name.trim().isEmpty()) {
            user.setName(name);
        }
        if (bio != null) {
            user.setBio(bio);
        }
        if (profilePicture != null) {
            user.setProfilePicture(profilePicture);
        }

        User updatedUser = userRepository.save(user);
        return new UserProfileDto(updatedUser);
    }
}