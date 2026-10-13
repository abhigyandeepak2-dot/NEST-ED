package com.edunet.backend.dto;

import com.edunet.backend.entity.User.Role;

public class AuthResponse {
    private Long id;
    private String fullName;
    private String email;
    private Role role;
    private String avatar;
    private String message;

    public AuthResponse(Long id, String fullName, String email, Role role, String avatar, String message) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.avatar = avatar;
        this.message = message;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public Role getRole() { return role; }
    public String getAvatar() { return avatar; }
    public String getMessage() { return message; }
}