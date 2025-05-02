package com.vitalconnect.userprofile.model;

// <editor-fold desc="IMPORTS">
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;
// </editor-fold>

// Anotaciones de JPA para la creación de tablas.
@Entity
@Table(name = "user_profiles")

// Anotaciones de Lombok para la generación automática de código.
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserProfile {

    @Id // le señala la columna que es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // le indica que la clave primaria es autoincremental
    private int id;

    @NotBlank(message = "Es obligatorio registrar un nombre.") // valida que el campo no esté vacío
    @Size(max = 100) // valida que el campo no exceda los 100 caracteres
    private String nombre;

    @NotBlank(message = "Es obligatorio registrar un apellido.") // valida que el campo no esté vacío
    @Size(max = 100) // valida que el campo no exceda los 100 caracteres
    private String apellido;

    @JsonIgnore // ignora el atributo en el archivo json
    @NotBlank(message = "Es obligatorio registrar un RUN.") // valida que el campo no esté vacío
    @Column(unique = true) // valida que el campo sea único
    private int rut;

    @JsonIgnore // ignora el atributo en el archivo json
    @NotBlank(message = "Es obligatorio registrar un dígito verificador") // valida que el campo no esté vacío
    @Size(max = 1) // valida que el campo no exceda 1 caracter
    private String dvRut;

    @Transient // indica que este campo no se almacena en la base de datos
    @com.fasterxml.jackson.annotation.JsonProperty("RUN") // expone el campo en la respuesta JSON
    public String getRun() {
        return this.rut + "-" + this.dvRut;
    }

    @NotBlank(message = "Es obligatorio registrar un correo.")
    @Size(max = 255, message = "El mail no puede exceder los 255 caracteres.")
    @Column(unique = true) // asegura que el correo sea único en la base de datos.
    private String email;

    @ElementCollection(fetch = FetchType.EAGER) // permite la carga de los datos de forma anticipada
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id")) // indica la tabla de unión
    @Column(name = "role") // indica el nombre de la columna
    private Set<String> roles;

    // Como no todos los usuarios tienen especialidades, no se usa FetchType.EAGER, ya que no se necesita una carga anticipada de información.
    @ElementCollection
    @CollectionTable(name = "user_specialties", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "specialty")
    private Set<String> especialidades;

    // Este campo indica si el usuario está activo o no. Por defecto, se establece en true.
    @Column(name = "activo")
    private boolean activo = true;

}