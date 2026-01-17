📦 User Microservice – Spring Boot

Microservicio REST desarrollado con Spring Boot, encargado de la gestión de usuarios y la obtención dinámica de direcciones mediante la API externa COPOMEX (SEPOMEX).

Este proyecto fue diseñado siguiendo buenas prácticas, principios SOLID y estándares de desarrollo profesional.

🚀 Funcionalidad Principal

CRUD completo de Usuarios

Integración con API externa COPOMEX para obtener dirección física

Persistencia en MongoDB

API RESTful con respuestas en JSON

Documentación automática con Swagger/OpenAPI

Despliegue con Docker

🧱 Arquitectura y Estándares de Desarrollo
✅ Separación de Responsabilidades

Cada capa cumple una única función:

Capa	Responsabilidad
Controller	Exponer endpoints REST
Service	Lógica de negocio (CRUD)
CopomexService	Integración con API externa
DTOs	Contratos de entrada y salida
Entity / Document	Modelo de dominio
Repository	Acceso a datos
✅ Inversión de Dependencias (DIP)

Implementada mediante inyección por constructor:

UserService

UserRepository

UserMapper

CopomexService (WebClient)

✅ Buenas Prácticas REST

Uso correcto de verbos HTTP:

GET

POST

PUT

DELETE

Recursos bien definidos:

/users


Versionamiento de API:

/v1/api/users

✅ Respuestas en Formato JSON

Ejemplo de respuesta:

{
  "id": "696aa91550c83c4e015dddba",
  "nombre": "Erick Josué",
  "apellidoPaterno": "Guerrero",
  "apellidoMaterno": "+++++",
  "correo": "++++++++",
  "direccion": {
    "pais": "+++++",
    "estado": "+++++",
    "municipio": "++++",
    "ciudad": "++++",
    "codigoPostal": "++++",
    "tipoAsentamiento": "Colonia",
    "colonias": [
      "++++++"
    ]
  }
}

✅ Desacoplamiento de Capas

DTO específico para API externa:

CopomexResponse

Entidades de dominio independientes:

User

Address

✅ Manejo Global de Excepciones

GlobalExceptionHandler

Manejo de errores generales

ResourceNotFoundException

Errores personalizados

✅ Logging y Trazabilidad

Logs por cada paso relevante del flujo

Clases con logging:

UserServiceImpl

CopomexService

✅ Configuración Externa

Uso de application.yml

Externalización de variables sensibles:

copomex:
  api:
    key: ${COPOMEX_API_KEY}

📚 Documentación de la API

Swagger / OpenAPI disponible en:

/exa-tec-doc

🧰 Tecnologías y Dependencias

Java 17

Spring Boot

Spring Web

Spring Data MongoDB

WebClient

Lombok

MapStruct

Swagger / OpenAPI

Docker

MongoDB

🐳 Docker

El proyecto incluye configuración para ejecución mediante Docker.

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

📦 Entregables

📁 Repositorio GitHub

🗄️ Datos de conexión a MongoDB

🎥 Video demostrativo (opcional)

👨‍💻 Autor

Erick Guerrero
Backend Java Developer/Architect
Spring Boot | Microservices | MongoDB | Docker
