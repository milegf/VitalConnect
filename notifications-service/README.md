# Notifications Service - VitalConnect
Este microservicio forma parte del ecosistema de la plataforma VitalConnect, diseñada para la gestión descentralizada, segura y trazable de historiales médicos.

El notifications-service es responsable del envío de alertas y notificaciones en tiempo real a pacientes, médicos y administradores del sistema.

## Funcionalidad
- Envío de correos electrónicos mediante Spring Boot Mail.
- Consumo de eventos asincrónicos desde Apache Kafka.
- Validación de datos con Spring Validation.
- Exposición de endpoints RESTful (eventualmente para pruebas o reintentos).
- Preparado para ampliación hacia notificaciones push o SMS.

## Tecnologías a utilizar
- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring Mail
- Spring Kafka
- Spring Validation
- Lombok
- Maven

## Requisitos para ejecutar localmente
- Java 17
- Maven (versión por confirmar)
- Apache Kafka local o en Docker
- IntelliJ IDEA (recomendado)

## Cómo ejecutar el microservicio
Desde el directorio raíz del proyecto VitalConnect:
```bash
cd notifications-service
mvn spring-boot:run
```

O desde IntelliJ IDEA:
- Click derecho sobre la clase principal → Run

## Estructura del proyecto
```
notifications-service/
├── src/
│   ├── main/java/com/vitalconnect/notifications/
│   └── test/java/com/vitalconnect/notifications/
├── resources/
│   └── application.properties
└── pom.xml
```

## Pruebas
Este microservicio incluye dependencias para pruebas unitarias y de integración:
- spring-boot-starter-test
- spring-kafka-test

## Nota de seguridad
La dependencia spring-kafka-test incluye transitivamente commons-io:2.11.0, la cual presenta una vulnerabilidad conocida: CVE-2024-47554 (severidad moderada)

Queda pendiente de resolución dependiendo de la versión de Maven del entorno institucional para poder reemplazar commons.io.

---
## Autoría
Proyecto propuesto y desarrollado como parte de la asignatura DSY1103 – Desarrollo Fullstack I (DuocUC) por Milenka Guerra y Michelle Melo.

## Licencia
Uso educativo. Código desarrollado con fines académicos.
