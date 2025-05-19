package com.vitalconnect.adminpanel.controller;

import com.vitalconnect.adminpanel.exception.ResourceNotFoundException;
import com.vitalconnect.adminpanel.model.Admin;
import com.vitalconnect.adminpanel.model.Report;
import com.vitalconnect.adminpanel.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")

public class AdminController {

    @Autowired
    private AdminService adminService;

    // CRUD de reports
    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = adminService.getAllReports();
        if (reports.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reports);
    }

    @PostMapping("/reports")
    public ResponseEntity<Report> createReport(@Valid @RequestBody Report report) {
        return ResponseEntity.ok(adminService.createReport(report));
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable int id) {
        try {
            adminService.deleteReport(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/reports/usuario/{usuario}")
    public ResponseEntity<List<Report>> getReportsByUsuario(@PathVariable String usuario) {
        List<Report> reports = adminService.getReportsByUsuario(usuario);
        return reports.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reports);
    }

    @GetMapping("/reports/tipo/{tipo}")
    public ResponseEntity<List<Report>> getReportsByTipo(@PathVariable String tipo) {
        List<Report> reports = adminService.getReportsByTipo(tipo);
        return reports.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(reports);
    }

    // CRUD de admins
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        if (admins.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(admins);
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.createAdmin(admin));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
        try {
            Admin admin = adminService.getAdminById(id);
            return ResponseEntity.ok(admin);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @Valid @RequestBody Admin admin) {
        try {
            Admin updatedAdmin = adminService.updateAdmin(id, admin);
            return ResponseEntity.ok(updatedAdmin);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
        try {
            adminService.deleteAdmin(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Admin> getAdminByRut(@PathVariable String rut) {
        try {
            Admin admin = adminService.getAdminByRut(rut);
            return ResponseEntity.ok(admin);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
