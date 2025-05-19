package com.vitalconnect.adminpanel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(length = 50)
    private String tipo;

    @NotBlank
    @Column(length = 500)
    private String mensaje;

    @NotBlank
    @Column(length = 100)
    private String usuario; // quien fue reportado o generó el incidente

    @Column(name = "fecha", updatable = false) //fecha no modificable para evitar manipulaciones erroneas
    private LocalDateTime fecha = LocalDateTime.now();

}
