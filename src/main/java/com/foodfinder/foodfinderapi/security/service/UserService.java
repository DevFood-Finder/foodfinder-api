package com.foodfinder.foodfinderapi.security.service;

import com.foodfinder.foodfinderapi.security.domain.model.entity.User;
import com.foodfinder.foodfinderapi.security.domain.persistence.UserRepository;

import com.foodfinder.foodfinderapi.security.service.dto.UpdateUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, UpdateUserRequestDto updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstname(updatedUser.getFirstname());
                    user.setLastname(updatedUser.getLastname());
                    user.setPhoneNumber(updatedUser.getPhoneNumber());
                    user.setCountry(updatedUser.getCountry());
                    user.setProfilePictureUrl(updatedUser.getProfilePictureUrl());

                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
