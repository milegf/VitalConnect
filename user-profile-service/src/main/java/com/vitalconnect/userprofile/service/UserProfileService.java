package com.vitalconnect.userprofile.service;
import com.vitalconnect.userprofile.exception.ResourceNotFoundException;

import com.vitalconnect.userprofile.model.UserProfile;
import com.vitalconnect.userprofile.repository.UserProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

//    @Autowired
//    public UserProfileService(UserProfileRepository userProfileRepository) {
//        this.userProfileRepository = userProfileRepository;
//    }

    // Crear nuevo perfil de usuario
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    // Obtener todos los perfiles de usuario
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

    // Obtener perfil por ID
    public UserProfile getUserProfileById(int id) {
        return userProfileRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado."));
    }

    // Obtener perfil por RUT
    public Optional<UserProfile> getUserProfileByRut(int rut) {
        return userProfileRepository.findByRut(rut);
    }

    // Actualizar perfil
    public Optional<UserProfile> updateUserProfile(int id, UserProfile updatedProfile) {
        return userProfileRepository.findById(id).map(existing -> {
            existing.setNombre(updatedProfile.getNombre());
            existing.setApellido(updatedProfile.getApellido());
            existing.setRut(updatedProfile.getRut());
            existing.setEmail(updatedProfile.getEmail());
            existing.setEspecialidades(updatedProfile.getEspecialidades());
            existing.setRoles(updatedProfile.getRoles());
            return userProfileRepository.save(existing);
        });
    }

    // Eliminar perfil
    public boolean deleteUserProfile(int id) {
        if (userProfileRepository.existsById(id)) {
            userProfileRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
