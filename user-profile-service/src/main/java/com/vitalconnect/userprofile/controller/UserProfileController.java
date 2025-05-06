package com.vitalconnect.userprofile.controller;

import com.vitalconnect.userprofile.model.UserProfile;
import com.vitalconnect.userprofile.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Controller para manejar las solicitudes HTTP relacionadas con los perfiles de usuarios.
@RequestMapping("/api/v1/users") //Ruta base para las solicitudes de la API.

public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    // Solicitudes HTTP para API REST

    // Crear nuevo perfil
    @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@Valid @RequestBody UserProfile userProfile) {
        return ResponseEntity.ok(userProfileService.createUserProfile(userProfile));
    }

    // Obtener todos los perfiles
    @GetMapping
    public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
        return ResponseEntity.ok(userProfileService.getAllUserProfiles());
    }

    // Obtener perfil por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable int id) {
        UserProfile userProfile = userProfileService.getUserProfileById(id);
        return ResponseEntity.ok(userProfile);
    }

    // Actualizar perfil
    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable int id, @Valid @RequestBody UserProfile userProfile) {
        return userProfileService.updateUserProfile(id, userProfile)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar perfil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable int id) {
        userProfileService.deleteUserProfile(id);
        return ResponseEntity.noContent().build();
    }

}
