# User Profile Service - VitalConnect
Este microservicio forma parte del ecosistema de la plataforma VitalConnect, diseñada para la gestión descentralizada, segura y trazable de historiales médicos.

El user-profile-service es responsable de la administración de los perfiles de usuario, incluyendo información personal, especialidades médicas asociadas, roles del sistema y trazabilidad de actividad básica.

## Funcionalidad
- Gestión de datos de usuario (nombre, rut, especialidad, etc.).
- Definición de roles (paciente, médico, administrador).
- Almacenamiento seguro de información.
- Exposición de endpoints RESTful.
- Base de datos relacional (MySQL).

## Tecnologías a utilizar
- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring Data JPA
- Spring Security
- Lombok
- Maven
- MySQL (como base de datos relacional)

## Requisitos para ejecutar localmente
- Java 17
- Maven (versión por confirmar)
- Base de datos MySQL en ejecución (con configuración en application.properties)
- IntelliJ IDEA (recomendado)

## Cómo ejecutar el microservicio
Desde el directorio raíz del proyecto VitalConnect:
```bash
cd user-profile-service
mvn spring-boot:run
```

O desde IntelliJ IDEA:
- Click derecho sobre la clase principal → Run

## Estructura del proyecto
```
user-profile-service/
├── src/
│   ├── main/java/com/vitalconnect/user/
│   └── test/java/com/vitalconnect/user/
├── resources/
│   └── application.properties
└── pom.xml
```

## Pruebas
Incluye dependencias básicas para pruebas unitarias:
- spring-boot-starter-test
- spring-security-test

---
## Autoría
Proyecto propuesto y desarrollado como parte de la asignatura DSY1103 – Desarrollo Fullstack I (DuocUC) por Milenka Guerra y Michelle Melo.

## Licencia
Uso educativo. Código desarrollado con fines académicos.
