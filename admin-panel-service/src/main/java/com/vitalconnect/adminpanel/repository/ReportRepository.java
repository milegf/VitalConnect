package com.vitalconnect.adminpanel.repository;

import com.vitalconnect.adminpanel.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    List<Report> findByUsuario(String usuario);
    List<Report> findByTipo(String tipo);

}
