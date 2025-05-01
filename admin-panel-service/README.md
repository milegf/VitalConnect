# Admin Panel Service - VitalConnect
Este microservicio forma parte del ecosistema de la plataforma VitalConnect, diseñada para la gestión descentralizada, segura y trazable de historiales médicos.

El admin-panel-service se encarga de centralizar funciones administrativas del sistema, tales como monitoreo, validación de cuentas, control de accesos y revisión de actividad del sistema.

## Funcionalidad
- Validación y revocación de accesos de usuarios y profesionales.
- Revisión de trazabilidad registrada en blockchain (indirectamente).
- Panel de control para administración general del sistema.
- Exposición de endpoints protegidos por roles.
- Persistencia de datos administrativos en base de datos MySQL.

## Tecnologías a utilizar
- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring Security
- Spring Data JPA
- Spring Validation
- Lombok
- Maven
- MySQL (en Amazon RDS)

## Requisitos para ejecutar localmente
- Java 17
- Maven (versión por confirmar)
- Base de datos MySQL en ejecución (con configuración en application.properties)
- IntelliJ IDEA (recomendado)

## Cómo ejecutar el microservicio
Desde el directorio raíz del proyecto VitalConnect:
```bash
cd admin-panel-service
mvn spring-boot:run
```

O desde IntelliJ IDEA:
- Click derecho sobre la clase principal → Run

## Estructura del proyecto
```
admin-panel-service/
├── src/
│   ├── main/java/com/vitalconnect/admin/
│   └── test/java/com/vitalconnect/admin/
├── resources/
│   └── application.properties
└── pom.xml
```

## Pruebas
Incluye dependencias básicas para pruebas unitarias:
- spring-boot-starter-test
-spring-security-test

---
## Autoría
Proyecto propuesto y desarrollado como parte de la asignatura DSY1103 – Desarrollo Fullstack I (DuocUC) por Milenka Guerra y Michelle Melo.

## Licencia
Uso educativo. Código desarrollado con fines académicos.
