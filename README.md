# ControlStock Application

## Descripción

*ControlStock* es una aplicación diseñada para gestionar inventarios y controlar el stock de productos de manera eficiente. Este sistema permite a los usuarios realizar un seguimiento de los productos, sus cantidades disponibles y actualizaciones en tiempo real, asegurando una gestión óptima de los recursos. Además, incluye autenticación y autorización mediante *Spring Security* y *JWT (JSON Web Tokens)* para garantizar la seguridad de la aplicación.

## Características

- *Gestión de Productos:* Crear, actualizar, eliminar y consultar productos.
- *Control de Stock:* Verificar el stock disponible de cada producto y recibir alertas en caso de niveles bajos.
- *Gestión de Categorías:* Organizar productos por categorías para facilitar su administración.
- *Reportes:* Generar reportes de inventario para análisis y toma de decisiones.
- *Autenticación y Autorización:*  
  - Seguridad mediante *Spring Security*.
  - Uso de *JWT* para autenticación basada en tokens.
  - Roles de usuario para control de acceso (por ejemplo: ADMIN y USER).

## Tecnologías Utilizadas

- *Java 11+*: Lenguaje principal de desarrollo.
- *Spring Boot:* Framework para la construcción de aplicaciones web y APIs REST.
- *Spring Data JPA:* Para la gestión de persistencia de datos.
- *Spring Security:* Implementación de autenticación y autorización.
- *JWT (JSON Web Tokens):* Para autenticación basada en tokens.
- *MySQL:* Base de datos relacional para almacenar los datos.
- *Lombok:* Reducción de código repetitivo mediante anotaciones.
- *Springdoc OpenAPI (Swagger):* Documentación interactiva de la API.

## Requisitos Previos

- *Java 11* o superior.
- *Maven 3.6.3* o superior.
- *MySQL 5.7* o superior.

## Instalación

1. *Clonar el repositorio:*
   ```bash
   git clone https://github.com/SchetoT/controlstock.git
   cd controlstock
