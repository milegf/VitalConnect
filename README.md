# VitalConnect
VitalConnect es una plataforma de salud digital orientada a la descentralización, seguridad y trazabilidad de historiales médicos. Se compone de microservicios desarrollados en Java con Spring Boot, organizados como un proyecto Maven multimódulo.

## Estructura del proyecto
```
vitalconnect/
├── user-profile-service/     
├── notifications-service/    
├── admin-panel-service/       
├── pom.xml                    
├── .gitignore                 
├── .gitattributes             
└── README.md                  
```

## Tecnologías
- Java 17
- Spring Boot 3.4.5
- Maven
- MySQL / Amazon RDS
- Apache Kafka
- Docker
- JPA / Hibernate
- Spring Security, Validation y Actuator
- Lombok

## Microservicios (en desarrollo)
`user-profile-service`: Microservicio encargado de gestionar usuarios del sistema, incluyendo autenticación básica, creación de perfiles y asignación de roles.

`notifications-service`: Encargado de emitir notificaciones a pacientes y profesionales ante eventos como registros, accesos o cambios.

`admin-panel-service`: Servicio centralizado de administración del sistema: auditoría, gestión de usuarios, control de accesos.

## Requisitos para ejecutar
- JDK 17
- Maven 3.8+
- MySQL local (o Docker)
- IntelliJ IDEA

## Cómo ejecutar
### 1. Clonar el proyecto
```bash
git clone https://github.com/usuario/vitalconnect.git
cd vitalconnect
```

### 2. Ejecutar un microservicio
```bash
cd user-profile-service
mvn spring-boot:run
```

## Buenas prácticas
- Estructura limpia y modular
- Uso de `.gitignore` para evitar subir archivos locales o sensibles
- Uso de `@Valid` y control de errores con DTOs
- Seguridad mediante Spring Security (JWT en desarrollo)
- Conexión a base de datos configurada en `application.properties` (en desarrollo)

## Estado
**!** El actual proyecto se encuentra en fase de desarrollo.
La información aquí presentada es preliminar y está sujeta a cambios.

Se recomienda revisar el estado de cada microservicio antes de realizar cualquier implementación o prueba.

---

## Autoría
Proyecto propuesto y desarrollado como parte de la asignatura DSY1103 – Desarrollo Fullstack I (DuocUC) por Milenka Guerra y Michelle Melo.

## Licencia
Uso educativo. Código desarrollado con fines académicos.