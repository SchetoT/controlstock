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

## Requisitos Previos

- *Java 11* o superior.
- *Maven 3.6.3* o superior.
- *MySQL 5.7* o superior.

## Instalación

1. *Clonar el repositorio:*
   ```bash
   git clone https://github.com/SchetoT/controlstock.git
   cd controlstock

2. Configurar la base de datos:

Crea una base de datos en MySQL:

CREATE DATABASE controlstock_db;

Actualiza el archivo application.properties con las credenciales de tu base de datos:

spring.datasource.url=jdbc:mysql://localhost:3306/controlstock_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña



3. Construir y ejecutar la aplicación:

mvn clean install
mvn spring-boot:run

La aplicación estará disponible en http://localhost:8080.



Uso

Autenticación:

La aplicación utiliza JWT para la autenticación. Antes de acceder a los endpoints protegidos, es necesario autenticarse mediante el endpoint de login:

Endpoint de login:
POST /api/auth/login
Request Body:

{
  "username": "tu_usuario",
  "password": "tu_contraseña"
}

Response:
Un token JWT que debe incluirse en los encabezados de las solicitudes posteriores:

Authorization: Bearer <tu_token>


Endpoints principales:

Productos:

Obtener todos los productos: GET /api/products

Crear un producto: POST /api/products (requiere rol ADMIN)

Actualizar un producto: PUT /api/products/{id} (requiere rol ADMIN)

Eliminar un producto: DELETE /api/products/{id} (requiere rol ADMIN)


Categorías:

Obtener todas las categorías: GET /api/categories

Crear una categoría: POST /api/categories (requiere rol ADMIN)


