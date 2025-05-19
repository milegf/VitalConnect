package com.vitalconnect.adminpanel.service;

import com.vitalconnect.adminpanel.exception.ResourceNotFoundException;
import com.vitalconnect.adminpanel.model.Admin;
import com.vitalconnect.adminpanel.model.Report;
import com.vitalconnect.adminpanel.repository.AdminRepository;
import com.vitalconnect.adminpanel.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private AdminRepository adminRepository;

    //Obtener todos los reportes
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    //Crear reporte
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    //Borrar reporte
    public void deleteReport(int id) {
        if(!reportRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reporte no encontrado con ID: " + id);
        }
        reportRepository.deleteById(id);
    }

    public List<Report> getReportsByUsuario(String usuario) {
        return reportRepository.findByUsuario(usuario);
    }

    public List<Report> getReportsByTipo(String tipo) {
        return reportRepository.findByTipo(tipo);
    }

    //Obtener todos los admin
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    //Buscar admin por id
    public Admin getAdminById(int id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin no encontrado con ID: " + id));
    }

    //Buscar admin por rut
    public Admin getAdminByRut(String rut) {
        return adminRepository.findByRut(rut)
                .orElseThrow(() -> new ResourceNotFoundException("Admin no encontrado con RUT: " + rut));
    }


    //Crear un admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    //Actualizar un admin
    public Admin updateAdmin(int id, Admin adminData) {
        Admin admin = getAdminById(id);
        admin.setRut(adminData.getRut());
        admin.setNombre(adminData.getNombre());
        admin.setApellido(adminData.getApellido());
        admin.setRol(adminData.getRol());
        admin.setBaneado(adminData.isBaneado());
        return adminRepository.save(admin);
    }


    //Borrar un admin
    public void deleteAdmin(int id) {
        if (!adminRepository.existsById(id)) {
            throw new ResourceNotFoundException("Admin no encontrado con ID: " + id);
        }
        adminRepository.deleteById(id);
    }
}
