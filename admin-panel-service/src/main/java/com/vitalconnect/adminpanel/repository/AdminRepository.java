package com.vitalconnect.adminpanel.repository;

import com.vitalconnect.adminpanel.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByRut(String rut);
}
